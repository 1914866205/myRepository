package test.GetInfo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class WriterExcel {
    public void weiterExcel(ArrayList<User> users) throws Exception {
        //1.创建一个workbook对象对应一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        FileInputStream fs=null;
        FileOutputStream fos=null;
        POIFSFileSystem ps=null;
        HSSFSheet sheet = null;
        File file = null;
        //2.是否是第一次运行
        if (new main().init) {
            //第一次运行，要创建这个文件，以及一个sheet
            //本次循环在整个生命周期上只运行一次
            //格式：xxxx年x月云班课成绩
            file = new File("D:\\"+Calendar.getInstance().get(Calendar.YEAR) + "年云班课.xls");
            file.createNewFile();
//            System.out.println("filename:" + file.getName());
//            System.out.println("filepath:" + file.getPath());
        } else {
            //如果Excel存在
            file = new File("D:\\"+Calendar.getInstance().get(Calendar.YEAR) + "年云班课.xls");
//            System.out.println("非第一次创建时的filename:" + file.getName());
//            System.out.println("非第一次创建时的filepath:" + file.getPath());
        }
        //再判断是否需要新建sheet
        //sheet：                             新建                                继续使用
        //                  初始化                         今天是一号              不是初始化，今天不是一号
        //            1号初始化     非1号初始化
//        System.out.println(new main().day+1);
//        System.out.println(1+new main().day);
        if (new main().day==1){
            //今天是1号  1号就需要创建
            sheet = workbook.createSheet((1+Calendar.getInstance().get(Calendar.MONTH)) + "月");
//            System.out.println("一号初始化sheet"+sheet.getSheetName());
        }else {
            //今天不是1号
            //是否初始化了
            if (new main().init){
                //今行初始化
                sheet = workbook.createSheet((1+Calendar.getInstance().get(Calendar.MONTH)) + "月");
//                System.out.println("非一号初始化sheet"+sheet.getSheetName());
                //初始化完毕，初始化功能关闭
                new main().init = false;
            }else {
                //继续使用
                //  !!! 注意这里，循环调用时，这个workbook对象是个新的，内容为空

                fs=new FileInputStream("D:\\"+Calendar.getInstance().get(Calendar.YEAR) + "年云班课.xls");  //获取head.xls
                ps=new POIFSFileSystem(fs);  //使用POI提供的方法得到excel的信息
                workbook =new HSSFWorkbook(ps);
                sheet=workbook.getSheet((1+Calendar.getInstance().get(Calendar.MONTH)) + "月");  //获取到工作表
//                System.out.println((1+Calendar.getInstance().get(Calendar.MONTH)) + "月");
//                System.out.println("非一号继续使用sheet");
//                System.out.println(sheet.getSheetName());
//                System.out.println("+++++++++++++++++++++++++");
            }
        }
        //如果sheet是空的，就属性全部加入
        //如果不是空的，就加入score属性
        //至于什么时候换sheet，有时间控制
//        System.out.println("56行的sheet:"+sheet.getSheetName());
//        System.out.println("第一次" + sheet.getLastRowNum());
        if (sheet.getLastRowNum() <= 0) {
//            System.out.println(sheet.getLastRowNum());
            //如果是新的sheet,在表中添加表头第0行
            HSSFRow row = sheet.createRow(0);
            //创建单元格，设置表头
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("排名");
            cell = row.createCell(1);
            cell.setCellValue("学号");
            cell = row.createCell(2);
            cell.setCellValue("姓名");
            for (int i = 3; i < 34; i++) {
                cell = row.createCell(i);
                cell.setCellValue((i-2)+ "号成绩");
            }
            //在表格写入数据
            for (int i = 0; i < users.size(); i++) {
                HSSFRow row1 = sheet.createRow(1 + i);
                User user = users.get(i);
                //创建单元格设值
                row1.createCell(0).setCellValue(user.getRanking());
                row1.createCell(1).setCellValue(user.getStudentNum());
                row1.createCell(2).setCellValue(user.getName());
                row1.createCell(2 + Calendar.getInstance().get(Calendar.DATE)).setCellValue(user.getScore());
            }
        } else {
            //如果sheet是继续添加
            //在表格写入数据
            for (int i = 0; i < users.size(); i++) {
                //从第一行开始写
                Row row1 = sheet.getRow(1 + i);
                User user = users.get(i);
                ///
                //创建单元格设值   正式
                row1.createCell(2 + Calendar.getInstance().get(Calendar.DATE)).setCellValue(user.getScore());
                //创建单元格设置值  测试
//                row1.createCell((new main().day2 + Calendar.getInstance().get(Calendar.DATE))).setCellValue(user.getScore());
            }
            //测试
//            new main().day2++;
        }

//        System.out.println("输出30行30列检查是否写入成功");
//        for (int i = 0; i <30 ; i++) {
//            for (int j = 0; j < 20; j++) {
//                System.out.print(sheet.getRow(i).getCell(j));
//            }
//            System.out.println("");
//        }

        //一直到这里 sheet都是填好的

        //将文件保存到指定的位置
        try {
            //允许继续写入
             fos = new FileOutputStream(file);
            workbook.write(fos);
            System.out.println("写入成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fos!=null){
                fos.close();
            }
            if (fs!=null){
                fs.close();
            }
        }

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        //此处修改为+1则是获取后一天
        calendar.set(Calendar.DATE, day + 1);
        if (day == 1) {
             new main().write = false;
        } else {
             new main().write = true;
        }
    }
}
