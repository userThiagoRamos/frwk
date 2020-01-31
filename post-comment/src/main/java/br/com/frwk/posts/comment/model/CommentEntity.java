package br.com.frwk.posts.comment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.frwk.posts.comment.base.BaseEntity;

@Entity
@Table(name = "COMMENT")
public class CommentEntity extends BaseEntity{

	private static final long serialVersionUID = 7050040122708987538L;

	@Id
	@GeneratedValue(generator = "SQ_COMMENT", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "SQ_COMMENT", sequenceName = "SQ_COMMENT", allocationSize = 1)
	@Column(name = "id_comment")
	private Long id;
		
	@Column(name = "id_post")
	private Long postId;
	
	@Column(name = "id_user")
	private Long userId;
	
	@Column(columnDefinition = "TEXT")
	private String text;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
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

	public CommentEntity(String text, Date createdAt) {
		super();
		this.text = text;
		this.createdAt = createdAt;
	}

	public CommentEntity() {
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
