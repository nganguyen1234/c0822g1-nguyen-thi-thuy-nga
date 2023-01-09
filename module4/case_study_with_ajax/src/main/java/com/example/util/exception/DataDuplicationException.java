package com.example.util.exception;

import java.util.HashMap;
import java.util.Map;

public class DataDuplicationException extends Exception {
    private Map<String, String> errorMap;
    public DataDuplicationException() {
        if (this.errorMap == null) {
            this.errorMap = new HashMap<>();
        }
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }
}
