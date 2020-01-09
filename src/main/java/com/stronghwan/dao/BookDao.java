package com.stronghwan.dao;

import com.stronghwan.entity.Book;
import com.stronghwan.entity.PageBean;
import com.stronghwan.units.DBUnit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author stronghwan
 * @Verison
 * @Date2019/12/19-13-17
 */
public class BookDao {

    /**
     *  增加图书
     * @param book 图书实体
     * @return
     */
    public boolean add(Book book){
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DBUnit.getConnection();
            stmt = conn.createStatement();
            String sql = "insert into book(bookName,author,press,isbn,category,price) values('" + book.getBookName() + "','" + book.getAuthor() + "','" + book.getPress() + "','"+book.getIsbn()+"','"+book.getCategory()+"',"+book.getPrice()+")";
            int executeUpdate = stmt.executeUpdate(sql);
            if (executeUpdate > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取所有图书
     * @return
     */
    public List<Book> find(){
        Connection conn  = null;
        Statement statement = null;
        List<Book> bookList= new ArrayList<>();
        try {
            conn = DBUnit.getConnection();
            String sql = "select * from book;";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("bookName"));
                book.setAuthor(resultSet.getString("author"));
                book.setPress(resultSet.getString("press"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setCategory(resultSet.getString("category"));
                book.setPrice(resultSet.getDouble("price"));
                bookList.add(book);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return bookList;
    }

    /**
     * 通过id获取图书
     * @param  keyword 关键字
     * @return
     */
    public List<Book> findById(Integer keyword){
        Connection conn  = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<Book> bookList = new ArrayList<>();
        try {
            conn = DBUnit.getConnection();
            String sql = "select * from book where id = " + keyword;
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
           while (resultSet.next()){
               Book book = new Book();
               book.setId(resultSet.getInt("id"));
               book.setBookName(resultSet.getString("bookName"));
               book.setAuthor(resultSet.getString("author"));
               book.setPress(resultSet.getString("press"));
               book.setIsbn(resultSet.getString("isbn"));
               book.setCategory(resultSet.getString("category"));
               book.setPrice(resultSet.getDouble("price"));
               bookList.add(book);
           }
        } catch (Exception e) {
            e.getStackTrace();
        }
        finally {
            DBUnit.release(resultSet,statement,conn);
        }
        return bookList;
    }
    /**
     * 搜索图书
     * @param  keyword 关键字
     * @return
     */
    public List<Book> search(String keyword){
        Connection conn  = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Book> bookList = new ArrayList<>();
        try {
            conn = DBUnit.getConnection();
            String sql = "select * from book where bookName like  ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1,"%"+keyword+"%");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("bookName"));
                book.setAuthor(resultSet.getString("author"));
                book.setPress(resultSet.getString("press"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setCategory(resultSet.getString("category"));
                book.setPrice(resultSet.getDouble("price"));
                bookList.add(book);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        finally {
            DBUnit.release(resultSet,statement,conn);
        }
        return bookList;
    }
    /**
     * 获取分页图书
     * @return
     */
    public PageBean<Book> findBookPage(int currentPage, int pageCount){
        Connection conn  = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Book> bookList = new ArrayList<>();
        try {
            conn = DBUnit.getConnection();
            statement = conn.createStatement();
            currentPage = (currentPage - 1)*8;
            String sql1 = "select * from book limit "+ currentPage + "," + pageCount;
            resultSet = statement.executeQuery(sql1);
            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("bookName"));
                book.setAuthor(resultSet.getString("author"));
                book.setPress(resultSet.getString("press"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setCategory(resultSet.getString("category"));
                book.setPrice(resultSet.getDouble("price"));
                bookList.add(book);
            }
            String sql2 = "select count(*) from book ";
            int total = 0;
            final ResultSet resultSet1 = statement.executeQuery(sql2);
            while (resultSet1.next()){
                total = resultSet1.getInt(1);
            }
            PageBean<Book> pageBean = new PageBean<>();
            pageBean.setCurrentPage(currentPage/8+1);
            pageBean.setPageCount(pageCount);
            pageBean.setPageData(bookList);
            pageBean.setTotalCount(total);
            pageBean.setTotalPage((total % pageCount == 0) ? (total / pageCount) : (total / pageCount + 1));
            return pageBean;

        } catch (Exception e) {
          e.getStackTrace();
        }finally {
            DBUnit.release(resultSet,statement,conn);
        }
        return null;
    }

    /**
     * 修改图书信息
     * @param book
     * @return
     */
    public boolean update(Book book) {
        Connection conn = null;
        Statement statement = null;

        try {
        conn = DBUnit.getConnection();
        statement = conn.createStatement();
        String sql = "update book set bookName='"+book.getBookName()+"',author='"+book.getAuthor()+"',press='"+book.getPress()+"',isbn='"+book.getIsbn()+"',category='"+book.getCategory()+"',price="+book.getPrice()+"where id ="+book.getId();
        int i = statement.executeUpdate(sql);
        if (i > 0){
            return true;
        }
        } catch (Exception e) {
        e.printStackTrace();
    }finally {
            DBUnit.release(null,statement,conn);
        }
        return false;
}

    /**
     *  删除图书（一般不会真的删除 只是会让状态改变）
     * @param id
     * @return
     */
    public boolean delete(int id){
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DBUnit.getConnection();
            statement = conn.createStatement();
            String sql = "delete from book where id =" + id;
            int executeUpdate = statement.executeUpdate(sql);
            if (executeUpdate > 0){
                return true;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }finally {
            DBUnit.release(null,statement,conn);
        }
        return false;
    }
}
