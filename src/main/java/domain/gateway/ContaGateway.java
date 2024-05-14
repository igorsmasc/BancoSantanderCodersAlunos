package domain.gateway;

import domain.model.Conta;

public interface ContaGateway {
    Conta findById(String id);
    Conta save(Conta conta);
}
