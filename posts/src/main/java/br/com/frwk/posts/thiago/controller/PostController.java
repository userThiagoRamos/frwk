package br.com.frwk.posts.thiago.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.frwk.posts.thiago.model.Post;

@RestController
@RequestMapping("v1/post")
public class PostController {
	
	
	@GetMapping("/{postId}")
	public Post getPost(@Valid @PathVariable("postId") long postId) {
		return new Post("post1","teste");
	}

}
