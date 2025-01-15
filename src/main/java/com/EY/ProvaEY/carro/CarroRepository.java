package com.EY.ProvaEY.carro;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, String> {
    List<Carro> findAllByActiveTrue();
}
