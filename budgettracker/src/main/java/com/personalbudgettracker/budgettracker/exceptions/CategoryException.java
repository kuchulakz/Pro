package com.personalbudgettracker.budgettracker.exceptions;

public class CategoryException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CategoryException(String message) {
        super(message);
    }
}