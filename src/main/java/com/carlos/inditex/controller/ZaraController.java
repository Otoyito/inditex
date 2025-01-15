package com.carlos.inditex.controller;

import com.carlos.inditex.controller.dto.ProductOutputDTO;
import com.carlos.inditex.controller.mapper.ProductMapper;
import com.carlos.inditex.service.ZaraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
public class ZaraController {

    private final ZaraService zaraService;
    private final ProductMapper productMapper;

    @GetMapping("/product")
    public ResponseEntity<ProductOutputDTO> getProductForDate(@RequestParam("brand_id") int brandId, @RequestParam("product_id") int productId, @RequestParam("date") String dateStr) {
        var dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        //try(var date = new LocalDateTime.parse(simpleDateFormat.parse(dateStr))) {
        return ResponseEntity.ok(
                productMapper.mapProductToProductOutputDTO(
                        zaraService.getProductForDate(brandId, productId, LocalDateTime.parse(dateStr, dateTimeFormatter))));
    }
}
