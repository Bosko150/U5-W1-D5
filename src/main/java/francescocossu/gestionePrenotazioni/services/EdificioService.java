package francescocossu.gestionePrenotazioni.services;


import francescocossu.gestionePrenotazioni.entities.Edificio;
import francescocossu.gestionePrenotazioni.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public Edificio saveEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public void deleteEdificio(Edificio edificio) {
        edificioRepository.delete(edificio);
    }

    public Edificio findEdificioById(Long id) {
        return edificioRepository.findById(id).get();
    }

    public List<Edificio> findAllEdifici() {
        return edificioRepository.findAll();
    }

    public void updateEdificio(Edificio edificio) {
        edificioRepository.save(edificio);
    }
}
