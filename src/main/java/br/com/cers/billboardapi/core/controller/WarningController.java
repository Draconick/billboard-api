package br.com.cers.billboardapi.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cers.billboardapi.core.controller.dto.WarningDTO;
import br.com.cers.billboardapi.core.service.WarningService;

@RestController
@RequestMapping(value = "/api/v1/warnings", produces = MediaType.APPLICATION_JSON_VALUE)
public class WarningController {

	@Autowired
	private WarningService warningService;
	
	@GetMapping("/{id}")
	public ResponseEntity<WarningDTO> findById(@PathVariable final Long id) {
		return new ResponseEntity<>(warningService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<WarningDTO> insert(@RequestBody final WarningDTO warningDTO){
		final WarningDTO warning = warningService.insert(warningDTO);
		
		return new ResponseEntity<>(warning, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<WarningDTO>> findAll(){
		return new ResponseEntity<>(warningService.findAll(), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Long id) {
		warningService.delete(id);
	}
}
