package com.wolfman.spring;

public class UncaughtExceptionHandlerDemo {


    public static void main(String[] args) {
        Thread.currentThread()
                .setUncaughtExceptionHandler((t,e) ->{
                    System.out.println(e.getMessage());
                });


        throw  new RuntimeException("故意的");




    }


}
