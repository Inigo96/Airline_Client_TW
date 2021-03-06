package gui;

import controller.Controller;
import entities.FlightDTO;
import entities.UserDTO;
import entities.ReservationDTO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.LineNumberInputStream;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.StringContent;


public class MainWindow extends JFrame implements ActionListener{

	private final Object lock = new Object();

	private UserDTO user;
	private Controller controller;
	private ArrayList<FlightDTO> flightList;
	private ArrayList<ReservationDTO> reservationList;

	private JScrollPane scrollPane;
	private int dia;
	private int mes;
	private int anyo;
	final int numColumnasVuelos = 3;
	private JTextField txtUsuario;
	private JTextField txtPass;
	private JTextField txtDestino;
	private JTextField txtOrigen;
	private JTable table;

	private JButton btnReservas;
	private JButton btnBuscar;
	private JButton btnLogIn;
	private JButton btnReservar;

	private JComboBox diaComBox;
	private JComboBox mesComBox;
	private JComboBox anyoComBox;


	public MainWindow(Controller controller){
		this.controller = controller;
		initComponents();
		this.setVisible(true);
		this.centreWindow();
	}
	
	private JPanel panel;	
	
	private void rellenarTablaVuelos(ArrayList<FlightDTO> patata){
	
		for(int i = 0; i< patata.size(); i++){
			FlightDTO v =  patata.get(i);
				table.setValueAt(v.getArrivalA(), i, 0);
				table.setValueAt(v.getDepartureA(), i, 1);
				table.setValueAt(gregorianToString(v.getDate()), i, 2);
				
		}

		scrollPane.add(table);
		panel.add(scrollPane);
	}
	
	private void rellenarTablaReservas(ArrayList<ReservationDTO> reservas){

//		ReservationDTO[] resers=new ReservationDTO[reservas.size()];

//		ReservationDTO[] resers=(ReservationDTO[]) reservas.toArray();
		for(int i=0;i<reservas.size();i++){
			FlightDTO f;
			f=reservas.get(i).getFlight();
			table.setValueAt(Integer.toString(i), i, 0);
			table.setValueAt(f.toString(), i, 1);

		}
		scrollPane.add(table);
		panel.add(scrollPane);

	}
	
	
	public void initComponents(){
		setResizable(true);
//		getContentPane().setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(700,700);
		getContentPane().setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 125);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(118, 91, 89, 23);
		panel_2.add(btnLogIn);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(82, 22, 125, 20);
		panel_2.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtPass = new JTextField();
		txtPass.setBounds(82, 53, 125, 20);
		panel_2.add(txtPass);
		txtPass.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(26, 25, 46, 14);
		panel_2.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 56, 62, 14);
		panel_2.add(lblContrasea);

		btnReservas = new JButton("Reservas");
		btnReservas.setBounds(20, 91, 99, 23);
		panel_2.add(btnReservas);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(131, 91, 86, 23);

		panel_3.add(btnBuscar);

		txtDestino = new JTextField();
		txtDestino.setText("Destino");
		txtDestino.setBounds(131, 24, 86, 20);
		panel_3.add(txtDestino);
		txtDestino.setColumns(10);

		txtOrigen = new JTextField();
		txtOrigen.setText("Origen");
		txtOrigen.setBounds(10, 24, 86, 20);
		panel_3.add(txtOrigen);
		txtOrigen.setColumns(10);

		JLabel barra = new JLabel("/");
		barra.setBounds(62, 58, 23, 14);
		panel_3.add(barra);

		diaComBox = new JComboBox();
		diaComBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		diaComBox.setBounds(10, 55, 42, 20);
		panel_3.add(diaComBox);

		mesComBox = new JComboBox();
		mesComBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		mesComBox.setBounds(82, 55, 42, 20);
		panel_3.add(mesComBox);

		anyoComBox = new JComboBox();
		anyoComBox.setModel(new DefaultComboBoxModel(new String[] {"2017", "2018"}));
		anyoComBox.setBounds(156, 55, 61, 20);
		panel_3.add(anyoComBox);

		JLabel barra_1 = new JLabel("/");
		barra_1.setBounds(134, 58, 12, 14);
		panel_3.add(barra_1);

		btnReservar = new JButton("Reservar");
		btnReservar.setBounds(10, 91, 100, 23);
		panel_3.add(btnReservar);

		panel = new JPanel();
		panel.setBounds(0, 123, 684, 538);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblResultados = new JLabel("  Resultados");
		panel.add(lblResultados, BorderLayout.NORTH);
		
		table = new JTable(25, 3);
		scrollPane = new JScrollPane();
		scrollPane.add(table);
		panel.add(scrollPane, BorderLayout.CENTER);
		
//		table.setVisible(true);

		scrollPane.setViewportView(table);

		btnBuscar.addActionListener(this);
		btnLogIn.addActionListener(this);
		btnReservas.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		user = controller.login(txtUsuario.getText(), txtPass.getText());
		if(e.getSource().equals(btnBuscar)){
			// conexion con los datos
			anyo = anyoComBox.getSelectedIndex() + 2017;
	      		mes = mesComBox.getSelectedIndex() + 1;
     			dia = diaComBox.getSelectedIndex() + 1;
			flightList= controller.searchFlight(txtOrigen.getText(), txtDestino.getText(), new GregorianCalendar(anyo, mes,dia));

			System.out.println("flightList = " + flightList);
			System.out.println("flightList = " + flightList.size());
			rellenarTablaVuelos(flightList);
			this.scrollPane.add(table);

			

		}else if(e.getSource().equals(btnLogIn)){
			String email = txtUsuario.getText();
			String pass = txtPass.getText();
			// Comprueba que el usuario va con la contrasena.
			if(user!=null){
				txtUsuario.setEditable(false);
				txtPass.setEditable(false);
				this.setTitle("Log in correct");
//				try{wait(3000);}catch(InterruptedException exception){
//					exception.printStackTrace();
//				}
//				this.setTitle("");

			}else{
				this.setTitle("Error in Log in");
//				try{wait(3000);}catch(InterruptedException exception){
//					exception.printStackTrace();
//				}
//				this.setTitle("");
			}

		}else if(e.getSource().equals(btnReservas)){
			// Conseguir las reservas en funcion del User
			reservationList = controller.getReservations(user);
			rellenarTablaReservas(reservationList);
			this.scrollPane.add(table);
			scrollPane.setVisible(true);

		}else if(e.getSource().equals(btnReservar)){
			// Crear reserva
			int numVuelo = table.getSelectedRow();
			FlightDTO flight  = flightList.get(numVuelo);
			controller.createReservation(flight, user);

		}
	}

	public void centreWindow() {
		Dimension dim = getToolkit().getScreenSize();
		Rectangle abounds = getBounds();
		setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
	}
	public String gregorianToString(GregorianCalendar calendar){

		int year =calendar.get(Calendar.YEAR);
		int month= calendar.get(Calendar.MONTH)+1;
		int day=calendar.get(Calendar.DAY_OF_MONTH);

		return Integer.toString(day)+"-"+Integer.toString(month)+"-"+Integer.toString(year);
	}
}
