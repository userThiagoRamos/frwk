package br.com.frwk.repository;

import java.util.List;

import br.com.frwk.base.BaseRepository;
import br.com.frwk.model.LinkEntity;

public interface LinkRepository extends BaseRepository<LinkEntity> {

	List<LinkEntity> findAllByIdPost(Long idPost);

}
