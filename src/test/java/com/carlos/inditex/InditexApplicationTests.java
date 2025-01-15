package com.carlos.inditex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.restassured.RestAssured;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InditexApplicationTests {

    @LocalServerPort
    int port;

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA) -> 35.50")
    void test1() {
        var response = RestAssured
                .given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .get("http://localhost:" + port + "/product?brand_id=1&product_id=35455&date=2020-06-14-10.00.00");

        assertEquals(200, response.getStatusCode());
        assertEquals(new BigDecimal("35.50"), new BigDecimal(response.getBody().jsonPath().getString("price")).setScale(2,  RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA) -> 25.45")
    void test2() {
        var response = RestAssured
                .given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .get("http://localhost:" + port + "/product?brand_id=1&product_id=35455&date=2020-06-14-16.00.00");

        assertEquals(200, response.getStatusCode());
        assertEquals(new BigDecimal("25.45"), new BigDecimal(response.getBody().jsonPath().getString("price")).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA) -> 35.50")
    void test3() {
        var response = RestAssured
                .given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .get("http://localhost:" + port + "/product?brand_id=1&product_id=35455&date=2020-06-14-21.00.00");

        assertEquals(200, response.getStatusCode());
        assertEquals(new BigDecimal("35.50"), new BigDecimal(response.getBody().jsonPath().getString("price")).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA) -> 30.50")
    void test4() {
        var response = RestAssured
                .given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .get("http://localhost:" + port + "/product?brand_id=1&product_id=35455&date=2020-06-15-10.00.00");

        assertEquals(200, response.getStatusCode());
        assertEquals(new BigDecimal("30.50"), new BigDecimal(response.getBody().jsonPath().getString("price")).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA) -> 38.95")
    void test5() {
        var response = RestAssured
                .given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .get("http://localhost:" + port + "/product?brand_id=1&product_id=35455&date=2020-06-16-21.00.00");

        assertEquals(200, response.getStatusCode());
        assertEquals(new BigDecimal("38.95"), new BigDecimal(response.getBody().jsonPath().getString("price")).setScale(2, RoundingMode.HALF_UP));
    }
}
