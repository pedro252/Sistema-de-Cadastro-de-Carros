package com.EY.ProvaEY.carro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestCarro(
        Long id,
        @NotBlank
        String marca,
        String modelo,
        @NotNull
        Double preco
) {
}
