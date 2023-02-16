package com.duyhelloworld.baedungfirstwebapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(lazy = true, value = AccessLevel.PUBLIC) @Setter private Long id;
    
    @Column(nullable = false, unique = true)
    private @Setter @Getter String title;

    @Column(updatable = false, nullable = false)
    private @Getter String author;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
}
