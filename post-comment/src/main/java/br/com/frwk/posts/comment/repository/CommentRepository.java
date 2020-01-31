package br.com.frwk.posts.comment.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.frwk.posts.comment.model.CommentEntity;

public interface CommentRepository extends PagingAndSortingRepository<CommentEntity, Long> {

}
