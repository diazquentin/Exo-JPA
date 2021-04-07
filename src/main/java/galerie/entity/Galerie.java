package galerie.entity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity // Une entité JPA
public class Galerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NonNull
    private String nom;

    @Column(unique = true)
    @NonNull
    private String adresse;

    @OneToMany (mappedBy = "organisateur")
    List<Exposition> evenements = new LinkedList<>();

    public float CA(int annee) {
        float ca = 0f;
        for (Exposition e : evenements) {
            if (e.getDebut().isAfter(LocalDate.of(annee, 1, 1)) && e.getDebut().isBefore(LocalDate.of(annee, 12, 31))) {
                ca += e.CA();
            }
        }
        return ca;
    }
}
