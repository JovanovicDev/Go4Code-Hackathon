package socialnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import socialnetwork.model.Post;
import socialnetwork.repository.PostRepository;

@Component
public class PostService {
	
	@Autowired
	PostRepository postRepository;

	public Page<Post> findAll(Pageable page) {
		return postRepository.findAll(page);
	}

	public Post findOne(Long id) {
		return postRepository.findById(id).get();
	}

	public Post save(Post post) {
		return postRepository.save(post);
	}

	public void remove(Long id) {
		postRepository.deleteById(id);
	}
}

