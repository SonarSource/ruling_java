package example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;

public class AppointmentService {

  void schedule() {
    LocalDate.of(2024, Month.JANUARY, 10);
    LocalDate.of(2024, Month.FEBRUARY, 15);
    LocalDate.of(2024, Month.MARCH, 20);
    LocalDate.of(2024, Month.APRIL, 5);
    LocalDate.of(2024, Month.MAY, 1);
    LocalDate.of(2024, Month.JUNE, 18);
    LocalDateTime.of(2024, Month.JULY, 4, 10, 0);
    LocalDateTime.of(2024, Month.AUGUST, 22, 9, 30);
    LocalDateTime.of(2024, 9, 1, 8, 0);
    LocalDateTime.of(2024, 10, 31, 23, 0);
    LocalDateTime.of(2024, Month.NOVEMBER, 5, 17, 0);
    LocalDateTime.of(2024, 12, 25, 15, 0);
    YearMonth.of(2024, 1);
    YearMonth.of(2024, 3);
    YearMonth.of(2024, 6);
    YearMonth.of(2024, Month.SEPTEMBER);
    YearMonth.of(2024, 11);
    MonthDay.of(1, 1);
    MonthDay.of(3, 17);
    MonthDay.of(12, 25);
  }
}