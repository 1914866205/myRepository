package test.GetInfo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class WriterExcel {
    public boolean weiterExcel(ArrayList<User> users) throws Exception{
       //1.创建一个workbook对象对应一个excel文件
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=null;
        File file=null;
       //2.是否是第一次运行
       if (new main().init){
           //第一次运行，要创建这个文件，以及一个sheet
           //格式：xxxx年x月云班课成绩
           file=new File(Calendar.getInstance().get(Calendar.YEAR)+"年云班课.xls");
           file.createNewFile();
           sheet=workbook.createSheet(Calendar.getInstance().get(Calendar.MONTH)+"月");
            new main().init=false;
       }else{
           //如果Excel存在
           file=new File(Calendar.getInstance().get(Calendar.YEAR)+"年"+Calendar.getInstance().get(Calendar.MONTH)+"月云班课.xls");

            //再判断是否需要新建sheet
           if (new main().day==1){
               //如果是一号，就新建一个sheet
               sheet=workbook.createSheet(Calendar.getInstance().get(Calendar.MONTH)+"月");
           }else {
               //如果不是一号，就用之前的sheet
               sheet=workbook.getSheet(Calendar.getInstance().get(Calendar.MONTH)+"月");
           }

       }

        //如果sheet是空的，就属性全部加入
        //如果不是空的，就加入score属性
        //至于什么时候换sheet，有时间控制
        if (sheet==null){
            //如果是新的sheet,在表中添加表头第0行
            HSSFRow row=sheet.createRow(0);
            //创建单元格，设置表头
            HSSFCell cell=row.createCell(0);
            cell.setCellValue("排名");
            cell=row.createCell(1);
            cell.setCellValue("学号");
            cell=row.createCell(2);
            cell.setCellValue("姓名");
            for (int i = 3; i <34 ; i++) {
                cell=row.createCell(i);
                cell.setCellValue(Calendar.getInstance().get(Calendar.DATE)+"号成绩");
            }
            //在表格写入数据
            for (int i = 0; i <users.size() ; i++) {
                HSSFRow row1=sheet.createRow(1+i);
                User user=users.get(i);
                //创建单元格设值
                row1.createCell(0).setCellValue(user.getRanking());
                row1.createCell(1).setCellValue(user.getStudentNum());
                row1.createCell(2).setCellValue(user.getName());
                row1.createCell(2+Calendar.getInstance().get(Calendar.DATE)).setCellValue(user.getScore());
            }
        }else {
            //如果sheet是继续添加
            //在表格写入数据
            for (int i = 0; i <users.size() ; i++) {
                HSSFRow row1=sheet.createRow(1+i);
                User user=users.get(i);
                //创建单元格设值
                row1.createCell(2+Calendar.getInstance().get(Calendar.DATE)).setCellValue(user.getScore());
            }
        }
        //将文件保存到指定的位置
        try {
            //允许继续写入
            FileOutputStream fos = new FileOutputStream(file,true);
            workbook.write(fos);
            System.out.println("写入成功");
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Calendar calendar=Calendar.getInstance();
        int day=calendar.get(Calendar.DATE);
        //         此处修改为+1则是获取后一天
        calendar.set(Calendar.DATE,day+1);
        if (day==1){
        return new main().write=false;
        }else {
        return new main().write=true;
        }
    }
}
