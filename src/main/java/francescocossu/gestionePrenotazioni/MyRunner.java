package francescocossu.gestionePrenotazioni;


import francescocossu.gestionePrenotazioni.services.EdificioService;
import francescocossu.gestionePrenotazioni.services.PostazioneService;
import francescocossu.gestionePrenotazioni.services.PrenotazioneService;
import francescocossu.gestionePrenotazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {
        
    }
}
