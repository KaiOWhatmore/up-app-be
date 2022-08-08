package com.upApp.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transactions {

    @Id
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "message")
    private String message;

    @Column(name = "amount")
    private String amount;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "settled_at")
    private String settledAt;

    @Column(name = "category")
    private String category;

    @Column(name = "parent_category")
    private String parentCategory;

}
