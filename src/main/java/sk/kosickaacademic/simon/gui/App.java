package sk.kosickaacademic.simon.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sk.kosickaacademic.simon.Conversion;

import java.util.HashSet;
import java.util.Set;

public class App extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("src/main/java/sk/kosickaacademic/simon/gui/sample.fxml"));
        primaryStage.setTitle("Exchange Rates");
        primaryStage.setScene(new Scene(root, 400, 420));
        primaryStage.show();
    }

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
        launch(args);
    }
}
