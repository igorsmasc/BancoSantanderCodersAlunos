package usecase;

import model.Conta;

public class ContaUseCase {

    public void transferir(Conta origem, Conta destino, Double valor) {
            origem.sacar(valor);
            destino.depositar(valor);
    }

    public void depositar(Conta conta, Double valor) {
        // Gateway - buscar conta

        conta.depositar(valor);
    }

    public void emprestimo(Conta conta, Double valor) throws Exception {
        if(conta.getSaldoDisponivelParaEmprestimo() >= valor) {
            conta.removerSaldoParaEmprestimo(valor);
            depositar(conta, valor);
        }
    }

}
