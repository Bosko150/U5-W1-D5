package francescocossu.gestionePrenotazioni;


import francescocossu.gestionePrenotazioni.entities.Postazione;
import francescocossu.gestionePrenotazioni.entities.Prenotazione;
import francescocossu.gestionePrenotazioni.entities.TipoPostazione;
import francescocossu.gestionePrenotazioni.entities.Utente;
import francescocossu.gestionePrenotazioni.services.EdificioService;
import francescocossu.gestionePrenotazioni.services.PostazioneService;
import francescocossu.gestionePrenotazioni.services.PrenotazioneService;
import francescocossu.gestionePrenotazioni.services.UtenteService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Scanner;

@Component
@Transactional
public class MyRunner implements CommandLineRunner {

    Scanner scanner = new Scanner(System.in);

    private EntityManager entityManager;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    public void resetDataBase() {
        entityManager.createNativeQuery("DROP TABLE prenotazione, postazione, utente, edificio").executeUpdate();
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            System.out.println("Benvenuto! Identificati per continuare (Inserisci ID utente o 0 per uscire)");
            utenteService.findAllUtenti().forEach(u -> System.out.println(u.toString()));
            String response = scanner.nextLine();

            if (response.equals("0")) {
                resetDataBase();
                break;
            }
            Utente utenteSelezionato = utenteService.findUtenteById(Long.parseLong(response));
            System.out.println("Hai selezionato: " + utenteSelezionato.toString());
            System.out.println("Cosa vuoi fare?\1. Cerca sale disponibili \0. Esci");
            String response2 = scanner.nextLine();
            if (response2.equals("0")) {
                resetDataBase();
                break;
            }

            if (response2.equals("1")) {
                System.out.println("Inserisci la città dove vuoi cercare sale disponibili:");
                String response3 = scanner.nextLine();
                System.out.println("\"Seleziona il tipo di sala che vuoi prenotare:\1. Privata\2. Open space\3. Sala riunioni\0. Esci\"");
                String response4 = scanner.nextLine();
                if (response3.equals("0")) {
                    resetDataBase();
                    break;
                }
                switch (response4) {
                    case "1":
                        System.out.println("Ecco le sale private disponibili:");
                        postazioneService.cercaPostazioniPerTipoECitta(TipoPostazione.PRIVATO, response3).forEach(System.out::println);
                        System.out.println("Seleziona l'id della sala che vuoi prenotare:");
                        String response5 = scanner.nextLine();
                        System.out.println("Seleziona la data in cui vuoi prenotare la sala (formato YYYY-MM-DD):");
                        String response7 = scanner.nextLine();


                        Postazione postazione = postazioneService.findPostazioneById(Long.parseLong(response5));
                        Prenotazione prenotazione = prenotazioneService.savePrenotazione(postazione, Date.valueOf(response7).toLocalDate(), utenteSelezionato);

                        break;
                    case "2":
                        System.out.println("Ecco le sale open space disponibili:");
                        postazioneService.cercaPostazioniPerTipoECitta(TipoPostazione.OPENSPACE, response3).forEach(System.out::println);
                        System.out.println("Seleziona l'id della sala che vuoi prenotare:");
                        String response6 = scanner.nextLine();
                        System.out.println("Seleziona la data in cui vuoi prenotare la sala (formato YYYY-MM-DD):");
                        String response8 = scanner.nextLine();
                        Postazione postazione2 = postazioneService.findPostazioneById(Long.parseLong(response6));
                        Prenotazione prenotazione2 = prenotazioneService.savePrenotazione(postazione2, Date.valueOf(response8).toLocalDate(), utenteSelezionato);
                        break;
                    case "3":
                        System.out.println("Ecco le sale riunioni disponibili:");
                        postazioneService.cercaPostazioniPerTipoECitta(TipoPostazione.SALA_RIUNIONI, response3).forEach(System.out::println);
                        System.out.println("Seleziona l'id della sala che vuoi prenotare:");
                        String response9 = scanner.nextLine();
                        System.out.println("Seleziona la data in cui vuoi prenotare la sala (formato YYYY-MM-DD):");
                        String response10 = scanner.nextLine();
                        Postazione postazione3 = postazioneService.findPostazioneById(Long.parseLong(response9));
                        Prenotazione prenotazione3 = prenotazioneService.savePrenotazione(postazione3, Date.valueOf(response10).toLocalDate(), utenteSelezionato);
                        break;
                }
            }


        }



        /*Utente utente1 = utenteService.findUtenteById(152L);
        Postazione postazione1 = postazioneService.findPostazioneById(252L);
        Prenotazione prenotazione1 = prenotazioneService.savePrenotazione(postazione1, LocalDate.now(), utente1);*/

    }
}
