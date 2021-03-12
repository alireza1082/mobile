package ir.sharif.moblie_hw1;

import android.widget.ImageView;
import android.widget.TextView;


public class Coin {
    private ImageView coinImage;
    private String coinName;
    private String coinShortName;
    private String coinFee;
    private String hourPriceChange;
    private String dayPriceChange;
    private String weekPriceChange;

    public Coin(ImageView coinImage, String coinName, String coinShortName, String coinFee,
                String hourPriceChange, String dayPriceChange, String weekPriceChange) {
        this.coinImage = coinImage;
        this.coinName = coinName;
        this.coinShortName = coinShortName;
        this.coinFee = coinFee;
        this.hourPriceChange = hourPriceChange;
        this.dayPriceChange = dayPriceChange;
        this.weekPriceChange = weekPriceChange;
    }

    public Coin(ImageView coinImage, String coinName, String coinFee) {
        this.coinImage = coinImage;
        this.coinName = coinName;
        this.coinFee = coinFee;
/*      this.coinShortName = coinShortName;
        this.hourPriceChange = hourPriceChange;
        this.dayPriceChange = dayPriceChange;
        this.weekPriceChange = weekPriceChange;*/
    }

    public ImageView getCoinImage() {
        return coinImage;
    }

    public String getCoinName() {
        return coinName;
    }

    public String getCoinShortName() {
        return coinShortName;
    }

    public String getCoinFee() {
        return coinFee;
    }

    public String getHourPriceChange() {
        return hourPriceChange;
    }

    public String getDayPriceChange() {
        return dayPriceChange;
    }

    public String getWeekPriceChange() {
        return weekPriceChange;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "coinName=" + coinName +
                ", coinFee=" + coinFee +
                '}';
    }
}
