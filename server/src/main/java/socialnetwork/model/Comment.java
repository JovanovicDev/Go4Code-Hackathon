package socialnetwork.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment") 
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name = "time")
	private LocalDateTime time;
	
	@Column(name = "content")
	private String content;
	
	public Comment() {
		
	}
	
	public Comment(Long id, Post post, User user, LocalDateTime time, String content) {
		super();
		this.id = id;
		this.post = post;
		this.user = user;
		this.time = time;
		this.content = content;
	}
	
	public Comment(Comment c) {
		super();
		this.id = c.getId();
		this.post = c.getPost();
		this.user = c.getUser();
		this.time = c.getTime();
		this.content = c.getContent();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}
	
	public void setPost(Post post) {
		this.post = post;
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

	@Override
	public String toString() {
		return "Comment [id=" + id + ", post=" + post + ", user=" + user + ", time=" + time + ", content=" + content
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, id, post, time, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(content, other.content) && Objects.equals(id, other.id)
				&& Objects.equals(post, other.post) && Objects.equals(time, other.time)
				&& Objects.equals(user, other.user);
	}

	
}
