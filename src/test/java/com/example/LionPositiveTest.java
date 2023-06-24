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
public class LionPositiveTest {

    @Mock
    Feline feline;

    private Lion lion;
    private String sex = "Самец";

    @Before
    public void init() throws Exception {
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
    public void getFoodReturnFoodForFeline() throws Exception {
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List expectedResult = feline.getFood("Хищник");
        List actualResult = lion.getFood();

        Mockito.verify(feline,Mockito.times(2)).getFood("Хищник");
        assertEquals("Львам дали не ту еду, что едят хищники",
                expectedResult, actualResult);
    }

}


