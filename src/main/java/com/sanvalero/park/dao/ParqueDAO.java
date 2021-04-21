package com.sanvalero.park.dao;

import com.sanvalero.park.domain.Parque;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParqueDAO {

    private static Conexion conexion;

    public ParqueDAO(Conexion conexion) {
        ParqueDAO.conexion = conexion;
    }

    public void registrarParque(Parque parque) throws SQLException {
        String sql = "INSERT INTO parque (cod_parque, codi_ciudad, codi_ccaa, nombre_parque, extension_m2) VALUES (?,?,?,?,?)";

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(sql);//Es un objeto que representa una sentencia sql
        sentencia.setInt(1, parque.getCod_parque());
        sentencia.setInt(2, parque.getCodi_ciudad());
        sentencia.setInt(3, parque.getCodi_ccaa());
        sentencia.setString(4, parque.getNombre_parque());
        sentencia.setInt(5, parque.getExtension_m2());
        sentencia.executeUpdate();//Los insert,los updates y los deletes se ejeutan con executeUpdate
    }


    // Todo Falta terminarlo no completado
    public void modificarParque(Parque parque) throws SQLException {  //Lanza el fallo a modificarParque de la clase Parque
        String sql = "UPDATE parque SET nombre_parque  = ?  WHERE cod_parque =?";

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(sql);
        sentencia.setString(1, parque.getNombre_parque());
        sentencia.setInt(2, parque.getCod_parque());

        sentencia.executeUpdate();
    }

    public static void eliminarParque(int cod_parque) throws SQLException {
        String sql = "DELETE FROM parque WHERE cod_parque= ?";

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(sql);
        sentencia.setString(1, String.valueOf(cod_parque));
        sentencia.executeUpdate();
    }


    public ArrayList<Parque> obtenerParquesCiudad(int cadenaBusqueda) throws SQLException {
        String sql = "SELECT  nombre_parque FROM parque where codi_ciudad= ?";
        //Recorremos todo el resultado de la tabla
        ArrayList<Parque> parques = new ArrayList<>();

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(sql);
        //Un ResultSet, o conjunto de resultados, contiene los resultados de una consulta SQL
        sentencia.setInt(1, cadenaBusqueda);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {//con next apuntamos a una fila nueva
            Parque parque= new Parque();

            parque.setNombre_parque(resultado.getString(1));


            parques.add(parque);
        }
        //Tengo un array list co tantos objetos  como filas hay en la tabla oosea todos los coches de la tabla
        return parques;
    }
    public ArrayList<Parque> obtenerParquesCcaa(int cadenaBusqueda2) throws SQLException {
        String sql = "SELECT  nombre_parque FROM parque where codi_ccaa= ?";
        //Recorremos todo el resultado de la tabla
        ArrayList<Parque> parques = new ArrayList<>();

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(sql);
        //Un ResultSet, o conjunto de resultados, contiene los resultados de una consulta SQL
        sentencia.setInt(1, cadenaBusqueda2);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {//con next apuntamos a una fila nueva
            Parque parque= new Parque();
            //id
            parque.setNombre_parque(resultado.getString(1));


            parques.add(parque);
        }
         return parques;
    }

    public int Total(int cadenaBusqueda2) throws SQLException {
        String sql = "SELECT COUNT(*) FROM parques";
        int cantidad = 0;
        ArrayList<Parque> parques = new ArrayList<>();
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(sql);
        //Un ResultSet, o conjunto de resultados, contiene los resultados de una consulta SQL
        sentencia.setInt(1, cadenaBusqueda2);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {//con next apuntamos a una fila nueva
            Parque parque= new Parque();
            //id
            parque.setNombre_parque(resultado.getString(1));


            parques.add(parque);
        }

        return cantidad;
    }

    public int Total() {
        return 0;
    }
}

