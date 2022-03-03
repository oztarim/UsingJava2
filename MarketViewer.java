import javax.swing.JFrame;

/**
   This program allows the user to view Market Meat prices with flavours.
*/
public class MarketViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new Market();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("MarketPriceChecker");
      frame.setVisible(true);
   }
}
