package repet;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

@RunWith(JUnit4.class) // podajemy jakiego frameworka/biblioteki będziemy używali do wykonywania testów (musi być w dependencies)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // specjalna adnotacja, która pozwala kontrolować jaka będzie kolejność wykonywania testów (wybrać: NAME_ASCENDING) - trzeba wtedy ponumerować testy (funkcje) np. test_1_nazwa...
public class CalculatorTests { // każda klasa jest oddzielną instancją, która zostaje stworzona przed rozpoczęciem testów, co oznacza, że każda klasa może przechowywać również pola np.zamiast w teście tworzyć new Calculator robimy pole private Calculator

    private static Calculator calculator;

    @BeforeClass
    public static void funkcjaWywolanaPrzdWszystkimTestami() { // musi być static; jak stosujemy BeforeClass yo pola klasy też muszą być static
        System.out.println("Rozpoczynam testy w klasie: " + CalculatorTests.class);
        calculator = new Calculator();
    }

    @Before
    public void funkcjaPrzedKazdymTestem() {
        System.out.println("Testowanko.");
    }

    @Test // żeby stworzyć pojedynczą metodę testową używamy adnotacji @Test (szczegółowo opisujemy metodę)
    public void test_1_calculator_Should_Return_10_when_add_5_and_5() {
//        Calculator calculatorCitizen = new Calculator("Citizen");

//        int sumResult = calculatorCitizen.sum(5, 5);

        int sumResult = calculator.sum(5,5);

        // zapewniam, że wynik dzialania funkcji sum, dla parametrów 5 i 5, wynosi 10
        Assert.assertEquals(10, sumResult);
        Assert.assertNotNull(calculator);
    }

    @Test
    public void test_2_calculator_Should_Return_10_when_add_6_and_4() {

        int sumResult = calculator.sum(6,4);

        // zapewniam, że wynik dzialania funkcji sum, dla parametrów 6 i 4, wynosi 10
        Assert.assertEquals(10, sumResult);
    }
}
