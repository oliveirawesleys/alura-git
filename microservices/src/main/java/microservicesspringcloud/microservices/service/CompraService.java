package microservicesspringcloud.microservices.service;

import microservicesspringcloud.microservices.client.FornecedorClient;
import microservicesspringcloud.microservices.dto.CompraDto;
import microservicesspringcloud.microservices.dto.InfoFornecedorDto;
import microservicesspringcloud.microservices.dto.InfoPedidoDto;
import microservicesspringcloud.microservices.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDto compra) {

        final String estado = compra.getEndereco().getEstado();

        LOG.info("Buscando informações do fornecedor de {}", estado);
        InfoFornecedorDto info = fornecedorClient.getInfoPorEstado(estado);

        LOG.info("Realizando um pedido");
        InfoPedidoDto pedido = fornecedorClient.realizaPedido(compra.getItens());

        System.out.println(info.getEndereco());

        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
        compraSalva.setEnderecoDestino(compra.getEndereco().toString());

        return compraSalva;
    }
}
