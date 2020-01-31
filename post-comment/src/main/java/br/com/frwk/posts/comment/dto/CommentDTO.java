package br.com.frwk.posts.comment.dto;

import br.com.frwk.posts.comment.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommentDTO extends BaseDTO {
	
	private static final long serialVersionUID = 6294820797180434154L;

	private Long postId;
	private String username;
	private String text;
	
	

}
