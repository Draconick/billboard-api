package br.com.cers.billboardapi.core.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cers.billboardapi.core.controller.dto.WarningDTO;
import br.com.cers.billboardapi.core.converter.WarningConverter;
import br.com.cers.billboardapi.core.model.Warning;
import br.com.cers.billboardapi.core.repository.WarningRepository;

@Service
public class WarningService {

	@Autowired
	private WarningRepository warningRepository;
	
	@Autowired
	private WarningConverter warningConverter;
	
	public WarningDTO findById(Long id) {
		final Optional<Warning> warningOptional = warningRepository.findById(id);
		if(warningOptional.isPresent()) {
			Warning warning = warningOptional.get();
			WarningDTO warningDTO = warningConverter.toDTO(warning);
			warning.setLatestPreview(LocalDateTime.now());
			warningRepository.saveAndFlush(warning);
			return warningDTO;			
		} else {
			return null;
		}
	}
	
	public WarningDTO insert(WarningDTO warningDTO) {
		Warning warning = warningRepository.save(warningConverter.fromDTO(warningDTO));
		
		return warningConverter.toDTO(warning);
	}
	
	public List<WarningDTO> findAll(){
		return warningConverter.toListDTO(warningRepository.findAll());
	}
	
	public void delete(Long id) {
		final Optional<Warning> warningOptional = warningRepository.findById(id);
		if(warningOptional.isPresent()) {
			warningRepository.delete(warningOptional.get());
		}
	}
}
