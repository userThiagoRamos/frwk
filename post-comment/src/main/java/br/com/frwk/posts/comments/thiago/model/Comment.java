package br.com.frwk.posts.comments.thiago.model;

import java.util.Date;

public class Comment {

	private Long id;
	private Long postId;
	private String text;
	private Date createdAt;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Comment(String text, Date createdAt) {
		super();
		this.text = text;
		this.createdAt = createdAt;
	}

	public Comment() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

}
