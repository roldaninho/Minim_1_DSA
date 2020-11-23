package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.Queue;

public class Laboratorio {
    String nombre;
    int IDLab;
    Queue<Muestra> listaCola;

    public Laboratorio(String nombre) {
        this.nombre = nombre;
        this.listaCola = new LinkedList<Muestra>();
    }

    public Laboratorio() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIDLab() {
        return IDLab;
    }

    public void setIDLab(int IDLab) {
        this.IDLab = IDLab;
    }

    public void addMuestra(Muestra nueva)
    {
        this.listaCola.add(nueva);
    }

    public Muestra analizarMuestra(){
        return this.listaCola.poll();
    }


}
