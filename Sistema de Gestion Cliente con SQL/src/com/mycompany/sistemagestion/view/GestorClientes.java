package com.mycompany.sistemagestion.view;
import com.mycompany.sistemasgestion.dao.ClienteDao;
import com.mycompany.sistemasgestion.models.Cliente;
import com.mysql.cj.util.StringUtils;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Dialog.ModalExclusionType;

public class GestorClientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorClientes frame = new GestorClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	/*---- LISTA -----*/
	private List<Cliente> lista = new ArrayList<Cliente>(); 
	
	/*------ PANEL DE LISTA ------*/
	JList listClientes = new JList();
	
	/*----- Creación de "lbl_Id" -----*/
	JLabel lbl_Id = new JLabel("");
	
	
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	
	private void actualizarLista() {
		ClienteDao dao = new ClienteDao();
		 lista = dao.listar();//aquí "lista(arrayList al inicio)" lista es la variable que contiene los valores de dao.listar();
		
		DefaultListModel datos = new DefaultListModel();
		for(int i = 0 ; i < lista.size(); i++) {
			Cliente nombre = lista.get(i);
			datos.addElement(nombre.getNombreCompleto());
		}
		listClientes.setModel(datos);
	}
	
	private void limpiarCajasDeTexto() {
		txtNombre.setText(null);
		txtApellido.setText(null);
		txtTelefono.setText(null);
		txtEmail.setText(null);
		lbl_Id.setText(null);
	}
	
	
	public GestorClientes() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) { //Función que se ejecuta cuando se carga la ventana por primera vez
				actualizarLista();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(10, 59, 64, 18);
		lblNewLabel.setFont(new Font("Raleway", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(84, 59, 161, 20);
		txtNombre.setFont(new Font("Raleway", Font.PLAIN, 14));
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(143, 188, 102, 25);
		btnGuardar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = new Cliente();
				
				cliente.setNombre(txtNombre.getText());
				cliente.setApellido(txtApellido.getText());
				cliente.setEmail(txtEmail.getText());
				cliente.setTelefono(txtTelefono.getText());
				
				
				//Otra forma es:  !lbl_Id.getText().equals("")
				if (!StringUtils.isEmptyOrWhitespaceOnly(lbl_Id.getText())) {// Si el campo NO esta vacío 
					cliente.setId(lbl_Id.getText());
				}
				
				ClienteDao dao = new ClienteDao();
				dao.guardar(cliente); //agrega el cliente a la BD
				
				actualizarLista();
					JOptionPane.showMessageDialog(rootPane, "El cliente se guardo correctamente");
				
				limpiarCajasDeTexto();
			}
			
		});
		
		btnGuardar.setFont(new Font("Raleway", Font.PLAIN, 13));
		contentPane.add(btnGuardar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(281, 42, 321, 245);
		contentPane.add(scrollPane);
		
		//Aquí antes estaba: JList listClientes = new JList();  (tuve que moverla)
		scrollPane.setViewportView(listClientes);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = listClientes.getSelectedIndex();//Esto retorna el índice seleccionado
				Cliente cliente = lista.get(indice);
				ClienteDao dao = new ClienteDao();
				dao.eliminar(cliente.getId());
				actualizarLista();
				JOptionPane.showMessageDialog(rootPane, "Se elimino correctamente.");
			}
		});
		btnEliminar.setFont(new Font("Raleway", Font.PLAIN, 13));
		btnEliminar.setBounds(143, 224, 102, 25);
		contentPane.add(btnEliminar);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setFont(new Font("Raleway", Font.PLAIN, 14));
		lblApellido.setBounds(10, 87, 77, 18);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Raleway", Font.PLAIN, 14));
		txtApellido.setColumns(10);
		txtApellido.setBounds(84, 87, 161, 20);
		contentPane.add(txtApellido);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Raleway", Font.PLAIN, 14));
		lblEmail.setBounds(10, 116, 60, 18);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Raleway", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(84, 116, 161, 20);
		contentPane.add(txtEmail);
		
		JLabel lblTelfono = new JLabel("Teléfono: ");
		lblTelfono.setFont(new Font("Raleway", Font.PLAIN, 14));
		lblTelfono.setBounds(10, 145, 77, 18);
		contentPane.add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Raleway", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(84, 145, 161, 20);
		contentPane.add(txtTelefono);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = listClientes.getSelectedIndex();//Esto retorna el índice seleccionado
				Cliente cliente = lista.get(indice);
				lbl_Id.setText(cliente.getId());
				txtNombre.setText(cliente.getNombre());
				txtApellido.setText(cliente.getApellido());
				txtEmail.setText(cliente.getEmail());
				txtTelefono.setText(cliente.getTelefono());
				
				
			}
		});
		btnEditar.setFont(new Font("Raleway", Font.PLAIN, 13));
		btnEditar.setBounds(10, 223, 102, 25);
		contentPane.add(btnEditar);
		
		JLabel lbl_ID_2 = new JLabel("Id: ");
		lbl_ID_2.setFont(new Font("Raleway", Font.PLAIN, 14));
		lbl_ID_2.setBounds(10, 26, 64, 18);
		contentPane.add(lbl_ID_2);
		
		
		lbl_Id.setFont(new Font("Raleway", Font.PLAIN, 14));
		lbl_Id.setBounds(84, 26, 64, 18);
		contentPane.add(lbl_Id);
		
		JLabel lblId = new JLabel("");
		lblId.setFont(new Font("Raleway", Font.PLAIN, 14));
		lblId.setBounds(84, 26, 64, 18);
		contentPane.add(lblId);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCajasDeTexto();
			}
		});
		btnNuevo.setFont(new Font("Raleway", Font.PLAIN, 13));
		btnNuevo.setBounds(10, 188, 102, 25);
		contentPane.add(btnNuevo);
	}
}





