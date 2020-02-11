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
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//对接口进行测试
public class getCookie {
    private String loginUrl = "https://www.mosoteach.cn/web/index.php?c=passport&m=account_login";
    private String SearchUrl = "https://www.mosoteach.cn/web/index.php?c=member&m=index&clazz_course_id=2E0265B9-48F7-11EA-9C7F-98039B1848C6";
    private String charset = "UTF-8";

    public void test() {
        //用于模拟登录的账号密码
        Map<String, String> createMap = new HashMap<String, String>();
        createMap.put("account_name", "18851855106");
        createMap.put("user_pwd", ".15252205596xin");
        //登录页
        HttpPost httpPost = null;
        //目标页
        HttpPost httpPost2 = null;
        HttpResponse response = null;
        DefaultHttpClient client = null;
        String result = null;
        try {
            client = new DefaultHttpClient(new PoolingClientConnectionManager());
            httpPost = new HttpPost(loginUrl);
            // 设置请求头
            httpPost.setHeader("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");
            // 设置参数
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
            System.out.println("第一次响应头：-----------------"+response);
            String cookie = response.getLastHeader("Set-Cookie").getValue();
            // 第二次请求
            httpPost2 = new HttpPost(SearchUrl);//_uab_collina=157927674500777564610578; acw_tc=2f624a1415792767441954828e3bb8431fec169c7ab94717021e6f33395660; UM_distinctid=16fa902cc3ea6d-01a39aa22b730b-4c302978-144000-16fa902cc3f2f5; CNZZDATA1253495893=918955579-1579083845-https%253A%252F%252Fwww.baidu.com%252F%7C1579083845; SERVERID=99839ef45d7a55eafa8a2c6e604962e2|1581342594|1581342372;???喔艹 teachweb=92e9245471d6b09ee17553b605d02b4bacb746ff
            String finalCookie="_uab_collina=157927674500777564610578; acw_tc=2f624a1415792767441954828e3bb8431fec169c7ab94717021e6f33395660;UM_distinctid=16fa902cc3ea6d-01a39aa22b730b-4c302978-144000-16fa902cc3f2f5; CNZZDATA1253495893=918955579-1579083845-https%253A%252F%252Fwww.baidu.com%252F%7C1579083845; ";
            finalCookie+=cookie;
            finalCookie+="teachweb=25d723d89eaf193d5f9bdfa42317c79069bdd27e";
//            httpPost2.setHeader("Cookie",finalCookie);
            response = client.execute(httpPost2);
            System.out.print("第二次请求头");
            for(Header header :httpPost2.getAllHeaders()){//SERVERID=68d1116c9d546083ed3f42865840c83a|1581344640|1581344632;Path=/
                System.out.println("：-----------------"+header.toString());
            }
//UM_distinctid=16fa902cc3ea6d-01a39aa22b730b-4c302978-144000-16fa902cc3f2f5; CNZZDATA1253495893=918955579-1579083845-https%253A%252F%252Fwww.baidu.com%252F%7C1579083845; SERVERID=68d1116c9d546083ed3f42865840c83a|1581344677|1581344632; teachweb=25d723d89eaf193d5f9bdfa42317c79069bdd27e
            System.out.println("第二次响应头：-----------------"+response);

            // 登录后的请求内容
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
//                    //通过延迟2000毫秒然后再去请求可解决js异步加载获取不到数据的问题
//                    Document doc= Jsoup.connect(SearchUrl).timeout(2000).get();
////        System.out.println("doc"+doc);
//                    Elements elements = doc.getElementsByClass("members");
//                    System.out.println("elements"+elements);
//                    System.out.println("Result---------------------start:");
//                    for (Element element : elements) {
//                        // 打印出每一个节点的信息;你可以选择性的保留你想要的数据,一般都是获取个固定的索引;
//                        if (element != null) {
//                            System.out.println(element.text());
//                        }
//                    }
//                    System.out.println("Result---------------------End");
                    result = EntityUtils.toString(resEntity, charset); //因为你登录的结果没有被你用到所以说
                }
            }
             System.out.println(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getCookie main = new getCookie();
        main.test();
    }
}
