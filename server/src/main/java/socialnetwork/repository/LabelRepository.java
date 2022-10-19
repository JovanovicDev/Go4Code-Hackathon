package socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import socialnetwork.model.Label;

@Component
public interface LabelRepository extends JpaRepository<Label, Long> {
	
	

}
