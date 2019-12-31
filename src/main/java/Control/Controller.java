package Control;

import Persistencia.ExchangeRatesPool;
import Persistencia.FileCurrencySetLoader;
import Vista.MainFrame;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Controller {
     private Map<String, Command> commands = new HashMap<String, Command>();
     private MainFrame frame;
     private ExchangeRatesPool rateGetter;

     public Controller(MainFrame mainFrame) {
         this.frame = mainFrame;
     }


    public void initialize() {
         rateGetter = new ExchangeRatesPool();
         frame.setCurrencySet(new FileCurrencySetLoader().loadCurrencies());
         frame.initialize();
         JButton button = (JButton)frame.getMyComponents().get("Button");
         commands.put("calculate", new CalculateCommand(frame,rateGetter));
         button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent actionEvent) {
                 commands.get("calculate").execute();
             }
         });
    }

    private void handleClick() {
        JTextField textField = (JTextField) frame.getMyComponents().get("Input");


    }
}