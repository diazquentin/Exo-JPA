package galerie.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity

public class Tableau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NonNull
    String titre;

    @Column(unique = true)
    @NonNull
    String support;

    @Column(unique = true)
    @NonNull
    Integer largeur;

    @Column(unique = true)
    @NonNull
    Integer hauteur;

    @ManyToMany
    List<Exposition> accrochage = new LinkedList<>();

    @OneToOne
    Transaction vendu;

    @ManyToOne
    Artiste auteur;
}
