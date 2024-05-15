package com.menuPizze;

import com.menuPizze.config.AppConfig;
import com.menuPizze.model.MenuItem;
import com.menuPizze.model.Ordine;
import com.menuPizze.model.Pizza;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testAggiornaContoRisultato(){
		Ordine ordine = new Ordine();
		ordine.setClienti(1);
		double result = ordine.aggiornaConto(7.5);
		assertEquals(7.5, result, 0.001);
	}

	@Test
	public void testAggiornaContoNull(){
		Ordine ordine = new Ordine();
		ordine.setClienti(1);
		double result = ordine.aggiornaConto(5);
		assertNotNull(result);
	}


	@ParameterizedTest
	@ValueSource(doubles={7.5, 9.2, 4.1})
	public void testAggiornaContoParam(double bill){
		Ordine ordine = new Ordine();
		ordine.setClienti(1);
		double result = ordine.aggiornaConto(bill);
		assertNotNull(result);
	}

	@ParameterizedTest
	@ValueSource(strings={"margherita","diavola","gianfranco"})
		public void testInserimentoPizza(String pizza){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		MenuItem result = ctx.getBean(pizza, MenuItem .class);
		assertNull(result);
	}

}
