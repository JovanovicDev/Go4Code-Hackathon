package socialnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import socialnetwork.model.Comment;
import socialnetwork.repository.CommentRepository;

@Component
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;

	public Page<Comment> findAll(Pageable page) {
		return commentRepository.findAll(page);
	}

	public Comment findOne(Long id) {
		return commentRepository.findById(id).get();
	}

	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	public void remove(Long id) {
		commentRepository.deleteById(id);
	}

}
