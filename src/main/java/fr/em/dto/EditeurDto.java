package fr.em.dto;

import fr.em.entities.ArticleEntity;
import fr.em.entities.EditeurEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class EditeurDto {

    private int id;
    private String nom;
    private List<Article> articles;

    @Getter
    @Setter
    private class Article {

        String ean13;
        BigDecimal prixAchat;
        String titre;

        public Article(ArticleEntity articleEntity) {
            ean13 = articleEntity.getEan13();
            prixAchat = articleEntity.getPrixAchat();
            titre = articleEntity.getTitre();
        }
    }

    public EditeurDto(EditeurEntity editeurEntity) {
        this.id = editeurEntity.getIdEditeur();
        this.nom = editeurEntity.getNomEditeur();
        //this.articles = toArticleList(editeurEntity.getArticles());
    }

    private List<Article> toArticleList(List<ArticleEntity> articles) {
        List<Article> liste = new ArrayList<>();
        for (ArticleEntity article : articles){
            liste.add(new Article(article));
        }
        return liste;
    }

    public static List<EditeurDto> toEditeurDto(List<EditeurEntity> editeurEntities) {
        List<EditeurDto> editeurDtos = new ArrayList<>();
        for (EditeurEntity editeurEntity : editeurEntities)
        {
            editeurDtos.add(new EditeurDto(editeurEntity));
        }
        return editeurDtos;
    }
}
