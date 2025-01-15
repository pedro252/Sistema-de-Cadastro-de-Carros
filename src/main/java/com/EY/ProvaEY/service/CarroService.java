package com.EY.ProvaEY.service;

import com.EY.ProvaEY.carro.Carro;
import com.EY.ProvaEY.carro.CarroRepository;
import com.EY.ProvaEY.carro.RequestCarro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public List<Carro> findAllActiveCarros() {
        return repository.findAllByActiveTrue();
    }

    public void registraCarro (RequestCarro data) {
        Carro newProduct = new Carro(data);
        repository.save(newProduct);
    }

    public Optional<Carro> atualizarCarro (RequestCarro data) {
        Optional<Carro> optionalCarro = repository.findById(String.valueOf(data.id()));
        optionalCarro.ifPresent(carro -> {
            carro.setMarca(data.marca());
            carro.setModelo(data.modelo());
            carro.setPreco(data.preco());
        });
        return optionalCarro;
    }

    public void deleteCarro(String id) {
        Optional<Carro> optionalProduct = repository.findById(id);
        optionalProduct.ifPresent(product -> {
            product.setActive(false);
            repository.save(product);
        });
    }
}


