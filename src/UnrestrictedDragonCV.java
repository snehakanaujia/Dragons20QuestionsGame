import java.awt.BorderLayout;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import datastructures.DefaultBinaryTreeNode;

import java.io.*;
/**
 * Controller and view combined class that extends the restricted game version's controller and view class
 * (DragonCV). Adds the JTextField needed for the unrestricted dragons 20 questions game. Calls the
 * appropriate methods depending on the buttons the user clicks as they play the game: yes, no, and new
 * game/restart. Has the ability to add question and answer nodes to the binary tree depending on the answer
 * and question the user wanted to get/encounter in the game.
 * 
 * @author Sneha Kanaujia
 *
 */
public class UnrestrictedDragonCV  extends DragonCV {

	//Creates a JTextField the user can input their new dragon/answer or question to add to the binary tree
	public JTextField text = new JTextField();
	//Creates a default binary tree node to hold the new dragon the user supplies if they want to add a new dragon/answer default binary tree node
	public DefaultBinaryTreeNode<String> newDragon = new DefaultBinaryTreeNode<String>();
	//String to hold the data of the old/"wrong" dragon/answer node
	public String oldDragonText = "";
	//String to hold the data of the new dragon/answer node the user wants to add to the binary tree
	public String newDragonText = "";
	
	/*Boolean that distinguishes yes and no answers while traversing through the tree and when its to set
	the new dragon/answer as the rightChild/yes or leftChild/no to the newly added question node*/
	boolean questionMode = false;
	
	/**
	 * Constructor that calls super and adds actionListener to the new JTextField created
	 */
	public UnrestrictedDragonCV() {
		super();
		
		text.addActionListener(this);
	}
	
