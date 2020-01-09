package com.stronghwan.controller;

import com.stronghwan.dao.BookDao;
import com.stronghwan.entity.Book;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author stronghwan
 * @Verison
 * @Date2019/12/19-16-07
 */
@WebServlet(urlPatterns = "/findBookByIdServlet")
public class FindBookByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String keyword = request.getParameter("keyword");
            List<Book> bookList = new ArrayList<>();
            if (StringUtils.isNotBlank(keyword)){
                BookDao bookDao = new BookDao();
                List<Book> book = bookDao.search(keyword);
                if (book != null){

                    request.setAttribute("bookList",book);
                    request.getRequestDispatcher("/search.jsp").forward(request,response);
                }
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
