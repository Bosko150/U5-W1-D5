package francescocossu.gestionePrenotazioni.services;


import francescocossu.gestionePrenotazioni.entities.Postazione;
import francescocossu.gestionePrenotazioni.entities.TipoPostazione;
import francescocossu.gestionePrenotazioni.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public Postazione savePostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public void deletePostazione(Postazione postazione) {
        postazioneRepository.delete(postazione);
    }

    public Postazione findPostazioneById(Long id) {
        return postazioneRepository.findById(id).get();
    }

    public List<Postazione> findAllPostazioni() {
        return postazioneRepository.findAll();
    }

    public void updatePostazione(Postazione postazione) {
        postazioneRepository.save(postazione);
    }

    public List<Postazione> cercaPostazioniPerTipoECitta(TipoPostazione tipoPostazione, String citta) {
        return postazioneRepository.findByTipoAndEdificioCitta(tipoPostazione, citta);
    }

}
