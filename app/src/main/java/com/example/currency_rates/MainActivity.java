package com.example.currency_rates;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

   public final String ADDRESS = "https://www.cbr-xml-daily.ru/daily_json.js";
   private Thread thread;
   private Runnable run;
   private String json;
   private Gson gson = new Gson();
   private Datas datas = null;

   public String getJson() throws IOException {
      URL url = null;
      HttpURLConnection conn = null;
      InputStream is = null;
      Scanner scanner = null;
      StringBuilder sb = new StringBuilder();

      try {
         url = new URL(ADDRESS);
         conn = (HttpURLConnection) url.openConnection();
         conn.setReadTimeout(10000 /* milliseconds */);
         conn.setConnectTimeout(15000 /* milliseconds */);
         conn.setRequestMethod("GET");
         conn.setDoInput(true);
         // Starts the query
         conn.connect();
         int response = conn.getResponseCode();
//         Log.d(DEBUG_TAG, "The response is: " + response);
         is = conn.getInputStream();

         scanner = new Scanner(is);
         while (scanner.hasNext())
            sb.append(scanner.next());

         return sb.toString();
      } finally {
         if (is != null)
            is.close();
         if (scanner != null)
            scanner.close();
      }
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      init();
//      downFrom();
      try {
         parse();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }


   private void downFrom() throws IOException {
      json = getJson();
   }

   private void init() {

      run = new Runnable() {
         @Override
         public void run() {
            try {
               json = getJson();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      };
      thread = new Thread(run);
      thread.start();
   }

   private void parse() throws IOException {
      datas = gson.fromJson(getJson(), Datas.class);
      System.out.println(datas);

      if (datas.Valute.isEmpty())
         System.out.println("ZZZZZZZZZZZ");
      else {
         System.out.println(datas.Valute.size());
         Collection<Curr> list = datas.Valute.values();
         for (Curr cur : list)
            System.out.println(cur.getCharCode());
      }


   }
}