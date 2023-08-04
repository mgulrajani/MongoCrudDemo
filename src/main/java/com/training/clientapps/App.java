package com.training.clientapps;

import com.training.utils.Calculator;

public class App {
    public static void main(String[] args) {

        Calculator c =  new Calculator();

        int retval = c.add(2,2);
        System.out.println(retval);


    }
}
