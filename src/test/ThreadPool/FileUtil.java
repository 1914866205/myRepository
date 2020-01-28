package test.ThreadPool;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class FileUtil {

    /**
     * 下载网络图片的方法，默认保存至当前文件所在地
     *
     * @param urlPath 给定网络图片url地址
     */
    public static void downPicture(String urlPath) {
        URL url = null;
        try {
            url = new URL(urlPath);
        } catch (MalformedURLException e) {
            System.out.println("创建URL对象出现异常");
        }
        /**
         * 创建IO流进行下载图片
         * url.openStream(): 打开于此URL，并返回一个InputStream，以便从该连接读取
         */
        InputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream fos = null;
        BufferedOutputStream bos = null;
        byte[] temp = new byte[2048];
        try {
            fis = url.openStream();
            bis = new BufferedInputStream(fis);

            fos = new FileOutputStream(new File(StringUtils.splitPicName(urlPath)));
            bos = new BufferedOutputStream(fos);

            while ((bis.read(temp)) != -1) {
                bos.write(temp);
            }
        } catch (IOException e) {
            System.out.println("出现IO异常");
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                System.out.println("IO流关闭出现异常");
            }
        }
    }
}
