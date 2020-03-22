package com.mockito.demo02;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRule;

import static org.mockito.Mockito.mock;

/**
 * 方式3: rule TODO wangxg
 */
public class UserDaoTest03_byRule {

    @Rule
    public MockitoJUnitRule mockitoJUnitRule = new MockitoJUnitRule(UserDaoTest03_byRule.class);


    @Test
    public void testFindUser() {
        UserDao userDao = mock(UserDao.class);
        User user = userDao.findUser("xxx", "1234");
        System.out.println(user);
    }
}
