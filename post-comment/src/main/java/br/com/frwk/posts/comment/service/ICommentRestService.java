package br.com.frwk.posts.comment.service;

import java.util.Collection;

import org.springframework.data.domain.Pageable;

import br.com.frwk.posts.comment.base.BaseDTO;

public interface ICommentRestService<T extends BaseDTO> {

	T create(String username,T dto);

	T update(String username,T dto);

	T delete(String username,Long id);

	Collection<T> findAll(Pageable pageable);

	T findOne(Long id);

}
