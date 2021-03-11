package ir.sharif.moblie_hw1;

import android.annotation.SuppressLint;
import android.util.Log;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.*;

public class ApiRequest {
    private static final ApiRequest apiRequest = new ApiRequest();
    private final OkHttpClient okHttpClient = new OkHttpClient();
    private final String candleApiKey = "613FAD50-662F-4835-AEF4-220DD67904AA";
    private final String cmcApiKey = "8dc04df1-b8e8-4ec4-9c62-76b0a2cb9ed2";

    public static ApiRequest getApiRequest() {
        return apiRequest;
    }

    public enum Range {
        weekly,
        oneMonth,
    }

    public void getCandles(String symbol, Range range) {
        String miniUrl;
        final String description;
        switch (range) {

            case weekly:
                miniUrl = "period_id=1DAY".concat("&time_end=".concat(getCurrentDate()).concat("&limit=7"));
                description = "Daily candles from now";
                break;

            case oneMonth:
                miniUrl = "period_id=1DAY".concat("&time_end=".concat(getCurrentDate()).concat("&limit=30"));
                description = "Daily candles from now";
                break;

            default:
                miniUrl = "";
                description = "";

        }

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://rest.coinapi.io/v1/ohlcv/".concat(symbol).concat("/USD/history?".concat(miniUrl)))
                .newBuilder();

        String url = urlBuilder.build().toString();

        final Request request = new Request.Builder().url(url)
                .addHeader("X-CoinAPI-Key", candleApiKey)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.v("TAG", e.getMessage());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    //System.out.println(response.body().string());
                }
            }
        });
    }

    public void getCoins(int limit) {
        String url = HttpUrl.parse("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest"
                .concat("?start=1").concat("&limit=").concat(Integer.toString(limit)).concat("&convert=USD"))
                .newBuilder().build().toString();

        final Request request = new Request.Builder().url(url)
                .addHeader("X-CMC_PRO_API_KEY", cmcApiKey)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    FileWriter data = new FileWriter("api_response.json");
                    data.write(response.body().string());
                }
            }
        });
    }

    private String getCurrentDate() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}

