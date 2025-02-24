package com.carlos.inditex.controller;

import com.carlos.inditex.controller.dto.ProductOutputDTO;
import com.carlos.inditex.controller.mapper.ProductMapper;
import com.carlos.inditex.service.ZaraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.Date;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ZaraController {

    private final ZaraService zaraService;
    private final ProductMapper productMapper;

    @GetMapping("")
    @Operation(
            summary = "retrieves current price for given product",
            responses = {
                    @ApiResponse(responseCode = "200", description = "product successfully retrieved", content = @Content(schema= @Schema(implementation = ProductOutputDTO.class))),
                    @ApiResponse(responseCode = "404", description = "product not found")
            }
    )
    public ResponseEntity<ProductOutputDTO> getProductForDate(@RequestParam("brand_id") Integer brandId, @RequestParam("product_id") Integer productId, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date date) {
        return ResponseEntity.ok(
                productMapper.mapProductToProductOutputDTO(
                        zaraService.getProductForDate(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), productId, brandId)));
    }
}
