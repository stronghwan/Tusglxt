package com.stronghwan.controller;

import com.stronghwan.dao.BookDao;
import com.stronghwan.entity.Book;
import org.apache.commons.beanutils.BeanUtils;

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
 * @Date2019/12/21-15-44
 */
@WebServlet(urlPatterns = "/update")
public class UpdateBookResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("utf-8");
            Book book = new Book();
            BookDao bookDao = new BookDao();
            BeanUtils.populate(book,req.getParameterMap());
            boolean update = bookDao.update(book);
            if (update){
                req.getRequestDispatcher("/pageList?currentPage=1").forward(req,resp);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
