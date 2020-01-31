package br.com.frwk.blog.post.service;

import java.util.Collection;

import org.springframework.data.domain.Pageable;

import br.com.frwk.blog.post.base.BaseDTO;

public interface IPostRestService<T extends BaseDTO> {

	T create(String username, T dto);

	T update(String username, T dto);

	T delete(String username, Long id);

	Collection<T> findAll(Pageable pageable);

	T findOne(Long id);

}
