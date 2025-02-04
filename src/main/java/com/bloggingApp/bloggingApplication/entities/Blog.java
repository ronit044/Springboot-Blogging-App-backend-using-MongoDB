package com.bloggingApp.bloggingApplication.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Blogs")
@Data
public class Blog {
    @Id
    private ObjectId id;
    private String title;
    private String description;
}
