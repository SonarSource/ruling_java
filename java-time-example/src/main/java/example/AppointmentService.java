package example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;

public class AppointmentService {

  void schedule() {
    LocalDate.of(2024, 1, 10);
    LocalDate.of(2024, 2, 15);
    LocalDate.of(2024, 3, 20);
    LocalDate.of(2024, 4, 5);
    LocalDate.of(2024, Month.MAY, 1);
    LocalDate.of(2024, 6, 18);
    LocalDateTime.of(2024, 7, 4, 10, 0);
    LocalDateTime.of(2024, 8, 22, 9, 30);
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