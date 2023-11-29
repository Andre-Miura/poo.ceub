package com.poo.controlador.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.poo.controlador.repositories.ControladorRepository;
import com.poo.controlador.dtos.ControladorDto;
import com.poo.controlador.models.ControladorModel;

@RestController
public class ControladorController {

	@Autowired
	ControladorRepository controladorRepository;
	
	@GetMapping("/lista")
	public ResponseEntity<List<ControladorModel>> listar(){
		List<ControladorModel> controladorList = controladorRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(controladorList);
	}
	
	@PostMapping("/criar")
	public ResponseEntity<ControladorModel> salvar(@RequestBody @Valid ControladorDto controladorDto) {
		var controladorModel = new ControladorModel();
		BeanUtils.copyProperties(controladorDto, controladorModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(controladorRepository.save(controladorModel));
	}
	
	@GetMapping("/pesquisar/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable(value="id") Integer id){
		Optional<ControladorModel> controlador = controladorRepository.findById(id);
		if(controlador.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse entregador não está cadastrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(controlador.get());
	}
	
	@PutMapping("/alterar/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value="id") Integer id,
													  @RequestBody @Valid ControladorDto controladorDto) {
		Optional<ControladorModel> controlador = controladorRepository.findById(id);
		if(controlador.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não cadastrado, crie seu cadastro.");
		}
		var controladorModel = controlador.get();
		BeanUtils.copyProperties(controladorDto, controladorModel);
		return ResponseEntity.status(HttpStatus.OK).body(controladorRepository.save(controladorModel));
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") Integer id) {
		Optional<ControladorModel> controlador = controladorRepository.findById(id);
		if(controlador.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não existente.");
		}
		controladorRepository.delete(controlador.get());
		return ResponseEntity.status(HttpStatus.OK).body("O entregador foi apagado.");
	}
	
	
}