package usecase;

import exception.SaldoInvalidoException;
import model.Conta;

public class ContaUseCase {

    public void transferir(Conta origem, Conta destino, Double valor) {
            // Gateway - buscar contas

            origem.sacar(valor);
            destino.depositar(valor);
    }

    public void depositar(Conta conta, Double valor) {
        // Gateway - buscar conta

        conta.depositar(valor);
    }

    public void emprestimo(Conta conta, Double valor) throws SaldoInvalidoException {
        if(conta.getSaldoDisponivelParaEmprestimo() >= valor) {
            conta.removerSaldoParaEmprestimo(valor);
            depositar(conta, valor);
        }
    }

}
