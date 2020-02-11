package test.GetInfo;

public class main {
    public static void main(String[] args) {
        GetInfoByUrl getInfoByUrl = new GetInfoByUrl();
        String result=getInfoByUrl.getInfo();
        new NeedInfo().getList(result);
    }
}
