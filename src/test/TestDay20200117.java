package test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TestDay20200117 {
    public static void main(String[] args) throws Exception {
            //1.获取要查询的文件夹
            File dir=new File("C:\\Users\\lenovo\\Pictures");
            //2.File[] listFiles()
            // 返回由当前File对象对应目录所包含文件路径或文件夹路径组成的File类型的数组。
            File[]fileArr=dir.listFiles();
            List<File> fileList=new ArrayList<File>();
            for (File file: fileArr){
                if (!file.isDirectory()){

                // 获取文件类型
                String type= Files.probeContentType(Paths.get(file.getPath()));
                if ("image/jpeg".equals(type)||"image/jpg".equals(type)) {
                    fileList.add(file);
                }
                }
            }
        System.out.println(fileList);
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                long diff=o1.length()-o2.length();
                if (diff>0){
                    return 1;
                }else if (diff==0){
                    return 0;
                }else {
                    return -1;
                }
            }

            @Override
            public boolean equals(Object obj) {
                return true;
            }
        });
        for (File file1:fileList){
            if (file1.isDirectory()){
                continue;
            }
            System.out.println(file1.getName()+":"+file1.length());
        }
    }
}

