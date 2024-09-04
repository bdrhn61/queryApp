package com.project.jwt_authentication.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name="post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)  // FetchType.LAZY // post objesi çekildeiğinde ilgili user ı getirme
    @JoinColumn(name="user_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE) // bir user silindiğinde ilgili bütün postlarını siler
    User user;

    String title;

    String text;

    @Temporal(TemporalType.TIMESTAMP)
    Date createDate;
}