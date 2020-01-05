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
            String id = request.getParameter("keyword");
            List<Book> bookList = new ArrayList<>();
            if (StringUtils.isNotBlank(id)){
                Integer resultId = Integer.parseInt(id);
                BookDao bookDao = new BookDao();
                Book book = bookDao.findById(resultId);
                if (book != null){
                    bookList.add(book);
                    request.setAttribute("bookList",bookList);
                    request.getRequestDispatcher("/list.jsp").forward(request,response);
                }
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
