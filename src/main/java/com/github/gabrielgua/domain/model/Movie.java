package com.github.gabrielgua.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;
import java.util.HashMap;

@Data
@Entity
@Table(name = "movies")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Movie {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "release_date")
    private OffsetDateTime releaseDate;

    private int rating;

    private String genre;

    private String producer;

    public String getClassification() {
        var classification = new HashMap<Integer, String>() {{
            put(1, "Esse é ruim demais!");
            put(2, "Ok!");
            put(3, "Bom!");
            put(4, "Excelente");
            put(5, "Absolute Cinema!");
        }};

        return classification.get(this.rating);
    }
}
