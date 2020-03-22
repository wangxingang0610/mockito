package com.mockito.demo06;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * ArgumentMatcher
 */
public class ArgumentMatcherTest {

    @Test
    public void basicTest(){
        //mock
        List<String> list = mock(ArrayList.class);

        //when
        when(list.get(0)).thenReturn("first");

        //断言
        assertThat(list.get(0), equalTo("first"));
        assertThat(list.get(1),nullValue());
    }



    @Test
    public void testComplex(){
        Foo foo = mock(Foo.class);
        when(foo.function(Mockito.isA(Parent.class))).thenReturn(10);
        int result = foo.function(new Child2());
        assertThat(result, equalTo(10));


        when(foo.function(Mockito.any(Child1.class))).thenReturn(0);
        result = foo.function(new Child1());
        assertThat(result, equalTo(0));

    }

    static class Foo{
        int function(Parent p){
            return p.work();
        }
    }

    interface Parent{
        int work();
    }

    class Child1 implements Parent{
        @Override
        public int work() {
            throw new RuntimeException();
        }
    }
    class Child2 implements Parent{
        @Override
        public int work() {
            throw new RuntimeException();
        }
    }











}
