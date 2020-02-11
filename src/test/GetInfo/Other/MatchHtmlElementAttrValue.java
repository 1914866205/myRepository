package test.GetInfo.Other;

import test.GetInfo.GetInfoByUrl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @use 获取指定HTML标签的指定属性的值
 * @ProjectName stuff
 * @Author <a href="mailto:mhmyqn@qq.com">mikan</a></br>
 * @Date 2012-11-19 下午08:27:24 </br>
 * @FullName com.mmq.regex.MatchHtmlElementAttrValue.java </br>
 * @JDK 1.6.0 </br>
 * @Version 1.0 </br>
 */
public class MatchHtmlElementAttrValue {

    /**
     * 获取指定HTML标签的指定属性的值
     * @param source 要匹配的源文本
     * @return 属性值列表
     */
    public static List<String> match(String source) {
        List<String> result = new ArrayList<String>();
//        String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";
//        String reg2 = "<a[^<>]*?\\s title=['\"]?(.*?)['\"]?(\\s.*?)?>";
        String reg2 = "class=\"full-name\">[\\u4E00-\\u9FA5]{2,3}";//名字
//        String reg2 = "class=\"student-no\">[0-9]{10}";
//        String reg2 = "class=\"score\">[0-9]{1,4}";//成绩
//        String reg2 = "class=\"ranking\">[0-9]{1,2}";//排名
//        String reg2 = "class=\"full-name\">倪涛涛</li>([\\s\\S]*){23700}";//名字




        //              <a开头.
        //              [] 表示一个中括号表达式的开始
        //              ^  当该符号在方括号表达式中使用时，表示不接受该方括号表达式中的字符集合。
        //              *  前面的子表达式零次或多
        //              ?  	匹配前面的子表达式零次或一次，或指明一个非贪婪限定符
        //             \\s  空白字符
        //             title=
        //
        Matcher m = Pattern.compile(reg2).matcher(source);
        while (m.find()) {
            String r = m.group(0);
            String s=r.substring(18);
            System.out.println(r.length());
            System.out.println(s);
            result.add(r);
        }
        return result;
    }

    public static void main(String[] args) {
//        String source = "<a title=中国体育报 href=''>aaa</a><a title='北京日报' href=''>bbb</a>";
        String source =" <ul>\n" +
                "                <li class=\"user-id\">7ADA9C11-C37A-11E8-AA22-7CD30AD36C02</li>\n" +
                "                <li class=\"full-name\">倪涛涛</li>\n" +
                "                <li class=\"student-no\">1802343210</li>\n" +
                "                <li class=\"avatar-url\">https://public-cdn-oss.mosoteach.cn/avatar/2018/7A/4a5787dc90bf88f6aa94b4d5637e3300.jpg?v=1538179726&x-oss-process=style/s100x100</li>\n" +
                "                <li class=\"score\">16</li>\n" +
                "                <li class=\"ranking\">1</li>\n" +
                "                <li class=\"read-progress\">0</li>\n" +
                "                <li class=\"role\">2</li>\n" +
                "            </ul>";

//        GetInfoByUrl getInfoByUrl = new GetInfoByUrl();
//        String source=getInfoByUrl.getInfo();
        List<String> list = match(source);
        System.out.println(list);
//        System.out.println(source);
    }
}
