package francescocossu.gestionePrenotazioni.repositories;


import francescocossu.gestionePrenotazioni.entities.Postazione;
import francescocossu.gestionePrenotazioni.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {


    @Query("SELECT p FROM Postazione p WHERE p.tipoPostazione = ?1 AND p.edificio.citta = ?2")
    List<Postazione> findByTipoAndEdificioCitta(TipoPostazione tipoPostazione, String citta);
}
