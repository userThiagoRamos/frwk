package br.com.frwk.base;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.frwk.dto.ResponseDTO;

public abstract class BaseController<E extends BaseEntity, D extends BaseDTO> {

	protected abstract BaseService<E, D> getService();

	@GetMapping(value = "/all")
	public ResponseDTO findAll() {
		List<E> resultList = getService().findAll();
		return ResponseDTO.withData(resultList);
	}

	@GetMapping(value = "/{id}")
	public ResponseDTO findOne(@PathVariable Long id) {
		E entity = getService().findById(id);
		return ResponseDTO.withData(entity);
	}

	@PostMapping
	public ResponseDTO create(@RequestBody @Valid D dto) {
		E entity = getService().create(dto);
		return ResponseDTO.withData(entity);
	}

	@PutMapping
	public ResponseDTO update(@RequestHeader(name = IConstants.HEADER_USERNAME) String username,
			@RequestBody @Valid D dto) {
		E entity = getService().update(username, dto);
		return ResponseDTO.withData(entity);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@RequestHeader(name = IConstants.HEADER_USERNAME) String username, @PathVariable Long id) {
		getService().delete(username, id);
	}

}
