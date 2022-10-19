package socialnetwork.controller;

import java.util.ArrayList;
import java.util.Collections;
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

import socialnetwork.dto.PostDTO;
import socialnetwork.model.Post;
import socialnetwork.model.User;
import socialnetwork.service.PostService;
import socialnetwork.service.UserService;

@RestController
@RequestMapping(value = "api/posts")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

	@Autowired
	UserService userService ;
	
	@Autowired
	PostService postService;

	@RequestMapping(method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<PostDTO>> getAllPosts(Pageable page) {
		Page<Post> posts = postService.findAll(page);
		
		List<PostDTO> retVal = new ArrayList<>();
	
		for(Post p : posts) {
			retVal.add(new PostDTO(p));
		}
		
		Collections.reverse(retVal);
		return new ResponseEntity<>(retVal, HttpStatus.OK); 
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PostDTO> getPost(@PathVariable Long id) {
		Post item = postService.findOne(id);
		PostDTO dto = new PostDTO(item);

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostDTO> create(@RequestBody PostDTO postDTO) {
		
		Post p = new Post();
		p.setUser(postDTO.getUser());
		p.setTime(postDTO.getTime());
		p.setContent(postDTO.getContent());
		
		p = postService.save(p);

		return new ResponseEntity<>(new PostDTO(p), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostDTO> update(@PathVariable Long id,
			@RequestBody PostDTO postDTO) {
		
		Post p = new Post();
		p.setId(postDTO.getId());
		p.setUser(postDTO.getUser());
		p.setTime(postDTO.getTime());
		p.setContent(postDTO.getContent());
		
		p = postService.save(p);

		return new ResponseEntity<>(new PostDTO(p), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Post p = postService.findOne(id);
		if (p != null) {
			postService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<PostDTO>> getPostsForUser(Pageable page, @PathVariable Long id) {
	
		Page<Post> posts = postService.findAll(page);
		
		List<PostDTO> retVal = new ArrayList<>();
		
		for(Post p : posts) {
			if (p.getUser().getId() == id ) {
				
				retVal.add(new PostDTO(p));
				
			}
			
		}
		
		return new ResponseEntity<>(retVal, HttpStatus.OK) ;


	}
	
	
	
	
	
	
	
	
	
	
}
