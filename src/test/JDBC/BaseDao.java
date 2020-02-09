package test.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * 完成基本的增删改查功能封装
 */
public class BaseDao {
    private static Connection conn=DbUtil.getConn();
    private static PreparedStatement pstmt=null;
    private static ResultSet res=null;

    /**
     * 执行数据库查询操作
     */

    public static ResultSet executeQuery(String sql, Object[]param){
        try {
            pstmt=conn.prepareStatement(sql);
            if (param!=null){
                for (int i = 0; i < param.length ; i++) {
                    pstmt.setObject(i+1,param[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("获取PreparedStatement对象异常");
            e.printStackTrace();
        }
        try {
            res=pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("获取ResultSet对象异常");
            e.printStackTrace();
        }
        return  res;
    }
    /**
     * 执行增删改操作
     */
    public static void executeUpdate(String sql,Object[]param){
        try {
            pstmt=conn.prepareStatement(sql);
            if (param!=null){
                for (int i = 0; i <param.length ; i++) {
                    pstmt.setObject(i+1,param[i]);
                }
            }
        } catch (SQLException e) {
            System.out.println("获取PreparedStatement对象异常");
            e.printStackTrace();
        }
        try {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("执行execute方法出错");
            e.printStackTrace();
        }
    }
}
