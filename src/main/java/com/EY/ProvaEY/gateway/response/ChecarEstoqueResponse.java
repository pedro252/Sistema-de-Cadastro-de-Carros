package com.EY.ProvaEY.gateway.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class ChecarEstoqueResponse {

    private StatusDoEstoque status;

    public void setStatus(StatusDoEstoque status) {
        this.status = status;
    }

    public StatusDoEstoque getStatus() {
        return status;
    }
}