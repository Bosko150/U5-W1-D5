package francescocossu.gestionePrenotazioni.services;


import francescocossu.gestionePrenotazioni.entities.Postazione;
import francescocossu.gestionePrenotazioni.entities.Prenotazione;
import francescocossu.gestionePrenotazioni.entities.Utente;
import francescocossu.gestionePrenotazioni.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public boolean isLiberaPerData(LocalDate data, Postazione postazione) {
        return prenotazioneRepository.findByPostazioneAndData(postazione, data) == null;
    }

    public Prenotazione savePrenotazione(Postazione postazione, LocalDate data, Utente utente) {

        if (!isLiberaPerData(data, postazione)) {
            System.out.println("La postazione " + postazione.getId() + " non è disponibile per la data " + data);
        }
        if (prenotazioneRepository.findByPostazioneAndData(postazione, data) != null) {
            System.out.println("L'utente " + utente.getUsername() + " ha già prenotato la postazione " + postazione.getId() + " per la data " + data);
        }
        Prenotazione prenotazione = new Prenotazione(utente, postazione, data);
        return prenotazioneRepository.save(prenotazione);
    }

    public void deletePrenotazione(Prenotazione prenotazione) {
        prenotazioneRepository.delete(prenotazione);
    }

    public Prenotazione findPrenotazioneById(Long id) {
        return prenotazioneRepository.findById(id).get();
    }

    public List<Prenotazione> findAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public void updatePrenotazione(Prenotazione prenotazione) {
        prenotazioneRepository.save(prenotazione);
    }
}
