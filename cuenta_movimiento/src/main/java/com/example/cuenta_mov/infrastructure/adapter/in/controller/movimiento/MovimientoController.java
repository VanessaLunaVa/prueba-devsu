package com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento;

import com.example.cuenta_mov.application.command.movimiento.MovimientoCommand;
import com.example.cuenta_mov.domain.model.EstadoCuenta;
import com.example.cuenta_mov.domain.model.EstadoCuentaMovimientos;
import com.example.cuenta_mov.domain.model.Movimiento;
import com.example.cuenta_mov.domain.ports.in.MovimientoUseCase;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.dto.EstadoCuentaResponse;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.mapper.CuentaResponseMapper;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.dto.EstadoCuentaMovimientosResponse;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.dto.MovimientoRequest;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.dto.MovimientoResponse;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.mapper.MovimientoRequestMapper;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.mapper.MovimientoResponseMapper;
import com.example.cuenta_mov.util.GeneralResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/movimiento")
@RequiredArgsConstructor
@Slf4j
public class MovimientoController {

    private final MovimientoUseCase movimientoUseCase;

    @GetMapping()
    public GeneralResponse<List<MovimientoResponse>> findAll() {
        List<Movimiento> all = movimientoUseCase.findAll();
        List<MovimientoResponse> response =
                all.stream().map(MovimientoResponseMapper::toResponse).toList();
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), response);
    }

    @GetMapping("/{id}")
    public GeneralResponse<MovimientoResponse> findId(@PathVariable Long id) {
        Movimiento byId = movimientoUseCase.findById(id);
        MovimientoResponse response = MovimientoResponseMapper.toResponse(byId);
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), response);
    }

    @PostMapping()
    public GeneralResponse<MovimientoResponse> save(@RequestBody MovimientoRequest mov) {
        MovimientoCommand command = MovimientoRequestMapper.toCommand(mov);
        Movimiento movimientoSaved = movimientoUseCase.save(command);
        MovimientoResponse response = MovimientoResponseMapper.toResponse(movimientoSaved);
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), response);
    }

    @PutMapping("/{id}")
    public GeneralResponse<MovimientoResponse> update(@PathVariable Long id, @RequestBody MovimientoRequest mov) {
        MovimientoCommand command = MovimientoRequestMapper.toCommand(mov);
        Movimiento movimientoSaved = movimientoUseCase.update(id, command);
        MovimientoResponse response = MovimientoResponseMapper.toResponse(movimientoSaved);
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), response);
    }

    @DeleteMapping("{id}")
    public GeneralResponse<String> delete(@PathVariable Long id) {
        movimientoUseCase.delete(id);
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
    }

    @GetMapping("reporte")
        public GeneralResponse<List<EstadoCuentaMovimientosResponse>> estadoCuenta(@RequestParam Long clienteId,
                                                                                   @RequestParam LocalDateTime fechaDesde,
                                                                                   @RequestParam LocalDateTime  fechaHasta) {

        List<EstadoCuentaMovimientos> all = movimientoUseCase.getEstadoCuentaMovimientos(clienteId,
                fechaDesde, fechaHasta);

        List<EstadoCuentaMovimientosResponse> list = all.stream()
                .map(MovimientoResponseMapper::toReporte)
                .toList();

        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), list);
    }
}
