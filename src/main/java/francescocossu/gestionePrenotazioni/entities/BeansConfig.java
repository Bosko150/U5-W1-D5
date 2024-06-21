package francescocossu.gestionePrenotazioni.entities;

import com.github.javafaker.Faker;
import francescocossu.gestionePrenotazioni.services.EdificioService;
import francescocossu.gestionePrenotazioni.services.PostazioneService;
import francescocossu.gestionePrenotazioni.services.PrenotazioneService;
import francescocossu.gestionePrenotazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class BeansConfig {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioneService prenotazioneService;

    private Faker faker = new Faker();


    @Bean
    public List<Edificio> edifici() {
        List<Edificio> edifici = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Edificio edificio = new Edificio(faker.company().name(), faker.address().streetAddress(), faker.pokemon().location());
            edificioService.saveEdificio(edificio);
            edifici.add(edificio);
        }
        return edifici;
    }

    @Bean
    public List<Utente> utenti() {
        List<Utente> utenti = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Utente utente = new Utente(faker.name().username(), faker.dragonBall().character(), faker.internet().emailAddress());
            utenteService.saveUtente(utente);
            utenti.add(utente);
        }
        return utenti;
    }

    @Bean
    public List<Postazione> postazioni() {
        List<Postazione> postazioni = new ArrayList<>();
        List<Edificio> edifici = edificioService.findAllEdifici();

        for (Edificio edificio : edifici) {
            for (int i = 0; i < 10; i++) {
                Postazione postazionePrivata = new Postazione("Sala " + faker.color().name(), 5, TipoPostazione.PRIVATO, edificio);
                Postazione openSpace = new Postazione("Sala " + faker.lorem().word(), 30, TipoPostazione.OPENSPACE, edificio);
                Postazione salaRiunioni = new Postazione("Sala " + faker.artist().name(), 15, TipoPostazione.SALA_RIUNIONI, edificio);
                postazioneService.savePostazione(postazionePrivata);
                postazioneService.savePostazione(openSpace);
                postazioneService.savePostazione(salaRiunioni);

                postazioni.add(postazionePrivata);
                postazioni.add(openSpace);
                postazioni.add(salaRiunioni);
            }
        }
        return postazioni;
    }


}




