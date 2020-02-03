package br.com.frwk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.frwk.base.BaseController;
import br.com.frwk.base.BaseService;
import br.com.frwk.dto.LinkDTO;
import br.com.frwk.dto.ResponseDTO;
import br.com.frwk.model.LinkEntity;
import br.com.frwk.service.LinkService;

@RestController
@RequestMapping("v1/link")
public class LinkController extends BaseController<LinkEntity, LinkDTO> {

	@Autowired
	private LinkService service;
	
	@Override
	protected BaseService<LinkEntity, LinkDTO> getService() {
		return service;
	}
	
	public ResponseDTO getAllByIdPost(@PathVariable("idPost") Long idPost) {
		return ResponseDTO.withData(service.getAllByIdPost(idPost));
	}

}
