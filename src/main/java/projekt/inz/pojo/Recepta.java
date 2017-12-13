package projekt.inz.pojo;
// Generated 2017-12-08 19:01:26 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Recepta generated by hbm2java
 */
@Entity
@Table(name = "recepta", catalog = "inz"
)
public class Recepta implements java.io.Serializable {

    private int idRecepty;
    private Doktor doktor;
    private Pacjent pacjent;
    private String przepisanieRecepty;

    public Recepta() {
    }

    public Recepta(Doktor doktor, Pacjent pacjent, String przepisanieRecepty) {
        this.doktor = doktor;
        this.pacjent = pacjent;
        this.przepisanieRecepty = przepisanieRecepty;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id_recepty", unique = true, nullable = false)
    public int getIdRecepty() {
        return this.idRecepty;
    }

    public void setIdRecepty(int idRecepty) {
        this.idRecepty = idRecepty;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doktora_fk", nullable = false)
    public Doktor getDoktor() {
        return this.doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pacjenta_fk", nullable = false)
    public Pacjent getPacjent() {
        return this.pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    @Column(name = "przepisanie_recepty", nullable = false, length = 250)
    public String getPrzepisanieRecepty() {
        return this.przepisanieRecepty;
    }

    public void setPrzepisanieRecepty(String przepisanieRecepty) {
        this.przepisanieRecepty = przepisanieRecepty;
    }

}
