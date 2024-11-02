package com.intecap_edu_gt.horario_subscripcion.Controller;

import com.intecap_edu_gt.horario_subscripcion.Model.HorarioAcceso;
import com.intecap_edu_gt.horario_subscripcion.Service.HorarioAccesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioAccesoController {

    @Autowired
    private HorarioAccesoService horarioAccesoService;

    @GetMapping("/{clienteId}")
    public List<HorarioAcceso> obtenerHorariosPorCliente(@PathVariable String clienteId) {
        return horarioAccesoService.obtenerHorariosPorCliente(clienteId);
    }

    // Método para manejar POST y crear un nuevo horario
    @PostMapping
    public ResponseEntity<HorarioAcceso> crearHorario(@RequestBody HorarioAcceso horarioAcceso) {
        // Lógica para crear el horario
        HorarioAcceso nuevoHorario = horarioAccesoService.crearHorario(horarioAcceso);
        return new ResponseEntity<>(nuevoHorario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HorarioAcceso actualizarHorario(@PathVariable Long id, @RequestBody HorarioAcceso horarioAcceso) {
        return horarioAccesoService.actualizarHorario(id, horarioAcceso)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void eliminarHorario(@PathVariable Long id) {
        boolean eliminado = horarioAccesoService.eliminarHorario(id);
        if (!eliminado) {
            throw new RuntimeException("Horario no encontrado");
        }
    }
}
