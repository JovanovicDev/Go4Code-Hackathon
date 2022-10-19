package socialnetwork.dto;

import java.time.LocalDateTime;

import socialnetwork.model.Post;
import socialnetwork.model.User;

public class PostDTO {
	
	private Long id;
	private User user;
	private LocalDateTime time;
	private String content;
//	private List<Comment> comments = new ArrayList<Comment>();
	
	public PostDTO() {
	}
	
	public PostDTO(Post p) {
		this.id = p.getId();
		this.user = p.getUser();
		this.time = p.getTime();
		this.content = p.getContent();
//		this.comments = p.getComments();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

//	public List<Comment> getComments() {
//		return comments;
//	}
//
//	public void setComments(List<Comment> comments) {
//		this.comments = comments;
//	}
}
