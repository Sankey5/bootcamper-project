package com.organization.mvcproject.MGL_Task1.model;

public class Review {
	
	/**
	 * TODO 1.0 java object member variable naming convention, 
	 * one member declared here is not object oriented refactor it
	 */
	private String reviewBody;
	private String author;
	private Integer rating;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReviewBody() {
		return reviewBody;
	}

	public void setReviewBody(String reviewBody) {
		this.reviewBody = reviewBody;
	}
}
