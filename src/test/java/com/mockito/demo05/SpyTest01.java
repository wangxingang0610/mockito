package com.mockito.demo05;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SpyTest01 {

    @Test
    public void testSpy(){
        List<String> realList = new ArrayList<>();
        List<String> list = spy(realList);

        list.add("java");
        list.add("php");

        assertThat(list.get(0), equalTo("java"));
        assertThat(list.get(1), equalTo("php"));

        //真实调用了
        assertThat(list.size(), equalTo(2));

    }


    @Test
    public void testSpy2(){
        List<String> realList = new ArrayList<>();
        List<String> list = spy(realList);

        list.add("java");
        list.add("php");

        assertThat(list.get(0), equalTo("java"));
        assertThat(list.get(1), equalTo("php"));

        //真实调用了
        assertThat(list.size(), equalTo(2));

        //when
        when(list.isEmpty()).thenReturn(true);
        when(list.size()).thenReturn(0);
        assertThat(list.get(0), equalTo("java"));
        assertThat(list.get(1), equalTo("php"));

        assertThat(list.isEmpty(),equalTo(true));
        assertThat(list.size(),equalTo(0));

    }
}
