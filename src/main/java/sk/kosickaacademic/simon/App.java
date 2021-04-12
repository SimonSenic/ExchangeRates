package sk.kosickaacademic.simon;

import java.util.HashSet;
import java.util.Set;

public class App
{
    public static void main( String[] args )
    {
        Set<String> set = new HashSet<>();
        set.add("USD");
        set.add("CZK");
        set.add("BTC");
        set.add("BND");
        set.add("CAD");
        set.add("PLN");
        //System.out.println(new APIRequest().getRatesFromAPI());
        /*Map<String, Double> map = new APIRequest().getExchangeRates(set);
        for(Map.Entry<String, Double> temp : map.entrySet()){
            System.out.println(temp.getKey() +" " +temp.getValue());
        }*/

        new Conversion().convertData(20);
    }
}
