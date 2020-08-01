package br.com.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.List;

import br.com.escola.repository.TurmaRepository;
import br.com.escola.model.Turma;

@RestController
@RequestMapping("/turma")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class TurmaController {

	@Autowired
	private TurmaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Turma>> findAllTurma (){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> findByIDTurma (@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@PostMapping
	public ResponseEntity<Turma> postTurma (@RequestBody Turma turma){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(turma));
	}
	@PutMapping
	public ResponseEntity<Turma> putTurma  (@RequestBody Turma turma){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(turma));
	}
	@DeleteMapping("/{id}")
	public void deleteTurma (@PathVariable long id) {
		repository.deleteById(id);
	}

}
