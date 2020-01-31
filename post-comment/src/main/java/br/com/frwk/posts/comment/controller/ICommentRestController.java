package br.com.frwk.posts.comment.controller;

import java.util.Collection;

import org.springframework.data.domain.Pageable;

import br.com.frwk.posts.comment.base.BaseDTO;

public interface ICommentRestController<T extends BaseDTO> {

	T create(T dto);

	T update(String username,T dto);

	T delete(String username,Long id);

	Collection<T> findAll(Pageable pageable);

	T findOne(Long id);

}
