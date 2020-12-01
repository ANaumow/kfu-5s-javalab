package ru.naumow.project.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Account author;

    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
