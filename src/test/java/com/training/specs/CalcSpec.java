package com.training.specs;

import com.training.utils.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcSpec {
   private static Calculator c;
     @BeforeAll
     public static void befAll(){
         //Arranging the data -- I have created  a Calculator object
         System.out.println("before all the tests begins");
         c=new Calculator();
     }


     @AfterAll
     public static void aftAll(){

         c=null;
     }


     @AfterEach
     public void aftEach(){

         System.out.println("after each test");
     }

    @BeforeEach
    public void befEach(){
        System.out.println("before each test ...");

    }



  //Arranging the data
  // Acting
  // Assert
    @Test
    public void testAdd(){

        //Act -- which method is being tested here
        //means we have to execute
        int retVal = c.add(2,2);

        //Assertions
        assertEquals(4,retVal);



        //test the code - fails -red -- go and work again on the logic -- test -green


    }

    //what should be the annotation
    @Test
    public void testSub(){

        //Acting and Assert
        //assertEquals takes 2 arguments ,expected ,actual
       assertEquals(1 , c.sub(5,4));


    }


}
