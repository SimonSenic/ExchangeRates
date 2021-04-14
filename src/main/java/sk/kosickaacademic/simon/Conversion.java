package sk.kosickaacademic.simon;

import sk.kosickaacademic.simon.api.APIRequest;
import sk.kosickaacademic.simon.database.DatabaseMongo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Conversion {
    public double convertData(double eur, String currency){
        if(eur<=0){
            System.out.println("Error: Invalid input.");
            return 0;
        }

        Set<String> set = new HashSet<>();
        set.add("USD");
        set.add("BTC");
        set.add("CAD");
        set.add("BND");
        set.add("PLN");
        Map map = new APIRequest().getExchangeRates(set);
        Map<String, Double> record = new HashMap();

        double output = 0;
        for(String temp : set){
            if(map.containsKey(temp)){
                double result = eur * (double) map.get(temp);
                System.out.println("EUR: " +eur +" -> " +temp +": " +result);
                record.put(temp, result);
            }
            if(temp.equals(currency)) output = eur * (double) map.get(temp);
        }
        new DatabaseMongo().insertNewData(eur, record);
        System.out.println();
        return output;
    }
}
