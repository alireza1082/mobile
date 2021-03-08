package ir.sharif.moblie_hw1;

import android.widget.ImageView;


public class Coin {
    private ImageView coin_Image;
    private String coin_Name;
    private String coin_Fee;
    private int Hour;
    private int day;
    private int week;

    public Coin(ImageView coin_Image, String coin_Name, String coin_Fee, int hour, int day, int week) {
        this.coin_Image = coin_Image;
        this.coin_Name = coin_Name;
        this.coin_Fee = coin_Fee;
        Hour = hour;
        this.day = day;
        this.week = week;
    }

    public ImageView getCoin_Image() {
        return coin_Image;
    }

    public String getCoin_Name() {
        return coin_Name;
    }

    public String getCoin_Fee() {
        return coin_Fee;
    }

    public int getHour() {
        return Hour;
    }

    public int getDay() {
        return day;
    }

    public int getWeek() {
        return week;
    }
}
