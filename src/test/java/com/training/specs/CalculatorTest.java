package com.training.specs;

import com.training.utils.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    //Arrange  Act  Assert
    private Calculator c;
    @BeforeEach
    public void setUp(){

         c = new Calculator();
    }

    //method which is annotated as @Test
    @Test
    public void testingAdd(){

       assertEquals(17, c.add(5,6));

    }

    @Test
    public void testingSub(){

    assertEquals(10,c.sub(20,10));



    }

    @AfterEach
    public void aftEach(){
        c=null;
    }
}
