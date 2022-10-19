package socialnetwork.dto;

import java.time.LocalDateTime;

import socialnetwork.model.Comment;
import socialnetwork.model.Post;
import socialnetwork.model.User;

public class CommentDTO {
	
	private Long id;
	private User user;
	private Post post;
	private LocalDateTime time;
	private String content;
	
	public CommentDTO() {
		super();
	}

	public CommentDTO(Long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
	public CommentDTO(Comment c) {
		this.id = c.getId();
		this.user = c.getUser();
		this.post = c.getPost();
		this.time = c.getTime();
		this.content = c.getContent();
	}

	public CommentDTO(Long id, User user, Post post, LocalDateTime time, String content) {
		super();
		this.id = id;
		this.user = user;
		this.post = post;
		this.time = time;
		this.content = content;
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
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
	
	
	
	

}
