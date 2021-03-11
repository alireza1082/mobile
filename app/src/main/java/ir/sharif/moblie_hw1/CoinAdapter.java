package ir.sharif.moblie_hw1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fasterxml.jackson.databind.ObjectMapper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ir.sharif.moblie_hw1.Coin;
import ir.sharif.moblie_hw1.CoinViewHolder;
import ir.sharif.moblie_hw1.R;

public class CoinAdapter extends RecyclerView.Adapter<CoinViewHolder> {
    private Context context;
    private ArrayList<Coin> coinList;

    public CoinAdapter (ArrayList<Coin> list){
        coinList = list;
    }

    @NonNull
    @Override
    public CoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(context).inflate(R.layout.sample_coin, parent, false);
        return new CoinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder holder, int position) {
        Coin coin = coinList.get(position);
        holder.setCoinName(coin.getCoinName());
        holder.setCoinShortName(coin.getCoinShortName());
        holder.setCoinFee(coin.getCoinFee());
        holder.setCoinImage(coin.getCoinImage());
        holder.setDayPriceChange(coin.getDayPriceChange());
        holder.setHourPriceChange(coin.getHourPriceChange());
        holder.setWeekPriceChange(coin.getWeekPriceChange());
    }

    @Override
    public int getItemCount() {
        return coinList == null ? 0 : coinList.size();
    }

    public void cacheCoins() {
        ThreadPool.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    FileWriter coins = new FileWriter("coins/coins.txt");
                    for (Coin coin : coinList) {
                        objectMapper.writeValue(new File("coins/"
                                + coin.getCoinShortName().toString() + ".json"), coin);
                        coins.write(coin.getCoinShortName().toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void restoreFromCache() {
        ThreadPool.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    BufferedReader coins = new BufferedReader(new FileReader("coins/coins.txt"));
                    while (true) {
                        String name = coins.readLine();
                        if (name != null) {
                            objectMapper.readValue(new File("coins/"
                                    + name+ ".json"), Coin.class);
                        } else break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
