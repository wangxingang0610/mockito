package com.mockito.demo01;

import javax.servlet.http.HttpServletRequest;

public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    public String login(HttpServletRequest request){

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        try {
            User user = userDao.findUser(userName, password);
            if (user == null) {
                return "/login";
            } else {
                return "/index";
            }
        }catch (Exception e){
            return "/error_505";
        }
    }
}
