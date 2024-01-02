package com.bookstore.bookstoremanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyBookList {
    @Id
    private Long id;
    private String name;
    private String author;
    private String price;

}
