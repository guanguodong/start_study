package xielou;

/**
 * Created by Administrator on 2016/5/1.
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println(System.currentTimeMillis());
        }
    }
}
