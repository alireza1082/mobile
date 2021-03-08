package ir.sharif.moblie_hw1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CoinAdapter extends RecyclerView.Adapter<CoinViewHolder> {
    private Context context;
    private ArrayList<Coin> coinList;

    @NonNull
    @Override
    public CoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
            LayoutInflater.from(context).inflate(R.layout.sample_coin , parent , false);
        return new CoinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder holder, int position) {
        Coin coin = coinList.get(position);
        holder.setCoin_Name(coin.getCoin_Name());
        holder.setCoin_Fee(coin.getCoin_Fee());
        holder.setCoin_Image(coin.getCoin_Image());
        holder.setDay(coin.getDay());
        holder.setHour(coin.getHour());
        holder.setWeek(coin.getWeek());
    }

    @Override
    public int getItemCount() {
        return coinList == null ? 0 : coinList.size();
    }
}
