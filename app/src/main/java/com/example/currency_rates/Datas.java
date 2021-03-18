package com.example.currency_rates;

import java.util.Map;

public class Datas {
   String Date; //": "2021-03-18T11:30:00+03:00",
   String PreviousDate;//": "2021-03-17T11:30:00+03:00",
   String PreviousURL;//": "\/\/www.cbr-xml-daily.ru\/archive\/2021\/03\/17\/daily_json.js",
   String Timestamp;//": "2021-03-17T23:00:00+03:00",

   Map<String, Curr> Valute;


   @Override
   public String toString() {
      return "Datas{" +
              "Date='" + Date + '\'' +
              ", PreviousDate='" + PreviousDate + '\'' +
              ", PreviousURL='" + PreviousURL + '\'' +
              ", Timestamp='" + Timestamp + '\'' +
              '}';
   }

}
