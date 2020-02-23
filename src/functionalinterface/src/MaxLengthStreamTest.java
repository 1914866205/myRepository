package functionalinterface.src;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MaxLengthStreamTest {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("javascript", "java", "javaweb", "springframework", "javaapi", "springboot", "javaee"));
        //重写接口，实现把最长的字符串集中到一个结果中

        MaxLengthStream mls=new MaxLengthStream() {
            @Override
            public List<String> getMaxLengthWords(List<String> list) {
                List<String> result=new ArrayList<>(5);
                for (int i = 0; i < 5; i++) {
                    //找出长度最长的字符串
                    String s = stringList.stream().max(Comparator.comparingInt(String::length)).get();
                    //加入结果集
                    result.add(s);
                    //从原集合移除
                    stringList.removeIf(str -> str.equals(s));
                }
                return result;
            }
        };
        //调用目标方法
        List<String> maxLengthWords = mls.getMaxLengthWords(stringList);
        //输出结果
        System.out.println(maxLengthWords);

        List<StudentInfo> studentList = new ArrayList<>();
        studentList.add(new StudentInfo("李小明",18,1.76, LocalDate.of(2001,3,23)));
        studentList.add(new StudentInfo("张小丽",18,1.61,LocalDate.of(2001,6,3)));
        studentList.add(new StudentInfo("王大朋",19,1.82,LocalDate.of(2000,3,11)));
        studentList.add(new StudentInfo("陈小跑",17,1.67,LocalDate.of(2002,10,18)));
        studentList.add(new StudentInfo("刘大硕",17,1.67,LocalDate.of(2002,10,18)));

        //排序前输出
        System.out.println("排序前");
        stringList.forEach(System.out::println);

        //按年龄排序（Integer类型）
        List<StudentInfo> sortedByAge = studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge)).collect(Collectors.toList());
        System.out.println("按年龄升序排序");
        sortedByAge.forEach(System.out::println);

        //按年龄 降序排序(Integer类型)，年龄相同按身高排序
        List<StudentInfo> sortedByAgeDesc = (List<StudentInfo>) studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge).reversed()).collect(Collectors.toList());
        System.out.println("按年龄降序排序");
        sortedByAgeDesc.forEach(System.out::println);

        //按年龄降序排序（Integer类型）,若年龄相同则按照身高排序
        List<StudentInfo> sortedByAgeAndHeight=studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge).reversed().thenComparing(StudentInfo::getHeight)).collect(Collectors.toList());
        System.out.println("按年龄降序和按身高升序排序");
        sortedByAgeAndHeight.forEach(System.out::println);
    }
}
