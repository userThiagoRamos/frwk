package br.com.frwk.blog.post.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.frwk.blog.post.model.PostEntity;

@RestController
@RequestMapping("v1/post")
public class PostController {
	
	
	@GetMapping("/{postId}")
	public PostEntity getPost(@Valid @PathVariable("postId") long postId) {
		return new PostEntity("post1","teste");
	}

}
