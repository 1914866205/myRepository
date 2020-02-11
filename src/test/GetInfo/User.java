package test.GetInfo;

public class User {
    //姓名
    private String name;
    //排名
    private int ranking;
    //经验
    private int score;
    //学号
    private String studentNum;
    public User() {
    }
    public User(String name, int ranking, int score, String studentNum) {
        this.name = name;
        this.ranking = ranking;
        this.score = score;
        this.studentNum = studentNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", ranking=" + ranking +
                ", score=" + score +
                ", studentNum='" + studentNum + '\'' +
                '}';
    }
}