	@Override
	/**
	 * Needed to sense which JButtons were pressed 
	 */
	public void actionPerformed(ActionEvent event) {
		//Finds the source of the ActionEvent
		Object source = event.getSource();
		
		//Checks if the New Game/restart button is clicked
		if(source == restart)
		{
			//Resets the questionMode boolean to false since its not asking user text input questions anymore
			questionMode = false;
			//Resets the currentNode to the root of the binary tree
			model.currentNode = model.getTree().root;
			//Resets the JLabel to the root/currentNode's data/the first question in the tree
			QorA.setText(model.getCurrentNode().getData());
		}
		//Checks if the user has traversed to a leaf node/dragon/answer
		else if(model.getCurrentNode().isLeaf())
		{
			//Checks that it's not asking the user text input questions yet, that the button clicked was yes in response to the dragon being the one the user thought of
			if(!questionMode && source == yes && QorA.getText().equals("Was " + model.getCurrentNode().getData() + " the dragon you were thinking of?"))
			{
				QorA.setText("Excellent! Thank you for playing!");
			}
			//Checks that it's not asking the user text input questions yet, that the button clicked was no in response to the dragon being the one the user thought of
			else if(!questionMode && source == no && QorA.getText().equals("Was " + model.getCurrentNode().getData() + " the dragon you were thinking of?"))
			{
				//Sets questionMode boolean to true since the game is entering user text input
				questionMode = true;
				//Sets the JLabel to ask what dragon the user was thinking of
				QorA.setText("What dragon were you thinking of?");
				//Adds the JTextField to the center of the southPanel of the general BorderLayout
				southPanel.add(text, BorderLayout.CENTER);
				
			}
			//Checks if the JTextBox was given input and if the question asked was "What dragon were you thinking of?"
			else if(source == text && QorA.getText().equals("What dragon were you thinking of?"))
			{
				//Saves the text the user inputed into the JTextField into a String
				newDragonText = text.getText();
				//Removes the inputed text from the JTextField/makes it blank again
				text.setText("");
				//Sets the node data for the new dragon/answer/leaf node to the text that was inputed by the user
				newDragon.setData(newDragonText);
				//Asks the user to give a differentiating question for the answer they got to and the one they wanted/are adding
				QorA.setText("Please give me a yes/no question that would have determined your thing.");
			}
			//Checks if the JTextBox was given input and if the question asked was "Please give me a yes/no question that would have determined your thing."
			else if(source == text && QorA.getText().equals("Please give me a yes/no question that would have determined your thing."))
			{
				//Gets the "wrong" dragon/answer/leaf node's data and save is in a string
				oldDragonText = model.getCurrentNode().getData();
				//Sets the "wrong" dragon/answer/leaf node's data to the one the user is adding
				model.getCurrentNode().setData(text.getText());
				//Removes the inputed text from the JTextField/makes it blank again
				text.setText("");
				//Then asks if the dragon/answer the user is adding is the result of a yes or no answer to the differentiating question they gave
				QorA.setText("Is the answer to your question yes or no? Please press the corresponding button.");
				//Removes the JTextField from the southPanel
				southPanel.remove(text);
			}
			//Checks if the user clicked the yes JButton and if the question asked was "Is the answer to your question yes or no? Please press the corresponding button."
			else if(source == yes && QorA.getText().equals("Is the answer to your question yes or no? Please press the corresponding button."))
			{
				//Sets the new dragon/answer to the right child of the current/new question node
				model.getCurrentNode().setRightChild(newDragon);
				//Creates a new node to hold the old/"wrong" dragon/answer data
				DefaultBinaryTreeNode<String> oldDragon = new DefaultBinaryTreeNode<String>();
				oldDragon.setData(oldDragonText);
				//Sets the old answer/dragon node to the left child of the current/new question node
				model.getCurrentNode().setLeftChild(oldDragon);
				//Thanks the user for playing through the question and answer JLabel
				QorA.setText("Excellent! Thank you for playing!");
				//Adds the newly added dragon/answer to the list of options in the JLabel
				String optionText = options.getText() + newDragon.getData() + ", ";
				options.setText(optionText);
			}
			//Checks if the user clicked the yes JButton and if the question asked was "Is the answer to your question yes or no? Please press the corresponding button."
			else if(source == no && QorA.getText().equals("Is the answer to your question yes or no? Please press the corresponding button."))
			{
				//Sets the new dragon/answer to the left child of the current/new question node
				model.getCurrentNode().setLeftChild(newDragon);
				//Creates a new node to hold the old/"wrong" dragon/answer data
				DefaultBinaryTreeNode<String> oldDragon = new DefaultBinaryTreeNode<String>();
				oldDragon.setData(oldDragonText);
				//Sets the old answer/dragon node to the right child of the current/new question node
				model.getCurrentNode().setRightChild(oldDragon);
				//Thanks the user for playing through the question and answer JLabel
				QorA.setText("Excellent! Thank you for playing!");
				//Adds the newly added dragon/answer to the list of options in the JLabel
				String optionText = options.getText() + newDragon.getData() + ", ";
				options.setText(optionText);
			}
			
		}
		//Checks if it's not questionMode and if the user clicked the yes JButton
		else if(!questionMode && source == yes)
		{
			//Calls the model's yes method to traverse through the binary tree appropriately
			model.choiceYes();
			//Updates the question and answer JLabel to reflect the current node's data
			QorA.setText(model.getCurrentNode().getData());
			
			//Checks if the current node the user has traversed to is a leaf/answer/dragon
			if(model.getCurrentNode().isLeaf())
			{
				//Asks the user if that answer/dragon was the one the user was thinking of
				QorA.setText("Was " + model.getCurrentNode().getData() + " the dragon you were thinking of?"); 
			}
			
		}
		//Checks if it's not questionMode and if the user clicked the yes JButton
		else if(!questionMode && source == no)
		{
			//Calls the model's no method to traverse through the binary tree appropriately
			model.choiceNo();
			//Updates the question and answer JLabel to reflect the current node's data
			QorA.setText(model.getCurrentNode().getData());
			
			//Checks if the current node the user has traversed to is a leaf/answer/dragon
			if(model.getCurrentNode().isLeaf())
			{
				//Asks the user if that answer/dragon was the one the user was thinking of
				QorA.setText("Was " + model.getCurrentNode().getData() + " the dragon you were thinking of?"); 
			}
		}
		
		

	}
	
}