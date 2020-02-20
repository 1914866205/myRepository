package test.ncp.main.util;


import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class DbUtil {
    /**
     * 读取和处理资源文件
     */
    public static Properties properties;

    //执行本类时加载
    static {
        properties=new Properties();

        //读取资源配置文件
        try {
            properties.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("dbconnection.properties")));
            //获取驱动对象
            Class.forName(properties.getProperty("jdbc.driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库的连接
     * @return 返回连接对象Connection
     */

    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(
                    properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"),
                    properties.getProperty("jdbc.password")
                    );
            assert connection!=null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;

    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
