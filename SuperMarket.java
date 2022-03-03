import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SuperMarket extends JFrame
{
//Constructs the frame
  private static final int FRAME_WIDTH = 300;
  private static final int FRAME_HEIGHT = 400;

  private JPanel radioButtonPanel;
  private JPanel radioButton;
  private JPanel checkBoxPanel;
  private JPanel pricePanel;

   public SuperMarket()
   {
     colorPanel = new JPanel();

     add(colorPanel, BorderLayout.CENTER);
     createControlPanel();
     setSize(FRAME_WIDTH, FRAME_HEIGHT);



     JPanel radioButtonPanel = new JPanel();
     radioButtonPanel.setLayout(new GridLayout(3, 1));
     radioButton.setBorder(new TitledBorder(new EtchedBorder(), "Size"));
     radioButtonPanel.add(smallButton);
     radioButtonPanel.add(mediumButton);
     radioButtonPanel.add(largeButton);
     JPanel checkBoxPanel = new JPanel();
     checkBoxPanel.setLayout(new GridLayout(2, 1));
     checkBoxPanel.add(pepperoniButton());
     checkBoxPanel.add(anchoviesButton());
     JPanel pricePanel = new JPanel(); // Uses FlowLayout
     pricePanel.add(new JLabel("Your Price:"));
     pricePanel.add(priceTextField);
     JPanel centerPanel = new JPanel(); // Uses FlowLayout
     centerPanel.add(radioButtonPanel);
     centerPanel.add(checkBoxPanel);
// Frame uses BorderLayout by default
     add(centerPanel, BorderLayout.CENTER);
     add(pricePanel, BorderLayout.SOUTH);

}
