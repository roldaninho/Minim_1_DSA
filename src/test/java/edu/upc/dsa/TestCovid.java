package edu.upc.dsa;
import edu.upc.dsa.models.Laboratorio;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TestCovid {

    private Covid19Manager covid;

    @Before
    public void setCovid() throws Exception{
        this.covid = Covid19ManagerImpl.getInstance();

        this.covid.addPersona(new Persona(1, "Marc", "Roldán", 21, "B"));
        this.covid.addPersona(new Persona(2, "Carme", "Forcadell", 56, "A"));
        this.covid.addPersona(new Persona(3, "Ernet", "Lluch", 78, "D"));
        this.covid.addPersona(new Persona(4, "Marta", "Sánchez", 57, "C"));
        this.covid.addPersona(new Persona(5, "Quim", "Torra", 60, "C"));

        Muestra muestra = new Muestra(1, 1, 1, "12/12/2019", 1);

        this.covid.nuevoLab(new Laboratorio("CAP Sant Just"));
        this.covid.nuevoLab(new Laboratorio("CAP Esplugues"));
        this.covid.nuevoLab(new Laboratorio("Hospital Moisses Broggi"));
        this.covid.nuevoLab(new Laboratorio("CAP Castelldefels"));
    }

    @After
    public void tearDown(){
        this.covid.clear();
    }

    @Test
    public void setPersona(){

        this.covid.addPersona(new Persona(6, "Carlos", "Smith", 31, "A"));
        Assert.assertEquals(6, this.covid.Size());
    }

    @Test
    public void procesarMuestra(){

        Muestra muestra = new Muestra(1, 1, 1, "12/12/2019", 1);
        this.covid.enviarMuestra(muestra);
        this.covid.procesarMuestra(1);
        Assert.assertEquals(2,this.covid.nMuestras());

    }

}
