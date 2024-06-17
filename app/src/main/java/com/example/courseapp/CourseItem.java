package com.example.courseapp;

import java.io.Serializable;

public class CourseItem implements Serializable {
    private String title;
    private String subtitle;
    private String description;
    private String imageUrl;

    // Constructor to initialize the course item with all its details.
    public CourseItem(String title, String subtitle, String description, String imageUrl) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    // Let's get the title of the course.
    public String getTitle() {
        return title;
    }

    // And here's the subtitle of the course.
    public String getSubtitle() {
        return subtitle;
    }

    // Now, let's get the full description of the course.
    public String getDescription() {
        return description;
    }

    // Finally, here's the URL for the course image.
    public String getImageUrl() {
        return imageUrl;
    }
}
