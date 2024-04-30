import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main (String[] args){
        EventoDAO eventoDAO = new EventoDAO();
//            Evento newEvento = new Evento(3, "partita di calcio", LocalDate.of(2024, 5, 18), "derby", Evento.TipoEvento.PUBBLICO, 60000);
//            eventoDAO.salvaEvento(newEvento);

//        logger.info(eventoDAO.cercaEvento(2));
//    }

    eventoDAO.eliminaEvento(3);

}}