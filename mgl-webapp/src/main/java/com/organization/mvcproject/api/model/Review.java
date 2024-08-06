package com.organization.mvcproject.api.model;

public interface Review {
    String getAuthor();

    void setAuthor(String author);

    Integer getRating();

    void setRating(Integer rating);

    String getBody();

    void setBody(String body);
}
