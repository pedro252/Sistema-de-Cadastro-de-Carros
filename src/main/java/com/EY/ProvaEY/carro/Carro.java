package com.EY.ProvaEY.carro;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Table(name = "carros")
@Entity(name = "carro")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    public Carro() {
        }

    private Double preco;

    private boolean active = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Carro(RequestCarro requestProduct) {
        this.marca = requestProduct.marca();
        this.modelo = requestProduct.modelo();
        this.preco = requestProduct.preco();
    }
}
