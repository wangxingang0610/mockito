package com.mockito.demo02;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 方式1: MockitoJunitRunner
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest01_byMockitoJUnitRunner {

    @Test
    public void findUser() {
        //mock
        UserDao userDao = mock(UserDao.class, Mockito.RETURNS_SMART_NULLS);

        //when
        User user = new User();
        when(userDao.findUser("xxx","123")).thenReturn(user);

        user = userDao.findUser("xxxx", "123");
        System.out.println(user);

    }
}
