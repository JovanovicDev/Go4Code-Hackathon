package socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import socialnetwork.model.Post;

@Component
public interface PostRepository extends JpaRepository<Post, Long>{

}
