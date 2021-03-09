package ir.sharif.moblie_hw1;

import android.widget.ImageView;
import android.widget.TextView;


public class Coin {
    private ImageView coinImage;
    private TextView coinName;
    private TextView coinShortName;
    private TextView coinFee;
    private TextView hourPriceChange;
    private TextView dayPriceChange;
    private TextView weekPriceChange;

    public Coin(ImageView coinImage, TextView coinName, TextView coinShortName, TextView coinFee,
                TextView hourPriceChange, TextView dayPriceChange, TextView weekPriceChange) {
        this.coinImage = coinImage;
        this.coinName = coinName;
        this.coinShortName = coinShortName;
        this.coinFee = coinFee;
        this.hourPriceChange = hourPriceChange;
        this.dayPriceChange = dayPriceChange;
        this.weekPriceChange = weekPriceChange;
    }

    public ImageView getCoinImage() {
        return coinImage;
    }

    public TextView getCoinName() {
        return coinName;
    }

    public TextView getCoinShortName() {
        return coinShortName;
    }

    public TextView getCoinFee() {
        return coinFee;
    }

    public TextView getHourPriceChange() {
        return hourPriceChange;
    }

    public TextView getDayPriceChange() {
        return dayPriceChange;
    }

    public TextView getWeekPriceChange() {
        return weekPriceChange;
    }
}
