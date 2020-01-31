package br.com.frwk.blog.post.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDTO {

	private Object data;
	private String message;
	private String details;
	
	private ResponseDTO(Object data) {
		super();
		this.message = "sucessso";
		this.data = data;
	}
	
	private ResponseDTO(String details) {
		super();
		this.message = "error";
		this.details = details;
	}
	
	public static ResponseDTO withData(Object data) {
		return new ResponseDTO(data);
	}
	
	public static ResponseDTO forError(String details) {
		return new ResponseDTO(details);
	}
	
	
}
