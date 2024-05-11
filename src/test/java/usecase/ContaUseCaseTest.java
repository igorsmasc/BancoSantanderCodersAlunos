package usecase;

import model.Cliente;
import model.Conta;
import org.junit.*;

public class ContaUseCaseTest {

    private ContaUseCase contaUseCase;
    private Conta conta1;

    // @BeforeClass - antes da classe ser instanciada
    @BeforeClass
    public static void beforeClass() {
        // Subir banco
        // Preparar alguma config
        System.out.println("Before class");
    }

    // @Before - antes de CADA teste
    @Before
    public void before() {
        System.out.println("before");

        contaUseCase = new ContaUseCase();
        Cliente cliente1 = new Cliente("Ana", "111.111.111.11");
        conta1 = new Conta("1", cliente1);
    }

    // @After
    @After
    public void after() {
        System.out.println("After");
    }

    // @AfterClass
    @AfterClass
    public static void afterClass() {
        System.out.println("After class");
    }

    @Test
    public void deveTransferirCorretamenteEntreDuasContas() {
        System.out.println("deveTransferirCorretamenteEntreDuasContas");
        // Given - Dado

        contaUseCase.depositar(conta1, 100.0);

        Cliente cliente2 = new Cliente("Carla", "222.222.222.22");
        Conta conta2 = new Conta("2", cliente2);

        // When - Quando
        contaUseCase.transferir(conta1, conta2, 20.0);

        // Then - Entao
        // - Valor esperado - Valor atual
        Double valorEsperadoConta1 = 80.0;
        Assert.assertEquals(valorEsperadoConta1, conta1.getSaldo());

        Double valorEsperadoConta2 = 20.0;
        Assert.assertEquals(valorEsperadoConta2, conta2.getSaldo());
    }

    @Test
    public void deveDepositarCorretamente() {
        System.out.println("deveDepositarCorretamente");
        // Given -  Dado

        // When - Quando
        contaUseCase.depositar(conta1, 10.0);

        // Then
        Double valorEsperado = 10.0;
        Assert.assertEquals(valorEsperado, conta1.getSaldo());
    }

    @Test
    public void testeExemplo1() {
        System.out.println("testeExemplo");
    }
}
