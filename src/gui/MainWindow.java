package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainWindow extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtDestino;
	private JTextField txtOrigen;
	public MainWindow() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 124, 434, 137);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 125);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setBounds(118, 91, 89, 23);
		panel_2.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(82, 22, 125, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 53, 125, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(26, 25, 46, 14);
		panel_2.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 56, 62, 14);
		panel_2.add(lblContrasea);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnImg = new JButton("Img");
		btnImg.setBounds(156, 23, 51, 23);
		panel_3.add(btnImg);
		
		txtDestino = new JTextField();
		txtDestino.setText("Destino");
		txtDestino.setBounds(95, 24, 51, 20);
		panel_3.add(txtDestino);
		txtDestino.setColumns(10);
		
		txtOrigen = new JTextField();
		txtOrigen.setText("Origen");
		txtOrigen.setBounds(34, 24, 51, 20);
		panel_3.add(txtOrigen);
		txtOrigen.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setBounds(58, 78, 12, 14);
		panel_3.add(label);
		
		JComboBox diaComBox = new JComboBox();
		diaComBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		diaComBox.setBounds(10, 75, 42, 20);
		panel_3.add(diaComBox);
	}
	public static void main(String[] args) {
		MainWindow a = new MainWindow();
		a.setVisible(true);
	}
}
