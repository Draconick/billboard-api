package br.com.cers.billboardapi.core.controller.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarningDTO {
	
	private Long id;
	private String title;
	private String description;
	private LocalDateTime created;
	private LocalDateTime latestPreview;
	
}
