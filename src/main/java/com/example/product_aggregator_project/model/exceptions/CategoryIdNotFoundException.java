package com.example.product_aggregator_project.model.exceptions;

public class CategoryIdNotFoundException extends RuntimeException{

    public CategoryIdNotFoundException() {
        super("Category Id Not Found.");
    }
}
