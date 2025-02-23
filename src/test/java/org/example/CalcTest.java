package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.w3c.dom.ls.LSOutput;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @BeforeAll
    public static void setUp(){
        System.out.println("before all");
    }

    @BeforeEach
    public void setUpEach(){
        System.out.println("before each");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("after all");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("after each");
    }

    @Test
    @DisplayName("Проверка суммирования")
    @Timeout(10)
    void summ() {
        Calc calc = new Calc();
        int result =  calc.sum(1, 6);
        Assertions.assertEquals(7, result, "Неверный ответ");

    }


    @ParameterizedTest(name = "№{index} - сложение {0} и {1}, ожидаем {2}")
    @DisplayName("Проверка сложения")
    @CsvSource({"1, 2, 3", "-1, 2, 1", "0, 0, 0"})
    @Tag("param")
    void sum(int a, int b,int expectedResult) {
        Calc calc = new Calc();
        int result = calc.sum(a, b);
        Assertions.assertEquals(expectedResult, result, "Неверный ответ");
    }

    @ParameterizedTest(name = "№{index} - вычитание {0} и {1}, ожидаем {2}")
    @DisplayName("Проверка вычитания")
    @CsvSource({"3, 2, 1", "1, 2, -1", "0, 0, 0"})
    @Tag("param")
    void diff(int a, int b, int expectedResult) {
        Calc calc = new Calc();
        int result = calc.diff(a, b);
        Assertions.assertEquals(expectedResult, result, "Неверный ответ");
    }
}