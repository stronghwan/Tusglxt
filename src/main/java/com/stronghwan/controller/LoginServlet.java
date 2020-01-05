package com.stronghwan.controller;

import com.stronghwan.dao.TUserDao;
import com.stronghwan.entity.TUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @TODO
 * @Author stronghwan
 * @Verison
 * @Date2019/12/21-13-23
 */

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            TUser tUser = new TUser();
            TUserDao tUserDao = new TUserDao();
            BeanUtils.populate(tUser,req.getParameterMap());
            if (StringUtils.isNotBlank(tUser.getUsername()) && StringUtils.isNotBlank(tUser.getPassword())){
                TUser resultTUser = tUserDao.find(tUser);
                if (resultTUser != null){
                    req.getSession().setAttribute("username",resultTUser.getUsername());
                    req.getRequestDispatcher("/pageList?currentPage=1").forward(req,resp);
                }
            }
//            Cookie[] cookies = req.getCookies();
//            Arrays.stream(cookies).forEach(cookie -> {
//                if (){
//
//                }
//            });
        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
