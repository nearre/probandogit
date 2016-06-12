package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.bean.Persona;
import app.conexion.Conexion;

public class DaoPersona {
	
	
	
	
	
	
	
	
	
	public ArrayList<Persona> buscar(int dni){
		
		ArrayList<Persona> list=new ArrayList<>();
		
		String sql="select*from personame where dni='"+dni+"'";
		
		Connection cn=Conexion.abrir();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps=cn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			Persona per;
			
			while(rs.next()){
				
				per=new Persona();
				
				per.setNombre(rs.getString(2));
				per.setApellido(rs.getString(3));
				per.setFecha(rs.getString(4));
				per.setLugar(rs.getString(5));
				
				list.add(per);
				
			}
			
			rs.close();
			ps.close();
			cn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}
	
	

	
	public ArrayList<Persona> listarTabla(){
		
		ArrayList<Persona> listame=new ArrayList<>();
		String sql="select*from personame";
		
		Connection cn=Conexion.abrir();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps=cn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			Persona per;
			while(rs.next()){
			per=new Persona();
			
			per.setDni(rs.getInt(1));
			per.setNombre(rs.getString(2));
			per.setApellido(rs.getString(3));
			per.setFecha(rs.getString(4));
			per.setLugar(rs.getString(5));
			
			listame.add(per);
				
			}
			
			rs.close();
			ps.close();
			cn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listame;
	}
	
	
	public void insertar(Persona per){
		
	
		String sql="insert into personame values (?,?,?,?,?)";
		
		Connection cn=Conexion.abrir();
		
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement(sql);
			
			ps.setInt(1,per.getDni());
			ps.setString(2, per.getNombre());
			ps.setString(3,per.getApellido());
			ps.setString(4,per.getFecha());
			ps.setString(5,per.getLugar());
			
			ps.executeUpdate();
			
			ps.close();
			cn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	public void editar(Persona per,int dni){
	
		String sql="update personame set nombre=?,apellido=?,fecha=?,lugar=? where dni='"+dni+"'";
		
		Connection cn=Conexion.abrir();
		PreparedStatement ps;
		
		try {
			ps=cn.prepareStatement(sql);
			
			ps.setString(1,per.getNombre());
			ps.setString(2,per.getApellido());
			ps.setString(3,per.getFecha());
			ps.setString(4,per.getLugar());
			
			ps.executeUpdate();
			
			ps.close();
			cn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	public void borrar(int dni){
		
		String sql="delete from personame where dni='"+dni+"'";
		
		Connection cn=Conexion.abrir();
		PreparedStatement ps;
		try {
			ps=cn.prepareStatement(sql);
			ps.executeUpdate();
			
			ps.close();
			cn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

