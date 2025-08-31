/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
/**
 *
 
 * @author Marco
 */
public class Estudiante extends Persona {
    private String carnet;
    private int id;
    Conexion cn;
    private int getid;
    
    public Estudiante(){}
    public Estudiante(int id,String carnet, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.carnet = carnet;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            cn = new Conexion();
            cn.abrir_conexion();
            String query;
            query = "Select id as id,nombres,apellidos,direccion,telefono,fecha_nacimiento from personas";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[]={"ID","Nombres","Apellidos","Direccion","Telefono","FN"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[]= new String[6];
            while(consulta.next()){
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("nombres");
                datos[2] = consulta.getString("apellidos");
                datos[3] = consulta.getString("direccion");
                datos[4] = consulta.getString("telefono");
                datos[5] = consulta.getString("fecha_nacimiento");
                tabla.addRow(datos);
            }
            cn.cerrar_conexion();
    }catch(Exception ex){
        cn.cerrar_conexion();
        System.out.println("Error: "+ ex.getMessage());
    }
        return tabla;
    }
    
    @Override
    public void agregar(){        
    try{
        PreparedStatement parametro;
        String query = "INSERT INTO personas(nombres,apellidos,direccion,telefono,fecha_nacimiento) VALUES(?,?,?,?,?)";
        cn = new Conexion();
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
        parametro.setString(1, getNombres());
        parametro.setString(2, getApellidos());
        parametro.setString(3, getDireccion());
        parametro.setString(4, getTelefono());
        parametro.setString(5, getFecha_nacimiento());
        int executar = parametro.executeUpdate();
        cn.cerrar_conexion();
        JOptionPane.showMessageDialog(null,Integer.toString(executar)+"Registro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
    }catch(Exception ex){
        System.out.println("Error..."+ ex.getMessage());
    }
    }
    @Override
    public void modificar() {
        try{
        PreparedStatement parametro;
        String query = "UPDATE personas set nombres=?, apellidos=?, direccion=?,telefono=?,fecha_nacimiento=? where id=?";
        cn = new Conexion();
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
        parametro.setString(1, getNombres());
        parametro.setString(2, getApellidos());
        parametro.setString(3, getDireccion());
        parametro.setString(4, getTelefono());
        parametro.setString(5, getFecha_nacimiento());
        parametro.setInt(6, getId());
        int executar = parametro.executeUpdate();
        cn.cerrar_conexion();
        JOptionPane.showMessageDialog(null,Integer.toString(executar)+"Registro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
    }catch(Exception ex){
        System.out.println("Error..."+ ex.getMessage());
    }
    }
    @Override
    public void eliminar(){
         try{
        PreparedStatement parametro;
        String query = "INSERT INTO personas(nombres,apellidos,direccion,telefono,fecha_nacimiento) VALUES(?,?,?,?,?)";
        cn = new Conexion();
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
        parametro.setString(1, getNombres());
        parametro.setString(2, getApellidos());
        parametro.setString(3, getDireccion());
        parametro.setString(4, getTelefono());
        parametro.setString(5, getFecha_nacimiento());
        int executar = parametro.executeUpdate();
        cn.cerrar_conexion();
        JOptionPane.showMessageDialog(null,Integer.toString(executar)+"Registro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
    }catch(Exception ex){
        System.out.println("Error..."+ ex.getMessage());
    }
    }

   
    
   
    
}
