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
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Data
public class BookLombok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(lazy = true, value = AccessLevel.PUBLIC) @Setter private Long id;
    
    @Column(nullable = false, unique = true)
    @NonNull
    private @Setter @Getter String title;

    @Column(updatable = false, nullable = false)
    @NonNull
    private @Getter String author;

    public BookLombok(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
}
