package com.EY.ProvaEY.gateway;
import com.EY.ProvaEY.gateway.response.ChecarEstoqueResponse;
import com.EY.ProvaEY.gateway.response.StatusDoEstoque;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Objects;

@Service
public class ChecarEstoqueGateway {
    private static final Logger LOG = LoggerFactory.getLogger(ChecarEstoqueGateway.class);
    private static final String CARRO_INDISPONIVEL = "O carro está indisponível para a venda.";
    private static final String CARRO_DISPONIVEL = "O carro está disponível. Você pode prosseguir com a venda.";
    private static final String ERROR_CONSULTA_ESTOQUE = "Tivemos um erro ao consultar o estoque";

    @Value("${mock.check.estoque.url}")
    private String estoqueUrl;

    private final RestTemplate restTemplate;

    public ChecarEstoqueGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String consultarEstoquePorId(String id) {
        if (estoqueUrl == null || estoqueUrl.isBlank()) {
            LOG.error("URL de estoque não configurada corretamente");
            return CARRO_INDISPONIVEL;
        }

        try {
            String url = UriComponentsBuilder.fromHttpUrl(estoqueUrl)
                    .pathSegment(id)
                    .toUriString();

            ChecarEstoqueResponse response = restTemplate.getForObject(url, ChecarEstoqueResponse.class);

            if (Objects.nonNull(response) && StatusDoEstoque.AVAILABLE.equals(response.getStatus())) {
                return CARRO_DISPONIVEL;
            } else {
                return CARRO_INDISPONIVEL;
            }
        } catch (Exception e) {
            LOG.error(ERROR_CONSULTA_ESTOQUE, e);
            return CARRO_INDISPONIVEL;
        }
    }
}
