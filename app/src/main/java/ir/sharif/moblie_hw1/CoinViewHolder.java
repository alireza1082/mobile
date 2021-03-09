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

    public void setCoinName(TextView coinName) {
        this.coinName = coinName;
    }

    public void setCoinShortName(TextView coinShortName) {
        this.coinShortName = coinShortName;
    }

    public void setCoinFee(TextView coinFee) {
        this.coinFee = coinFee;
    }

    public void setHourPriceChange(TextView hourPriceChange) {
        this.hourPriceChange = hourPriceChange;
    }

    public void setDayPriceChange(TextView dayPriceChange) {
        this.dayPriceChange = dayPriceChange;
    }

    public void setWeekPriceChange(TextView weekPriceChange) {
        this.weekPriceChange = weekPriceChange;
    }
}
