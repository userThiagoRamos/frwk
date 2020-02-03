package br.com.frwk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.frwk.base.BaseEntity;

@Entity
@Table(name = "link")
public class LinkEntity extends BaseEntity{
	
	private static final long serialVersionUID = -8993481278842160289L;
	
	@Id
	@GeneratedValue(generator = "SQ_LINK", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "SQ_LINK", sequenceName = "SQ_LINK", allocationSize = 1)
	@Column(name = "id_link")
	private Long id;
	
	private Long idPost;
	private String description;
	private String href;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Long getIdPost() {
		return idPost;
	}
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}
	

}
