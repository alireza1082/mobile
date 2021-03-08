package ir.sharif.moblie_hw1;

import android.content.Context;
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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
