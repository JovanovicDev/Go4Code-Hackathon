package socialnetwork.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import socialnetwork.dto.LabelDTO;
import socialnetwork.model.Label;
import socialnetwork.service.LabelService;

@RestController
@RequestMapping(value = "api/labels")
@CrossOrigin(origins = "http://localhost:4200")
public class LabelController {
	
	@Autowired
	LabelService labelService;

	@RequestMapping(method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<LabelDTO>> getAllLabels() {
		List<Label> labels = labelService.findAll();
		
		List<LabelDTO> retVal = new ArrayList<>();
	
		for(Label l : labels) {
			retVal.add(new LabelDTO(l));
		}
		

		return new ResponseEntity<>(retVal, HttpStatus.OK); 
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<LabelDTO> getLabel(@PathVariable Long id) {
		Label item = labelService.findOne(id);
		LabelDTO dto = new LabelDTO(item);

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

}
