package xielou;

import java.io.IOException;

/**
 * Created by Administrator on 2016/4/29.
 */
public class MAIN {

    int a = 0;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        long time = System.currentTimeMillis();
        //new MyThread().start();
        for(int k=0;k<1000000;k++)
        for(int i=0;i<100000;i++) {

            //++����
            Sing.getInstance().blong ++;
            //���������++���� ��������������ʧô
            Sing.getInstance().setBlong(Sing.getInstance().getBlong() + 1);
//            Sing.getInstance().blong ++;
            //�Ƿ���й¶��
            Sing.getInstance().setaLong(new Long(123));
            //Thread.sleep(100);
            //�Ƿ���й¶��
            Sing.getInstance().xielou();
        }

//        System.gc();
        System.out.println("wating:" + Runtime.getRuntime().freeMemory() + " max:" + Runtime.getRuntime().maxMemory() + " time:" + (System.currentTimeMillis() - time + " blong:" + Sing.getInstance().blong));
        System.in.read();
    }
}
