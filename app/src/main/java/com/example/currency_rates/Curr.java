package com.example.currency_rates;

public class Curr {
   String ID;
   String NumCode; //: "036",
   String CharCode; //: "AUD",
   String Nominal;  //: 1,
   String Name; //: "Австралийский доллар",
   String Value; //: 56.5078,
   String Previous; //: 56.3631

   public String getID() {
      return ID;
   }

   public void setID(String ID) {
      this.ID = ID;
   }

   public String getNumCode() {
      return NumCode;
   }

   public void setNumCode(String numCode) {
      NumCode = numCode;
   }

   public String getCharCode() {
      return CharCode;
   }

   public void setCharCode(String charCode) {
      CharCode = charCode;
   }

   public String getNominal() {
      return Nominal;
   }

   public void setNominal(String nominal) {
      Nominal = nominal;
   }

   public String getName() {
      return Name;
   }

   public void setName(String name) {
      Name = name;
   }

   public String getValue() {
      return Value;
   }

   public void setValue(String value) {
      Value = value;
   }

   public String getPrevious() {
      return Previous;
   }

   public void setPrevious(String previous) {
      Previous = previous;
   }

   @Override
   public String toString() {
      return "Curr{" +
              "CharCode='" + CharCode + '\'' +
              '}';
   }

}
