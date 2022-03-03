import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/** author Ozgur Tarim- 217437054

 */
public class Market extends JFrame
{
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 400;

	private JTextArea text;
	private JRadioButton threehundredgramButton;
	private JRadioButton fourhundredgramButton;
	private JRadioButton fivehundredgramButton;
	private JCheckBox seasonedCheckBox;
	private JCheckBox pepperedCheckBox;
	private JCheckBox onlySaltCheckBox;
	private JCheckBox withHotSauceCheckBox;
	private JComboBox<String> freshmeatCombo;
	private ActionListener listener;

	/**

	 */
	public Market()
	{
		// Construct text sample
		text = new JTextArea(" ");
		add(text, BorderLayout.SOUTH);
		text.setEditable(false);

		// This listener is shared among all components
		listener = new ChoiceListener();

		//Construct the menu at north
		JMenuBar menu = new JMenuBar();
		JMenu options = new JMenu("Options");
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(listener);
		options.add(exit);
		menu.add(options);
		add(menu,BorderLayout.NORTH);


		createControlPanel();
		setLabelPrice();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	class ChoiceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String action = event.getActionCommand();
			if(action.equals("Done")) {
				setLabelPrice();
			}
			else {
				System.exit(0);
			}
		}
	}

	/**

	 */
	public void createControlPanel()
	{
		JPanel freshMeatPanel = createComboBox();
		JPanel flavourGroupPanel = createCheckBoxes();
		JPanel amountGroupPanel = createRadioButtons();

		JButton done = new JButton("Done");
		done.addActionListener(listener);

		// Line up component panels

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(4, 1));
		controlPanel.add(freshMeatPanel);
		controlPanel.add(flavourGroupPanel);
		controlPanel.add(amountGroupPanel);
		controlPanel.add(done);


		// Add panels to content pane

		add(controlPanel, BorderLayout.CENTER);


	}

	/**

      @return the panel containing the combo box
	 */
	public JPanel createComboBox()
	{
		freshmeatCombo = new JComboBox<String>();
		freshmeatCombo.addItem("Chicken");
		freshmeatCombo.addItem("Steak");
		freshmeatCombo.addItem("Salmon");
		freshmeatCombo.setEditable(true);

		JPanel panel = new JPanel();
		panel.add(freshmeatCombo);
		return panel;
	}

	/**

      @return the panel containing the check boxes
	 */
	public JPanel createCheckBoxes()
	{
		seasonedCheckBox = new JCheckBox("Seasoned");
		pepperedCheckBox = new JCheckBox("Only Peppered");
		onlySaltCheckBox = new JCheckBox("Only Salt");
		withHotSauceCheckBox = new JCheckBox("With Hot Sauce");
		//withHotSauceCheckBox.setSelected(true);

		JPanel panel = new JPanel();
		panel.add(seasonedCheckBox);
		panel.add(pepperedCheckBox);
		panel.add(onlySaltCheckBox);
		panel.add(withHotSauceCheckBox);

		panel.setBorder(new TitledBorder(new EtchedBorder(), "Flavour"));

		return panel;
	}

	/**
      Creates the radio buttons
      @return the panel containing the radio buttons
	 */
	public JPanel createRadioButtons()
	{

    //grams for meat selection

		threehundredgramButton = new JRadioButton("300 grams");

		fourhundredgramButton = new JRadioButton("400 grams");

		fivehundredgramButton = new JRadioButton("500 grams");

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
      Gets user choice for price, style, and size
      and sets the price of the text sample.
	 */
	public void setLabelPrice()
	{
		String details = "Order for ";
		String facename = (String) freshmeatCombo.getSelectedItem();
		details += facename + ":\n";
		details += "-- Flavours: ";
		int price = 0;
		//Check for flavours
		if (seasonedCheckBox.isSelected()) {
			details += "Seasoned - ";
			price += 5;
		}
		if (pepperedCheckBox.isSelected()) {
			details += "Peppered - ";
			price += 7;
		}
		if (onlySaltCheckBox.isSelected()) {
			details += "Only Salt - ";
			price += 2;
		}
		if (withHotSauceCheckBox.isSelected()) {
			details += "Hot Sauce - ";
			price += 6;
		}
		details += "\n";
		details += "-- Weight: ";

		//Check for grams
		if (threehundredgramButton.isSelected()) {
			details += "300 grams\n";
			price += 6;
		}
		else if (fourhundredgramButton.isSelected()) {
			details += "400 grams\n";
			price += 9;
		}
		else if (fivehundredgramButton.isSelected()) {
			details += "500 grs\n";
			price += 14;
		}
		else {
			return;
		}

		//Check for meat kind
		if (facename.equals("Chicken")) {
			price += 7;
		}
		else if(facename.equals("Steak")) {
			price += 15;
		}
		else {
			price += 17;
		}


		text.setText(details+"-- PRICE: $"+price);
		text.repaint();
	}
}
