package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {

    private Feline feline;
    private Lion lion;

    private final String sex;
    private final boolean hasManeExpected;

    public LionTest(String sex, boolean hasManeExpected) {
        this.sex = sex;
        this.hasManeExpected = hasManeExpected;
    }
    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false}
        };
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void init() throws Exception {
        MockitoAnnotations.openMocks(this);
        feline = Mockito.mock(Feline.class);
        lion = new Lion(this.sex, feline);
    }

    @Test
    public void getKittensReturnKittensFromFeline() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedResult = feline.getKittens();
        int actualResult = lion.getKittens();

        Mockito.verify(feline,Mockito.times(2)).getKittens();
        assertEquals("У льва количество котят взяли не из семейства кошачьих",
                expectedResult, actualResult);
    }

    @Test
    public void doesHaveManeReturnValidValue() {
        boolean expectedResult = this.hasManeExpected;
        boolean actualResult = lion.doesHaveMane();
        assertEquals("Неожиданное значение для гривы льва",
                expectedResult, actualResult);
    }

    @Test
    public void getFoodReturnFoodForFeline() throws Exception {
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List expectedResult = feline.getFood("Хищник");
        List actualResult = lion.getFood();

        Mockito.verify(feline,Mockito.times(2)).getFood("Хищник");
        assertEquals("Львам дали не ту еду, что едят хищники",
                expectedResult, actualResult);
    }

//    @Test
//    public void negativeTestSexNotValidThrowException() throws Exception {
//        exceptionRule.expect(Exception.class);
//        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самей или самка");
//        lion = new Lion("львёнок", feline);
//    }



}

@RunWith(MockitoJUnitRunner.class)
class LionTestNegative {

    private Lion lion;

    @Mock
    Feline feline;


    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void negativeTestSexNotValidThrowException() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самей или самка");
        lion = new Lion("львёнок", feline);
    }

}

