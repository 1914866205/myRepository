//package test.ncp.main.util;
//
//import com.csvreader.CsvReader;
//import com.csvreader.CsvWriter;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.util.List;
//
///**
// * 文件的操作类
// */
//public class fileUtil {
//    public static char separator = ',';
//
//    public static void readCSVInputDB(String filePath, String tableName, BaseDao baseDao) {
//        CsvReader reader = null;
//        try {
//            //如果生成文件乱码，就设置GBK编码
//            reader = new CsvReader(filePath, separator, Charset.forName("utf-8"));
//            //读取表头
//            reader.readHeaders();
//            String[] keyArray = reader.getHeaders();
////            for (int i = 1; i < keyArray.length; i++) {
////                System.out.print(keyArray[i]+"+");
////            }
////            逐条读取数据，直至读完
//            int i = 0;
//            //忽略第一行
//            while (reader.readRecord()) {
//                if (i == 0) {
//                    i++;
//                    continue;
//                }
//                i++;
//                //读一行
////                String row=reader. getRawRecord();
////                把行数据转成列数组
//                String[] valueArray = reader.getRawRecord().split(",");
//                baseDao.insert(tableName, keyArray, valueArray);
//                //读这行的第一列
////                System.out.println(reader.get(1));
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                reader.close();
//            }
//        }
//    }
//
//    /**
//     * @param dataList 数据集
//     * @param filePath 全路径名
//     * @return
//     */
//    public static boolean createCSV(List<String[]> dataList, String filePath) {
//        CsvWriter writer = null;
//        FileOutputStream fos = null;
//        boolean isSuccess = false;
//        try {
//            fos = new FileOutputStream(filePath, true);
//            //如果生成的文件编码错误，设置GBK编码
//            writer = new CsvWriter(fos, separator, Charset.forName("GBK"));
//            for (String[] strs : dataList) {
//                writer.writeRecord(strs);
//            }
//            isSuccess = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (null != writer) {
//                writer.close();
//            }
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return isSuccess;
//    }
//
//    /**
//     * @param databaseName 数据库名
//     * @param tableName    表名
//     * @param filePath     要写到的json的路径
//     */
//
//    public static void readSetIntoJson(String databaseName, String tableName, String filePath) {
//        try {
//            ResultSet rs=null;
//            ResultSetMetaData rsm=null;//获取 列信息
//            String sql = "select * from " + tableName;
//            PreparedStatement preparedStatement = null;
//            System.out.println(sql);
//            preparedStatement = BaseDao.getConnection(databaseName).prepareStatement(sql);
//            rs = preparedStatement.executeQuery();
//            rsm=rs.getMetaData();
//            int columns=rsm.getColumnCount();
//            File file=new File(filePath+"\\"+tableName+".json");
//            System.out.println(file.getPath());
//            FileOutputStream fos=new FileOutputStream(file);
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            // json文件以 { 开头
//            fos.write("[".getBytes("utf-8"));
//            String str="";
////            int x=0;   第一个表有八万多条数据，写1000行存入
//            while(rs.next()){
////                x++;
//                str+="{";
//                // 1为第一列
//                for (int i = 1; i < columns; i++) {
//                    if (rsm.getColumnName(i).equals("body")&&rs.getString(i).substring(0,1).equals("\"")){
//                    str+="\""+rsm.getColumnName(i)+"\":"+rs.getString(i)+",";
//                    }else{
//                    str+="\""+rsm.getColumnName(i)+"\":\""+rs.getString(i)+"\",";
//                    }
//                }
//                //删除最后一个 ,
//                str=str.substring(0,str.length()-1);
//                str+="},";
////                if (x==1000){
////                    break;
////                }
//            }
//            //删除最后一个 ,
//            str=str.substring(0,str.length()-1);
//            str+="]";
//            fos.write(str.trim().getBytes("utf-8"));
//            rs.close();
//            fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
