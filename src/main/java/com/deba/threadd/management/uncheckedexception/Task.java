package com.deba.threadd.management.uncheckedexception;

public class Task implements Runnable{
    @Override
    public void run() {
        int numero=Integer.parseInt("TTT");
        System.out.println(numero);
    }
}
