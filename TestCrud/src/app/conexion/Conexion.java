package app.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	
  private static final String url="jdbc:mysql://localhost/persona";
  private static final String user="root";
  private static final String pass="rootladvd";
	
	
public static Connection abrir(){
	
	
	Connection cn=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		cn=DriverManager.getConnection(url,user,pass);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return cn;
	
	
}
	
//public static void main(String[] args) {
	//Conexion c=new Conexion();
	
	
	//}





}
