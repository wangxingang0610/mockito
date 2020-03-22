package com.mockito.demo03;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StubblingTest {

    private List<String> list;

    @Before
    public void setUp(){
        this.list = mock(ArrayList.class);
    }


    @Test
    public void testHowToStubbling(){
        when(list.get(0)).thenReturn("first");
        assertThat(list.get(0),equalTo("first"));
    }

    @Test
    public void testStubblingWithException(){
        when(list.get(0)).thenReturn("first");
        assertThat(list.get(0),equalTo("first"));

        when(list.get(anyInt())).thenThrow(new RuntimeException());
        try{
            list.get(0);
            fail("not to here");
        }catch (Exception e){
            System.out.println("--------error---------");
            assertThat("error", (e instanceof RuntimeException));
        }
    }

    @Test
    public void howToStubblingVoidMethod(){
        //when
        doNothing().when(list).clear();

        //调用
        list.clear();

        //verify time 1
//        verify(list,times(1)).clear();

        //verify time 2
//        verify(list,times(2)).clear();
    }


    /**
     * stubbling return
     */
    @Test
    public void stubblingDoReturn(){
        //以下两种方式等同
        when(list.get(0)).thenReturn("first");
        doReturn("second").when(list).get(1);

        assertThat(list.get(0), equalTo("first"));
        assertThat(list.get(1), equalTo("second"));
    }



    @Test
    public void testIterateSubbling(){
//        when(list.size()).thenReturn(1);
//        when(list.size()).thenReturn(2);
//        when(list.size()).thenReturn(3);
//        when(list.size()).thenReturn(4);
//        assertThat(list.get(2), equalTo("third"));


//        when(list.size()).thenReturn(1, 2, 3, 4);
//        assertThat(list.size(), equalTo(1));
//        assertThat(list.size(), equalTo(2));
//        assertThat(list.size(), equalTo(3));
//        assertThat(list.size(), equalTo(4));


        when(list.size()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4);
        assertThat(list.size(), equalTo(1));
        assertThat(list.size(), equalTo(2));
        assertThat(list.size(), equalTo(3));
        assertThat(list.size(), equalTo(4));
    }

    @Test
    public void testStubblingWithAnswer(){
        when(list.get(anyInt())).thenAnswer(invocation ->{
            Integer arg = invocation.getArgumentAt(0, Integer.class);
            return String.valueOf(arg * 10);
        });


        assertThat(list.get(0), equalTo("0"));
        assertThat(list.get(1), equalTo("10"));

    }





































    @After
    public void setDown(){
        reset(this.list);
    }
}
