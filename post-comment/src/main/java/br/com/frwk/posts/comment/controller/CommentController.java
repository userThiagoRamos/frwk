package br.com.frwk.posts.comment.controller;

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

import br.com.frwk.posts.comment.base.IConstants;
import br.com.frwk.posts.comment.dto.CommentDTO;
import br.com.frwk.posts.comment.dto.ResponseDTO;
import br.com.frwk.posts.comment.service.CommentService;

@RestController
@RequestMapping("v1/comment")
public class CommentController implements ICommentRestController<CommentDTO>{
	
	@Autowired
	private CommentService service;

	@PostMapping
	@Override
	public ResponseDTO create(@RequestHeader(name = IConstants.HEADER_USERNAME) String username, @Valid @RequestBody CommentDTO dto) {
		return ResponseDTO.withData(service.create(username,dto));
	}

	@PutMapping
	@Override
	public ResponseDTO update(@RequestHeader(name = IConstants.HEADER_USERNAME) String username, @Valid @RequestBody CommentDTO dto) {
		return ResponseDTO.withData(service.update(username, dto));
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseDTO delete(@RequestHeader(name = IConstants.HEADER_USERNAME) String username, @PathVariable("id") Long id) {
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
	
	@GetMapping("/post/{idPost}")
	public ResponseDTO findAllByIdPost(@PathVariable("idPost") Long idPost) {
		return ResponseDTO.withData(service.getAllByIdPost(idPost));
	}

}
