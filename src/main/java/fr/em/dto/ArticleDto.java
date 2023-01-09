package fr.em.dto;

import fr.em.entities.ArticleEntity;
import fr.em.entities.EditeurEntity;
import fr.em.entities.GenreEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ArticleDto {
    private String ean13;
    private BigDecimal prixAchat;
    private String titre;

    @Getter
    @Setter
    private class Genre {
        int id;
        String nom;
        public Genre(GenreEntity genreEntity) {
            id = genreEntity.getIdGenre();
            nom = genreEntity.getNomGenre();
        }
    }

    @Getter
    @Setter
    private class Editeur {
        int id;
        String nom;
        public Editeur(EditeurEntity editeurEntity) {
            id = editeurEntity.getIdEditeur();
            nom = editeurEntity.getNomEditeur();
        }
    }

    public ArticleDto(ArticleEntity articleEntity) {
        this.ean13 = articleEntity.getEan13();
        this.titre = articleEntity.getTitre();
        this.prixAchat = articleEntity.getPrixAchat();
    }

    private List<Genre> toGenreList(List<GenreEntity> genres) {
        List<Genre> liste = new ArrayList<>();
        for (GenreEntity genre : genres) {
            liste.add(new Genre(genre));
        }
        return liste;
    }

    public static List<ArticleDto> toArticleDto(List<ArticleEntity> articleEntities) {
        List<ArticleDto> articleDtos = new ArrayList<>();
        for (ArticleEntity articleEntity : articleEntities) {
            articleDtos.add(new ArticleDto(articleEntity));
        }
        return articleDtos;
    }

}
