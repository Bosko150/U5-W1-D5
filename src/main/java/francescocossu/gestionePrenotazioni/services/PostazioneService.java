package francescocossu.gestionePrenotazioni.services;


import francescocossu.gestionePrenotazioni.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;
}
