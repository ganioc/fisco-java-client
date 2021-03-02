package com.ruff.hello.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FizzTest {

    @Test
    public void FizzNormalNumbers(){
        Fizz fb = new Fizz();
        Assertions.assertEquals("1", fb.convert(1));
    }

    @Test
    public void FizzThreeNumbers(){
        Fizz fb = new Fizz();
        Assertions.assertEquals("Fizz", fb.convert(3));
    }
    @Test
    public void FizzThreeAndFiveNumbers(){
        Fizz fb = new Fizz();
        Assertions.assertEquals("Buzz", fb.convert(5));
    }
}