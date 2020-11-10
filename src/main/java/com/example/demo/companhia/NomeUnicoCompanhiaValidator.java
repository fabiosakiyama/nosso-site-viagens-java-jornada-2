package com.example.demo.companhia;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NomeUnicoCompanhiaValidator implements Validator {

    private CompanhiaRepository companhiaRepository;

    public NomeUnicoCompanhiaValidator(CompanhiaRepository companhiaRepository) {
        this.companhiaRepository = companhiaRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCompanhiaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NovaCompanhiaRequest request = (NovaCompanhiaRequest) target;

        if (errors.hasErrors()) {
            return;
        }

        Optional<Companhia> possivelCompanhia = companhiaRepository.findByNome(request.getNome());
        if (possivelCompanhia.isPresent()) {
            errors.rejectValue("nome", null, "Nome da companhia ja existe");
        }

    }
}
