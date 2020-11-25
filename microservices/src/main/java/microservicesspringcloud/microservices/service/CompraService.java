package microservicesspringcloud.microservices.service;

import microservicesspringcloud.microservices.dto.CompraDto;
import microservicesspringcloud.microservices.dto.InfoFornecedorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private RestTemplate client;

    public void realizaCompra(CompraDto compra) {
        //RestTemplate client = new RestTemplate();
        ResponseEntity<InfoFornecedorDto> exchange =
                //client.exchange("http://localhost:8082/info/" + compra.getEndereco().getEstado(),
                client.exchange("http://fornecedor/info/" + compra.getEndereco().getEstado(),
                HttpMethod.GET, null, InfoFornecedorDto.class);

        System.out.println(exchange.getBody().getEndereco());
    }
}
