package com.stronghwan.controller;

import com.stronghwan.dao.BookDao;
import com.stronghwan.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author stronghwan
 * @Verison
 * @Date2019/12/19-16-07
 */
@WebServlet(urlPatterns = "/updateBookServlet")
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer bookId = Integer.parseInt(id);
        BookDao bookDao = new BookDao();
        Book book = bookDao.findById(bookId);
        if (book != null){
            request.setAttribute("book",book);
            request.getRequestDispatcher("/edit.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
