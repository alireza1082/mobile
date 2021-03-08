package ir.sharif.moblie_hw1;

import android.widget.ImageView;
import android.widget.TextView;


public class Coin {
    private ImageView coin_Image;
    private TextView coin_Name;
    private TextView coin_Fee;
    private TextView Hour;
    private TextView day;
    private TextView week;

    public Coin(ImageView coin_Image, TextView coin_Name, TextView coin_Fee, TextView hour, TextView day, TextView week) {
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

    public TextView getCoin_Name() {
        return coin_Name;
    }

    public TextView getCoin_Fee() {
        return coin_Fee;
    }

    public TextView getHour() {
        return Hour;
    }

    public TextView getDay() {
        return day;
    }

    public TextView getWeek() {
        return week;
    }
}
