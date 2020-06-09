package com.castelli.acervo.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.castelli.acervo.domain.Artista;
import com.castelli.acervo.dto.ArtistaDTO;
import com.castelli.acervo.repositories.ArtistaRepository;
import com.castelli.acervo.resources.exceptions.FieldMessage;

public class ArtistaUpdateValidator implements ConstraintValidator<ArtistaUpdate, ArtistaDTO> {

	@Autowired
	private HttpServletRequest request;   //Permite pegar o id do cliente
	@Autowired
	private ArtistaRepository repo;
	@Override
	public void initialize(ArtistaUpdate ann) {  }

	@Override
	public boolean isValid(ArtistaDTO objDto, ConstraintValidatorContext context) {
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) 
			request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();

		Artista aux = repo.findByAlias(objDto.getAlias());
		if(aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("alias", "Alias já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
