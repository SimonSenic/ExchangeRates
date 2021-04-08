package sk.kosickaacademic.simon.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import java.util.Properties;
import java.util.Set;

public class APIRequest {
    public Map getExchangeRates(Set<String> rates){
        if(rates==null || rates.size()==0) return null;
        return parseData(rates);
    }

    private String getRatesFromAPI(){
        try{
            Properties prop = new Properties();
            InputStream loader = getClass().getClassLoader().getResourceAsStream("url.properties");
            prop.load(loader);
            URL url = new URL(prop.getProperty("url") +prop.getProperty("api") +prop.getProperty("format"));
            URLConnection con = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String result="";
            while(br.readLine() != null)
                result+=br.readLine();
            br.close();
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private Map parseData(Set<String> rates){
        String data = getRatesFromAPI();
        if(data==null || data.equals("")) return null;
        try {
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(data);
            JSONObject ratesObj = (JSONObject) object.get("rates");
            Map<String, Double> map = new HashMap<>();
            for(String temp : rates){
                if(ratesObj.containsKey(temp)){
                    double value = (double) ratesObj.get(temp);
                    map.put(temp, value);
                }
            }
            return map;
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

}
