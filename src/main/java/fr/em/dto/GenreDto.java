package fr.em.dto;


import fr.em.entities.ArticleEntity;
import fr.em.entities.GenreEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class GenreDto {

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

    public GenreDto(GenreEntity genreEntity) {
        this.id = genreEntity.getIdGenre();
        this.nom = genreEntity.getNomGenre();
        //this.articles = toArticle(genreEntity.getArticles());
    }

    private List<Article> toArticle(List<ArticleEntity> articles) {
        List<Article> liste = new ArrayList<>();
        for (ArticleEntity article : articles){
            liste.add(new Article(article));
        }
        return liste;
    }

    public static List<GenreDto> toGenreDto(List<GenreEntity> genreEntities) {
        List<GenreDto> genreDtos = new ArrayList<>();
        for (GenreEntity genreEntity : genreEntities)
        {
            genreDtos.add(new GenreDto(genreEntity));
        }
        return genreDtos;
    }
}
