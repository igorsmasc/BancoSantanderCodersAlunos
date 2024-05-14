package main;

import domain.gateway.ContaGateway;
import domain.model.Cliente;
import domain.model.Conta;
import domain.usecase.ContaUseCase;
import infra.gateway.ContaGatewayDB;
import infra.gateway.ContaGatewayHttp;
import infra.gateway.ContaGatewayLocal;

public class Main {
    public static void main(String[] args) throws Exception {

        ContaGateway contaGateway = new ContaGatewayHttp();
        ContaUseCase contaUseCase = new ContaUseCase(contaGateway);

        Cliente cliente = new Cliente("Ana", "111.111.111.11");
        Conta conta = new Conta("1", cliente);

        contaUseCase.criarConta(conta);
        contaUseCase.depositar("1", 1000.0);

        System.out.println(contaUseCase.buscarConta("1"));
    }
}
