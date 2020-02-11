package test.GetInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
public class GetInfoByUrl {
    private String loginUrl = "https://www.mosoteach.cn/web/index.php?c=passport&m=account_login";
    private String SearchUrl = "https://www.mosoteach.cn/web/index.php?c=member&m=index&clazz_course_id=2E0265B9-48F7-11EA-9C7F-98039B1848C6";
    private String charset = "UTF-8";

    public String getInfo() {
        //用于模拟登录的账号密码
        Map<String, String> createMap = new HashMap<String, String>();
        createMap.put("account_name", "18851855106");
        createMap.put("user_pwd", ".15252205596xin");
        //用于登录页
        HttpPost httpPost = null;
        //用于目标页
        HttpPost httpPost2 = null;

        HttpResponse response = null;
        //使用HttpClient发送请求、接收响应
        DefaultHttpClient client = null;
        String result = null;
        try {
            client = new DefaultHttpClient(new PoolingClientConnectionManager());
            httpPost = new HttpPost(loginUrl);
            // 设置请求头
            httpPost.setHeader("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");
    //         设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = createMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, String> elem = (Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
            // 第一次请求
            response = client.execute(httpPost);
//            System.out.println("第一次响应头：-----------------"+response);
//            String cookie = response.getLastHeader("Set-Cookie").getValue();
  //           第二次请求
            httpPost2 = new HttpPost(SearchUrl);
            response = client.execute(httpPost2);
//            for(Header header :httpPost2.getAllHeaders()){
//                System.out.println("-----------------"+header.toString());
//            }
//            System.out.println("第二次响应头：-----------------"+response);
//             登录后的请求内容
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


}
