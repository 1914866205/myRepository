package test.GetInfo.Other;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.net.URI;
import java.util.List;

/**
 * @author mq_xu
 * @description 客户端表单登录后取值（云班课为例）
 * @create 2020/2/7
 */
public class ClientFormLogin {
    public static void main(String[] args) throws Exception {
        BasicCookieStore cookieStore = new BasicCookieStore();
        try (CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build()) {

            HttpUriRequest login = RequestBuilder.post()
                    .setUri(new URI("https://www.mosoteach.cn/web/index.php?c=passport&m=account_login"))
                    .addParameter("account_name", "18851855106")
                    .addParameter("user_pwd", ".15252205596xin")
                    .build();
            try (CloseableHttpResponse response2 = httpclient.execute(login)) {
                HttpEntity entity = response2.getEntity();

                System.out.println("Login form post: " + response2.getStatusLine());
                EntityUtils.consume(entity);

                System.out.println("Post login cookies:");
                List<Cookie> cookies = cookieStore.getCookies();
                String auth = "";
                if (cookies.isEmpty()) {
                    System.out.println("None");
                } else {
                    for (Cookie cookie : cookies) {
                        System.out.println("- " + cookie.toString());
                        if ("SERVERID".equals(cookie.getName())) {
                            auth = cookie.getValue();
                        }
                    }
                }
            } finally {
                //班课活动数据
//                HttpGet httpGet = new HttpGet("https://www.mosoteach.cn/web/index.php?c=interaction&m=index&clazz_course_id=94F161C6-9395-11E9-A9F1-98039B1848C6");
                HttpGet httpGet = new HttpGet("https://www.mosoteach.cn/web/index.php?c=interaction&m=index&clazz_course_id=2E0265B9-48F7-11EA-9C7F-98039B1848C6");
                CloseableHttpResponse response = httpclient.execute(httpGet);
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//                FileUtils.writeStringToFile(new File("D:\\activity.html"), content, "UTF-8");
                System.out.println(content);
                //它这个都没传cookie?它在上面把cookie得到了  但是没用？  应该在下面屏蔽的代码里用了没有  我看了一圈
                //班课资源数据
//                HttpGet httpGet = new HttpGet("https://www.mosoteach.cn/web/index.php?c=res&m=index&clazz_course_id=88B0EAF8-2D3B-11EA-9C7F-98039B1848C6");
//                CloseableHttpResponse response = httpclient.execute(httpGet);
//                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//                FileUtils.writeStringToFile(new File("D:\\resource.html"), content, "UTF-8");
//                System.out.println(content);

                //班课成员数据
//                HttpGet httpGet = new HttpGet("https://www.mosoteach.cn/web/index.php?c=member&m=index&clazz_course_id=94F161C6-9395-11E9-A9F1-98039B1848C6");
//                CloseableHttpResponse response = httpclient.execute(httpGet);
//                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//                FileUtils.writeStringToFile(new File("D:\\member.html"), content, "UTF-8");
//                System.out.println(content);

                //成员分组数据
//                HttpGet httpGet = new HttpGet("https://www.mosoteach.cn/web/index.php?c=member_group&m=detail&clazz_course_id=94F161C6-9395-11E9-A9F1-98039B1848C6&plan_id=142861");
//                CloseableHttpResponse response = httpclient.execute(httpGet);
//                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//                FileUtils.writeStringToFile(new File("D:\\member_group.html"), content, "UTF-8");
//                System.out.println(content);


                //班课分组数据
//                HttpGet httpGet = new HttpGet("https://www.mosoteach.cn/web/index.php?c=group&m=index&clazz_course_id=94F161C6-9395-11E9-A9F1-98039B1848C6");
//                CloseableHttpResponse response = httpclient.execute(httpGet);
//                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//                FileUtils.writeStringToFile(new File("D:\\group.html"), content, "UTF-8");
//                System.out.println(content);

                //导出报告页面数据
//                HttpUriRequest export = RequestBuilder.post()
//                        .setUri(new URI("https://www.mosoteach.cn/web/index.php?c=export&m=export_data&clazz_course_id=94F161C6-9395-11E9-A9F1-98039B1848C6"))
////                        .addParameter("clazz_course_id", "94F161C6-9395-11E9-A9F1-98039B1848C6")
////                        .addParameter("user_id", "97CD5E48-D0F2-11E8-AA22-7CD30AD36C02")
//                        .build();
//                CloseableHttpResponse response = httpclient.execute(export);
//                HttpEntity entity = response.getEntity();
//                String content = EntityUtils.toString(entity);
//                FileUtils.writeStringToFile(new File("D:\\export.html"), content, "UTF-8");


                //教学包数据
//                HttpGet httpGet = new HttpGet("https://www.mosoteach.cn/web/index.php?c=ccp&m=index");
//                CloseableHttpResponse response = httpclient.execute(httpGet);
//                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//                FileUtils.writeStringToFile(new File("D:\\course_package.html"), content, "UTF-8");
//                System.out.println(content);

                //库管理数据
//                HttpPost httpPost = new HttpPost("https://www.mosoteach.cn/web/index.php?c=library_manager&m=get_repository_list");
//                CloseableHttpResponse response = httpclient.execute(httpPost);
//                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//                FileUtils.writeStringToFile(new File("D:\\lib_manage.html"), content, "UTF-8");
//                System.out.println(content);
            }
        }
    }
}
