package ubo.fr.entities;
import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name="Utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String Nom;
    private String Prenom;
    private Date Date_naissance;

    public Utilisateur(int idUtilisateur, String nom, String prenom, Date date_naissance) {
        this.userId = idUtilisateur;
        Nom = nom;
        Prenom = prenom;
        this.Date_naissance = date_naissance;
    }
    public Utilisateur() {}
    public Integer getIdUtilisateur() {
        return userId;
    }
    public void setIdUtilisateur(Integer id) {
        this.userId = id;
    }

    @Column(name = "Nom", nullable = false)
    public String getNom() {
        return Nom;
    }
    public void setNom(String firstname) {
        this.Nom = firstname;
    }

    @Column(name = "Prenom", nullable = false)
    public String getPrenom() {
        return Prenom;
    }
    public void setPrenom(String lastname) {
        this.Prenom = lastname;
    }
    public void setDate_naissance(Date date_naissance) {
        this.Date_naissance = date_naissance;
    }

    @Column(name = "Date_naissance", nullable = false)
    public Date getDate_naissance() {
        return Date_naissance;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "userId=" + userId +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", Date_naissance=" + Date_naissance +
                '}';
    }
}
