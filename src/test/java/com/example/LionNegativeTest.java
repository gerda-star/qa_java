package com.example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionNegativeTest {

    private Lion lion;
    private String sex = "Львёнок";

    @Mock
    Feline feline;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void negativeTestSexNotValidThrowException() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самей или самка");
        lion = new Lion(this.sex, feline);
    }

}
