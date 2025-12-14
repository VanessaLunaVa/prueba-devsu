package com.example.cliente_persona.infrastructure.adapter.in.controller;

import com.example.cliente_persona.application.command.ClienteCommand;
import com.example.cliente_persona.domain.model.Cliente;
import com.example.cliente_persona.domain.ports.in.ClienteUseCase;
import com.example.cliente_persona.infrastructure.adapter.in.controller.dto.ClienteRequest;
import com.example.cliente_persona.infrastructure.adapter.in.controller.dto.ClienteResponse;
import com.example.cliente_persona.infrastructure.adapter.in.controller.mapper.ClienteRequestMapper;
import com.example.cliente_persona.infrastructure.adapter.in.controller.mapper.ClienteResponseMapper;
import com.example.cliente_persona.util.GeneralResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
@Slf4j
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    @GetMapping()
    public GeneralResponse<List<ClienteResponse>> findAll() {
        List<Cliente> all = clienteUseCase.findAll();
        List<ClienteResponse> response =
                all.stream().map(ClienteResponseMapper::toResponse).toList();
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), response);
    }

    @GetMapping("/{id}")
    public GeneralResponse<ClienteResponse> findId(@PathVariable Long id) {
        Cliente byId = clienteUseCase.findById(id);
        ClienteResponse cliente = ClienteResponseMapper.toResponse(byId);
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), cliente);
    }

    @PostMapping()
    public GeneralResponse<ClienteResponse> save(@RequestBody ClienteRequest cliente) {
        ClienteCommand command = ClienteRequestMapper.toCommand(cliente);
        Cliente save = clienteUseCase.save(command);
        ClienteResponse response = ClienteResponseMapper.toResponse(save);
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), response);
    }

    @PutMapping("/{id}")
    public GeneralResponse<ClienteResponse> update(@PathVariable Long id, @RequestBody ClienteRequest cliente) {
        ClienteCommand command = ClienteRequestMapper.toCommand(cliente);
        Cliente save = clienteUseCase.update(id, command);
        ClienteResponse response = ClienteResponseMapper.toResponse(save);
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), response);
    }

    @DeleteMapping("/{id}")
    public GeneralResponse<String> delete(@PathVariable Long id) {
        clienteUseCase.delete(id);
        return GeneralResponse.ok(HttpStatus.OK.getReasonPhrase(), "Cliente eliminado correctamente");
    }
}
