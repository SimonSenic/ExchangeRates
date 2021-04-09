package sk.kosickaacademic.simon;

import sk.kosickaacademic.simon.api.APIRequest;

import java.util.HashSet;
import java.util.Map;
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
        Map<String, Double> map = new APIRequest().getExchangeRates(set);
        for(Map.Entry<String, Double> tmp : map.entrySet()){
            System.out.println(tmp.getKey() +" " +tmp.getValue());
        }
    }
}
