package francescocossu.gestionePrenotazioni.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Utente utente;
    @ManyToOne
    private Postazione postazione;
    private LocalDate data;

    public Prenotazione(Utente utente, Postazione postazione, LocalDate data) {
        this.utente = utente;
        this.postazione = postazione;
        this.data = data;
    }
}
