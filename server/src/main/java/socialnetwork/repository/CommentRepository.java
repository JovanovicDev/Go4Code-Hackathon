package socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import socialnetwork.model.Comment;

@Component
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
