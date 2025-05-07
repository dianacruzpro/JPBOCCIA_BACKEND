package com.uped.JP_BOCCIA_BACK.service.impl;

import ch.qos.logback.classic.Logger;
import com.uped.JP_BOCCIA_BACK.dto.ClasificacionDTO;
import com.uped.JP_BOCCIA_BACK.entity.Clasificacion;
import com.uped.JP_BOCCIA_BACK.entity.Equipo;
import com.uped.JP_BOCCIA_BACK.entity.Jugador;
import com.uped.JP_BOCCIA_BACK.entity.Torneo;
import com.uped.JP_BOCCIA_BACK.exception.ClasificacionNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.exception.EquipoNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.exception.JugadorNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.exception.TorneoNoEncontradoException;
import com.uped.JP_BOCCIA_BACK.mapper.ClasificacionMapper;
import com.uped.JP_BOCCIA_BACK.repository.ClasificacionRepository;
import com.uped.JP_BOCCIA_BACK.repository.EquipoRepository;
import com.uped.JP_BOCCIA_BACK.repository.JugadorRepository;
import com.uped.JP_BOCCIA_BACK.repository.TorneoRepository;
import com.uped.JP_BOCCIA_BACK.service.ClasificacionService;
import com.uped.JP_BOCCIA_BACK.service.EquipoService;
import com.uped.JP_BOCCIA_BACK.service.JugadorService;
import com.uped.JP_BOCCIA_BACK.service.TorneoService;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClasificacionServiceImpl implements ClasificacionService {

    private final ClasificacionRepository clasificacionRepository;
    private final JugadorService jugadorService;
    private final EquipoService equipoService;
    private final TorneoService torneoService;
    private final TorneoRepository torneoRepository;
    private final JugadorRepository jugadorRepository;
    private final EquipoRepository equipoRepository;
    private static final Logger log = (Logger) LoggerFactory.getLogger(ClasificacionServiceImpl.class);


    public ClasificacionServiceImpl(
            ClasificacionRepository clasificacionRepository,
            JugadorService jugadorService,
            EquipoService equipoService,
            TorneoService torneoService, TorneoRepository torneoRepository, JugadorRepository jugadorRepository, EquipoRepository equipoRepository) {
        this.clasificacionRepository = clasificacionRepository;
        this.jugadorService = jugadorService;
        this.equipoService = equipoService;
        this.torneoService = torneoService;
        this.torneoRepository = torneoRepository;
        this.jugadorRepository = jugadorRepository;
        this.equipoRepository = equipoRepository;
    }

    @Override
    public List<ClasificacionDTO> listarTodos() {
        return clasificacionRepository.findAll()
                .stream()
                .map(ClasificacionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClasificacionDTO buscarPorId(Long id) {
        try {
            Clasificacion clasificacion = clasificacionRepository.findById(id)
                    .orElseThrow(() -> new ClasificacionNoEncontradoException(id));

            log.info("Clasificación encontrada: {}", clasificacion);
            return ClasificacionMapper.toDTO(clasificacion);

        } catch (ClasificacionNoEncontradoException e) {
            log.error("Clasificación con ID {} no encontrada", id, e);
            throw e;
        } catch (Exception e) {
            log.error("Error inesperado al buscar clasificación con ID {}", id, e);
            throw new RuntimeException("Error al procesar la solicitud", e);
        }
    }


    @Override
    public ClasificacionDTO guardar(ClasificacionDTO dto) {
        if (dto.getTorneoID() == null) {
            throw new IllegalArgumentException("El ID del torneo no puede ser null");
        }

        // Validación por tipo de clasificación
        if (dto.getTipo() == null) {
            throw new IllegalArgumentException("El tipo de clasificación no puede ser null");
        }

        if (dto.getTipo().equals("jugador")) {
            if (dto.getEquipoID() != null) {
                throw new IllegalArgumentException("El ID del equipo debe ser null cuando el tipo es 'jugador'");
            }
            if (dto.getJugadorID() == null) {
                throw new IllegalArgumentException("El ID del jugador no puede ser null cuando el tipo es 'jugador'");
            }
        } else if (dto.getTipo().equals("equipo")) {
            if (dto.getJugadorID() != null) {
                throw new IllegalArgumentException("El ID del jugador debe ser null cuando el tipo es 'equipo'");
            }
            if (dto.getEquipoID() == null) {
                throw new IllegalArgumentException("El ID del equipo no puede ser null cuando el tipo es 'equipo'");
            }
        } else {
            throw new IllegalArgumentException("Tipo de clasificación no válido");
        }

        Torneo torneo = torneoRepository.findById(dto.getTorneoID())
                .orElseThrow(() -> new TorneoNoEncontradoException(dto.getTorneoID()));

        Jugador jugador = null;
        if (dto.getJugadorID() != null) {
            jugador = jugadorRepository.findById(dto.getJugadorID())
                    .orElseThrow(() -> new JugadorNoEncontradoException(dto.getJugadorID()));
        }

        Equipo equipo = null;
        if (dto.getEquipoID() != null) {
            equipo = equipoRepository.findById(dto.getEquipoID())
                    .orElseThrow(() -> new EquipoNoEncontradoException(dto.getEquipoID()));
        }

        // Crea la entidad de clasificación
        Clasificacion clasificacion = ClasificacionMapper.toEntity(dto, torneo, jugador, equipo);
        Clasificacion guardado = clasificacionRepository.save(clasificacion);
        return ClasificacionMapper.toDTO(guardado);
    }



    @Override
    public ClasificacionDTO actualizar(ClasificacionDTO dto) {
        Clasificacion existente = clasificacionRepository.findById(dto.getId())
                .orElseThrow(() -> new ClasificacionNoEncontradoException(dto.getId()));


        Torneo torneo = torneoRepository.findById(dto.getTorneoID()).orElse(null);
        Jugador jugador = jugadorRepository.findById(dto.getJugadorID()).orElseThrow(() ->  new JugadorNoEncontradoException(dto.getJugadorID()));
        Equipo equipo = equipoRepository.findById(dto.getEquipoID()).orElseThrow(() ->  new EquipoNoEncontradoException(dto.getEquipoID()));


        existente.setTorneo(torneo);
        existente.setTipo(Clasificacion.TipoClasificacion.valueOf(dto.getTipo()));
        existente.setJugador(jugador);
        existente.setEquipo(equipo);
        existente.setPosicion(dto.getPosicion());
        existente.setFechaRegistro(dto.getFechaRegistro().atStartOfDay());

        Clasificacion actualizado = clasificacionRepository.save(existente);
        return ClasificacionMapper.toDTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        if (!clasificacionRepository.existsById(id)) {
            throw new ClasificacionNoEncontradoException(id);
        }
        clasificacionRepository.deleteById(id);
    }
}
