package java17.ex01;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;

/**
 * Exercice 01 - Les dates avant Java 8
 */
public class DateAndTime_01_Test {

	// Vous vous souvenez de java.util.Date (Java 1) ?
	@Test
	public void test_date() {
		// On définit le fuseau horaire en CET
		TimeZone.setDefault(TimeZone.getTimeZone("CET"));

		// Date(année - 1900, mois 0-11, jour, heure, minute, seconde)
		Date date = new Date(117, 2, 24, 1, 2, 3);

		assertThat(date.toString(), is("Fri Mar 24 01:02:03 CET 2017"));

		// Changement du jour
		date.setDate(25);

		assertThat(date.toString(), is("Sat Mar 25 01:02:03 CET 2017"));
	}

	// Vous vous souvenez de java.util.Calendar (Java 1.1) ?

	@Test
	public void test_calendar() throws Exception {
		// On utilise Europe/Paris plutôt que CET pour garantir la compatibilité
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris"));

		Calendar calendar = Calendar.getInstance();

		// Configuration de la date
		calendar.set(Calendar.YEAR, 2017);
		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 24);
		calendar.set(Calendar.HOUR_OF_DAY, 1);
		calendar.set(Calendar.MINUTE, 2);
		calendar.set(Calendar.SECOND, 3);
		calendar.set(Calendar.MILLISECOND, 0);

		assertThat(calendar.getTime().toString(), is("Fri Mar 24 01:02:03 CET 2017"));

		// Modification du jour
		calendar.set(Calendar.DAY_OF_MONTH, 25);

		assertThat(calendar.getTime().toString(), is("Sat Mar 25 01:02:03 CET 2017"));
	}
}