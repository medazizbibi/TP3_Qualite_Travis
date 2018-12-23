package tp1.fw.partie1.Services.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp1.fw.partie1.Domain.Livre;
import tp1.fw.partie1.Domain.Models.ModelPromotion;
import tp1.fw.partie1.Domain.Promotion;
import tp1.fw.partie1.Repositories.LivreRepository;
import tp1.fw.partie1.Repositories.PromotionRepository;
import tp1.fw.partie1.Services.Interfaces.IPromotionService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PromotionServiceImpl implements IPromotionService{

    @Autowired
    PromotionRepository promotionRepository;


    @Autowired
    LivreRepository livreRepository;

    @Override
    @Transactional
    public Promotion addPromotion(ModelPromotion modelPromotion) {

        Livre livre= livreRepository.findById(modelPromotion.getIdProduit()).get();

        Promotion promotionToBeAdded= new Promotion(
                UUID.randomUUID().toString(),
                modelPromotion.getDateDebut(),
                modelPromotion.getDureeEnJours(),
                modelPromotion.getPourcentage(),
                livre
                );

        promotionRepository.save(promotionToBeAdded);
        return promotionToBeAdded;
    }

    @Override
    @Transactional
    public Promotion editPromotion(Promotion promotion) {

        promotionRepository.save(promotion);

        return promotion;


    }

    @Override
    @Transactional
    public void deletePromotion(String idPromotion) {

        promotionRepository.deleteById(idPromotion);
    }

    @Override
    @Transactional
    public List<Promotion> getAllPromotion() {

        List<Promotion> result = new ArrayList<>();
        Iterable<Promotion> iter= promotionRepository.findAll();
        for (Promotion p : iter) {
            result.add(p);
        }
        return result;


    }
}
