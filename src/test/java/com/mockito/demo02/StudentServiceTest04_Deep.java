package com.mockito.demo02;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


public class StudentServiceTest04_Deep {

    //需要stubling
//    @Mock
//    private StudentService studentService;

    // 无须stubling
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private StudentService studentService;

    @Mock
    private Student student;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGet() {
//        when(studentService.get()).thenReturn(student);
        Student student = studentService.get();
        student.foo();

    }
}
