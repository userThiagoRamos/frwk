package br.com.frwk.blog.post.dto;

import br.com.frwk.blog.post.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor()
@EqualsAndHashCode(callSuper = true)
public class PostDTO extends BaseDTO{
	
	private static final long serialVersionUID = -6374799485976763981L;
	
	private String title;
	private String text;
	private String username;
	
	

}
