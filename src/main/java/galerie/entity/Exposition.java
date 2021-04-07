package galerie.entity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

public class Exposition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (unique = true)
    @NonNull
    private LocalDate debut;

    @Column (unique = true)
    @NonNull
    private String intitule;

    @Column (unique = true)
    @NonNull
    private Integer duree;

    @ManyToOne
    Galerie organisateur;

    @OneToMany (mappedBy = "lieuDeVente")
    List<Transaction> ventes = new LinkedList<>();
    
    @ManyToMany (mappedBy = "accrochage")
    List<Tableau> oeuvres = new LinkedList<>();

    public float CA(){
        float ca = 0f;
        for(Transaction t: ventes){
            ca+=t.getPrixVente();
        }
        return ca;
    }

    public LocalDate getDebut(){
        return this.debut;
    }
}
