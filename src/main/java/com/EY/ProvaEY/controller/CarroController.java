package com.EY.ProvaEY.controller;

import com.EY.ProvaEY.carro.*;
import com.EY.ProvaEY.gateway.ChecarEstoqueGateway;
import com.EY.ProvaEY.service.CarroService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("carro")
public class CarroController {

    @Autowired
    private ChecarEstoqueGateway checarEstoqueGateway;

    @Autowired
    private CarroService carroService;

    @GetMapping("/estoque/{id}")
    public ResponseEntity<String> consultarEstoque(@PathVariable String id) {
        // Consultar a disponibilidade do carro
        String estoqueResponse = checarEstoqueGateway.consultarEstoquePorId(id);
        return ResponseEntity.ok(estoqueResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        var allCarro = carroService.findAllActiveCarros();
        return ResponseEntity.ok(allCarro);
    }

    @PostMapping("/add")
    public ResponseEntity<String> registerProduct(@RequestBody @Valid RequestCarro data) {
        carroService.registraCarro(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualizar")
    @Transactional
    public ResponseEntity<?> updateProduct(@RequestBody @Valid RequestCarro data) {
        Optional<Carro> updatedCarro = carroService.atualizarCarro(data);
        return updatedCarro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteCarro(@PathVariable String id) {
        carroService.deleteCarro(id);
        return ResponseEntity.noContent().build();
    }
}
