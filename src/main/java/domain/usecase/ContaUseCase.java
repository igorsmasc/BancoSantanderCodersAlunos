package domain.usecase;

import domain.gateway.ContaGateway;
import domain.model.Conta;

public class ContaUseCase {

    private ContaGateway contaGateway;

    public ContaUseCase(ContaGateway contaGateway) {
        this.contaGateway = contaGateway;
    }

    public void criarConta(Conta conta) {
        contaGateway.save(conta);
    }

    public Conta buscarConta(String id) {
        return contaGateway.findById(id);
    }

    public void transferir(String idOrigem, String idDestino, Double valor) throws Exception {
        Conta contaOrigem = contaGateway.findById(idOrigem);
        if (contaOrigem == null) throw new Exception("Conta origem invalida - [id: " + idOrigem + "]");

        Conta contaDestino = contaGateway.findById(idDestino);
        if (contaDestino == null) throw new Exception("Conta destino invalida - [id: " + idDestino + "]");

        contaOrigem.sacar(valor);
        contaDestino.depositar(valor);

        contaGateway.save(contaOrigem);
        contaGateway.save(contaDestino);
    }

    public void depositar(String idConta, Double valor) throws Exception {
        Conta conta = contaGateway.findById(idConta);
        if (conta == null) throw new Exception("Conta invalida - [id: " + idConta + "]");

        conta.depositar(valor);
        contaGateway.save(conta);
    }

    public void emprestimo(String idConta, Double valor) throws Exception {
        Conta conta = contaGateway.findById(idConta);
        if (conta == null) throw new Exception("Conta invalida - [id: " + idConta + "]");

        if (conta.getSaldoDisponivelParaEmprestimo() >= valor) {
            conta.removerSaldoParaEmprestimo(valor);
            conta.depositar(valor);
        }

        contaGateway.save(conta);
    }

}
