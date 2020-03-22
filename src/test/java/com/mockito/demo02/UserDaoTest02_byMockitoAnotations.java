package com.mockito.demo02;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * 方式2: 注解
 */
public class UserDaoTest02_byMockitoAnotations {

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private UserDao userDao;

    @Test
    public void testFindUser(){
        User user = userDao.findUser("xxx", "123");
        System.out.println(user);
    }
}
