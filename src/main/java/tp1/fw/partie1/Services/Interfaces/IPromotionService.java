package tp1.fw.partie1.Services.Interfaces;

import tp1.fw.partie1.Domain.Models.ModelPromotion;
import tp1.fw.partie1.Domain.Promotion;

import java.util.List;

public interface IPromotionService {

    public Promotion addPromotion(ModelPromotion modelPromotion);
    public Promotion editPromotion(Promotion promotion);
    public void deletePromotion(String idPromotion);
    public List<Promotion> getAllPromotion();


}
