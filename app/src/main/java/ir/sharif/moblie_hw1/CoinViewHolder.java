package ir.sharif.moblie_hw1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CoinViewHolder extends RecyclerView.ViewHolder {
    private ImageView coinImage;
    private String coinName;
    private String coinShortName;
    private String coinFee;
    private String hourPriceChange;
    private String dayPriceChange;
    private String weekPriceChange;

    public CoinViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void setCoinImage(ImageView coinImage) {
        this.coinImage = coinImage;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public void setCoinShortName(String coinShortName) {
        this.coinShortName = coinShortName;
    }

    public void setCoinFee(String coinFee) {
        this.coinFee = coinFee;
    }

    public void setHourPriceChange(String hourPriceChange) {
        this.hourPriceChange = hourPriceChange;
    }

    public void setDayPriceChange(String dayPriceChange) {
        this.dayPriceChange = dayPriceChange;
    }

    public void setWeekPriceChange(String weekPriceChange) {
        this.weekPriceChange = weekPriceChange;
    }
}
