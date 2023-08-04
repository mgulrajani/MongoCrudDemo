package com.training.specs;

import com.training.utils.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSpec {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        System.out.println("initialising calculator");
        this.calculator =new Calculator();

    }
    @BeforeAll
    public static void setAll(){
        System.out.println("before all the tests");
    }
    @Test
    public void testAdd(){
        System.out.println("in the test");
        assertEquals(9,this.calculator.add(4,5));
        System.out.println("after assertion");

    }

    @AfterEach
    public void afterE(){
        System.out.println("after test is done");
    }

    @AfterAll
    public static void afterA(){
        System.out.println("after all ......done");
    }
}
