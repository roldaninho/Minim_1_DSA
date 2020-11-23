package edu.upc.dsa;

import edu.upc.dsa.models.Laboratorio;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;

public interface Covid19Manager {

    public void enviarMuestra(Muestra muestra);
    public void addPersona(Persona nuevaPersona);
    public String procesarMuestra(int IDLab);
    public void clear();
    public int Size();
    public int nLab();
    public int nMuestras();
    public void nuevoLab(Laboratorio laboratorio);
    public static final int maxlab = 15;

}
