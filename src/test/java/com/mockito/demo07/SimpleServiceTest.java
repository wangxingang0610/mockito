package com.mockito.demo07;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class SimpleServiceTest {


    @Mock
    private SimpleService simpleService;

    /**
     * 传递任何参数，要求返回值相同
     */
    @Test
    public void method1WithWildcardArgumentMatcher() {
        //when
        Mockito.when(simpleService.method1(anyInt(),anyString(),anyCollection(), isA(Serializable.class))).thenReturn(100);

        //调用
        int result = simpleService.method1(1, "wangxg", Collections.emptyList(), "aaaaaa");
        assertThat(result, equalTo(100));

        result = simpleService.method1(8, "LiLi", Collections.emptyList(), "zxy");
        assertThat(result, equalTo(100));
    }

    /**
     * 传递不同参数，要求返回值不同
     */
    @Test
    public void method1WithWildcardArgumentMatcherSpec() {
        //when
        Mockito.when(simpleService.method1(anyInt(),eq("java"), anyCollection(), isA(Serializable.class))).thenReturn(12);
        Mockito.when(simpleService.method1(anyInt(),eq("php"),  anyCollection(), isA(Serializable.class))).thenReturn(29);
//        Mockito.when(simpleService.method1(anyInt(),eq("333"),  anyCollection(), isA(Serializable.class))).thenReturn(-100);

        //调用
        int result = simpleService.method1(1, "java", Collections.emptyList(), "aaaaaa");
        assertThat(result, equalTo(12));

        result = simpleService.method1(8, "php", Collections.emptyList(), "zxy");
        assertThat(result, equalTo(29));

        //如果有如下要求，依然需要写对应的when,否则测试不通过
        result = simpleService.method1(8, "333", Collections.emptyList(), "zxy");
        assertThat(result, equalTo(-100));
    }


    /**
     * 粗粒度 放到最上面， 越精确的要放在下方，否则会被覆盖，报错
     */
    @Test
    public void method1WithWildcardArgumentMatcherSpec2() {
        //when
        Mockito.when(simpleService.method1(anyInt(),anyString(),  anyCollection(), isA(Serializable.class))).thenReturn(-100);
        Mockito.when(simpleService.method1(anyInt(),eq("java"), anyCollection(), isA(Serializable.class))).thenReturn(12);
        Mockito.when(simpleService.method1(anyInt(),eq("php"),  anyCollection(), isA(Serializable.class))).thenReturn(29);

        //调用
        int result = simpleService.method1(1, "java", Collections.emptyList(), "aaaaaa");
        assertThat(result, equalTo(12));

        result = simpleService.method1(8, "php", Collections.emptyList(), "zxy");
        assertThat(result, equalTo(29));

        //如果有如下要求，依然需要写对应的when
        result = simpleService.method1(8, "333", Collections.emptyList(), "zxy");
        assertThat(result, equalTo(-100));
    }

    @Test
    public void method2WithWildcardArgumentMatcher() {
        List<Object> emptyList = Collections.emptyList();
        doNothing().when(simpleService).method2(anyInt(), anyString(),anyCollection(),isA(Serializable.class));
        simpleService.method2(1,"aa", emptyList, "mockito");
        verify(simpleService, times(1)).method2(1, "aa",emptyList, "mockito");
        verify(simpleService, times(1)).method2(anyInt(), eq("aa"),anyCollection(), isA(Serializable.class));
    }


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }
}
