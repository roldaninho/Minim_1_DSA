package edu.upc.dsa;

import edu.upc.dsa.models.Laboratorio;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class Covid19ManagerImpl implements Covid19Manager {

    private static Covid19Manager instance;
    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);
    private int nLab;
    private int nMuestras;
    private HashMap<Integer, Persona> personas;
    private Laboratorio laboratorios[];


    private  Covid19ManagerImpl(){
        this.personas = new HashMap<Integer, Persona>();
        nLab = 0;
        this.laboratorios = new  Laboratorio[maxlab];
    }

    public static Covid19Manager getInstance(){
        if (instance == null){
            instance = new Covid19ManagerImpl();
        }
        return instance;
    }

    public Laboratorio getLabID(int IDLab){
        Laboratorio laboratorio = new Laboratorio();
        for (int k = 0; k<nLab; k++){
            if(laboratorios[k].getIDLab() == IDLab){
                laboratorio = laboratorios[k];
                break;
            }
        }
        return laboratorio;
    }

    public void nuevoLab(Laboratorio laboratorio){
        laboratorios[nLab] = laboratorio;
        nLab ++;
    }

    @Override
    public void enviarMuestra(Muestra muestra) {

        logger.info(laboratorios);
        logger.debug("Vamos a enviar una muestra");
        Laboratorio laboratorio = getLabID(muestra.getIDlab());
        laboratorio.addMuestra(muestra);
        nMuestras++;
        logger.debug("Hemos enviado la muestra");
        logger.info(laboratorios);

    }

    @Override
    public void addPersona(Persona nuevaPersona) {
        logger.debug("Vamos a añadir persona");
        this.personas.put(nuevaPersona.getID(), nuevaPersona);
        logger.debug("Hemos añadido persona");

    }

    @Override
    public String procesarMuestra(int IDLab) {

        logger.debug("Vamos a procesar una muestra");
        Laboratorio laboratorio = getLabID(IDLab);
        Muestra muestra = laboratorio.analizarMuestra();
        logger.info(muestra);
        int IDPersona = muestra.getIDPersona();
        Persona persona = personas.get(IDPersona); //Utilizamos el diccionario del Hashmap
        persona.anadirMuestra(muestra);
        if(persona.getSalud().equals("A")){
            return ("Resultado: Tu estado de salud es bueno. Comentario: Estás hecho un/una fiera");
        }
        else if(persona.getSalud().equals("B")){
            return ("Resultado: Tu estado de salud es bueno. Comentario: Estás hecho un/una máquina");
        }
        else if(persona.getSalud().equals("C")){
            return ("Resultado: Tu estado de salud es preocupante. Comentario: Deberías acudir a tu centro de salud");
        }
        else
        {
            return ("Resultado: Tu estado de salud es grave. Comentario: Ingreso en UCI");
        }
    }

    @Override
    public void clear() {

        personas.clear();
        laboratorios = new Laboratorio[nLab];
        nMuestras = 0;
        nLab = 0;
        instance = null;

    }

    @Override
    public int Size() {
        return personas.size();
    }

    public int nLab(){
        return this.nLab;
    }

    public int nMuestras(){
        return this.nMuestras;
    }

}
