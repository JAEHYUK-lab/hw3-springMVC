package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Subject {
	private int year;
	private int semester;
	
	@NotEmpty(message="The subject cannot be empty")
	@Size(min=2, max=50, message="Subject must be between 2 and 50 chars")
	private String subject;
	
	
	private String classification;
	
	@Size(min=2, max=30, message="Professor must be between 2 and 30 chars")
	private String professor;
	private int credit;
}