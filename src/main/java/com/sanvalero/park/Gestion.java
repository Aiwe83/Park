package com.sanvalero.park;

import com.sanvalero.park.dao.ParqueDAO;
import com.sanvalero.park.dao.Conexion;
import com.sanvalero.park.domain.Parque;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {

    private boolean salir;
    private Scanner teclado;
    private Conexion conexion;
    private ParqueDAO parqueDAO;

    //Esta clase es para hablar con el usuario
    public Gestion() {
        salir = false;
        teclado = new Scanner(System.in);
        conexion = new Conexion();
        conexion.conectar();
        //Le pasa el objeto conexion para que pueda hablar con la base de datos
        parqueDAO = new ParqueDAO(conexion);
    }

    public void ejecutar() {
        do {// Haz
            System.out.println("_________________||Parques de España||____________  ");
            System.out.println("                          Menú                      ");
            System.out.println("Aplicación GesTaller v0.1");
            System.out.println("1.Consulta el nombre de  los parques parques por codigo ciudad");
            System.out.println("2.Consulta el nombre de los parque  por codigo de CCAA");
            System.out.println("3.Registrar Parques");
            System.out.println("4.Actualizar informacion del los parques");
            System.out.println("5.Eliminar Parque");
            System.out.println("x.Salir del programa");
            System.out.print("Selecciona: ");

            String opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    verParquesCiudad();//Todo no es el metodo para la pregunta
                    break;
                case "2":
                    verParquesCcaa();//Todo  no el metedo para la pregunta
                    break;
                case "3":
                    registrarParque();
                    break;
                case "4":
                    modificarParque();
                    break;
                case "5":
                    eliminarParque();
                    break;
                case "6":
                    obtenerCantidadTotal();//Todo hay que hacer elmetodo
                    break;
                case "x":
                    salir();
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (!salir);//Mientras no se cierre
    }


    //Presentar informacion al usuario
    //Comunicar con la base de datos
    private void verParquesCiudad() {
        System.out.println("cod_parque? entre 1-20: ");
        int cod_parque = Integer.parseInt(teclado.nextLine());
        try {
            ArrayList<Parque> parques = parqueDAO.obtenerParquesCiudad(cod_parque);
            for (Parque parque : parques) {//"For each mejorado" recorre la coleccion completa coche a coche
                System.out.println(parque);
            }
        } catch (SQLException sqle) {
            System.out.println("Se ha producido un problema leyendo los datos");
            sqle.printStackTrace();
        }
    }

    private void verParquesCcaa() {
        System.out.println("cod_ccaa?: ");
        int codi_ccaa = Integer.parseInt(teclado.nextLine());
        try {
            ArrayList<Parque> parques = parqueDAO.obtenerParquesCcaa(codi_ccaa);
            for (Parque parque : parques) {//"For each mejorado" recorre la coleccion completa coche a coche
                System.out.println(parque);
            }
        } catch (SQLException sqle) {
            System.out.println("Se ha producido un problema leyendo los datos");
            sqle.printStackTrace();
        }
    }
    //Preguntar informacion al usuario
    //Comunicar con la base de datos
    //Confirmar al usuario

    private void registrarParque() {

        System.out.println("cod_parque?: ");
        int cod_parque = Integer.parseInt(teclado.nextLine());
        System.out.println("codi_ciudad?: ");
        int codi_ciudad = Integer.parseInt(teclado.nextLine());
        System.out.println("codi_ccaa?: ");
        int codi_ccaa = Integer.parseInt(teclado.nextLine());
        System.out.println("nombre_parque?: ");
        String nombre_parque = teclado.nextLine();
        System.out.println("extension_m2?: ");
        int extension_m2 = Integer.parseInt(teclado.nextLine());
        // TODO Solicitar el resto de campos
        Parque parque = new Parque();
        parque.setCod_parque(cod_parque);
        parque.setCodi_ciudad(codi_ciudad);
        parque.setCodi_ccaa(codi_ccaa);
        parque.setNombre_parque(nombre_parque);
        parque.setExtension_m2(extension_m2);

        try {
            parqueDAO.registrarParque(parque);
            System.out.println("El parque se ha registrado correctamente");
        } catch (SQLException sqle) {
            System.out.println("Se ha producido un problema. Inténtelo de nuevo");
            sqle.printStackTrace();
        }
    }

    private void modificarParque() {//Todo Metodo no completado completar cuanto antes

        System.out.println("nombre_parque?: ");
        String nombre_parque = teclado.nextLine();
        System.out.println("cod_parque?: ");
        int cod_parque = Integer.parseInt(teclado.nextLine());

        // TODO Solicitar el resto de campos
        Parque parque = new Parque();
        parque.setNombre_parque(nombre_parque);
        parque.setCod_parque(cod_parque);


        try {//Aca se atrapa la excepcion del metodo modificarParque de la clase ParqueDAO
            parqueDAO.modificarParque(parque);//lo conecta con la la base de datos parquesDAO
            System.out.println("El coche se ha modificado correctamente");
        } catch (SQLException sqle) {
            System.out.println("Se ha producido un problema. Inténtelo de nuevo");
            sqle.printStackTrace();
        }
    }

    private void eliminarParque() {
        System.out.println("cod_parque?: ");
        int cod_parque = Integer.parseInt(teclado.nextLine());

        Parque parque = new Parque();

        parque.setCod_parque(cod_parque);


        try {
            ParqueDAO.eliminarParque(cod_parque);
            System.out.println("El coche se ha eliminado correctamente");
        } catch (SQLException sqle) {
            System.out.println("Se ha producido un problema. Inténtelo de nuevo");
            sqle.printStackTrace();
        }
    }

    private void obtenerCantidadTotal() {

    }

    private void salir() {
        salir = true;
    }
}

