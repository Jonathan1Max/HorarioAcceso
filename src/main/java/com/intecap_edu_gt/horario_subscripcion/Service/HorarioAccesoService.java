package com.intecap_edu_gt.horario_subscripcion.Service;

import com.intecap_edu_gt.horario_subscripcion.Model.HorarioAcceso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class HorarioAccesoService {
    private final List<HorarioAcceso> horarios = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<HorarioAcceso> obtenerHorariosPorCliente(String clienteId) {
        List<HorarioAcceso> resultado = new ArrayList<>();
        for (HorarioAcceso horario : horarios) {
            if (horario.getClienteId().equals(clienteId)) {
                resultado.add(horario);
            }
        }
        return resultado;
    }

    public HorarioAcceso crearHorario(HorarioAcceso horarioAcceso) {
        horarioAcceso.setId(counter.getAndIncrement());
        horarios.add(horarioAcceso);
        return horarioAcceso;
    }

    public Optional<HorarioAcceso> actualizarHorario(Long id, HorarioAcceso horarioActualizado) {
        for (HorarioAcceso horario : horarios) {
            if (horario.getId().equals(id)) {
                horario.setClienteId(horarioActualizado.getClienteId());
                horario.setInicioAcceso(horarioActualizado.getInicioAcceso());
                horario.setFinAcceso(horarioActualizado.getFinAcceso());
                horario.setActivo(horarioActualizado.isActivo());
                return Optional.of(horario);
            }
        }
        return Optional.empty();
    }

    public boolean eliminarHorario(Long id) {
        return horarios.removeIf(horario -> horario.getId().equals(id));
    }
}