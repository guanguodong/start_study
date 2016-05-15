package xielou;

import java.util.HashSet;
import java.util.UUID;

/**
 * Created by Administrator on 2016/4/29.
 */
public class Sing {
    private static Sing _Sing;
    public static Sing getInstance(){
        if(_Sing == null){
            _Sing = new Sing();
        }
        return _Sing;
    }

    public long blong;
    public Long aLong;

    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
//        this.aLong = null;
        this.aLong = aLong;
    }

    public long getBlong() {
        return blong;
    }

    public void setBlong(long blong) {
        this.blong = blong;
    }

    HashSet<String> strings = new HashSet<>();

    public void xielou(){
        strings = new HashSet<String>();
        for(int i = 0;i < 1000;i++) {
            strings.add(UUID.randomUUID().toString());
        }
        strings = null;

    }
}
