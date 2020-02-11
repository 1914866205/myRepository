package test.GetInfo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NeedInfo {
    public void getList(String result) {
        //匹配最小数据域的正则
        String regRange = "class=\"full-name\">倪涛涛</li>([\\s\\S]*){23700}";//名字
//        String s=r.substring(0,23700);

//        //匹配名字的正则
        String regName = "class=\"full-name\">[\\u4E00-\\u9FA5]{2,3}";
////        String s=r.substring(18);  从第18位截取
//        //匹配学号的正则
//        String regStudentNum = "class=\"student-no\">[0-9]{10}";
////        String s=r.substring(19);
//        //匹配成绩的正则
//        String regScore = "class=\"score\">[0-9]{1,4}";
////        String s=r.substring(14);
//        //匹配排名的正则
//        String regRanking = "class=\"ranking\">[0-9]{1,2}";//排名
////        String s=r.substring(16);

        //先把所有数据删减到需要的数据
        String rang = this.getInfoByReg(result, regRange, 0, 23700);
        int i=this.getSize(rang,regName);
        ArrayList<User> users = new ArrayList<>();
        for (int x=0;x<i;x++){
            User user=new User();
            users.add(user);
        }
        this.getInfoByRegName(rang,users);
        this.getInfoByRegRanking(rang,users);
        this.getInfoByRegScore(rang,users);
        this.getInfoByRegStudentNum(rang,users);

        //把集合对象按照成绩降序排序
        Collections.sort(users, new Comparator<User>(){
            /*
             * int compare(User o1, User o2) 返回一个基本类型的整型，
             */
            public int compare(User u1, User u2) {
                //按照学生的成绩进行降序排列
                if(u1.getScore() > u2.getScore()){
                    return -1;
                }
                if(u1.getScore() == u2.getScore()){
                    return 0;
                }
                return 1;
            }
        });




        System.out.println(users);
    }

    public String getInfoByReg(String info, String reg, int start, int end) {
        Matcher m = Pattern.compile(reg).matcher(info);
        String s = null;
        while (m.find()) {
            String r = m.group(0);
            s = r.substring(start, end);
        }
        return s;
    }

    public int getSize(String rang, String reg) {
        Matcher m = Pattern.compile(reg).matcher(rang);
        int i=0;
        while (m.find()) {
            i++;
        }
        return  i;
    }

    public int getInfoByRegName(String rang,ArrayList<User> users) {
        Matcher m = Pattern.compile("class=\"full-name\">[\\u4E00-\\u9FA5]{2,3}").matcher(rang);
        int i=0;
        String string = null;
        while (m.find()) {
            String r = m.group(0);
            string = r.substring(18);
            users.get(i).setName(string);
            i++;
        }
        return  i;
    }

    public int getInfoByRegStudentNum(String rang,ArrayList<User> users) {
        Matcher m = Pattern.compile("class=\\\"student-no\\\">[0-9]{10}").matcher(rang);
        int i=0;
        String string = null;
        while (m.find()) {
            String r = m.group(0);
            string = r.substring(19);
            users.get(i).setStudentNum(string);
            i++;
        }
        return  i;
    }
    public int getInfoByRegScore(String rang,ArrayList<User> users) {
        Matcher m = Pattern.compile("class=\"score\">[0-9]{1,4}").matcher(rang);
        int i=0;
        String string = null;
        while (m.find()) {
            String r = m.group(0);
            string = r.substring(14);
            users.get(i).setScore(Integer.parseInt(string));
            i++;
        }
        return  i;
    }
    public int getInfoByRegRanking(String rang,ArrayList<User> users) {
        Matcher m = Pattern.compile("class=\"ranking\">[0-9]{1,2}").matcher(rang);
        int i=0;
        String string = null;
        while (m.find()) {
            String r = m.group(0);
            string = r.substring(16);
            users.get(i).setRanking(Integer.parseInt(string));
            i++;
        }
        return  i;
    }

}
