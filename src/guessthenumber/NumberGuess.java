package guessthenumber;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class NumberGuess extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField guessTxt;
	private JTextField message;
	private JLabel lblNewLabel_2;

	int score = 0, life = 5;
	Random rd = new Random();
	int random = rd.nextInt(100) + 1;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberGuess frame = new NumberGuess();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public NumberGuess() {
		setTitle("Guess the Number");
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LIFE");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(448, 30, 54, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setForeground(new Color(255, 0, 0));
		textField.setBounds(512, 23, 160, 28);
		textField.setEditable(false);
		textField.setText(" <3 <3 <3 <3 <3 ");
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblScore = new JLabel("SCORE");
		lblScore.setForeground(new Color(144, 238, 144));
		lblScore.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblScore.setBounds(422, 61, 91, 29);
		contentPane.add(lblScore);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 0, 255));
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(512, 62, 160, 28);
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		
		JLabel lblYourGuess = new JLabel("Your Guess");
		lblYourGuess.setForeground(SystemColor.textHighlight);
		lblYourGuess.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblYourGuess.setBounds(114, 199, 185, 61);
		contentPane.add(lblYourGuess);
		
		guessTxt = new JTextField();
		guessTxt.setFont(new Font("Alberta", Font.BOLD, 17));
		guessTxt.setBounds(300, 199, 137, 61);
		contentPane.add(guessTxt);
		guessTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(life == 1) {
					textField.setText(" ");
				}
				
				
				if (life > 1){
					
					if(life == 5) {
						textField.setText("<3 <3 <3 <3 ");
					}
					if(life == 4) {
						textField.setText("<3 <3 <3 ");
					}
					if(life == 3) {
						textField.setText("<3 <3  ");
					}
					if(life == 2) {
						textField.setText("<3 ");
					}

					
					
					String guess = guessTxt.getText();
					int g = Integer.parseInt(guess);
					
						if (g == random) {
							life = 0;
							score= score + 100;
							textField_1.setText(String.valueOf(score));
							message.setText("Congratulations!! Its a match");
							JOptionPane.showMessageDialog(null, "Congratulations!! Its a match");
							new NewGame().setVisible(true);
							dispose();
							
						}	else if (g > random) {
							message.setText("Try guessing lower number");
							score= score + 5;
							textField_1.setText(String.valueOf(score));
							life--;
						
						} else if (g < random) {
							message.setText("Try guessing higher number");
							score= score + 5;
							textField_1.setText(String.valueOf(score));	
							life--;
						}
				}
				else {
				
				message.setText("The Number is: " + String.valueOf(random));
				JOptionPane.showMessageDialog(null, "Moye Moye !! try Again");
				new NewGame().setVisible(true);
				dispose();
				}
				
			}
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(323, 269, 91, 36);
		contentPane.add(btnNewButton);
		
		message = new JTextField();
		message.setForeground(new Color(255, 0, 255));
		message.setFont(new Font("Alberta", Font.BOLD, 20));
		message.setBounds(67, 334, 605, 81);
		message.setEditable(false);
		contentPane.add(message);
		message.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Guess the number between 1 to 100");
		lblNewLabel_2.setBackground(new Color(230, 230, 250));
		lblNewLabel_2.setForeground(new Color(184, 134, 11));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(125, 151, 298, 29);
		contentPane.add(lblNewLabel_2);
	}
}
