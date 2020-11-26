package microservicefornecedor.fornecedor.service;

import microservicefornecedor.fornecedor.model.InfoFornecedor;
import microservicefornecedor.fornecedor.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public InfoFornecedor getInforPorEstado(String estado) {
        return infoRepository.findByEstado(estado);
    }
}
