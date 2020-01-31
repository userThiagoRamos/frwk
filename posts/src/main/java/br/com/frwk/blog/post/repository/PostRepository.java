package br.com.frwk.blog.post.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.frwk.blog.post.model.PostEntity;

public interface PostRepository extends PagingAndSortingRepository<PostEntity, Long> {

}
