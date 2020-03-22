package com.mockito.demo04;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StubblingTest {


    @Test
    public void testStubblingWithUnRealCall(){
        StubblingService stubblingService = mock(StubblingService.class);
        stubblingService.getStr();
    }

    @Test
    public void testStubblingWithRealCall(){

        //mock
        StubblingService stubblingService = mock(StubblingService.class);

        //a、并无真正调用
        //when
        when(stubblingService.getStr()).thenReturn("aaa");
        //断言
        assertThat(stubblingService.getStr(),equalTo("aaa"));


        //b、真正调用了
        //when
        when(stubblingService.getNum()).thenCallRealMethod();
        //断言
        assertThat(stubblingService.getNum(),equalTo(10));
    }
}
