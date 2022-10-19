package socialnetwork.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import socialnetwork.dto.CommentDTO;
import socialnetwork.dto.PostDTO;
import socialnetwork.model.Comment;
import socialnetwork.model.Post;
import socialnetwork.service.CommentService;

@RestController
@RequestMapping(value = "api/comments")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<CommentDTO>> getAllComments(Pageable page) {
		Page<Comment> comments = commentService.findAll(page);
		
		List<CommentDTO> retVal = new ArrayList<>();
	
		for(Comment c : comments) {
			retVal.add(new CommentDTO(c));
		}
		

		return new ResponseEntity<>(retVal, HttpStatus.OK); 
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CommentDTO> getComment(@PathVariable Long id) {
		Comment item = commentService.findOne(id);
		CommentDTO dto = new CommentDTO(item);

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommentDTO> create(@RequestBody CommentDTO postDTO) {
		
		Comment c = new Comment();
		c.setUser(postDTO.getUser());
		c.setPost(postDTO.getPost());
		c.setTime(postDTO.getTime());
		c.setContent(postDTO.getContent());
		
		c = commentService.save(c);

		return new ResponseEntity<>(new CommentDTO(c), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommentDTO> update(@PathVariable Long id,
			@RequestBody CommentDTO postDTO) {
		
		Comment p = new Comment();
		p.setId(postDTO.getId());
		p.setUser(postDTO.getUser());
		p.setPost(postDTO.getPost());
		p.setTime(postDTO.getTime());
		p.setContent(postDTO.getContent());
		
		p = commentService.save(p);

		return new ResponseEntity<>(new CommentDTO(p), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Comment p = commentService.findOne(id);
		if (p != null) {
			commentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<CommentDTO>> getCommentsForUser(Pageable page, @PathVariable Long id) {
	
		Page<Comment> comments = commentService.findAll(page);
		
		List<CommentDTO> retVal = new ArrayList<>();
		
		for(Comment c : comments) {
			if (c.getUser().getId() == id ) {
				
				retVal.add(new CommentDTO(c));
				
			}
			
		}
		
		return new ResponseEntity<>(retVal, HttpStatus.OK) ;


	}
	
	
	
	
	
	
	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<CommentDTO>> getCommentsForPost(Pageable page, @PathVariable Long id) {
	
		Page<Comment> comments = commentService.findAll(page);
		
		List<CommentDTO> retVal = new ArrayList<>();
		
		for(Comment c : comments) {
			if (c.getPost().getId() == id ) {
				
				CommentDTO dto = new CommentDTO(c);
				retVal.add(dto);
				
			}
			
		}
		
		return new ResponseEntity<>(retVal, HttpStatus.OK) ;


	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
