package br.com.frwk.dto;

import br.com.frwk.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor()
@EqualsAndHashCode(callSuper = true)
public class LinkDTO extends BaseDTO{
	
	private static final long serialVersionUID = 4764913679202049836L;
	
	private String description;
	private String href;

}
