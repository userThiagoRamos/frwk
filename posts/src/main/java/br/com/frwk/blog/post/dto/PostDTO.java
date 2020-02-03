package br.com.frwk.blog.post.dto;

import javax.validation.constraints.NotEmpty;

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
	
	@NotEmpty(message = "Informe o titulo do post")
	private String title;
	
	@NotEmpty(message = "Informe o texto do post")
	private String text;
	
	private String username;
	
	

}
