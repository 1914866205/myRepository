package design_pattern.proxy;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("事务执行");
    }
}
