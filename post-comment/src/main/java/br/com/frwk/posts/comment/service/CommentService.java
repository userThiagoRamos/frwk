package br.com.frwk.posts.comment.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.frwk.posts.comment.dto.CommentDTO;
import br.com.frwk.posts.comment.model.CommentEntity;
import br.com.frwk.posts.comment.repository.CommentRepository;

@Service
public class CommentService implements ICommentRestService<CommentDTO> {

	@Autowired
	private CommentRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDTO create(String username, CommentDTO dto) {
		CommentEntity postEntity = modelMapper.map(dto, CommentEntity.class);
		postEntity.setCreatedAt(new Date());
		postEntity.setUsername(username);
		CommentEntity savedEntity = repository.save(postEntity);
		dto.setId(savedEntity.getId());
		return dto;
	}

	@Override
	public CommentDTO update(String username, CommentDTO dto) {
		if (dto.getId() == null) {
			return new CommentDTO();
		}
		if (repository.existsById(dto.getId())) {
			CommentEntity entity = modelMapper.map(dto, CommentEntity.class);
			entity.setUsername(username);
			repository.save(entity);
		}

		return dto;
	}

	@Override
	public CommentDTO delete(String username, Long id) {
		if (id == null) {
			return new CommentDTO();
		}
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}

		return new CommentDTO();
	}

	@Override
	public Collection<CommentDTO> findAll(Pageable pageable) {
		Page<CommentEntity> listEntity = repository.findAll(pageable);
		return listEntity.stream().map(comment -> modelMapper.map(comment, CommentDTO.class)).collect(Collectors.toList());
	}

	@Override
	public CommentDTO findOne(Long id) {
		if (id == null) {
			return new CommentDTO();
		}
		CommentEntity entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
		return modelMapper.map(entity, CommentDTO.class);
	}

	@Transactional(readOnly = true)
	public List<CommentDTO> getAllByIdPost(Long idPost) {
		List<CommentEntity> listEntity = repository.findAllByIdPost(idPost);
		return listEntity.stream().map(comment -> modelMapper.map(comment, CommentDTO.class)).collect(Collectors.toList());
	}

}
