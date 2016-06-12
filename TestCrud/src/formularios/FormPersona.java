package formularios;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import app.bean.Persona;
import app.dao.DaoPersona;

@SuppressWarnings("serial")
public class FormPersona extends JFrame implements ActionListener {
	
	JPanel pan1;
	JPanel pan2;
	JPanel pan3;
	
	JLabel lbl_dni;
	JLabel lbl_nombre;
	JLabel lbl_apellido;
	JLabel lbl_fecha;
	JLabel lbl_lugar;
	
	JTextField txt_dni;
	JTextField txt_nombre;
	JTextField txt_apellido;
	JTextField txt_fecha;
	JTextField txt_lugar;
	
	JButton btn_insertar;
	JButton btn_editar;
	JButton btn_borrar;
	JButton btn_listar;
	JButton btn_agregartabla;
	JButton btn_buscar;
	JButton btn_limpiar;
	
	JTable megan;
	
	
	
	public FormPersona(){
		
		setLayout(null);
		iniciar();
		
		
		
		
		
		
	}
	
	
	public void iniciar(){
		
		this.setSize(700,670);
		Panel1();
		Panel2();
		Panel3();
		
		
		
		
	}
	
	///Diseño ds
	
	public void Panel1(){
		
	pan1=new JPanel(new GridLayout(5,2,1,5));
	pan1.setBounds(10, 10, 400,300 );
	Border bordeame= new TitledBorder(new EtchedBorder(), "Datos del Lince");
    pan1.setBorder(bordeame); 
    getContentPane().add(pan1);
    
    lbl_dni=new JLabel("Dni");
    lbl_nombre=new JLabel("Nombre");
    lbl_apellido=new JLabel("Apellido");
    lbl_fecha=new JLabel("Fecha");
    lbl_lugar=new JLabel("Lugar");
    
    txt_dni=new JTextField(15);
    txt_nombre=new JTextField(30);
    txt_apellido=new JTextField(50);
    txt_fecha=new JTextField(20);
    txt_lugar=new JTextField(20);
    
    pan1.add(lbl_dni);
    pan1.add(txt_dni);
    pan1.add(lbl_nombre);
    pan1.add(txt_nombre);
    pan1.add(lbl_apellido);
    pan1.add(txt_apellido);
    pan1.add(lbl_fecha);
    pan1.add(txt_fecha);
    pan1.add(lbl_lugar);
    pan1.add(txt_lugar);
    
		
		
	}
	
	
	
	public void Panel2(){
		
		pan2=new JPanel();
		pan2.setBounds(40, 320, 500,250 );
		Border bordeame= new TitledBorder(new EtchedBorder(), "Miranda Cosgrove(Tabla)");
	    pan2.setBorder(bordeame); 
	    getContentPane().add(pan2);	
	    
	    generarTabla();
		
		
	}
	
	
	public void generarTabla(){
		
		String [] columnas={"Dni","Nombres","Apellidos","Fecha","Lugar"};
		
		DefaultTableModel model=new DefaultTableModel(null, columnas);
		
		megan=new JTable(model);
		megan.setPreferredScrollableViewportSize(new Dimension(440, 170));
		JScrollPane scroll=new JScrollPane(megan);
		pan2.add(scroll);
		
	}
	
	
public void Panel3(){
	
	//GridLayout(5, 1, 30, 10)
		
		pan3=new JPanel(new GridLayout(7, 1, 20, 10));
		pan3.setBounds(420, 10, 150,300 );
		Border bordeame= new TitledBorder(new EtchedBorder(), "Botones Shidoris");
	    pan3.setBorder(bordeame); 
	    getContentPane().add(pan3);	
	    
	    btn_insertar=new JButton("Insertar");
	    btn_editar=new JButton("Editar");
	    btn_borrar=new JButton("Borrar");
	    btn_listar=new JButton("Listar");
	    btn_agregartabla=new JButton("Agregar");
	    btn_buscar=new JButton("Buscar");
	    btn_limpiar=new JButton("Limpiar");
	    
	    btn_insertar.addActionListener(this);
	    btn_editar.addActionListener(this);
	    btn_borrar.addActionListener(this);
	    btn_listar.addActionListener(this);
	    btn_agregartabla.addActionListener(this);
	    btn_buscar.addActionListener(this);
	    btn_limpiar.addActionListener(this);
	    
	    pan3.add(btn_insertar);
	    pan3.add(btn_editar);
	    pan3.add(btn_borrar);
	    pan3.add(btn_listar);
	    pan3.add(btn_agregartabla);
	    pan3.add(btn_buscar);
	    pan3.add(btn_limpiar);
	    
	    
	    
		
		
	}
	
	
//// Metodos de los botones

public void buscarPersona(){
	
	int dni=Integer.parseInt(txt_dni.getText());
	
	DaoPersona perdao=new DaoPersona();
	
	ArrayList<Persona> lista=new ArrayList<>();
	
	lista=perdao.buscar(dni);
	
	for (Persona x : lista) {
		
		txt_nombre.setText(x.getNombre());
		txt_apellido.setText(x.getApellido());
		txt_fecha.setText(x.getFecha());
		txt_lugar.setText(x.getLugar());
		
	}
	
	
	
}
	

	
 public void registrarPersona(){
	 
	Persona per=new Persona();
	per.setDni(Integer.parseInt(txt_dni.getText()));
	per.setNombre(txt_nombre.getText());
	per.setApellido(txt_apellido.getText());
	per.setFecha(txt_fecha.getText());
	per.setLugar(txt_lugar.getText());
	
	DaoPersona perdao=new DaoPersona();
	
	perdao.insertar(per);
	
	 
	 
	 
	 
 }
 
 
 public void editarPersona(){
	 
	 
	 int dni=Integer.parseInt(txt_dni.getText());
	 Persona per=new Persona();
	 per.setNombre(txt_nombre.getText());
     per.setApellido(txt_apellido.getText());
     per.setFecha(txt_fecha.getText());
	 per.setLugar(txt_lugar.getText());
	 
	 
	 DaoPersona perdao=new DaoPersona();
	 perdao.editar(per, dni);
	 
	 
	 
 }

	
 
