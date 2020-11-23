package edu.upc.dsa.models;

import java.util.LinkedList;

public class Persona {
    int ID;
    String nombre;
    String apellido;
    int edad;
    String salud; //A, B, C o D
    LinkedList<Muestra> muestrasPersona;

    public Persona(int ID, String nombre, String apellido, int edad, String salud) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salud = salud;
        this.muestrasPersona = new LinkedList<Muestra>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSalud() {
        return salud;
    }

    public void setSalud(String salud) {
        this.salud = salud;
    }

    public void anadirMuestra(Muestra muestra){
        this.muestrasPersona.add(muestra);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", salud='" + salud + '\'' +
                ", muestrasPersona=" + muestrasPersona +
                '}';
    }
}
