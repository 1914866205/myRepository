package design_pattern.proxy;

public class UserDaoProxy implements UserDao {
    private UserDao userDao=null;

    public UserDaoProxy(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("开始了");
        userDao.save();
        System.out.println("结束啦");
    }
}
