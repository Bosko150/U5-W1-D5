package francescocossu.gestionePrenotazioni.repositories;


import francescocossu.gestionePrenotazioni.entities.Postazione;
import francescocossu.gestionePrenotazioni.entities.Prenotazione;
import francescocossu.gestionePrenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    List<Prenotazione> findByUtente(Utente utente);

    Prenotazione findByPostazioneAndData(Postazione postazione, LocalDate data);

    List<Prenotazione> findByData(LocalDate data);

    List<Prenotazione> findByUtenteUsername(String username);

    boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);
}
