package br.com.frwk.blog.post.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.frwk.blog.post.base.BaseEntity;

@Entity
@Table(name = "POST")
public class PostEntity extends BaseEntity{

	private static final long serialVersionUID = 1894478476453785341L;

	@Id
	@GeneratedValue(generator = "SQ_POST", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "SQ_POST", sequenceName = "SQ_POST", allocationSize = 1)
	@Column(name = "id_post")
	private Long id;

	@Length(min = 2, max = 150)
	private String title;

	@Column(columnDefinition = "TEXT")
	private String text;
	
	@NotEmpty(message = "Informe a o nome do usuario")
	@Column(name="username")
	private String username;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



}
