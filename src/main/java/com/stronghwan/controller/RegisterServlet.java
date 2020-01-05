package com.stronghwan.controller;

import com.stronghwan.dao.TUserDao;
import com.stronghwan.entity.TUser;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author stronghwan
 * @Verison
 * @Date2019/12/21-13-45
 */
@WebServlet(urlPatterns = "/register")
public class RegisterServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            TUser tUser = new TUser();
            TUserDao tUserDao = new TUserDao();
            BeanUtils.populate(tUser,req.getParameterMap());
            if (StringUtils.isNotBlank(tUser.getUsername()) && StringUtils.isNotBlank(tUser.getPassword())){
                 boolean isAdd = tUserDao.add(tUser);
                 if (isAdd){
                     resp.sendRedirect("/login.jsp");
                 }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
