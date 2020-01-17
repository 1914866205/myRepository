package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class TestDay20200116RandomAccessFile {
    public static void main(String[] args) {
        RandomAccessFile randomAccessFile;
        {
            try {
                randomAccessFile = new RandomAccessFile(new File("D:\\QQ群下载\\data.txt"),"r");
                String str="";
                while ((str=randomAccessFile.readLine())!=null){
                    if (str.subSequence(0,str.length()-1).equals("Host")){
                        System.out.println("Host:"+randomAccessFile.readLine());
                    }else if (str.subSequence(0,str.length()-1).equals("Content-Type")){
                        System.out.println("Content-Type:"+randomAccessFile.readLine());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
