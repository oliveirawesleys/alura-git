package microservicesspringcloud.microservices.client;

import microservicesspringcloud.microservices.dto.InfoFornecedorDto;
import microservicesspringcloud.microservices.dto.InfoPedidoDto;
import microservicesspringcloud.microservices.dto.ItemDaCompraDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFornecedorDto getInfoPorEstado(@PathVariable String estado);

    @PostMapping("/pedido")
    InfoPedidoDto realizaPedido(List<ItemDaCompraDto> itens);
}
