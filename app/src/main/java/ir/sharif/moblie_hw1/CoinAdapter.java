package ir.sharif.moblie_hw1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CoinAdapter extends RecyclerView.Adapter<CoinViewHolder> {
    private Context context;
    private ArrayList<Coin> coinList;

    public CoinAdapter() {
        this.coinList = new ArrayList<Coin>();
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
        ThreadPool.getThreadPool().execute(() -> {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                BufferedReader coins = new BufferedReader(new FileReader("coins/coins.txt"));
                while (true) {
                    String name = coins.readLine();
                    if (name != null) {
                        objectMapper.readValue(new File("coins/"
                                + name + ".json"), Coin.class);
                    } else break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public boolean isFirstUse() {
        File coins = new File("coins/coins.txt");
        return coins.length() == 0;
    }

    public void updateCoins(Boolean networkAvailable) {
        if (networkAvailable) {
            updateFromApi(10);
        } else {
            restoreFromCache();
        }
    }

    private void updateFromApi(int limit) {
        ThreadPool.getThreadPool().execute(() -> {
            ApiRequest.getApiRequest().getCoins(limit);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode node = objectMapper.readValue(new File("api_response.json"), JsonNode.class);
                JsonNode data = node.get("data");
                for (int i = 0; i < limit; i++) {
                    JsonNode coin = data.get(i);
                    String name = coin.get("name").asText();
                    String shortName = coin.get("symbol").asText();
                    JsonNode usdDetail = coin.get("quote").get("USD");
                    String fee = usdDetail.get("price").asText();
                    String hourPriceChange = usdDetail.get("percent_change_1h").asText();
                    String dayPriceChange = usdDetail.get("percent_change_24h").asText();
                    String weekPriceChange = usdDetail.get("percent_change_7d").asText();
                    coinList.add(new Coin(null, name, shortName, fee, hourPriceChange, dayPriceChange, weekPriceChange));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
