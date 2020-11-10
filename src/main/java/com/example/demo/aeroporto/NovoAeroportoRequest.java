package com.example.demo.aeroporto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoAeroportoRequest {
	
	@NotBlank
	private String nome;
	
	@NotNull
	private Long paisId;

	public static Aeroporto toModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
