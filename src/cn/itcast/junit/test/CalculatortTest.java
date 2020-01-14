package cn.itcast.junit.test;

import cn.itcast.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class CalculatortTest {
        /*
        * 初始化方法    @Before
        *       用于资源申请，所有测试方法在执行之前都会执行该方法
         * */

                       @Before
                       public void init(){
                               System.out.println("init被执行了");
                          }
           /* 释放资源方法    @After
            *       用于资源释放，所有测试方法在执行之后都会执行该方法
             * */

        @After
        public void close(){
                System.out.println("close被执行了");
        }


        //测试add方法
        @Test
        public void testAdd(){
                //1 创建计算器对象
                Calculator calculator=new Calculator();
                //2 测试方法
                int m=calculator.add(1,2);
                System.out.println(m);
                //如果控制台是绿色 则无错误
                //如果是红色，则有错误
                //一般只看程序是否运行成功，不看结果

                //断言   我断言结果为3
                Assert.assertEquals(3,m);

        }

}
