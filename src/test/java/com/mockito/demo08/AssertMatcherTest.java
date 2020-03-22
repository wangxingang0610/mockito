package com.mockito.demo08;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertMatcherTest {

    @Test
    public void test(){

        int a = 10;
        assertThat(a, equalTo(10));
        assertThat(a, not(equalTo(2)));
        assertThat(a, is(10));
        assertThat(a, is(not(8)));
    }

    @Test
    public void test2(){

        double price = 12.99;
        assertThat(price, either(equalTo(12.99)).or(equalTo(499.09)));
        assertThat(price, both(equalTo(12.99)).and(not(equalTo(499.09))));
    }

    @Test
    public void test3(){

        double price = 12.99;
        assertThat(price, anyOf(is(12.99), is(30.8), not(76.00)));
        assertThat(price, allOf(is(12.99), is(not(30.8)), not(equalTo(76.00)),not(is(66.99)), not(equalTo(23.1212))));
    }

    @Test
    public void test4(){
        int num = 8;

        assertThat(Stream.of(1,2,3).anyMatch(integer -> integer > 2), equalTo(true));
        assertThat(Stream.of(1,2,3).allMatch(integer -> integer > 0), equalTo(true));
    }
}
