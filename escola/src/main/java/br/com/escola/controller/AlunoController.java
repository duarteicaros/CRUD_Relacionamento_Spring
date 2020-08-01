package br.com.escola.controller;

import java.util.List;

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

import br.com.escola.model.Aluno;
import br.com.escola.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {

	@Autowired
	private AlunoRepository repository;

	@GetMapping
	public ResponseEntity<List<Aluno>> findAllAluno() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findByIDAluno(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Aluno> postAluno(@RequestBody Aluno aluno) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
	}

	@PutMapping
	public ResponseEntity<Aluno> putAluno(@RequestBody Aluno aluno) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(aluno));
	}

	@DeleteMapping("/{id}")
	public void deleteAluno(@PathVariable long id) {
		repository.deleteById(id);
	}
}
