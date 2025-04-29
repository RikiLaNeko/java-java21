package java17.ex07;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * Exercice 07 - Instant
 */
public class DateAndTime_07_Test {

	@Test
	public void test_date_to_localdate() throws Exception {

		// TODO Créer une date Java 1 (12/02/2017)
		Calendar cal = Calendar.getInstance();
		cal.set(2017, Calendar.FEBRUARY, 12);
		Date date = cal.getTime();

		// TODO transformer la date en Instant
		Instant instant = date.toInstant();

		// TODO transformer la date en LocalDate
		LocalDate result = instant.atZone(ZoneId.systemDefault()).toLocalDate();

		// TODO valoriser les différentes variables afin de rendre le test passant
		// Les variables sont déjà correctement valorisées par la conversion

		assertThat(result.getYear(), is(2017));
		assertThat(result.getMonth(), is(Month.FEBRUARY));
		assertThat(result.getDayOfMonth(), is(12));
	}
}