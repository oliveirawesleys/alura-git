package microservicesspringcloud.microservices.service;

import com.netflix.discovery.converters.Auto;
import microservicesspringcloud.microservices.client.FornecedorClient;
import microservicesspringcloud.microservices.dto.CompraDto;
import microservicesspringcloud.microservices.dto.InfoFornecedorDto;
import microservicesspringcloud.microservices.dto.InfoPedidoDto;
import microservicesspringcloud.microservices.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDto compra) {

        InfoFornecedorDto info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());

        InfoPedidoDto pedido = fornecedorClient.realizaPedido(compra.getItens());

        System.out.println(info.getEndereco());

        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
        compraSalva.setEnderecoDestino(compra.getEndereco().toString());

        return compraSalva;
    }
}
