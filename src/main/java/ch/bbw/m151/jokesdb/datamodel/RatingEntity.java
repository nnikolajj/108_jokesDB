package ch.bbw.m151.jokesdb.datamodel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
@Getter
@Setter
public class RatingEntity {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = true, length = 500)
    int rating;
    int jokeId;
}
