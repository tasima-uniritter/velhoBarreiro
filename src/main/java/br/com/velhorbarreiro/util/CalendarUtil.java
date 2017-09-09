package br.com.velhorbarreiro.util;

import java.util.Calendar;

public class CalendarUtil {

	public static void setInicioDia (Calendar calendar) {
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}
}
