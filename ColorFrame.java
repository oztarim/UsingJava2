import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ColorFrame extends JFrame
{
   private static final int FRAME_WIDTH = 1000;
   private static final int FRAME_HEIGHT = 1400;

   private JPanel colorPanel;
   private JSlider redSlider;
   private JSlider greenSlider;
   private JSlider blueSlider;
   private JRadioButton radioButtonPanel;

   private JRadioButton smallButton;
   private JRadioButton mediumButton;
   private JRadioButton largeButton;

   private JRadioButton pepperoniButton;

   private JRadioButton anchoviesButton;

   private JPanel priceTextField;

   private JPanel pricePanel;


   public ColorFrame()
   {
      colorPanel = new JPanel();

      radioButtonPanel = new JPanel();
      add(radioButtonPanel, BorderLayout.CENTER);

    //  add(colorPanel, BorderLayout.CENTER);
      createControlPanel();

      setSampleColor();
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

   class ColorListener implements ChangeListener
   {
      public void stateChanged(ChangeEvent event)
      {
         setSampleColor();
      }
   }

   public void createControlPanel()
   {
      ChangeListener listener = new ColorListener();


      //smallButton = new JPanel();
    //  smallButton.addChangeListener(listener);

      //mediumButton = new Jpanel();
      //mediumButton.addChangeListener(listener);

      //largeButton = new Jpanel();
      //largeButton.addChangeListener(listener);



      JPanel radioButtonPanel = new JPanel();
      radioButtonPanel.setLayout(new GridLayout(6, 3));
      //radioButton.setBorder(new TitledBorder(new EtchedBorder(), "Size"));

      JPanel controlPanel = new JPanel();
      controlPanel.setLayout(new GridLayout(3, 2));

      controlPanel.add(new JLabel("smallButton"));
      controlPanel.add(smallButton);

      controlPanel.add(new JLabel("mediumButton"));
      controlPanel.add(mediumButton);

      controlPanel.add(new JLabel("largeButton"));
      controlPanel.add(largeButton);

      controlPanel.add(new JLabel("pepperoniButton"));
      controlPanel.add(pepperoniButton);

      controlPanel.add(new JLabel("anchoviesButton"));
      controlPanel.add(anchoviesButton);

      //JPanel radioButtonPanel = new JPanel();
      radioButtonPanel.setLayout(new GridLayout(3, 1));
      //radioButton.setBorder(
    //  new TitledBorder(new EtchedBorder(), "Size"));
      radioButtonPanel.add(smallButton);
      radioButtonPanel.add(mediumButton);
      radioButtonPanel.add(largeButton);
      JPanel checkBoxPanel = new JPanel();
      checkBoxPanel.setLayout(new GridLayout(2, 1));
      checkBoxPanel.add(pepperoniButton);
      checkBoxPanel.add(anchoviesButton);


      JPanel pricePanel = new JPanel(); // Uses FlowLayout
      pricePanel.add(new JLabel("Your Price:"));
      pricePanel.add(priceTextField);
      JPanel centerPanel = new JPanel(); // Uses FlowLayout


      centerPanel.add(radioButtonPanel);
      centerPanel.add(checkBoxPanel);
// Frame uses BorderLayout by default
      add(centerPanel, BorderLayout.CENTER);
      add(pricePanel, BorderLayout.SOUTH);




      //add(controlPanel, BorderLayout.NORTH);

      add(radioButtonPanel, BorderLayout.NORTH);

      //add(radioButton, BorderLayout.EAST);
   }

   /**
      Reads the slider values and sets the panel to
      the selected color.
   */
   public void setSampleColor()
   {
      // Read slider values

      int red = redSlider.getValue();
      int green = greenSlider.getValue();
      int blue = blueSlider.getValue();

      // Set panel background to selected color

      //colorPanel.setBackground(new Color(red, green, blue));
      //colorPanel.repaint();

      radioButtonPanel.setBackground(new Color(red, green, blue));
      radioButtonPanel.repaint();

   }
}
