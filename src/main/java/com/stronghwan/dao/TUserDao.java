package com.stronghwan.dao;

import com.stronghwan.entity.TUser;
import com.stronghwan.units.DBUnit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author stronghwan
 * @Verison
 * @Date2019/12/20-23-20
 */
public class TUserDao {

    public boolean add(TUser tUser){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBUnit.getConnection();
            statement = connection.createStatement();
            String sql = "insert into tuser(username,password) value('"+tUser.getUsername()+"','"+tUser.getPassword()+"')";
            int i = statement.executeUpdate(sql);
            if (i > 0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUnit.release(null,statement,connection);
        }
        return false;
    }

    public TUser find(TUser tUser){
        Connection connection = null;
        Statement statement = null;
        TUser resultTUser = new TUser();
        ResultSet resultSet = null;
        try {
            connection = DBUnit.getConnection();
            statement = connection.createStatement();
            String sql = "select * from tuser where username = '"+tUser.getUsername()+"' and password='"+tUser.getPassword()+"'";
            resultSet =  statement.executeQuery(sql);
           if (resultSet.next()){
               resultTUser.setId(resultSet.getInt("id"));
               resultTUser.setUsername(resultSet.getString("username"));
               resultTUser.setPassword(resultSet.getString("password"));
           }
            return resultTUser;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUnit.release(resultSet,statement,connection);
        }
        return null;
    }
}
