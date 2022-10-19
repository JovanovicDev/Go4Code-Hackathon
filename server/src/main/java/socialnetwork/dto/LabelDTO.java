package socialnetwork.dto;

import socialnetwork.model.Label;

public class LabelDTO {
	
	private Long id;
	private String name;
	
	public LabelDTO() {
		super();
	}

	public LabelDTO(Label l) {
		this.id = l.getId();
		this.name = l.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
