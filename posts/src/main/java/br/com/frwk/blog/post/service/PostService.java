package br.com.frwk.blog.post.service;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.frwk.blog.post.dto.PostDTO;
import br.com.frwk.blog.post.model.PostEntity;
import br.com.frwk.blog.post.repository.PostRepository;

@Service
public class PostService implements IPostRestService<PostDTO> {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDTO create(String username,PostDTO dto) {
		dto.setUsername(username);
		PostEntity postEntity = modelMapper.map(dto, PostEntity.class);
		PostEntity savedPost = postRepository.save(postEntity);
		dto.setId(savedPost.getId());
		return dto;
	}

	@Override
	public PostDTO update(String username,PostDTO dto) {
		if (dto.getId() == null) {
			return new PostDTO();
		}
		if (postRepository.existsById(dto.getId())) {
			PostEntity postEntity = modelMapper.map(dto, PostEntity.class);
			postRepository.save(postEntity);
		}

		return dto;
	}

	@Override
	public PostDTO delete(String username,Long id) {
		if (id == null) {
			return new PostDTO();
		}
		if (postRepository.existsById(id)) {

			postRepository.deleteById(id);
		}

		return new PostDTO();
	}

	@Override
	public Collection<PostDTO> findAll(Pageable pageable) {
		Page<PostEntity> postList = postRepository.findAll(pageable);
		return postList.stream().map(post -> modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
	}

	@Override
	public PostDTO findOne(Long id) {
		if (id == null) {
			return new PostDTO();
		}
		PostEntity postEntity = postRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		return modelMapper.map(postEntity, PostDTO.class);
	}

}
