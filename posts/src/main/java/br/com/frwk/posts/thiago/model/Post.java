package br.com.frwk.posts.thiago.model;

public class Post {

	private String title;
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Post(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public Post() {
		super();
	}

}
