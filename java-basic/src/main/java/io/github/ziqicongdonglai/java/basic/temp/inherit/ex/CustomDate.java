package io.github.ziqicongdonglai.java.basic.temp.inherit.ex;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author ke_zhang
 * @create 2021-10-21 10:20
 * @description 自定义Date
 */
public class CustomDate extends Date {
    public void getGMT() {
        Calendar cd = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss 'GMT'", Locale.CHINA);
        df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println(df.format(cd.getTime()));
        // 距离 1970年1月1日 时间戳
        //System.out.println(System.currentTimeMillis());
    }

    @Override
    public String toString() {
       DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       return df.format(this);
    }

    public static void main(String[] args) {
        CustomDate customDate = new CustomDate();
        //System.out.println(customDate);
        customDate.getGMT();
    }
}
