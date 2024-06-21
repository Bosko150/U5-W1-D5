package francescocossu.gestionePrenotazioni.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String descrizione;
    private int numeroPosti;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    @ManyToOne
    private Edificio edificio;
    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

    public Postazione(String descrizione, int numeroPosti, TipoPostazione tipoPostazione, Edificio edificio) {
        this.descrizione = descrizione;
        this.numeroPosti = numeroPosti;
        this.tipoPostazione = tipoPostazione;
        this.edificio = edificio;
    }
}
