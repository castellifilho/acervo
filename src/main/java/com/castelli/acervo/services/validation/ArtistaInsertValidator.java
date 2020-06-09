package com.castelli.acervo.services.validation;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.castelli.acervo.domain.Artista;
import com.castelli.acervo.dto.ArtistaNewDTO;
import com.castelli.acervo.repositories.ArtistaRepository;
import com.castelli.acervo.resources.exceptions.FieldMessage;

public class ArtistaInsertValidator implements ConstraintValidator<ArtistaInsert, ArtistaNewDTO> {

	@Autowired
	private ArtistaRepository repo;
	@Override
	public void initialize(ArtistaInsert ann) {  }

	@Override
	public boolean isValid(ArtistaNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		Artista aux = repo.findByAlias(objDto.getAlias());
		//Artista auxNome = repo.findByNome(objDto.getNome());
		if(aux != null) {
			list.add(new FieldMessage("alias", "Artista já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
