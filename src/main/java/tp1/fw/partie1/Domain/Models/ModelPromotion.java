package tp1.fw.partie1.Domain.Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModelPromotion {

    private String dateDebut;
    private int dureeEnJours;
    private double pourcentage;
    private String idProduit;
}
