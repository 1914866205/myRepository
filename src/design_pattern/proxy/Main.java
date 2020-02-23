package design_pattern.proxy;

public class Main {
    public static void main(String[] args) {
        UserDaoImpl userDao=new UserDaoImpl();
        userDao.save();

        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();
    }
}
