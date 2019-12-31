package Control;

import Modelo.Currency;
import Modelo.ExchangeRate;
import Persistencia.ExchangeRatesPool;
import Vista.MainFrame;

import javax.swing.*;

public class CalculateCommand implements Command {
    private final MainFrame frame;
    private final ExchangeRatesPool exangeRatesPool;

    public CalculateCommand (MainFrame frame, ExchangeRatesPool exangeRatesPool) {
        this.frame = frame;
        this.exangeRatesPool = exangeRatesPool;
    }
    
    @Override
    public void execute () {
        JComboBox<String> selectFrom = (JComboBox<String>) frame.getMyComponents().get("SelectorFrom");
        JComboBox<String> selectTo = (JComboBox<String>) frame.getMyComponents().get("SelectorTo");
        ExchangeRate rate = exangeRatesPool.get((Currency)selectFrom.getSelectedItem(),(Currency)selectTo.getSelectedItem());
        double amount = Double.parseDouble(((JTextField)frame.getMyComponents().get("Input")).getText());
        ((JTextArea)frame.getMyComponents().get("Result")).setText(""+ rate.getRate() * amount);
    }
}