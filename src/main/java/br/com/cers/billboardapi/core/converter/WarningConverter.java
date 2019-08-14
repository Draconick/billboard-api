package br.com.cers.billboardapi.core.converter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.cers.billboardapi.core.controller.dto.WarningDTO;
import br.com.cers.billboardapi.core.model.Warning;

@Component
public class WarningConverter {

	
	public WarningDTO toDTO(final Warning warning) {
		final WarningDTO warningDTO = new WarningDTO();
		
		warningDTO.setId(warning.getId());
		warningDTO.setDescription(warning.getDescription());
		warningDTO.setTitle(warning.getTitle());
		warningDTO.setCreated(warning.getCreated());
		warningDTO.setLatestPreview(warning.getLatestPreview());
		
		return warningDTO;
	}
	
	public Warning fromDTO(WarningDTO warningDTO) {
		final Warning warning = new Warning();
		
		if(warningDTO.getId() != null) {
			warning.setId(warningDTO.getId());			
		}
		warning.setTitle(warningDTO.getTitle());
		warning.setDescription(warningDTO.getDescription());
		if(warningDTO.getCreated() != null) {
			warning.setCreated(warningDTO.getCreated());			
		} else {
			warning.setCreated(LocalDateTime.now());
		}
		if(warningDTO.getLatestPreview() != null) {
			warning.setLatestPreview(warningDTO.getLatestPreview());			
		}
		
		return warning;
	}
	
	public List<WarningDTO> toListDTO(List<Warning> listmodel) {
		return listmodel.stream().map(p -> {
			return toDTO(p);
		}).collect(Collectors.toList());
	}
}
