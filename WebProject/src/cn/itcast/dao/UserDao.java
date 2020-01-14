package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.DataBaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
* 操作数据库中User表的方法
* */
public class UserDao {
    //声明JDBC对象共用
    DataBaseConnection dbc=new DataBaseConnection();
    PreparedStatement pstmt=null;
    /**
     * 登录方法
     *
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据
     */
    public User login(User loginUser){
       try {

        User user=null;
        //1.编写sql
        String sql="select * from user where username=?and password=?";
        pstmt=dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1,loginUser.getUsername());
        pstmt.setString(2,loginUser.getPassword());
        ResultSet rs=pstmt.executeQuery();
        if (rs.next()){
            user=new User();
            user.setId(rs.getInt(1));
            user.setPassword(rs.getString(2));
            user.setUsername(rs.getString(3));
        }
        return user;
       }catch (Exception e){
           e.printStackTrace();//记录日志
           return null;
       }
    }
}
