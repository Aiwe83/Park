
package com.sanvalero.park.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection conexion;//Esta es la variable mas importante por la conexion
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL_CONEXION = "jdbc:mysql://localhost:3306/parques";
//    private final String URL_CONEXION = "jdbc:oracle:thin@localhost:1521:taller";
    private final String USUARIO = "root";
    private final String CONTRASENA = "1983";
    
    public Conexion() {
        
    }
    
    public Connection getConexion() {
        return conexion;
    }
    
    public void conectar() {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL_CONEXION, USUARIO, CONTRASENA);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();//Aqui pinto la traza de la excepcion
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
