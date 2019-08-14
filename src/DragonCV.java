import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.io.*;
/**
 * Controller and view combined class that adds all the JButtons, JPanels, and JLabel needed for
 * the restricted dragons 20 questions game. Calls the appropriate methods depending on the buttons the
 * user clicks as they play the game: yes, no, and new game/restart
 * 
 * @author Sneha Kanaujia
 *
 */
public class DragonCV extends JPanel implements ActionListener {

	//Yes and No and restart/"New Game" JButtons
	protected JButton yes;
	protected JButton no;
	protected JButton restart;

	//A class-wide instance of the model
	protected DragonModel model = new DragonModel();

	//A panel that will govern the south of the general BorderLayout to hold all the QorA JLabel and later, the JTextField
	protected JPanel southPanel = new JPanel(new BorderLayout());
	//JLabel that will ask all the questions and offer all the answers throughout the game and be updated as the game progresses
	protected JLabel QorA = new JLabel(model.getCurrentNode().getData());
	//Creates a JLabel displaying the (leaf nodes/dragons) options the user can choose from to play the game (<html> notation makes it wrap text)
	protected JLabel options = new JLabel("");
	
	//A panel that will govern the north of the general BorderLayout to display node data and the JTextField in the unrestricted version
	protected JPanel northPanel = new JPanel(new BorderLayout());

	/**
	 * Constructor sets up all the JButtons, JPanels, JLabels and their placement, adjustments and actionListeners
	 */
	public DragonCV()
	{
		// Set the layout to be border-style
		super(new BorderLayout());

		//Centers the JLabel in the window
		QorA.setHorizontalAlignment(SwingConstants.CENTER);
		//Sets the font and text size of the question/answers QorA JLabel
		QorA.setFont(new Font("Apple Chancery", Font.BOLD, 26));
		//Adds the question/answer JLabel to the south of the BorderLayout of the southPanel
		southPanel.add(QorA, BorderLayout.NORTH);
		southPanel.setBackground(Color.cyan);
		//Adds the southPanel to the south of the main BorderLayout
		add(southPanel, BorderLayout.SOUTH);

		//Creates a JLabel displaying the (leaf nodes/dragons) options the user can choose from to play the game (<html> notation makes it wrap text)
		options.setText("<html>Choose a dragon: "+ model.getDragons(model.getTree().root) +"<html>");
		//Centers the JLabel in the window
		options.setHorizontalAlignment(SwingConstants.CENTER);
		//Sets the font and text size of the dragon options JLabel
		options.setFont(new Font("Apple Chancery", Font.PLAIN, 20));
		//Adds the options JLabel to the center of the BorderLayout of the northPanel
		northPanel.add(options, BorderLayout.CENTER);


		//Creates a JButton that says Yes
		yes = new JButton("Yes");
		//Adds actionlistener to the button
		yes.addActionListener(this);
		//Adds the yes JButton to the west of the BorderLayout
		add(yes, BorderLayout.WEST);

		//Creates an ImageIcon object with the specified picture
		ImageIcon image = new ImageIcon("GoldDragon.jpg");
		//Puts the ImageIcon object into a JLabel
		JLabel dragonPic = new JLabel(image);
		//Creates a new JPanel
		JPanel picPanel = new JPanel();
		//Adds the JLabel with the ImageIcon to the JPanel
		picPanel.add(dragonPic);
		//Adds the JPanel to the center of the BorderLayout
		add(picPanel, BorderLayout.CENTER);

		//Creates a JButton that says No
		no = new JButton("No");
		//Adds actionlistener to the button
		no.addActionListener(this);
		//Adds the no JButton to the east of the BorderLayout
		add(no, BorderLayout.EAST);

		//Creates a JButton that says New Game
		restart = new JButton("New Game");
		//Adds actionlistener to the button
		restart.addActionListener(this);
		//Adds the restart/"New Game" JButton to the south of the BorderLayout of the northPanel
		northPanel.add(restart, BorderLayout.SOUTH);
		
		//Sets the background color of the northPanel to orange
		northPanel.setBackground(Color.ORANGE);
		//Adds the northPanel to the north of the main BorderLayout
		add(northPanel, BorderLayout.NORTH);
	}

	@Override
	/**
	 * Needed to sense which JButtons were pressed 
	 * @param event
	 */
	public void actionPerformed(ActionEvent event) {
		//Finds the source of the ActionEvent
		Object source = event.getSource();

		/*If the yes or no button is clicked then it updates the record of the BT
		 * traversal/currentNode appropriately and updates the JLabel displaying
		 * questions/answers appropriately
		 */
		if(source == yes)
		{
			model.choiceYes();
			QorA.setText(model.getCurrentNode().getData());
		}
		else if(source == no)
		{
			model.choiceNo();
			QorA.setText(model.getCurrentNode().getData());
		}
		//Checks if the restart/new game button was clicked and if so, starts from the beginning 
		else if(source == restart)
		{
			model.currentNode = model.getTree().root;
			QorA.setText(model.getCurrentNode().getData());
		}

	}
}