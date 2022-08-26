package fr.eni.springtpeniencheres.service.impl;

import fr.eni.springtpeniencheres.bo.Article;
import fr.eni.springtpeniencheres.bo.Enchere;
import fr.eni.springtpeniencheres.bo.Utilisateur;
import fr.eni.springtpeniencheres.repository.EnchereRepository;
import fr.eni.springtpeniencheres.service.ArticleService;
import fr.eni.springtpeniencheres.service.EnchereService;
import fr.eni.springtpeniencheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EnchereServiceJpaImpl implements EnchereService {

   @Autowired
   private EnchereRepository enchereRepository;

   @Autowired
   private ArticleService articleService;

   @Autowired
   private UtilisateurService utilisateurService;

    @Override
    public void addEnchere(Enchere enchere) throws Exception {

        LocalDate dateFinEnchere = articleService.getArticleById(enchere.getArticle().getNoArticle()).getDateFinEncheres();

        Enchere previewEnchere = getLastEnchere(enchere.getArticle().getNoArticle());

        System.out.println(hasEnoughCredit(enchere.getEncherisseur(), enchere));

        Utilisateur utilisateurChoisi = utilisateurService.getUtilisateurById(enchere.getEncherisseur().getNoUtilisateur());

        //Controlle enchere précedente
        if (getLastEnchere(enchere.getArticle().getNoArticle()) == null || isNewHighest(enchere)){

            if (checkDateEnchere(enchere.getDateEnchere(),dateFinEnchere) && hasEnoughCredit(utilisateurChoisi, enchere)){

                System.out.println("ca marche !");

                utilisateurChoisi.setCredit(utilisateurChoisi.getCredit() - enchere.getMontantEnchere());
                utilisateurService.updateUtilisateur(utilisateurChoisi);

                if (previewEnchere != null){
                    Utilisateur previewBidder = previewEnchere.getEncherisseur();
                    previewBidder.setCredit(previewBidder.getCredit() + previewEnchere.getMontantEnchere());
                    utilisateurService.updateUtilisateur(previewBidder);
                }

                enchereRepository.save(enchere);
            }else {
                System.out.println("ca marche pas");
            }

        }

    }

    @Override
    public List<Enchere> listeEnchere() {
        return enchereRepository.findAll();
    }

    @Override
    public Enchere getEnchereById(long id) {
        return enchereRepository.findById(id).get();
    }

    @Override
    public List<Enchere> getEncheresByArticle(Article article) {
        return enchereRepository.findByArticle(article);
    }

    @Override
    public Enchere getLastEnchere(long id) {
        return enchereRepository.findFirstByArticleNoArticleOrderByMontantEnchereDesc(id);
    }

    @Override
    public boolean checkDateEnchere(LocalDateTime dateCreaEnchere, LocalDate dateFinEnchere) {

        boolean res = false;

        if (dateFinEnchere.isAfter(toDate(dateCreaEnchere)) || toDate(dateCreaEnchere).isEqual(dateFinEnchere)){

            res = true;
        }

        return res;
    }

    public boolean isNewHighest(Enchere newEnchere){
        boolean res = false;


            if (getLastEnchere(newEnchere.getArticle().getNoArticle()).getMontantEnchere() < newEnchere.getMontantEnchere()){

                res = true;

            }


        return res;
    }

    public boolean hasEnoughCredit(Utilisateur bidder, Enchere enchere){
        boolean res = false;

        System.out.println(bidder);
        System.out.println(enchere.getMontantEnchere());

        if ( bidder.getCredit() >= enchere.getMontantEnchere() ){
            res = true;
        }

        return res;
    }

    public static LocalDate toDate(LocalDateTime dateCreaEnchere) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateConvertie = dateCreaEnchere.format(DateTimeFormatter.ISO_LOCAL_DATE);

        return LocalDate.parse(dateConvertie,formatter);
    }



}
