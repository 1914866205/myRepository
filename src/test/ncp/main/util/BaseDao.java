package test.ncp.main.util;



import java.sql.*;
import java.util.*;

/**
 * 数据库功能类
 *
 * 本想用工厂设计模式，但针对每个csv文件单独写一个方法，显然不可能
 */
public class BaseDao {
    private static Connection connection=DbUtil.getConnection();
    private static PreparedStatement preparedStatement=null;
    private static ResultSet resultSet=null;
    private static BaseDao baseDao=new BaseDao();
    private BaseDao(){}
    public static BaseDao getInstance(){
        return baseDao;
    }
    //创建数据库
    public int createDatabase(String name) {
        int flag = 0;
        try {
        String sql="create database "+name;
        System.out.println("创建数据库执行的语句："+sql);
        preparedStatement= (PreparedStatement) connection.prepareStatement(sql);
        flag=preparedStatement.executeUpdate(sql);
            System.out.println("数据库"+name+"创建成功");
        preparedStatement.close();
        throw new SQLException("数据库已存在");
        } catch (SQLException e) {
            System.out.println("数据库已存在");
        }
        return flag;
    }

    //打开指定的数据库
    public static Connection getConnection(String name) {
        Connection connection=null;
        try {
            Properties properties=new Properties();
            properties.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("dbconnection.properties")));
            //获取驱动对象
            Class.forName(properties.getProperty("jdbc.driver"));
            String database=properties.getProperty("jdbc.url").substring(0,28)+name+properties.getProperty("jdbc.url").substring(32);
//            System.out.println(database);
            connection= DriverManager.getConnection(
                    database,
                    properties.getProperty("jdbc.username"),
                    properties.getProperty("jdbc.password")
            );
            assert connection!=null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void createTable(String tableName,LinkedHashMap<String,String> map){
        try {
            String sql="create table "+tableName+"(";
            preparedStatement= (PreparedStatement) connection.prepareStatement(sql);
            //将map集合转成set
            Set<Map.Entry<String,String>> set=map.entrySet();
            Iterator<Map.Entry<String,String>> iterator=set.iterator();
            // 鉴于map的key不能重复，所以键为列名，值为这个列的属性
            //值可以有多个，如varchar(20) 长度为20
            // not null 非空
            //unique 唯一
            //primary key 主键
            //foreight 外键
            //auto_increment  自增  value直接用空格隔开

            while (iterator.hasNext()){
                Map.Entry<String,String> rowmap= iterator.next();
                String key=rowmap.getKey();
                String value=rowmap.getValue();
                sql+=key+" "+value+",";
            }
            //删除最后一个逗号
            sql=sql.substring(0,sql.length()-1);
            //设置utf-8编码
            sql+=")"+"ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1";
            System.out.println("建表的sql:"+sql);
            preparedStatement.executeUpdate(sql);
//            System.out.println("建表结束");
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //插入表数据
    //key为列名，value为值
    public void insert(String tableName,String [] keyArray,String [] valueArray){
        try {
//            String sql="insert into  "+tableName+"(";
            String sql="insert into  "+tableName+" values (";
            String sql2="";
            preparedStatement= (PreparedStatement) connection.prepareStatement(sql);
//            Iterator iterator= (Iterator) map.entrySet();
//            // 鉴于map的key不能重复，所以键为列名，值为这个列的值
//            while (iterator.hasNext()){
//                String key= (String) iterator.next();
//                String value=map.get(key);
//                sql+=key+",";
//                sql2+=value+",";
//            }
            for (int i = 0; i <keyArray.length&&i<valueArray.length ; i++) {
//                sql+=keyArray[i].toLowerCase()+",";//列名要转成全小写
                sql2+="'"+valueArray[i]+"',";
            }
            //删除最后一个逗号
//            sql=sql.substring(0,sql.length()-1);
            sql2=sql2.substring(0,sql2.length()-1);
//            sql+=") values (";
            sql2+=")";
            sql+=sql2;
//            System.out.println("在表添加数据的sql:"+sql);
//            System.out.println(sql);
            int m=preparedStatement.executeUpdate(sql);
//            System.out.println(m);
//            System.out.println("添加数据结束");
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //创建简单的索引
    public void createIndex(String indexName,String tableName,String colName){
        String sql="create index "+indexName+" on "+tableName+" ( "+colName+" )";
        try {
            System.out.println("创建索引的sql:"+sql);
            preparedStatement= (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.executeUpdate(sql);
            System.out.println("创建索引完毕完毕");
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //sql执行方法
    public static boolean executeSQL(String sql,String...params){
        boolean flag=false;
        try {
            preparedStatement=connection.prepareStatement(sql);
            for (int i = 0,n=params.length ;i<n; i++) {
                preparedStatement.setString(i+1,params[i]);
            }
            preparedStatement.execute(sql);
            flag=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 执行增删改操作
     */
    public static void executeUpdate(String sql,Object[]param){
        try {
            preparedStatement=connection.prepareStatement(sql);
            if (param!=null){
                for (int i = 0; i <param.length ; i++) {
                    preparedStatement.setObject(i+1,param[i]);
                }
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    /**
//     * @param databaseName 数据库名称
//     * @param tableName    表名
//     */
//    public static ResultSet getDBInfo(String databaseName, String tableName) {
//        String sql = "select * from " + tableName;
//        PreparedStatement preparedStatement = null;
//        try {
//            System.out.println(sql);
//            preparedStatement = BaseDao.getConnection(databaseName).prepareStatement(sql);
//            resultSet = preparedStatement.executeQuery();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                preparedStatement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        return resultSet;
//    }
}
