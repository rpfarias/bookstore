package com.rafaelfarias.bookstoremanager.books.entity;

import com.rafaelfarias.bookstoremanager.author.entity.Author;
import com.rafaelfarias.bookstoremanager.entity.Auditable;
import com.rafaelfarias.bookstoremanager.publishers.entity.Publisher;
import com.rafaelfarias.bookstoremanager.users.entity.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String isbn;

    // cada vez que add um registro e não informar esse dado, o valordesta coluna vai ser sempre 0
    @Column(columnDefinition = "integer default 0")
    private int pages;

    @Column(columnDefinition = "integer default 0")
    private int chapters;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Author author;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Publisher publisher;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private User user;
}
