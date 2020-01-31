package br.com.frwk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.frwk.base.BaseRepository;
import br.com.frwk.base.BaseService;
import br.com.frwk.dto.LinkDTO;
import br.com.frwk.model.LinkEntity;
import br.com.frwk.repository.LinkRepository;

@Service
public class LinkService extends BaseService<LinkEntity, LinkDTO> {

	@Autowired
	private LinkRepository repository;
	
	@Override
	public BaseRepository<LinkEntity> getRepository() {
		return repository;
	}

}
