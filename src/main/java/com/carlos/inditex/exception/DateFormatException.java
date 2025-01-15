package com.carlos.inditex.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DateFormatException extends RuntimeException {
    private String nestedMessage;

    public DateFormatException(String nestedMessage) {
        this.nestedMessage = nestedMessage;
    }
}
