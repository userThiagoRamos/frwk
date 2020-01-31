package br.com.frwk.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService<E extends BaseEntity, D extends BaseDTO>  {

	@Autowired
	private ModelMapper modelMapper;

	@SuppressWarnings("unused")
	private Class<E> entityTypeClass;

	public E create(D dto) {
		E entity = modelMapper.map(dto, getEntityTypeClass());
		return getRepository().save(entity);
	}

	public E update(String username, D dto) {
		E entity = null;
		if (dto.getId() != null && getRepository().existsById(dto.getId())) {
			entity = modelMapper.map(dto, getEntityTypeClass());
			getRepository().save(entity);
		}
		return entity;
	}

	public void delete(String username,Long id) {
		getRepository().deleteById(id);
	}

	public E findById(Long id) {
		return getRepository().findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public List<E> findAll() {
		return getRepository().findAll();
	}

	@SuppressWarnings("unchecked")
	public Class<E> getEntityTypeClass() {
		return (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public abstract BaseRepository<E> getRepository();

}
