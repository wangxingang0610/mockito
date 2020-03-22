package com.mockito.demo07;

import java.io.Serializable;
import java.util.Collection;

public class SimpleService {

    public int method1(int num, String str, Collection<?> c, Serializable ser){
        throw new RuntimeException();
    }

    public void method2(int num, String str, Collection<?> c, Serializable ser){
        throw new RuntimeException();
    }
}
