package JFrames;

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

	/*------ LISTA ------*/
	List<Cliente> lista = new ArrayList<Cliente>();
	
	/*------ PANEL DE LISTA ------*/
	JList listClientes = new JList();
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	
	private void actualizarLista() {
		DefaultListModel datos = new DefaultListModel();
		for(int i = 0 ; i < lista.size(); i++) {
			Cliente nombre = lista.get(i);
			datos.addElement(nombre.getNombreCompleto());
		}
		listClientes.setModel(datos);
	}
	
	
	public GestorClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(10, 27, 60, 18);
		lblNewLabel.setFont(new Font("Raleway", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(84, 27, 161, 20);
		txtNombre.setFont(new Font("Raleway", Font.PLAIN, 14));
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(10, 188, 102, 25);
		btnGuardar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = new Cliente();
				
				cliente.setNombre(txtNombre.getText());
				cliente.setApellido(txtApellido.getText());
				cliente.setEmail(txtEmail.getText());
				cliente.setTelefono(txtTelefono.getText());
				
				lista.add(cliente);
				actualizarLista();
				JOptionPane.showMessageDialog(rootPane, "El cliente se guardo correctamente");
				
				limpiarCajasDeTexto();
			}
			private void limpiarCajasDeTexto() {
				txtNombre.setText(null);
				txtApellido.setText(null);
				txtTelefono.setText(null);
				txtEmail.setText(null);
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
				lista.remove(indice);
				actualizarLista();
				JOptionPane.showMessageDialog(rootPane, "Se elimino correctamente.");
			}
		});
		btnEliminar.setFont(new Font("Raleway", Font.PLAIN, 13));
		btnEliminar.setBounds(149, 188, 102, 25);
		contentPane.add(btnEliminar);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setFont(new Font("Raleway", Font.PLAIN, 14));
		lblApellido.setBounds(10, 55, 77, 18);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Raleway", Font.PLAIN, 14));
		txtApellido.setColumns(10);
		txtApellido.setBounds(84, 55, 161, 20);
		contentPane.add(txtApellido);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Raleway", Font.PLAIN, 14));
		lblEmail.setBounds(10, 84, 60, 18);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Raleway", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(84, 84, 161, 20);
		contentPane.add(txtEmail);
		
		JLabel lblTelfono = new JLabel("Teléfono: ");
		lblTelfono.setFont(new Font("Raleway", Font.PLAIN, 14));
		lblTelfono.setBounds(10, 113, 77, 18);
		contentPane.add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Raleway", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(84, 113, 161, 20);
		contentPane.add(txtTelefono);
	}
}





