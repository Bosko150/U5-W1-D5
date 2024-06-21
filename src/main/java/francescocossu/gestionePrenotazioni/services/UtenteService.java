package francescocossu.gestionePrenotazioni.services;


import francescocossu.gestionePrenotazioni.entities.Utente;
import francescocossu.gestionePrenotazioni.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;


    public Utente saveUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public void deleteUtente(Utente utente) {
        utenteRepository.delete(utente);
    }

    public Utente findUtenteById(Long id) {
        return utenteRepository.findById(id).get();
    }

    public List<Utente> findAllUtenti() {
        return utenteRepository.findAll();
    }

    public void updateUtente(Utente utente) {
        utenteRepository.save(utente);
    }
}
