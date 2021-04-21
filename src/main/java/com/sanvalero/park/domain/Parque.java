package com.sanvalero.park.domain;

import java.util.Objects;

public class Parque {

    private int cod_parque;
    private int codi_ciudad;
    private int codi_ccaa;
    private String nombre_parque;
    private int extension_m2;

    public Parque() {
    }

    public int getCod_parque() {
        return cod_parque;
    }

    public void setCod_parque(int cod_parque) {
        this.cod_parque = cod_parque;
    }

    public int getCodi_ciudad() {
        return codi_ciudad;
    }

    public void setCodi_ciudad(int codi_ciudad) {
        this.codi_ciudad = codi_ciudad;
    }

    public int getCodi_ccaa() {
        return codi_ccaa;
    }

    public void setCodi_ccaa(int codi_ccaa) {
        this.codi_ccaa = codi_ccaa;
    }

    public String getNombre_parque() {
        return nombre_parque;
    }

    public void setNombre_parque(String nombre_parque) {
        this.nombre_parque = nombre_parque;
    }

    public int getExtension_m2() {
        return extension_m2;
    }

    public void setExtension_m2(int extension_m2) {
        this.extension_m2 = extension_m2;
    }

    @Override
    public String toString() {
        return "Parque{" +
                "cod_parque=" + cod_parque +
                ", codi_ciudad=" + codi_ciudad +
                ", codi_ccaa=" + codi_ccaa +
                ", nombre_parque='" + nombre_parque + '\'' +
                ", extension_m2=" + extension_m2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parque parque = (Parque) o;
        return cod_parque == parque.cod_parque && codi_ciudad == parque.codi_ciudad && codi_ccaa == parque.codi_ccaa && extension_m2 == parque.extension_m2 && Objects.equals(nombre_parque, parque.nombre_parque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_parque, codi_ciudad, codi_ccaa, nombre_parque, extension_m2);
    }
}