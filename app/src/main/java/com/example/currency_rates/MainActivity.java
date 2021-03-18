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

   public final String ADRESS = "https://www.cbr-xml-daily.ru/daily_json.js";
   private Thread thread;
   private Runnable run;
   private String json;
   private Gson gson = new Gson();
   private Datas datas = null;

   public String getJson() throws IOException {
      URL url = new URL(ADRESS);
      HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

      InputStream is = httpCon.getInputStream();
      Scanner scanner = new Scanner(is);
      StringBuilder sb = new StringBuilder();
      while (scanner.hasNext())
         sb.append(scanner.next());

      scanner.close();
      return sb.toString();
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      init();
//      downFrom();
      parse();
   }


   private void downFrom() {
      try {
         json = getJson();
      } catch (IOException e) {
         e.printStackTrace();
      }
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

   private void parse() {
      try {
         datas = gson.fromJson(getJson(), Datas.class);
      } catch (IOException e) {
         e.printStackTrace();
      }
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