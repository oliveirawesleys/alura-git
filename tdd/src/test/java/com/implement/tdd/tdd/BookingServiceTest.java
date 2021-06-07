package com.implement.tdd.tdd;

import com.implement.tdd.tdd.model.BookingModel;
import com.implement.tdd.tdd.repository.BookingRepository;
import com.implement.tdd.tdd.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

    @TestConfiguration
    static class BookingServiceTestConfigurarion {

        @Bean
        public BookingService bookingService() {
            return new BookingService();
        }
    }

    @Autowired
    BookingService bookingService;

    @MockBean
    BookingRepository bookingRepository;

    @Before
    public void setup() {
        LocalDate checkIn = LocalDate.parse("2021-02-10");
        LocalDate checkOut = LocalDate.parse("2021-02-20");
        BookingModel bookingModel = new BookingModel("1", "Wesley", checkIn, checkOut, 2);

        Mockito.when(bookingRepository.fingByReserveName(bookingModel.getReserveName()))
                .thenReturn(java.util.Optional.of(bookingModel));
    }

    @Test
    public void bookingServiceTestDaysCalculator() {
        String name = "Wesley";
        int days = bookingService.daysCalculatorWithDatabase(name);

        assertEquals(days, 10);
    }

}
