package projekt.inz.pojo;
// Generated 2018-01-05 19:10:37 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Recepta generated by hbm2java
 */
@Entity
@Table(name="recepta"
    ,catalog="inz"
)
public class Recepta  implements java.io.Serializable {


     private Integer idRecepty;
     private Doktor doktor;
     private Pacjent pacjent;
     private String przepisanieRecepty;
     private Date dataWydania;

    public Recepta() {
    }

    public Recepta(Doktor doktor, Pacjent pacjent, String przepisanieRecepty, Date dataWydania) {
       this.doktor = doktor;
       this.pacjent = pacjent;
       this.przepisanieRecepty = przepisanieRecepty;
       this.dataWydania = dataWydania;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_recepty", unique=true, nullable=false)
    public Integer getIdRecepty() {
        return this.idRecepty;
    }
    
    public void setIdRecepty(Integer idRecepty) {
        this.idRecepty = idRecepty;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_doktora_fk", nullable=false)
    public Doktor getDoktor() {
        return this.doktor;
    }
    
    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_pacjenta_fk", nullable=false)
    public Pacjent getPacjent() {
        return this.pacjent;
    }
    
    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    
    @Column(name="przepisanie_recepty", nullable=false, length=250)
    public String getPrzepisanieRecepty() {
        return this.przepisanieRecepty;
    }
    
    public void setPrzepisanieRecepty(String przepisanieRecepty) {
        this.przepisanieRecepty = przepisanieRecepty;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_wydania", nullable=false, length=19)
    public Date getDataWydania() {
        return this.dataWydania;
    }
    
    public void setDataWydania(Date dataWydania) {
        this.dataWydania = dataWydania;
    }




}


