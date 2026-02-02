package com.example.day4pms.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class ProductModel {

    @Id
    private String id;
    @NotBlank(message = "Name can not be empty")
    private String name;
    @Min(value = 1,message = "Price can not be less than 1")
    private double price;
    @NotEmpty(message = "Description cannot be empty")
    private String description;
}
