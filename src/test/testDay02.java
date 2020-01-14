package test;

/**
 * 使用缓冲流，实现文件的拷贝，
 * 文件类型可以选择文本文件或图片文件，
 * 请根据不同的文件类型选取不同的流处理
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 分析
 *      1.获取文件的类型
 *      2.  文本文件用字节流reader,writer
 *          图片文件用字符流BufferInputStream,BufferOutputStream
 */
public class testDay02 {
    public static void main(String[] args) {
        try{
           //1.获取要复制的文件夹
            File dir=new File("D:\\test\\day02test");
            //.复制文件
           copyListAll(dir);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void copyListAll(File dir){
        System.out.println(dir.getPath());
                    InputStream is = null;
                    OutputStream os = null;
                    Reader reader=null;
                    Writer writer=null;
                try {
       //2.把文件转成文件数组
        File[]files=dir.listFiles();
        //3.依次获取数组里的文件并判断是文件夹还是文件
        for (File file:files){
            if (file.isDirectory()){
                //4.如果是文件夹，递归文件夹
                copyListAll(file);
            }else{
                //4.如果不是文件夹，复制到D:\test
                //  4.1获取文件类型
                    String type= Files.probeContentType(Paths.get(file.getPath()));
                System.out.println("type="+type);
                //  4.2根据文件类型选择不同的流
                    if (type.equals("image/jpeg")){
                        System.out.println("文件类型jpeg，选择字节流");
                        is=new FileInputStream(file);
                        os=new FileOutputStream("D:\\test\\复制的图片.jpeg");
                        BufferedInputStream buf=new BufferedInputStream(is);
                        BufferedOutputStream bos=new BufferedOutputStream(os);
                        //4.2.1高效字节流一次读取一个字节数组
                        byte [] bys=new byte[1024];
                        int len=0;
                        while((len=buf.read(bys))!=-1){
                            bos.write(bys,0,len);
                        }
                        bos.close();
                        buf.close();
                    }else if (type.equals("text/plain")){
                        System.out.println("文件类型txt，选择字符流");
                        reader=new InputStreamReader(new FileInputStream(file));

                        writer=new OutputStreamWriter(new FileOutputStream("D:\\test\\复制的文本.txt"));//你看这里
                        BufferedReader br=new BufferedReader(reader);
                        BufferedWriter bw=new BufferedWriter(writer);
                        //4.2.1高效字符流一次读取一个字符数组
                        char [] chs= new char[1024];
                        int len=0;
                        while((len=reader.read(chs))!=-1){
                            writer.write(chs,0,len);
                        }
                        br.close();
                        bw.close();
                    }else {
                        System.out.println("目前仅支持jpeg和txt两种格式");
                    }
            }
        }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (os!=null){
                        try {
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (is!=null){
                        try {
                            is.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (reader!=null){
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (writer!=null){
                        try {
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                }
    }
}
