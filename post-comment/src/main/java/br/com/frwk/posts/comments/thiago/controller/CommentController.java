package br.com.frwk.posts.comments.thiago.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.frwk.posts.comments.thiago.model.Comment;

@RestController
@RequestMapping("v1/comment")
public class CommentController {
	
	@GetMapping("/{postId}")
	public Comment getComment(@Valid @PathVariable long postId) {
		return new Comment("Concordo",new Date());
	}

}
