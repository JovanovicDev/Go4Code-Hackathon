package socialnetwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import socialnetwork.model.Label;
import socialnetwork.repository.LabelRepository;

@Component
public class LabelService {
	
	@Autowired
	private LabelRepository labelRepository;
	
	public List<Label> findAll (){
		
		return labelRepository.findAll();
	}
	
	public Label findOne (Long id) {
		return labelRepository.findById(id).get();
	}

}
