package com.stronghwan.controller;

import com.stronghwan.dao.BookDao;
import com.stronghwan.entity.Book;
import com.stronghwan.entity.PageBean;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 分页
 * @Author stronghwan
 * @Verison
 * @Date2019/12/21-18-21
 */
@WebServlet(urlPatterns = "/pageList")
public class BookPageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage = req.getParameter("currentPage");
        if (StringUtils.isBlank(currentPage)){
            currentPage = "1";
        }
        BookDao bookDao = new BookDao();
        Integer currentPageInt = Integer.parseInt(currentPage);
        PageBean<Book> bookPage = bookDao.findBookPage(currentPageInt, 8);
        System.out.println(bookPage.toString());
        req.setAttribute("pageList",bookPage);

        req.setAttribute("totalPage",bookPage.getListTotalPage());
        System.out.println(bookPage.getListTotalPage());
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
