package com.example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private Feline feline;
    private Lion lion;

    private final String sex;
    private final boolean hasManeExpected;

    public LionParameterizedTest(String sex, boolean hasManeExpected) {
        this.sex = sex;
        this.hasManeExpected = hasManeExpected;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void init() throws Exception {
        MockitoAnnotations.openMocks(this);
        feline = Mockito.mock(Feline.class);
        lion = new Lion(this.sex, feline);
    }

    @Test
    public void doesHaveManeReturnValidValue() {
        boolean expectedResult = this.hasManeExpected;
        boolean actualResult = lion.doesHaveMane();
        assertEquals("Неожиданное значение для гривы льва",
                expectedResult, actualResult);
    }

}
