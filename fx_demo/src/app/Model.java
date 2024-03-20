package app;

public class Model {
    public static int clicksNum = 0;

    public static int getClicksNum(){
        clicksNum++;
        return clicksNum;
    }
}
