//package test.ncp.main;
//
//import util.BaseDao;
//
//import java.util.LinkedHashMap;
//
//import static util.fileUtil.*;
//
//public class Main {
//    public static void main(String[] args) {
//        //测试导出
//        String filePathArea = "D:\\CompcuteApplication\\projectTest\\NCP-api\\src\\main\\resources\\DXYArea.csv";
//        String filePathNews = "D:\\CompcuteApplication\\projectTest\\NCP-api\\src\\main\\resources\\DXYNews.csv";
//        String filePathOverall = "D:\\CompcuteApplication\\projectTest\\NCP-api\\src\\main\\resources\\DXYOverall.csv";
//        String filePathRumors = "D:\\CompcuteApplication\\projectTest\\NCP-api\\src\\main\\resources\\DXYRumors.csv";
//
//        // 数据库名
//        String databaseName = "ncp";
//        BaseDao baseDao = BaseDao.getInstance();
//        //创建数据库
//        int flag=baseDao.createDatabase(databaseName);
//        System.out.println(flag);
//        //使用新建的数据库连接
//        baseDao.getConnection(databaseName);
//        //四个新表名
//        String tableNameArea = databaseName + "." + "dxyarea";
//        String tableNameNews = databaseName + "." + "dxynews";
//        String tableNameOverall = databaseName + "." + "dxyoverall";
//        String tableNameRumors = databaseName + "." + "dxyrumors";
//
//        //表的属性集合
//        LinkedHashMap<String, String> tableColArea = new LinkedHashMap<String, String>();
////        // 鉴于map的key不能重复，所以键为列名，值为这个列的属性
////        //值可以有多个，如varchar(20) 长度为20
////        // not null 非空
////        //unique 唯一
////        //primary key 主键
////        //foreight 外键
////        //auto_increment  自增  value直接用空格隔开
////        //重庆市,Chongqing,合川区,Hechuan District,312,0,8,2,9,0,0,0,2020-02-03 16:29:32.407
//////       ﻿provinceName+
//////       provinceEnglishName+
//////       cityName+
//////       cityEnglishName+
//////       province_confirmedCount+
//////       province_suspectedCount+
//////       province_curedCount+
//////       province_deadCount+
//////       city_confirmedCount+
//////       city_suspectedCount+
//////       city_curedCount+
//////       city_deadCount+
//////       updateTime+
////        /**mysql
////         * 4.0版本以下，varchar(50)，指的是50字节，如果存放UTF8汉字时，只能存16个（每个汉字3字节）
////         * 5.0版本以上，varchar(50)，指的是50字符，无论存放的是数字、字母还是UTF8汉字（每个汉字3字节），都可以存放50个
////         */
//        // 省/自治区/特别行政区中文
//        tableColArea.put("provinceName", "varchar(255)");
//        // 省/自治区/特别行政区英文
//        tableColArea.put("provinceEnglishName", "varchar(255)");
//        // 城市名称
//        tableColArea.put("cityName", "varchar(255)");
//        // 城市英文名称
//        tableColArea.put("cityEnglishName", "varchar(255)");
//        // 确诊病例
//        tableColArea.put("province_confirmedCount", "int(6)");
//        // 疑似病例
//        tableColArea.put("province_suspectedCount", "int(6)");
//        // 治愈病例
//        tableColArea.put("province_curedCount", "int(6)");
//        // 死亡病例
//        tableColArea.put("province_deadCount", "int(4)");
//        //城市确诊人数
//        tableColArea.put("city_confirmedCount", "int(6)");
//        //城市疑似人数
//        tableColArea.put("city_suspectedCount", "int(6)");
//        //城市确诊人数
//        tableColArea.put("city_curedCount", "int(6)");
//        //城市疑似病例
//        tableColArea.put("city_deadCount", "int(6)");
//        //更新时间
//        tableColArea.put("updateTime", "timestamp(3)");
//        //创建表格
//                baseDao.createTable(tableNameArea,tableColArea);
//
//        LinkedHashMap<String, String> tableColNews = new LinkedHashMap<String, String>();
//
//        //Md5加密的用户id
//        tableColNews.put("_id", "varchar(32)");
//        //文章id
//        tableColNews.put("id", "int(4)");
//        //发布时间
//        tableColNews.put("pubDate", "timestamp");
//        //标题
//        tableColNews.put("title", "varchar(20)");
//        //摘要
//        tableColNews.put("summary", "varchar(255)");
//        //信息发布机构
//        tableColNews.put("infoSource", "varchar(255)");
//        //信息网站
//        tableColNews.put("sourceUrl", "varchar(255)");
//        //部门编号
//        tableColNews.put("provinceId", "int(2)");
//        //创建时间
//        tableColNews.put("createTime", "timestamp");
//        //修改时间
//        tableColNews.put("modifyTime", "timestamp");
//        //登记
//        tableColNews.put("entryWay", "int(2)");
//        //采纳
//        tableColNews.put("adoptType", "int(2)");
//        //信息类型
//        tableColNews.put("infoType", "int(2)");
//        //信息标记
//        tableColNews.put("dataInfoState", "int(2)");
//        //信息运算
//        tableColNews.put("dataInfoOperator", "varchar(2)");
//        //信息时间
//        tableColNews.put("dataInfoTime", "timestamp");
//        //数据爬取时间
//        tableColNews.put("crawlTime", "timestamp(3)");
//        //所属地区
//        tableColNews.put("provinceName", "varchar(50)");
//        //信息内容   这里好像并没有抓取
////        tableColNews.put("body","varchar(20)");
//        //创建表格
//        baseDao.createTable(tableNameNews,tableColNews);
//
//
//        LinkedHashMap<String, String> tableColOverall = new LinkedHashMap<String, String>();
//        //Md5加密的用户id
//        tableColOverall.put("_id", "varchar(32)");
//        //说明
//        tableColOverall.put("infectSource", "varchar(255)");
//        //经过地址
//        tableColOverall.put("passWay", "varchar(255)");
//        //每日地址
//        tableColOverall.put("dailyPic", "varchar(255)");
//        //每日地址
//        tableColOverall.put("dailyPics", "varchar(255)");
//        //摘要地址
//        tableColOverall.put("summary", "varchar(255)");
//        //回复地址
//        tableColOverall.put("countRemark", "varchar(255)");
//
//        tableColOverall.put("currentConfirmedCount", "varchar(255)");
//        tableColOverall.put("confirmedCount", "varchar(255)");
//        tableColOverall.put("suspectedCount", "varchar(255)");
//        tableColOverall.put("curedCount", "varchar(255)");
//        tableColOverall.put("deadCount", "varchar(255)");
//        tableColOverall.put("seriousCount", "varchar(255)");
//        tableColOverall.put("suspectedIncr", "varchar(255)");
//        tableColOverall.put("currentConfirmedIncr", "varchar(255)");
//        tableColOverall.put("confirmedIncr", "varchar(255)");
//        tableColOverall.put("curedIncr", "varchar(255)");
//        tableColOverall.put("deadIncr", "varchar(255)");
//        tableColOverall.put("seriousIncr", "varchar(255)");
//        tableColOverall.put("virus", "varchar(255)");
//        tableColOverall.put("remark1", "varchar(255)");
//        tableColOverall.put("remark2", "varchar(255)");
//        tableColOverall.put("remark3", "varchar(255)");
//        tableColOverall.put("remark4", "varchar(255)");
//        tableColOverall.put("remark5", "varchar(255)");
//        tableColOverall.put("note1", "varchar(255)");
//        tableColOverall.put("note2", "varchar(255)");
//        tableColOverall.put("note3", "varchar(255)");
//        tableColOverall.put("generalRemark", "varchar(255)");
//        tableColOverall.put("abroadRemark", "varchar(255)");
//        tableColOverall.put("marquee", "varchar(255)");
//        tableColOverall.put("quanguoTrendChart", "varchar(255)");
//        tableColOverall.put("hbFeiHbTrendChart", "varchar(255)");
//        //更新时间
//        tableColOverall.put("updateTime", "timestamp(3)");
//        //创建表格
//        baseDao.createTable(tableNameOverall,tableColOverall);
//
//        LinkedHashMap<String, String> tableColRumors = new LinkedHashMap<String, String>();
//        //用户被Md加密后的id
//        tableColRumors.put("_id", "varchar(255)");
//        //主体内容
//        tableColRumors.put("body", "varchar(255)");
//        //文章id
//        tableColRumors.put("id", "int(3)");
//        //摘要主体
//        tableColRumors.put("mainSummary", "varchar(255)");
//        //谣言类型
//        tableColRumors.put("rumorType", "int(3)");
//        //资源地址
//        tableColRumors.put("sourceUrl", "varchar(255)");
//        //摘要
//        tableColRumors.put("summary", "varchar(255)");
//        //标题
//        tableColRumors.put("title", "varchar(20)");
//        //爬取时间
//        tableColRumors.put("crawlTime", "timestamp(3)");
//        //创建表格
//        baseDao.createTable(tableNameRumors,tableColRumors);
//
//
//        //        读取CSV文件,输入表名，数据库名
//        /**
//         *把数据从4个csv文件中写入到数据库的4个表中
//         *  1.创建数据库
//         *  2.获取数据(在读取时建表，添加数据)
//         */
//        readCSVInputDB(filePathArea,tableNameArea,baseDao);
//        readCSVInputDB(filePathNews,tableNameNews,baseDao);
//        readCSVInputDB(filePathOverall,tableNameOverall,baseDao);
//        readCSVInputDB(filePathRumors,tableNameRumors,baseDao);
//
//        //  把数据库表封装成json文件
//        readSetIntoJson(databaseName,tableNameArea,"D:\\CompcuteApplication\\projectTest\\NCP-api\\src\\main\\resources");
//        readSetIntoJson(databaseName,tableNameNews,"D:\\CompcuteApplication\\projectTest\\NCP-api\\src\\main\\resources");
//        readSetIntoJson(databaseName,tableNameOverall,"D:\\CompcuteApplication\\projectTest\\NCP-api\\src\\main\\resources");
//        readSetIntoJson(databaseName,tableNameRumors,"D:\\CompcuteApplication\\projectTest\\NCP-api\\src\\main\\resources");
//
//    }
//}
