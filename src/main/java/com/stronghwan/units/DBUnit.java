package com.stronghwan.units;

import java.sql.*;

/**
 * @Author stronghwan
 * @Verison
 * @Date2019/12/19-13-10
 */
public class DBUnit {
    public static Connection getConnection() throws SQLException,ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
        return connection;
    }
    public static void release(ResultSet rs, Statement st, Connection conn)
    {


        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
