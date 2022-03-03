import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
   This frame contains a text sample and a control panel
   to change the font of the text.
*/
public class Market extends JFrame
{
   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 400;

   private JLabel label;
   private JRadioButton threehundredgramButton;
   private JRadioButton fourhundredgramButton;
   private JRadioButton fivehundredgramButton;

   private JCheckBox seasonedCheckBox;

   private JCheckBox pepperedCheckBox;

   private JCheckBox onlySaltCheckBox;

   private JCheckBox withHotSauceCheckBox;

   private JComboBox priceTagCombo;



   private JComboBox freshmeatCombo;
   private ActionListener listener;

   /**
      Constructs the frame.
   */
   public Market()
   {
      // Construct text sample
      label = new JLabel("PRICE");
      add(label, BorderLayout.CENTER);

      // This listener is shared among all components
      listener = new ChoiceListener();

      createControlPanel();
      setLabelFont();
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

   class ChoiceListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         setLabelFont();
      }
   }

   /**
      Creates the control panel to change the font.
   */
   public void createControlPanel()
   {
      JPanel freshMeatPanel = createComboBox();
      JPanel flavourGroupPanel = createCheckBoxes();
      JPanel amountGroupPanel = createRadioButtons();

      // Line up component panels

      JPanel controlPanel = new JPanel();
      controlPanel.setLayout(new GridLayout(3, 1));
      controlPanel.add(freshMeatPanel);
      controlPanel.add(flavourGroupPanel);
      controlPanel.add(amountGroupPanel);

      // Add panels to content pane

      add(controlPanel, BorderLayout.SOUTH);
   }

   /**
      Creates the combo box with the font style choices.
      @return the panel containing the combo box
   */
   public JPanel createComboBox()
   {
      freshmeatCombo = new JComboBox();
      freshmeatCombo.addItem("Chicken");
      freshmeatCombo.addItem("Steak");
      freshmeatCombo.addItem("Salmon");
      freshmeatCombo.setEditable(true);
      freshmeatCombo.addActionListener(listener);

      JPanel panel = new JPanel();
      panel.add(freshmeatCombo);
      return panel;
   }

   /**
      Creates the check boxes for selecting bold and italic styles.
      @return the panel containing the check boxes
   */
   public JPanel createCheckBoxes()
   {
      seasonedCheckBox = new JCheckBox("Seasoned");
      seasonedCheckBox.addActionListener(listener);

      pepperedCheckBox = new JCheckBox("Only Peppred");
      pepperedCheckBox.addActionListener(listener);

      onlySaltCheckBox = new JCheckBox("Only Salt");
      onlySaltCheckBox.addActionListener(listener);

      withHotSauceCheckBox = new JCheckBox("With Hot Sauce");
      withHotSauceCheckBox.addActionListener(listener);

      JPanel panel = new JPanel();
      panel.add(seasonedCheckBox);
      panel.add(pepperedCheckBox);
      panel.add(onlySaltCheckBox);
      panel.add(withHotSauceCheckBox);

      panel.setBorder(new TitledBorder(new EtchedBorder(), "Flavour"));

      return panel;
   }

   /**
      Creates the radio buttons to select the font size.
      @return the panel containing the radio buttons
   */
   public JPanel createRadioButtons()
   {
      threehundredgramButton = new JRadioButton("300 grams");
      threehundredgramButton.addActionListener(listener);

      fourhundredgramButton = new JRadioButton("400 grams");
      fourhundredgramButton.addActionListener(listener);

      fivehundredgramButton = new JRadioButton("500 grams");
      fivehundredgramButton.addActionListener(listener);
      fivehundredgramButton.setSelected(true);

      // Add radio buttons to button group

      ButtonGroup group = new ButtonGroup();
      group.add(threehundredgramButton);
      group.add(fourhundredgramButton);
      group.add(fivehundredgramButton);

      JPanel panel = new JPanel();
      panel.add(threehundredgramButton);
      panel.add(fourhundredgramButton);
      panel.add(fivehundredgramButton);
      panel.setBorder(new TitledBorder(new EtchedBorder(), "Amount Per"));

      return panel;
   }

   /**
      Gets user choice for font name, style, and size
      and sets the font of the text sample.
   */
   public void setLabelFont()
   {
      // Get font name
      // Get font name
        String facename = (String) freshmeatCombo.getSelectedItem();

        // Get font style

        int style = 0;
        if (seasonedCheckBox.isSelected())
        {
           style = style + Font.ITALIC;
        }
        if (pepperedCheckBox.isSelected())
        {
           style = style + Font.BOLD;
        }
        if (onlySaltCheckBox.isSelected())
        {
           style = style + Font.ITALIC;
        }
        if (withHotSauceCheckBox.isSelected())
        {
           style = style + Font.BOLD;
        }
        // Get font size

        int size = 0;

        final int SMALL_SIZE = 24;
        final int MEDIUM_SIZE = 36;
        final int LARGE_SIZE = 48;

        if (threehundredgramButton.isSelected()) { size = SMALL_SIZE; }
        else if (fourhundredgramButton.isSelected()) { size = MEDIUM_SIZE; }
        else if (fivehundredgramButton.isSelected()) { size = LARGE_SIZE; }

        // Set font of text field

        label.setFont(new Font(facename, style, size));
        label.repaint();
   }
 }
