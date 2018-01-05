package projekt.inz.pojo;
// Generated 2018-01-05 19:10:37 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Doktor generated by hbm2java
 */
@Entity
@Table(name="doktor"
    ,catalog="inz"
)
public class Doktor  implements java.io.Serializable {


     private Integer idDoktor;
     private String imie;
     private String nazwisko;
     private String specjalnosc;
     private String login;
     private String haslo;
     private String email;
     private Set<Artykul> artykuls = new HashSet<Artykul>(0);
     private Set<Recepta> receptas = new HashSet<Recepta>(0);
     private Set<Skrzynka> skrzynkas = new HashSet<Skrzynka>(0);
     private Set<Wizyta> wizytas = new HashSet<Wizyta>(0);

    public Doktor() {
    }

	
    public Doktor(String imie, String nazwisko, String specjalnosc, String login, String haslo, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.specjalnosc = specjalnosc;
        this.login = login;
        this.haslo = haslo;
        this.email = email;
    }
    public Doktor(String imie, String nazwisko, String specjalnosc, String login, String haslo, String email, Set<Artykul> artykuls, Set<Recepta> receptas, Set<Skrzynka> skrzynkas, Set<Wizyta> wizytas) {
       this.imie = imie;
       this.nazwisko = nazwisko;
       this.specjalnosc = specjalnosc;
       this.login = login;
       this.haslo = haslo;
       this.email = email;
       this.artykuls = artykuls;
       this.receptas = receptas;
       this.skrzynkas = skrzynkas;
       this.wizytas = wizytas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_doktor", unique=true, nullable=false)
    public Integer getIdDoktor() {
        return this.idDoktor;
    }
    
    public void setIdDoktor(Integer idDoktor) {
        this.idDoktor = idDoktor;
    }

    
    @Column(name="imie", nullable=false, length=30)
    public String getImie() {
        return this.imie;
    }
    
    public void setImie(String imie) {
        this.imie = imie;
    }

    
    @Column(name="nazwisko", nullable=false, length=30)
    public String getNazwisko() {
        return this.nazwisko;
    }
    
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    
    @Column(name="specjalnosc", nullable=false, length=30)
    public String getSpecjalnosc() {
        return this.specjalnosc;
    }
    
    public void setSpecjalnosc(String specjalnosc) {
        this.specjalnosc = specjalnosc;
    }

    
    @Column(name="login", nullable=false, length=30)
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="haslo", nullable=false, length=30)
    public String getHaslo() {
        return this.haslo;
    }
    
    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    
    @Column(name="email", nullable=false, length=30)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="doktor")
    public Set<Artykul> getArtykuls() {
        return this.artykuls;
    }
    
    public void setArtykuls(Set<Artykul> artykuls) {
        this.artykuls = artykuls;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="doktor")
    public Set<Recepta> getReceptas() {
        return this.receptas;
    }
    
    public void setReceptas(Set<Recepta> receptas) {
        this.receptas = receptas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="doktor")
    public Set<Skrzynka> getSkrzynkas() {
        return this.skrzynkas;
    }
    
    public void setSkrzynkas(Set<Skrzynka> skrzynkas) {
        this.skrzynkas = skrzynkas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="doktor")
    public Set<Wizyta> getWizytas() {
        return this.wizytas;
    }
    
    public void setWizytas(Set<Wizyta> wizytas) {
        this.wizytas = wizytas;
    }




}


