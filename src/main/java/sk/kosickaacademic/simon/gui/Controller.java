package sk.kosickaacademic.simon.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import sk.kosickaacademic.simon.Conversion;

public class Controller {
    public MenuButton menu_to;
    public MenuItem item_usd, item_btc, item_cad, item_bnd, item_pln;
    public TextField txt_value, txt_result;
    public Label lab_error;
    public Button btn_convert;

    public void item_usd_select(ActionEvent actionEvent){
        menu_to.setText("USD");
    }

    public void item_btc_select(ActionEvent actionEvent){
        menu_to.setText("BTC");
    }

    public void item_cad_select(ActionEvent actionEvent){
        menu_to.setText("CAD");
    }

    public void item_bnd_select(ActionEvent actionEvent){
        menu_to.setText("BND");
    }

    public void item_pln_select(ActionEvent actionEvent){
        menu_to.setText("PLN");
    }

    public void btn_convert_click(ActionEvent actionEvent){
        try {
            int value = Integer.parseInt(txt_value.getText());
            if(value<=0){
                txt_result.clear();
                lab_error.setVisible(true);
            }else{
                lab_error.setVisible(false);
                txt_result.setText(String.valueOf(new Conversion().convertData(value, menu_to.getText())));
            }
        }catch (NumberFormatException e){
            txt_result.clear();
            lab_error.setVisible(true);
        }
    }

}
