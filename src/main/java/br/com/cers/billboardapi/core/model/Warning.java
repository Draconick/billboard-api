package br.com.cers.billboardapi.core.model;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="WARNING")
public class Warning {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="CREATED")
	@NotNull
	private LocalDateTime created;
	
	@Column(name="LATEST_PREVIEW")
	private LocalDateTime latestPreview;
	
	
}
