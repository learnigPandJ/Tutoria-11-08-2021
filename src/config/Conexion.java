package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection conexion;

    public Connection conectar(){
        String url = "jdbc:sqlite:basededatos/dbtutoria.db";
        try{
            conexion = DriverManager.getConnection(url);
            System.out.println("Conexion exitosa");

        }catch(SQLException e){
            System.out.println("Error: "+e);
        }


        return conexion;
    }
    
}
