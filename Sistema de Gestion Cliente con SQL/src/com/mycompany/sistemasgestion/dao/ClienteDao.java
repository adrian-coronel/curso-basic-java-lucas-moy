package com.mycompany.sistemasgestion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.sistemasgestion.models.Cliente;
import com.mysql.cj.util.StringUtils;

// DAO => Data Access Object
/* Aquí se crearán las clases que accederán a la base de datos
 * -- Permite recibir objetos de la clase "clientes" y guardarla en la BD (en la tabla Cliente)
 * -- A la misma vez "transformar" esos datos a objetos como lo es la clase cliente
 */
public class ClienteDao {

	
	public Connection conectar() {
		String baseDeDatos = "java";
		String usuario = "root";
		String password = "";
		String host = "localhost";
		String puerto = "3306";
		String driver = "com.mysql.cj.jdbc.Driver";
		String conexionUrl = "jdbc:mysql://"+ host +":"+ puerto +"/"+ baseDeDatos +"?useSSL=false";
		
		Connection conexion = null;
		
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(conexionUrl, usuario, password);
			
		} catch (Exception e) { //Si se encuentra un error se ejecuta "catch"
			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);;
		}
		return conexion;
	}
	
	public void agregar(Cliente cliente) {
		
		try {
			
			Connection conexion = conectar();
			
			String sql = "INSERT INTO `clientes` (`id`, `nombre`, `apellido`, `email`, `telefono`) VALUES (NULL, '"+cliente.getNombre()
			+"', '"+cliente.getApellido()+"', '"+cliente.getEmail()+"', '"+cliente.getTelefono()+"');";
			
			Statement statement = conexion.createStatement();//conexion.createStatement() retorna un valor de tipo "Statement"
			statement.execute(sql);//Ejecuta el código "sql"
			
			
		} catch (Exception e) { //Si se encuentra un error se ejecuta "catch"
			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);;
			//e.printStackTrace();
		}
	}
	
	public List<Cliente> listar() {
		
		List<Cliente> listado = new ArrayList<Cliente>();
		
		try {
			Connection conexion = conectar();
			
			String sql = "SELECT * FROM `clientes`; "; //Esto va a set la consulta para mostrar los datos de la BD
			
			Statement statement = conexion.createStatement();//conexion.createStatement() retorna un valor de tipo "Statement"
			ResultSet resultado = statement.executeQuery(sql);//Devuelve todos los datos de una tabla
			
			
			while(resultado.next()) { //Se recorre cada fila de la tabla
				Cliente cliente = new Cliente(); //Por cada fila, se crea un cliente
				cliente.setId(resultado.getString("id"));
				cliente.setNombre(resultado.getString("nombre")); //resultado.getString("nombre") retorna el valor de la columna NOMBRE
				cliente.setApellido(resultado.getString("apellido"));
				cliente.setTelefono(resultado.getString("telefono"));
				cliente.setEmail(resultado.getString("email"));
				
				listado.add(cliente);
			}
			
			
		} catch (Exception e) { //Si se encuentra un error se ejecuta "catch"
			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);;
			//e.printStackTrace();
		}
		return listado;
	}
	
	
	public void eliminar(String id) {
		
		
		try {
			Connection conexion = conectar();
			
			String sql = "DELETE FROM clientes WHERE `clientes`.`id` = "+ id;
			
			Statement statement = conexion.createStatement();//conexion.createStatement() retorna un valor de tipo "Statement"
			statement.execute(sql);//Ejecuta el código "sql"
			
			
		} catch (Exception e) { //Si se encuentra un error se ejecuta "catch"
			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);;
			//e.printStackTrace();
		}
	}
	
	
	public void actualizar(Cliente cliente) {
		
		try {
			
			Connection conexion = conectar();
			
			String sql = "UPDATE `clientes` SET `nombre` = '"+cliente.getNombre()
					+"', `apellido` = '"+cliente.getApellido()
					+"', `email` = '"+cliente.getEmail()
					+"', `telefono` = '"+cliente.getTelefono()
					+"' WHERE `clientes`.`id` = "+cliente.getId()+"; ";
			
			Statement statement = conexion.createStatement();//conexion.createStatement() retorna un valor de tipo "Statement"
			statement.execute(sql);//Ejecuta el código "sql"
			
			
		} catch (Exception e) { //Si se encuentra un error se ejecuta "catch"
			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);;
			//e.printStackTrace();
		}
	}

    public void guardar(Cliente cliente) {
    	if (StringUtils.isEmptyOrWhitespaceOnly(cliente.getId())) { //Si el cliente no tiene id se agrega, caso contrario es actualizar
    		agregar(cliente);
    	}else {
    		actualizar(cliente);
    	}
	
    }
	
	
}

/* IMPORTANTE!!!!!!
 * 
 * Cuando compile el formulario me salía error, ya que necesitaba el JDBC de MySQL
 * Enlace de Descarga: https://dev.mysql.com/downloads/connector/j/8.0.html (dar en Platform Independent)
 * VIDEO: https://www.youtube.com/watch?v=_7R46uVZTyc
 * 
 * */








