package modelos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import config.Conexion;


public class Crud{

    public void insertarDatos(String nombre, int genero, String materia, float nota){
        Conexion conexion = new Conexion();

        Connection con =  conexion.get_connection();
        try{
            Statement stm = con.createStatement();

            String query = String.format("insert into tb_asistentes (nombre,genero,materia,notas) values ('%s',%s,'%s',%s)",nombre, genero,materia,nota); 
            
            stm.executeUpdate(query); 

            con.close();

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
}