package edu.upc.dsa.models;

public class Muestra {
    int IDMuestra;
    int IDClinico;
    int IDPersona;
    String fecha;
    int IDlab;

    public Muestra(int IDMuestra, int IDClinico, int IDPersona, String fecha, int IDlab) {
        this.IDMuestra = IDMuestra;
        this.IDClinico = IDClinico;
        this.IDPersona = IDPersona;
        this.fecha = fecha;
        this.IDlab = IDlab;
    }

    public Muestra(int IDMuestra) {
        this.IDMuestra = IDMuestra;
    }

    public int getIDMuestra() {
        return IDMuestra;
    }

    public void setIDMuestra(int IDMuestra) {
        this.IDMuestra = IDMuestra;
    }

    public int getIDClinico() {
        return IDClinico;
    }

    public void setIDClinico(int IDClinico) {
        this.IDClinico = IDClinico;
    }

    public int getIDPersona() {
        return IDPersona;
    }

    public void setIDPersona(int IDPersona) {
        this.IDPersona = IDPersona;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIDlab() {
        return IDlab;
    }

    public void setIDlab(int IDlab) {
        this.IDlab = IDlab;
    }

}
