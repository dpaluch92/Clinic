package projekt.inz.pojo;
// Generated 2017-11-18 19:09:28 by Hibernate Tools 4.3.1



/**
 * Uslugi generated by hbm2java
 */
public class Uslugi  implements java.io.Serializable {


     private Integer idUslugi;
     private String opis;
     private int cena;

    public Uslugi() {
    }

	
    public Uslugi(String opis, int cena) {
        this.opis = opis;
        this.cena = cena;
    }
   
    public Integer getIdUslugi() {
        return this.idUslugi;
    }
    
    public void setIdUslugi(Integer idUslugi) {
        this.idUslugi = idUslugi;
    }
    public String getOpis() {
        return this.opis;
    }
    
    public void setOpis(String opis) {
        this.opis = opis;
    }
    public int getCena() {
        return this.cena;
    }
    
    public void setCena(int cena) {
        this.cena = cena;
    }
}


