package co.com.sofka.app.calculator;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

public class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals( first + " + " + second + " should equal " + expectedResult,expectedResult, basicCalculator.sum(first, second));
    }


    @Test
    @DisplayName("Testing rest: 5-3=2")
    public void rest() {
        // Arrange
        Long number1 = 5L;
        Long number2 = 3L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.rest(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing div: 15/3=5")
    public void div() {
        // Arrange
        Long number1 = 15L;
        Long number2 = 3L;
        Long expectedValue = 5L;

        // Act
        Long result = basicCalculator.div(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }
    @Test
    @DisplayName("Testing div by zero: 15/0=Sintax error")
    public void divError() {
        Long number1 = 15L;
        Long number2 = 0L;
        var response = Assertions.assertThrows(RuntimeException.class,
                ()->{ long result =basicCalculator.div(number1,number2);
        });
        Assertions.assertEquals("/ by zero",response.getMessage());
    }
}
