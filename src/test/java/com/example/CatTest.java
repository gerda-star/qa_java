package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnValidString() {
        String expectedResult = "Мяу";
        String actualResult = cat.getSound();
        assertEquals("Метод getSound вернул неожиданное значение для кошки", expectedResult, actualResult);
    }

    @Test
    public void getFoodReturnFoodForFeline() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List expectedResult = feline.eatMeat();
        List actualResult = cat.getFood();

        Mockito.verify(feline,Mockito.times(2)).eatMeat();
        assertEquals("Кошкам дали не ту еду, что ест семейство кошачьих",
                expectedResult, actualResult);
    }

}

