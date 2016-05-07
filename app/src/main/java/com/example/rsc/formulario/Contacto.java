package com.example.rsc.formulario;

import android.content.res.Resources;

import java.util.Date;

/**
 * Created by Silvia on 06/05/2016.
 */
public class Contacto {
    private String nombre;
    private int anio;
    private int mes;
    private int dia;
    private String telefono;
    private String correo;
    private String descripción;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public String fechaToString(){
        String fechaString;
        //fechaString = this.getAnio() + "-" + this.getMes() + "-" + this.getDia();
        String mes = validaMes(this.getMes());
        fechaString = (this.getDia() + " de " + mes + " de " + this.getAnio());
        return fechaString;
    }
    public String validaMes(int mes){
        String stMes = "";

        switch (mes) {
            case 1:
                stMes = "Enero" ;
                break;
            case 2:
                stMes = "Febrero";
                break;
            case 3:
                stMes = "Marzo";
                break;
            case 4:
                stMes = "Abril";
                break;
            case 5:
                stMes = "Mayo";
                break;
            case 6:
                stMes = "Junio";
                break;
            case 7:
                stMes = "Julio";
                break;
            case 8:
                stMes = "Agosto";
                break;
            case 9:
                stMes = "Septiembre";
                break;
            case 10:
                stMes = "Octubre";
                break;
            case 11:
                stMes = "Noviembre";
                break;
            case 12:
                stMes = "Diciembre";
                break;


        }
        return stMes;
    }
}
