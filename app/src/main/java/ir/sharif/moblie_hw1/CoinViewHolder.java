package ir.sharif.moblie_hw1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CoinViewHolder extends RecyclerView.ViewHolder {
    private ImageView coin_Image;
    private TextView coin_Name;
    private TextView coin_Fee;
    private TextView Hour;
    private TextView day;
    private TextView week;


    public CoinViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void setCoin_Image(ImageView coin_Image) {
        this.coin_Image = coin_Image;
    }

    public void setCoin_Fee(TextView coin_Fee) {
        this.coin_Fee = coin_Fee;
    }

    public void setHour(TextView hour) {
        Hour = hour;
    }

    public void setDay(TextView day) {
        this.day = day;
    }

    public void setWeek(TextView week) {
        this.week = week;
    }
}
