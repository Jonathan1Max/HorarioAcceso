package com.intecap_edu_gt.horario_subscripcion.Interceptor;

import com.intecap_edu_gt.horario_subscripcion.Model.HorarioAcceso;
import com.intecap_edu_gt.horario_subscripcion.Service.HorarioAccesoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import java.time.LocalDateTime;
import java.util.List;

@Component
public class HorarioAccesoInterceptor implements HandlerInterceptor {

    @Autowired
    private HorarioAccesoService horarioAccesoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clienteId = request.getHeader("Cliente-Id");
        if (clienteId == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        }

        List<HorarioAcceso> horarios = horarioAccesoService.obtenerHorariosPorCliente(clienteId);
        LocalDateTime now = LocalDateTime.now();

        boolean tieneAcceso = horarios.stream()
                .anyMatch(horario -> horario.isActivo() && now.isAfter(horario.getInicioAcceso()) && now.isBefore(horario.getFinAcceso()));

        if (!tieneAcceso) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
        return true;
    }
}