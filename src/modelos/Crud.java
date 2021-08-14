package modelos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import config.Conexion;
import javax.swing.JOptionPane;


public class Crud{

    public void insertarDatos(String nombre, int genero, String materia, float nota){
        Conexion conexion = new Conexion();

        Connection con =  conexion.get_connection();
        try{
            Statement stm = con.createStatement();

            String query = String.format("insert into tb_asistentes (nombre,genero,materia,notas) values ('%s',%s,'%s',%s)",nombre, genero,materia,nota); 
            
            stm.executeUpdate(query); 

            con.close();

            JOptionPane.showMessageDialog(null, "Registro guardado con exito");


        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    public String leerDatos(){
        Conexion conexion = new Conexion();
        
        String datosObtenidos = "";

        Connection con =  conexion.get_connection();
        try{
            Statement stm = con.createStatement();

            String query = "select * from tb_asistentes"; 
            
            ResultSet datos = stm.executeQuery(query); 

            while(datos.next()){
                datosObtenidos += String.format("%s %s %s %s\n",datos.getString("nombre"),datos.getInt("genero"),datos.getString("materia"),datos.getDouble("notas"));
            }

            con.close();

        }catch(Exception e){
            System.out.println(e);
        }

        return datosObtenidos;
        
    }

    public void borrarDatos(String datoaborrar,String itemseleccionado ){
        Conexion conexion = new Conexion();

        Connection con =  conexion.get_connection();
        try{
            Statement stm = con.createStatement();

            String query = "";
            

            switch(itemseleccionado){
                case "Materia":
                    query = String.format("delete from tb_asistentes where materia ='%s'",datoaborrar);
                break;
                case "Nombre":
                    query = String.format("delete from tb_asistentes where nombre ='%s'",datoaborrar);
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Por favor seleccione por cual campo desea borrar (Materia ó Nombre)");

            }

           if(!query.equals("") && !datoaborrar.equals("") ){
                stm.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Registro eliminado con exito");
           } else{
                JOptionPane.showMessageDialog(null, "Registro no fue eliminado");
           }
            
           con.close();


        }catch(Exception e){
            System.out.println("Error: "+ e);
        }
        
    }

    public String[] leerDatosAsistente(int id_asistente){

        Conexion conexion = new Conexion();
        
        String datosObtenidos = "";

        Connection con =  conexion.get_connection();
        try{
            Statement stm = con.createStatement();

            String query = String.format("select * from tb_Asistentes where id = %s",id_asistente); 
            
            ResultSet datos = stm.executeQuery(query); 

            while(datos.next()){
                datosObtenidos += String.format("%s %s %s %s\n",datos.getString("nombre"),datos.getInt("genero"),datos.getString("materia"),datos.getDouble("notas"));
            }

            con.close();

        }catch(Exception e){
            System.out.println(e);
        }
        

        return datosObtenidos.split(" ");
        
    }

    public void actualizarRegistros(String nombre, int genero, String materia, float nota,int id){
        Conexion conexion = new Conexion();

        Connection con =  conexion.get_connection();
        try{
            Statement stm = con.createStatement();

            String query = String.format("update tb_asistentes set nombre = '%s', genero = %s, materia = '%s', notas = %s where id = %s",nombre, genero,materia,nota,id); 
            
            stm.executeUpdate(query); 

            con.close();

            JOptionPane.showMessageDialog(null, "Registro actualizado con exito");


        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    public String busquedadeDatos(String nombre,String materia){
        Conexion conexion = new Conexion();

        Connection con =  conexion.get_connection();
        String datosObtenidos="";
        try{
            Statement stm = con.createStatement();

            String query = "";
            String campo = "";
            if(!nombre.equals("") && materia.equals("")){
                campo = "Nombre";
            }else if(!materia.equals("") && nombre.equals("")){
                campo = "Materia";
            }else{
                campo = "MN";
            }

            switch(campo){
                case "Materia":
                    query = String.format("select * from tb_Asistentes where materia = '%s'",materia);
                break;
                case "Nombre":
                    query = String.format("select * from tb_Asistentes where nombre = '%s'",nombre);
                break;
                case "MN":
                    query = String.format("select * from tb_Asistentes where materia = '%s' and nombre = '%s'",materia,nombre);
                break; 
                default:
                    JOptionPane.showMessageDialog(null, "Por favor seleccione por cual campo desea buscar (Materia ó Nombre)");

            }

              ResultSet registros =  stm.executeQuery(query);
             
              while(registros.next()){
                datosObtenidos += String.format("%s %s %s %s\n",registros.getString("nombre"),registros.getInt("genero"),registros.getString("materia"),registros.getDouble("notas"));
            }
            
            
           con.close();


        }catch(Exception e){
            System.out.println("Error: "+ e);
        }

        return datosObtenidos;
        
    }
}