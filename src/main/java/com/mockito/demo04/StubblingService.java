package com.mockito.demo04;

public class StubblingService {

    public int getNum(){
        System.out.println("----getNum----");
        return 10;
    }

    public String getStr(){
        System.out.println("-----getStr----");
        throw new RuntimeException();
    }
}
