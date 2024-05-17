package com.GestionePrenotazioni.GestionePrenotazioni;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class GestionePrenotazioniApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testPrenotaPostazione() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/prenotazioni")
						.param("username", "nomeutente")
						.param("postazioneId", "1")
						.param("data", LocalDate.now().toString())
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testTrovaPostazioni() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/prenotazioni/postazioni")
						.param("tipo", "OPENSPACE")
						.param("citta", "Milano")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}

