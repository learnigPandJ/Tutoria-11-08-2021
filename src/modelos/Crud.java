package modelos;

import java.sql.Connection;
import java.sql.Statement;
import config.Conexion;


public class Crud{

    public void insertarDatos(String nombre, int genero, String materia, float nota){
        Conexion conexion = new Conexion();

        Connection con =  conexion.conectar();
        try{
            Statement stm = con.createStatement();

            String query = String.format("insert into tb_asistentes (nombre,genero,materia,notas) values ('%s',%s,'%s',%s)",nombre, genero,materia,nota); 
            
            stm.executeUpdate(query); 

            con.close();

        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}