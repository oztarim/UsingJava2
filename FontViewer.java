import javax.swing.JFrame;

/**
   This program allows the user to view font effects.
*/
public class MarketViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new Market();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("SuperMarketPriceChecker");
      frame.setVisible(true);
   }
}
