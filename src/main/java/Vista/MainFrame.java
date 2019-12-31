package Vista;

import Modelo.Currency;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class MainFrame extends JFrame {
    private Map<String,JComponent> components = new LinkedHashMap<String, JComponent>();
    private List<Currency> currencies;
    
    public MainFrame (String arg) {
        super(arg);
    }

    public void initialize () {
        components.put("From" , new JLabel("From: "));
        components.put("SelectorFrom", new JComboBox<Currency>());
        components.put("Amount", new JLabel("Amount"));
        components.put("Input", new JTextField());
        components.put("To", new JLabel("To: "));
        components.put("SelectorTo", new JComboBox<Currency>());
        components.put("Button", new JButton("Calculate"));
        components.put("ResultLabel", new JLabel("Result: "));
        components.put("Result", new JTextArea());
        components.get("Result").setPreferredSize(new Dimension(100, 20));
        JTextArea textArea = (JTextArea)components.get("Result");
        textArea.setEditable(false);
        components.get("Input").setPreferredSize(new Dimension(100, 20));

        JComboBox<Currency> from = (JComboBox<Currency>) components.get("SelectorFrom");
        for (Currency curr : currencies) {
            from.addItem(curr );
        }

        JComboBox<Currency> to = (JComboBox<Currency>) components.get("SelectorTo");
        for (Currency curr: currencies
             ) {
            to.addItem(curr);
        }


        JPanel panelTop = new JPanel();
        JPanel panelMid = new JPanel();
        JPanel panelBot = new JPanel();
        
        panelTop.add(components.get("From"));
        panelTop.add(components.get("SelectorFrom"));
        panelTop.add(components.get("Amount"));
        panelTop.add(components.get("Input"));
        panelTop.add(components.get("To"));
        panelTop.add(components.get("SelectorTo"));
        panelTop.setLayout(new FlowLayout());
        
        panelMid.add(components.get("ResultLabel"));
        panelMid.add(components.get("Result"));
        panelMid.setLayout(new FlowLayout());
        
        panelBot.add(components.get("Button"));
        panelBot.setLayout(new FlowLayout());

        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelMid, BorderLayout.CENTER);
        this.add(panelBot, BorderLayout.SOUTH);
        
        
        setSize(700, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void setCurrencySet (List<Currency> loadCurrencies) {
        this.currencies = loadCurrencies;
    }

    public Map<String, JComponent> getMyComponents() {
        return components;
    }
}