package model;

import exception.SaldoInvalidoException;
import org.junit.Assert;
import org.junit.Test;

public class ContaTest {

    @Test
    public void deveLancarExceptionCasoValorSolicitadoSejaMaiorQueValorDisponivel() {
        // Given
        Cliente cliente1 = new Cliente("Ana", "123.123.123-12");
        Conta conta1 = new Conta("1", cliente1);

        // When
        try {
            conta1.removerSaldoParaEmprestimo(100.0);
            Assert.fail("Nao lancou nenhuma exception");
        } catch (Exception e) {
            Assert.assertEquals("Saldo para emprestimo inferior ao solicitado", e.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void deveLancarExceptionCasoValorSolicitadoSejaMaiorQueValorDisponivel_2() throws Exception {
        // Given
        Cliente cliente1 = new Cliente("Ana", "123.123.123-12");
        Conta conta1 = new Conta("1", cliente1);

        // When
        conta1.removerSaldoParaEmprestimo(100.0);
    }

    @Test
    public void deveLancarExceptionCasoValorSolicitadoSejaMaiorQueValorDisponivel_3() {
        Cliente cliente1 = new Cliente("Ana", "123.123.123-12");
        Conta conta1 = new Conta("1", cliente1);

        Throwable throwable = Assert.assertThrows(SaldoInvalidoException.class, () -> conta1.removerSaldoParaEmprestimo(100.0));
        // Assert.assertEquals("Saldo para emprestimo inferior ao solicitado", throwable.getMessage());
    }

}
