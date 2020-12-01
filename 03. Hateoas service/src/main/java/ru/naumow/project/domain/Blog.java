package ru.naumow.project.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = { "posts", "subscriptions" })
@ToString(exclude = {"posts", "subscriptions"})
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "blog")
    private Set<Post> posts;

    @OneToMany(mappedBy = "blog")
    private Set<Subscription> subscriptions;

}
