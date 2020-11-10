package com.example.demo.aeroporto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NomeUnicoAeroportoValidator implements Validator {

    private AeroportoRepository aeroportoRepository;

    public NomeUnicoAeroportoValidator(AeroportoRepository aeroportoRepository) {
        this.aeroportoRepository = aeroportoRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAeroportoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NovoAeroportoRequest request = (NovoAeroportoRequest) target;

        if (errors.hasErrors()) {
            return;
        }

        Optional<Aeroporto> possivelAeroporto = aeroportoRepository.findByNome(request.getNome());
        if (possivelAeroporto.isPresent()) {
            errors.rejectValue("nome", null, "Nome de aeroporto nao pode ser repetido");
        }

    }
}
