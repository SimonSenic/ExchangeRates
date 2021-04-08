package sk.kosickaacademic.simon;

import sk.kosickaacademic.simon.api.APIRequest;

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
        //new APIRequest().getExchangeRates(set);
    }
}
