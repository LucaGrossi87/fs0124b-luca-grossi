import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main (String[] args){
        EventoDAO eventoDAO = new EventoDAO();
            Evento newEvento = new Evento( "partita di calcio", LocalDate.of(2024, 5, 18), "derby", Evento.TipoEvento.PUBBLICO, 60000);
            eventoDAO.salvaEvento(newEvento);

        PersonaDAO personaDAO = new PersonaDAO();
        Persona newPersona = new Persona("Mario", "Rossi", "mario@rossi.it", LocalDate.of(1980, 5, 18), Persona.Sesso.M);
        personaDAO.salvaPersona(newPersona);

        LocationDAO locationDAO = new LocationDAO();
        Location newLocation = new Location("Stadio Olimpico", "Roma");
        locationDAO.salvaLocation(newLocation);

        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();
        Partecipazione newPartecipazione = new Partecipazione(newPersona, newEvento, Partecipazione.Stato.DA_CONFERMARE);
        partecipazioneDAO.salvaPartecipazione(newPartecipazione);
    }

}