package cn.itcast.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 用户的实体类
* */
public class User {
    private int id;
    private String username;
    private String password;
    private  String gender;
    public User(){}
    public User(String username,String password){
        this.username=username;
        this.password=password;
    }
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 逻辑视图
     * @return
     */
    public String getBirStr() {
        if (birthday!=null){
        //1.格式化日期对象
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //2.返回字符串即可
            return simpleDateFormat.format(birthday);
        }else {
            return "";
        }
    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private Date birthday;
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
