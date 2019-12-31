package Control;
import Vista.MainFrame;

import java.io.IOException;



public class MoneyCalculator {
    public static void main(String[] args) throws IOException {
         MainFrame mainFrame = new MainFrame("Money Calculator");
         Controller controller = new Controller(mainFrame);
         controller.initialize();
    }
}