package usecase;

import domain.gateway.ContaGateway;
import domain.model.Cliente;
import domain.model.Conta;
import domain.usecase.ContaUseCase;
import infra.gateway.ContaGatewayLocal;
import org.junit.*;

public class ContaUseCaseTest {

    private ContaUseCase contaUseCase;
    private ContaGateway contaGateway;

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

        contaGateway = new ContaGatewayLocal();
        contaUseCase = new ContaUseCase(contaGateway);

        Cliente cliente1 = new Cliente("Ana", "111.111.111.11");
        Conta conta1 = new Conta("1", cliente1);

        Cliente cliente2 = new Cliente("Carla", "222.222.222.22");
        Conta conta2 = new Conta("2", cliente2);

        contaGateway.save(conta1);
        contaGateway.save(conta2);
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
    public void deveTransferirCorretamenteEntreDuasContas() throws Exception {
        // Mocks

        System.out.println("deveTransferirCorretamenteEntreDuasContas");
        // Given - Dado
        contaUseCase.depositar("1", 100.0);

        // When - Quando
        contaUseCase.transferir("1", "2", 20.0);

        // Then - Entao
        // - Valor esperado - Valor atual
        Double valorEsperadoConta1 = 80.0;
        Conta conta1DB = contaGateway.findById("1");
        Assert.assertEquals(valorEsperadoConta1, conta1DB.getSaldo());

        Double valorEsperadoConta2 = 20.0;
        Conta conta2DB = contaGateway.findById("2");
        Assert.assertEquals(valorEsperadoConta2, conta2DB.getSaldo());
    }

    @Test
    public void deveDepositarCorretamente() throws Exception {
        System.out.println("deveDepositarCorretamente");
        // Given -  Dado

        // When - Quando
        contaUseCase.depositar("1", 10.0);
        Conta conta1 = contaGateway.findById("1");

        // Then
        Double valorEsperado = 10.0;
        Assert.assertEquals(valorEsperado, conta1.getSaldo());
    }

    @Test
    public void testeExemplo1() {
        System.out.println("testeExemplo");
    }
}
