package br.com.frwk.blog.post.controller;

import org.springframework.data.domain.Pageable;

import br.com.frwk.blog.post.base.BaseDTO;
import br.com.frwk.blog.post.dto.ResponseDTO;

public interface IBasePostController<T extends BaseDTO> {

	ResponseDTO create(String username, T dto);

	ResponseDTO update(String username, T dto);

	ResponseDTO delete(String username, Long id);

	ResponseDTO findAll(Pageable pageable);

	ResponseDTO findOne(Long id);

}
