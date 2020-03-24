package com.mockito.demo05;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class SpyTest02 {

    @Spy
    private List<String> list = new ArrayList<>();

    @Test
    public void testSpy(){

        list.add("java");
        list.add("php");

        assertThat(list.get(0), equalTo("java"));
        assertThat(list.get(1), equalTo("php"));
        assertThat(list.size(), equalTo(2));
    }

    @Test
    public void test() {
        // mock creation
        List<String> data = Mockito.mock(List.class);

        // stubbing, 调用方法抛出异常
        Mockito.when(data.get(0)).thenThrow(NullPointerException.class);
        Mockito.doThrow(NullPointerException.class).when(data).get(1);

        // verification
//        Assertions.assertThrows(NullPointerException.class, () -> data.get(0));
//        Assertions.assertThrowsssertThrows(NullPointerException.class, () -> data.get(1));
    }


}
