package ir.sharif.moblie_hw1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Coin> coinList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        CoinAdapter coinAdapter = new CoinAdapter(coinList);
        recyclerView.setAdapter(coinAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (!isNetworkAvailable() && coinAdapter.isFirstUse()) {
            Toast.makeText(MainActivity.this, "Please connect to internet", Toast.LENGTH_SHORT).show();
        } else {
            coinAdapter.updateCoins(isNetworkAvailable());
        }
    }

    public Boolean isNetworkAvailable() {
        try {
            ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = null;
            if (manager != null) {
                networkInfo = manager.getActiveNetworkInfo();
            }
            return networkInfo != null && networkInfo.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}