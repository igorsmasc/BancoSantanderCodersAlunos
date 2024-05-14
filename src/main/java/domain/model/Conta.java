package domain.model;

import domain.exception.SaldoInvalidoException;

public class Conta {
    private String id;
    private Cliente cliente;
    private Double saldo;
    private Double saldoDisponivelParaEmprestimo;
    // Por hora vamos utilziar Double para valores em reais
    // e no futuro vamos alterar para BigDecimal

    public Conta(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.saldoDisponivelParaEmprestimo = 0.0;
    }

    public void depositar(Double valor) {
        this.saldo += valor;
    }

    public void sacar(Double valor) {
        this.saldo -= valor;
    }

    public void adicionarSaldoParaEmprestimo(Double valor) {
        this.saldoDisponivelParaEmprestimo += valor;
    }

    public void removerSaldoParaEmprestimo(Double valor) throws Exception {
        // Exception
        if(this.saldoDisponivelParaEmprestimo < valor) {
            throw new SaldoInvalidoException("Saldo para emprestimo inferior ao solicitado");
        }

        this.saldoDisponivelParaEmprestimo -= valor;
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double getSaldoDisponivelParaEmprestimo() {
        return saldoDisponivelParaEmprestimo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id='" + id + '\'' +
                ", cliente=" + cliente +
                ", saldo=" + saldo +
                ", saldoDisponivelParaEmprestimo=" + saldoDisponivelParaEmprestimo +
                '}';
    }
}
