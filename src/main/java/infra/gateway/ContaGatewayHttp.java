package infra.gateway;

import domain.gateway.ContaGateway;
import domain.model.Conta;

public class ContaGatewayHttp implements ContaGateway {
    @Override
    public Conta findById(String id) {
        // Faz GET http para a app de contas
        return null;
    }

    @Override
    public Conta save(Conta conta) {
        // Faz POST http para a app de contas
        return null;
    }
}
