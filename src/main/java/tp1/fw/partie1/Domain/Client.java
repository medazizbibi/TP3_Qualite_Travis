package tp1.fw.partie1.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

    @Id
    private String idClient;

    private String nom;
    private String prenom;
    private String adresse;
    private int telephone;

    private String username;
    private String password;


    @JsonBackReference
    @OneToOne(mappedBy = "client",fetch = FetchType.LAZY)
    Panier panier;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    @JsonManagedReference
    List<Commande> commandes;

    public Client(String idClient, String nom, String prenom, String adresse, int telephone, Panier panier, List<Commande> commandes) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.panier = panier;
        this.commandes = commandes;
    }
}
