package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;

import java.sql.SQLException;

public class UserDaoTest {

    @Test
    public void testLogin() throws SQLException {
        User user=new User();
        user.setUsername("ntt");
        user.setPassword("111");

        UserDao dao=new UserDao();
        User user1=dao.login(user);
        System.out.println(user1);
    }
}
