package com.carlos.inditex.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {

    }
}
