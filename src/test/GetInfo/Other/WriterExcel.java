//package test.GetInfo.Other;
//
//import org.apache.poi.hssf.usermodel.*;
//import test.GetInfo.User;
//import test.GetInfo.main;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//
//public class WriterExcel {
//    public boolean writeExcel(ArrayList<User> users) throws Exception {
//        //write参数用于判断下一次是继续写，还是另外写一个表
//        //init 是初始化
//        //week 第几周
//        //如果是继续写，就在本sheet写
//        //第一步，创建一个workbook对应一个excel文件
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet=null;
//        String str = null;
//        if (str.equals("周一")) {
//            if (new main().init) {
//                //如果是第一次
//                sheet = workbook.createSheet("第"+new main().week+"周云班课成绩");
//            } else {
//                new main().week++;
//                sheet = workbook.createSheet("第"+new main().week+"周云班课成绩");
//            }
//        } else {
//                sheet = workbook.createSheet("第"+new main().week+"周云班课成绩");
//        }
//            //第二部，在workbook中创建一个sheet对应excel中的sheet
//             sheet = workbook.createSheet("云班课");
//
//        //第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
//        HSSFRow row = sheet.createRow(0);
//        //第四步，创建单元格，设置表头
//        int columnIndex=0;
//        HSSFCell cell = row.createCell(columnIndex);
//        cell.setCellValue("排名");
//        cell = row.createCell(++columnIndex);
//        cell.setCellValue("学号");
//        cell = row.createCell(++columnIndex);
//        cell.setCellValue("姓名");
//        cell = row.createCell(++columnIndex);
//        cell.setCellValue("成绩");
//        if (false){
//            cell = row.createCell(++columnIndex);
//            cell.setCellValue("成绩");
//        }
//        //第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值
//        for (int i = 0; i < users.size(); i++) {
//            HSSFRow row1 = sheet.createRow(i + 1);
//            User user = users.get(i);
//            //创建单元格设值
//            row1.createCell(0).setCellValue(user.getRanking());
//            row1.createCell(1).setCellValue(user.getStudentNum());
//            row1.createCell(2).setCellValue(user.getName());
//            row1.createCell(3).setCellValue(user.getScore());
//        }
//
//        //将文件保存到指定的位置
//        try {
//
//            File file = new File("D:\\云班课成绩.xls");
//            if (file==null){
//                file.createNewFile();
//            }
//            //允许继续写入
//            FileOutputStream fos = new FileOutputStream(file,true);
//            workbook.write(fos);
//            System.out.println("写入成功");
//            fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//}