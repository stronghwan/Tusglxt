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

/**
 * @Author stronghwan
 * @Verison
 * @Date2019/12/19-16-05
 */
@WebServlet(urlPatterns = "/addBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("utf-8");
            Book book = new Book();
            BookDao bookDao = new BookDao();
            BeanUtils.populate(book,request.getParameterMap());
            boolean isAdd = bookDao.add(book);
            if (isAdd) {
                request.getRequestDispatcher("/pageList?currentPage=1").forward(request,response);
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