 public void borrarPersona(){
	 
	DaoPersona perdao=new DaoPersona();
	int dni=Integer.parseInt(txt_dni.getText());
	 perdao.borrar(dni);
	 
	 
	 
 }
 
 
 public void listarTabla(){
	
	 
	 String [] columnas={"Dni","Nombres","Apellidos","Fecha","Lugar"};
	 
	 DaoPersona perdao=new DaoPersona();
	 ArrayList<Persona> listando=new ArrayList<>();
	 listando=perdao.listarTabla();
	 
	 DefaultTableModel modelo=new DefaultTableModel(null, columnas);
	 megan.setModel(modelo);
	 for (Persona x : listando) {
		
		 modelo.addRow(new Object[]{x.getDni(),x.getNombre(),x.getApellido(),x.getFecha(),x.getLugar()});
		 
	}
	 
	 
	 
	 
 }
	
	public void limpiarDatos(){
		
		txt_dni.setText("");
		txt_nombre.setText("");
		txt_apellido.setText("");
		txt_fecha.setText("");
		txt_lugar.setText("");
		
		
	}
	
	
	public void agregarTabla(){
		
	 int dni=Integer.parseInt(txt_dni.getText());
	 
	// int cont=megan.getRowCount();
	 String nombre=txt_nombre.getText();
	 String apellido=txt_apellido.getText();
	 String fecha=txt_fecha.getText();
	 String lugar=txt_lugar.getText();
	 
	DefaultTableModel mod=(DefaultTableModel) megan.getModel();
	
	mod.addRow(new Object[]{String.valueOf(dni),nombre,apellido,fecha,lugar});
	 
	 
	 
		
		
		
	}
	
	
	
	
	

//botones

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==this.btn_insertar){
			
			registrarPersona();
			listarTabla();
			
			
		}
		
         if(e.getSource()==this.btn_editar){
			
			editarPersona();
			listarTabla();
			
			
		}

         
         
         if(e.getSource()==this.btn_borrar){
 			
 			
 			borrarPersona();
 			listarTabla();
 		}
         
         
         if(e.getSource()==this.btn_listar){
 			
 			listarTabla();
 			
 			
 		}
         
         
         if(e.getSource()==this.btn_agregartabla){
  			
  			agregarTabla();
  			
  			
  		} 
         
         
         if(e.getSource()==this.btn_buscar){
 			
 			buscarPersona();
 			
 			
 		}
         
         
         if(e.getSource()==this.btn_limpiar){
  			
  			limpiarDatos();
  			
  			
  		}
		
		
		
	}

	
	
	//main

	public static void main(String[] args) {
		FormPersona per=new FormPersona();
		per.setVisible(true);
		
		

	}
}
