import lombok.Getter;
import lombok.Setter;

public class Customers {
    private String nom;
    private String prenom;
    private String numeroDeTel;
    private String email;
    private  int dateDeNaissanc;

    public Customers(String nom, String prenom, String numeroDeTel, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroDeTel = numeroDeTel;
        this.email = email;
        this.dateDeNaissanc = dateDeNaissanc;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumeroDeTel() {
        return numeroDeTel;
    }

    public void setNumeroDeTel(String numeroDeTel) {
        this.numeroDeTel = numeroDeTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDateDeNaissanc() {
        return dateDeNaissanc;
    }

    public void setDateDeNaissanc(int dateDeNaissanc) {
        this.dateDeNaissanc = dateDeNaissanc;
    }

}
