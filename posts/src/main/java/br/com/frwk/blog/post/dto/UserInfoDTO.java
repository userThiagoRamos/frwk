package br.com.frwk.blog.post.dto;

import br.com.frwk.blog.post.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserInfoDTO extends BaseDTO{
	
	private static final long serialVersionUID = -4715285991138278382L;
	
	private String username;

}
