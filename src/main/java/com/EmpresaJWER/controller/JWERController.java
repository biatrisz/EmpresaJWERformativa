package com.EmpresaJWER.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmpresaJWER.entitie.JWER;
import com.EmpresaJWER.service.JWERService;

import jakarta.validation.Valid;

@RestController
@RequestMapping
@CrossOrigin 
public class JWERController {
	private final JWERService jwerService;
	
	public JWERController(JWERService jwerService) {
		this.jwerService = jwerService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<JWER> getProductById(@PathVariable Long id) {
		JWER jwer = jwerService.getJWERById(id);
		if (jwer != null) {
			return ResponseEntity.ok(jwer);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping
	public ResponseEntity<List<JWER>> getAllJWER() {
		List<JWER> jwer = jwerService.getAllJWER();
		return ResponseEntity.ok(jwer);
	}
	@PostMapping
	public ResponseEntity<JWER> criarjwer(@RequestBody @Valid JWER jwer){
		JWER criarJWER = jwerService.salvarJWER(jwer);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarJWER);
	}
	@PutMapping("/{id}")
	public ResponseEntity<JWER> updateJWER (@PathVariable Long id, @RequestBody @Valid JWER jwer) {
		JWER updatedJWER = jwerService.updateJWER(id, jwer);
		if (updatedJWER != null) {
			return ResponseEntity.ok(updatedJWER);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")

	public ResponseEntity<String> deleteJWER(@PathVariable Long id) {
		boolean deleted = jwerService.deleteJWER(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}
