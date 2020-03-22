package com.mockito.demo01;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;


@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private UserDao userDao;

    private HttpServletRequest request;

    private UserController userController;

    @Before
    public void setUp(){
        //mock 对象
        this.userDao = Mockito.mock(UserDao.class);
        this.request = Mockito.mock(HttpServletRequest.class);
        this.userController = new UserController(userDao);
    }


    @Test
    public void testLoginSuccess() {
        User user = new User();
        try {
            Mockito.when(request.getParameter("userName")).thenReturn("wangxg");
            Mockito.when(request.getParameter("password")).thenReturn("123456");
            Mockito.when(userDao.findUser(anyString(), anyString())).thenReturn(user);

            assertThat(userController.login(request), equalTo("/index"));
        }catch (Exception e){
            fail("error");
        }
    }

    @Test
    public void testLoginFail() {
        User user = new User();
        try {
            Mockito.when(request.getParameter("userName")).thenReturn("wangxg");
            Mockito.when(request.getParameter("password")).thenReturn("123456");
            Mockito.when(userDao.findUser(anyString(), anyString())).thenReturn(null);
            assertThat(userController.login(request), equalTo("/login"));
        }catch (Exception e){
            fail("error");
        }
    }


    @Test
    public void testLogin505() {
        User user = new User();
        try {
            Mockito.when(request.getParameter("userName")).thenReturn("wangxg");
            Mockito.when(request.getParameter("password")).thenReturn("123456");
            Mockito.when(userDao.findUser(anyString(), anyString())).thenThrow(UnsupportedOperationException.class);
            assertThat(userController.login(request), equalTo("/error_505"));
        }catch (Exception e){
            fail("error");
        }
    }

}