package com.stronghwan.controller;

import com.stronghwan.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author stronghwan
 * @Verison
 * @Date2019/12/21-16-08
 */
@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Integer bookId = Integer.parseInt(id);
        BookDao bookDao = new BookDao();
        boolean delete = bookDao.delete(bookId);
        if (delete){
            req.getRequestDispatcher("/pageList?currentPage=1").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
