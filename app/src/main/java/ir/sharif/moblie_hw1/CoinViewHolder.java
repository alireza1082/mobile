package ir.sharif.moblie_hw1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CoinViewHolder extends RecyclerView.ViewHolder {
    private ImageView coinImage;
    private TextView coinName;
    private TextView coinShortName;
    private TextView coinFee;
    private TextView hourPriceChange;
    private TextView dayPriceChange;
    private TextView weekPriceChange;

    public CoinViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void setCoinImage(ImageView coinImage) {
        this.coinImage = coinImage;
    }

    public void setCoinName(String coinName) {
        this.coinName.setText(coinName);
    }

    public void setCoinShortName(String coinShortName) {
        this.coinShortName.setText(coinShortName);
    }

    public void setCoinFee(String coinFee) {
        this.coinFee.setText(coinFee);
    }

    public void setHourPriceChange(String hourPriceChange) {
        this.hourPriceChange.setText(hourPriceChange);
    }

    public void setDayPriceChange(String dayPriceChange) {
        this.dayPriceChange.setText(dayPriceChange);
    }

    public void setWeekPriceChange(String weekPriceChange) {
        this.weekPriceChange.setText(weekPriceChange);
    }
}
