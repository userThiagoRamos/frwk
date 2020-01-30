package br.com.frwk.blog.post.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class PostEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Length(min = 2, max = 150)
	private String title;

	private String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public PostEntity(@Length(min = 2, max = 150) String title, String text) {
		super();
		this.title = title;
		this.text = text;
	}

	public PostEntity() {
		super();
	}

}
