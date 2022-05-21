import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // 테스트 클래스가 Mockito를 사용함을 의미
public class DollerCalculratorTest {

    // 실제 구현된 객체 대신에 Mock 객체를 사용하게 될 클래스 의미
    // 테스트 런타임 시 해당 객체 대신 Mock 객체가 주입되어 Unit Test가 처리된다
    @Mock
    public MarketApi marketApi;

    @BeforeEach
    public void init() {
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000); // Mock 객체 주입
    }

    @Test
    public void testHello() {
        System.out.println("hello");
    }

    @Test
    public void krwTest() {
        KrwCalculator krwCalculator = new KrwCalculator();
        Calculator calculator = new Calculator(krwCalculator);
        Assertions.assertEquals(20, calculator.add(10, 10));
    }

    @Test
    public void dollerTest() {
        MarketApi marketApi = new MarketApi();
        DollerCalculator dollerCalculator = new DollerCalculator(marketApi);
        dollerCalculator.init();

        Calculator calculator = new Calculator(dollerCalculator);
        Assertions.assertEquals(10 * 1100 + 10 * 1100, calculator.add(10, 10));
        Assertions.assertEquals(0, calculator.sub(10, 10));
    }

    @Test
    public void mockTest() {
        DollerCalculator dollerCalculator = new DollerCalculator(marketApi);
        dollerCalculator.init();

        Calculator calculator = new Calculator(dollerCalculator);
        Assertions.assertEquals(60000, calculator.add(10, 10));
        Assertions.assertEquals(0, calculator.sub(10, 10));
    }
}
