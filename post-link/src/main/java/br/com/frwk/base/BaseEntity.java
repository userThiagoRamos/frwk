package br.com.frwk.base;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -2947575661557744000L;
	
	public abstract Long getId();
    public abstract void setId(Long id);
  


}
