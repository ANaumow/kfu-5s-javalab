package ru.naumow.project.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

}
