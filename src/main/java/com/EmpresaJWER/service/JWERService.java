package com.EmpresaJWER.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.EmpresaJWER.entitie.JWER;
import com.EmpresaJWER.repository.JWERRepository;

@Service
public class JWERService {
private final JWERRepository jwerRepository;
public JWERService(JWERRepository JWERRepository) {
	this.jwerRepository = JWERRepository;
}

public List<JWER> getAllJWER (){
	return jwerRepository.findAll();
}

public JWER getJWERById(Long id) {
	Optional<JWER> JWER = jwerRepository.findById(id);
	return JWER.orElse(null);
}

public JWER salvarJWER(JWER jwer) {
	return jwerRepository.save(jwer);
}

public JWER updateJWER(Long id, JWER updatedJWER) {
	Optional<JWER> existingJWER = jwerRepository.findById(id);
	if (existingJWER.isPresent()) {
		updatedJWER.setId(id);
		return jwerRepository.save(updatedJWER);
	}
	return null;
}

public boolean deleteJWER(Long id) {
	Optional<JWER> existingJWER = jwerRepository.findById(id);
	if (existingJWER.isPresent()) {
		jwerRepository.deleteById(id);
		return true;
	}
	return false;
}
}
