package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {


    @Spy
    private Feline feline;


    @Test
    public void eatMeatReturnFoodForPredator() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyReturnStringFeline()  {
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();
        assertEquals("Вернулось неверное семейство для класса кошачьих",
                expectedResult, actualResult);
    }

    @Test
    public void getKittensReturnValidCount() {
        int expectedResult = 5;
        int actualResult = feline.getKittens(5);
        assertEquals("Количество вернувшихся котят не совпадает с запрашиваемым",
                expectedResult, actualResult);
    }

    @Test
    public void getKittensWithoutParametersReturnOne() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }


}
