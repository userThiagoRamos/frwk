package br.com.frwk.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BaseRepository<LinkEntity> getRepository() {
		return repository;
	}

	public List<LinkDTO> getAllByIdPost(Long idPost) {
		List<LinkEntity> list = repository.findAllByIdPost(idPost);
		return list.stream().map(link -> modelMapper.map(link, LinkDTO.class)).collect(Collectors.toList());
	}

}
