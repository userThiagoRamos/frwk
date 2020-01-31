package br.com.frwk.blog.post.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.frwk.blog.post.base.IConstants;
import br.com.frwk.blog.post.dto.PostDTO;
import br.com.frwk.blog.post.dto.ResponseDTO;
import br.com.frwk.blog.post.service.PostService;

@RestController
@RequestMapping("v1/post")
public class PostController implements IBasePostController<PostDTO> {

	@Autowired
	private PostService service;

	@PostMapping
	@Override
	public ResponseDTO create(@RequestHeader(name = IConstants.HEADER_USERNAME) String username, @Valid @RequestBody PostDTO dto) {
		return ResponseDTO.withData(service.create(username, dto));
	}

	@PutMapping
	@Override
	public ResponseDTO update(@RequestHeader(name = IConstants.HEADER_USERNAME) String username,@Valid @RequestBody PostDTO dto) {
		return ResponseDTO.withData(service.update(username, dto));
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseDTO delete(@RequestHeader(name = IConstants.HEADER_USERNAME) String username,@PathVariable("id") Long id) {
		return ResponseDTO.withData(service.delete(username, id));
	}

	@GetMapping("/all")
	@Override
	public ResponseDTO findAll(Pageable pageable) {
		return ResponseDTO.withData(service.findAll(pageable));
	}

	@GetMapping("/{id}")
	@Override
	public ResponseDTO findOne(@Valid @PathVariable("id") Long id) {
		return ResponseDTO.withData(service.findOne(id));
	}

}
