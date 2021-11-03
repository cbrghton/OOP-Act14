package mx.ipn;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TrabajaFechas {
    private Calendar calendar;
    private Locale locale;
    private DateFormat formatter;

    public TrabajaFechas() {
        this.calendar = Calendar.getInstance();
        this.locale = new Locale("es", "MX");
        this.formatter = new SimpleDateFormat("dd-MM-yyyy");
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public DateFormat getFormatter() {
        return this.formatter;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setFormatter(DateFormat dateFormat) {
        this.formatter = dateFormat;
    }

    public String formatoSpanish(Date fecha) {
        this.calendar.setTime(fecha);
        String month = this.calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, this.locale);
        String firstLetter = month.substring(0, 1);
        month = month.substring(1);
        firstLetter = firstLetter.toUpperCase(Locale.ROOT);
        month = firstLetter + month;

        return this.calendar.get(Calendar.DAY_OF_MONTH) + " de " + month + " de " + this.calendar.get(Calendar.YEAR);
    }

    public String estacionDelAnio(Date fecha) {
        this.calendar.setTime(fecha);

        int month = this.calendar.get(Calendar.MONTH);
        int day = this.calendar.get(Calendar.DAY_OF_MONTH);

        if ((day >= 20 && month == 2) || (month > 2 && month < 5) || (day < 21 && month == 5)) {
            return "Primavera";
        } else if ((day >= 21 && month == 5) || (month > 5 && month < 8) || (day < 22 && month == 8)) {
            return "Verano";
        } else if ((day >= 22 && month == 8) || (month > 8 && month < 11) || (day < 21 && month == 11)) {
            return "Otoño";
        } else if ((day >= 21 && month == 11) || (month == 12 || month == 0 || month == 1 ) || (day < 20 && month == 2)) {
            return "Invierno";
        }

        return "";
    }

    public String queDia(Date fInicial, int dias) {
        this.calendar.setTime(fInicial);
        this.calendar.add(Calendar.DATE, dias);

        return this.calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, this.locale);
    }

    public int edadEnSemanas(Date fNacimiento) {
        this.calendar.setTime(fNacimiento);

        int birthWeek = this.calendar.get(Calendar.WEEK_OF_YEAR);
        int birthYear = this.calendar.get(Calendar.YEAR);

        Date now = new Date();
        this.calendar.setTime(now);
        int actualWeek = this.calendar.get(Calendar.WEEK_OF_YEAR);
        int actualYear = this.calendar.get(Calendar.YEAR);

        return 52 - birthWeek + actualWeek + (52 * (actualYear - birthYear - 1));
    }
}
