package br.com.frwk.posts.comment.controller;

import org.springframework.data.domain.Pageable;

import br.com.frwk.posts.comment.base.BaseDTO;
import br.com.frwk.posts.comment.dto.ResponseDTO;

public interface ICommentRestController<T extends BaseDTO> {

	ResponseDTO create(String username,T dto);

	ResponseDTO update(String username,T dto);

	ResponseDTO delete(String username,Long id);

	ResponseDTO findAll(Pageable pageable);

	ResponseDTO findOne(Long id);

}
