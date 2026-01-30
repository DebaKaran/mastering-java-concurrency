package com.deba.threadd.management;

public class CalculatorTest {
    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++) {
            Calculator task = new Calculator(i);
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}
