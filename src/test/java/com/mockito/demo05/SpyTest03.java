package com.mockito.demo05;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

//@RunWith(MockitoJUnitRunner.class)
public class SpyTest03 {

    @Spy
    private List<String> list = new ArrayList<>();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testSpy(){

        list.add("java");
        list.add("php");

        assertThat(list.get(0), equalTo("java"));
        assertThat(list.get(1), equalTo("php"));
        assertThat(list.size(), equalTo(2));
    }
}
