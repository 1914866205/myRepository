//package test.GetInfo;
//
//
//import org.apache.taglibs.standard.resources.Resources;
//import org.jsoup.Jsoup;
//import org.jsoup.helper.DataUtil;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import test.ThreadPool.Resource;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ResolveResources {
//    public static List<Resources> resolveResources(String content){
//        List<Resources> resourcesList=new ArrayList<>();
//        Document document=null;
//        document= Jsoup.parse(content,"utf-8");
//        assert document!=null;
//        Element resListBox=document.getElementById("res-list-box");
//        //得到分组（看资源分组的时候可以显示）
//        Elements resRowBox=resListBox.getElementsByClass("res-row-box");
//        for (Element rowBox:resRowBox){
//            Element groupNameNode=rowBox.select(".res-group-name").first();
//            String groupName=groupNameNode.text();
//            int groupId= DataUtil.getGroupId(groupName);
//            //该分组下的资源集合
//            Elements groupResLists=rowBox.select(".res-row-open-enable");
//            for (Element resElement : groupResLists){
//                Resources resources=new Resources();
//                String title=resElement.select(".res-name").first().attr("title");
//                String name=resElement.select(".res-name").first().text();
//            }
//
//        }
//        return resourcesList;
//    }
//}
