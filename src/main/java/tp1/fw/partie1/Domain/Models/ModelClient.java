package tp1.fw.partie1.Domain.Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModelClient {
    private String nom;
    private String prenom;
    private String adresse;
    private int telephone;

}
