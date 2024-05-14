package infra.gateway;

import domain.gateway.ContaGateway;
import domain.model.Conta;

import java.util.HashMap;
import java.util.Map;

public class ContaGatewayLocal implements ContaGateway {
    public static Map<String, Conta> contas = new HashMap<>();

    @Override
    public Conta findById(String id) {
        if(contas.containsKey(id)) {
            return contas.get(id);
        }

        return null;
    }

    @Override
    public Conta save(Conta conta) {
        return contas.put(conta.getId(), conta);
    }
}
