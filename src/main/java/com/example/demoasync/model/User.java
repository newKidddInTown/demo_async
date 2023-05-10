package com.example.demoasync.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {
    @Id
    private String id;
    private String name;
    private String address;
    private boolean isDeleted = false;
}
