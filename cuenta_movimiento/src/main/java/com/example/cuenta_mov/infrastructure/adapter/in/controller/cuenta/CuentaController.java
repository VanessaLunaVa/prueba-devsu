package com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta;

import com.example.cuenta_mov.application.command.cuenta.CuentaCreateCommand;
import com.example.cuenta_mov.application.command.cuenta.CuentaUpdateCommand;
import com.example.cuenta_mov.domain.model.Cuenta;
import com.example.cuenta_mov.domain.model.EstadoCuenta;
import com.example.cuenta_mov.domain.ports.in.CuentaUseCase;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.dto.CreateCuentaRequest;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.dto.CuentaResponse;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.dto.EstadoCuentaResponse;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.dto.UpdateCuentaRequest;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.mapper.CuentaRequestMapper;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.mapper.CuentaRequestUpdateMapper;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.mapper.CuentaResponseMapper;
import com.example.cuenta_mov.util.GeneralResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/cuenta")
@RequiredArgsConstructor
@Slf4j
public class CuentaController {

    private final CuentaUseCase cuentaUseCase;

    @GetMapping()
    public GeneralResponse<List<CuentaResponse>> findAll() {
        List<Cuenta> all = cuentaUseCase.findAll();
        List<CuentaResponse> response =
                all.stream().map(CuentaResponseMapper::toResponse).toList();
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), response);
    }

    @GetMapping("/{id}")
    public GeneralResponse<CuentaResponse> findId(@PathVariable Long id) {
        Cuenta byId = cuentaUseCase.findById(id);
        CuentaResponse response = CuentaResponseMapper.toResponse(byId);
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), response);
    }

    @PostMapping()
    public GeneralResponse<CuentaResponse> save(@RequestBody CreateCuentaRequest cuenta) {
        CuentaCreateCommand command = CuentaRequestMapper.toCommand(cuenta);
        Cuenta cuentaSaved = cuentaUseCase.save(command);
        CuentaResponse response = CuentaResponseMapper.toResponse(cuentaSaved);
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), response);
    }

    @PutMapping("/{id}")
    public GeneralResponse<CuentaResponse> update(@PathVariable Long id, @RequestBody UpdateCuentaRequest cuentaRequest) {
        CuentaUpdateCommand command = CuentaRequestUpdateMapper.toCommand(cuentaRequest);
        Cuenta cuenta = cuentaUseCase.update(id, command);
        CuentaResponse response = CuentaResponseMapper.toResponse(cuenta);
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), response);
    }

    @DeleteMapping("{id}")
    public GeneralResponse<String> delete(@PathVariable Long id) {
        cuentaUseCase.delete(id);
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
    }

    @GetMapping("reporte")
    public GeneralResponse<List<EstadoCuentaResponse>> estadoCuenta(@RequestParam Long clienteId,
                                                                    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde,
                                                                    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta) {

        List<EstadoCuenta> all = cuentaUseCase.getEstadoCuenta(clienteId,
                fechaDesde, fechaHasta);

        List<EstadoCuentaResponse> list = all.stream()
                .map(CuentaResponseMapper::toResponseEstadoCuenta)
                .toList();

        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), list);
    }
}
