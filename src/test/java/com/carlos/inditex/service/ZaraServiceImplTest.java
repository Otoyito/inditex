package com.carlos.inditex.service;

import com.carlos.inditex.domain.Product;
import com.carlos.inditex.exception.ProductNotFoundException;
import com.carlos.inditex.model.ProductMO;
import com.carlos.inditex.repository.ProductRepository;
import com.carlos.inditex.repository.mapper.ProductModelMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class ZaraServiceImplTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductModelMapper productModelMapper;
    @InjectMocks
    private ZaraServiceImpl zaraService;

    @DisplayName("getProductForDate - throw unexpected")
    @Test
    void shouldThrowOnUnexpectedError_getProductForUpdate() {
        doThrow(new RuntimeException("MockedDatabaseException")).when(productRepository).findPriceListForBrandProductAndDates(anyInt(), anyInt(), any(LocalDateTime.class));

        assertThrows(RuntimeException.class, () -> zaraService.getProductForDate(LocalDateTime.now(), 1, 1));
    }

    @DisplayName("getProductForDate - not found")
    @Test
    void shouldThrowProductNotFoundException_getProductForUpdate() {
        doReturn(List.of()).when(productRepository).findPriceListForBrandProductAndDates(anyInt(), anyInt(), any(LocalDateTime.class));

        assertThrows(ProductNotFoundException.class, () -> zaraService.getProductForDate(LocalDateTime.now(), 1, 1));
    }

    @DisplayName("getProductForDate - found product")
    @Test
    void shouldReturnProduct_getProductForUpdate() {
        var productMO = Mockito.mock(ProductMO.class);
        var product = Mockito.mock(Product.class);
        var date = Mockito.mock(LocalDateTime.class);

        doReturn(List.of(productMO)).when(productRepository).findPriceListForBrandProductAndDates(1, 1, date);
        doReturn(product).when(productModelMapper).mapProductMO(productMO);

        assertEquals(product, zaraService.getProductForDate(date, 1, 1));
    }

}