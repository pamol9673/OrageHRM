package api_models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
	@JsonProperty("userId")
	private int userId;

	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("body")
	private String body;

	// Default constructor for JSON deserialization
	public Post() {
	}

	// Constructor for creating new posts
	public Post(int userId, String title, String body) {
		this.userId = userId;
		this.title = title;
		this.body = body;
	}

	// Getters
	public int getUserId() {
		return userId;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	// Setters
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return String.format("Post{userId=%d, id=%d, title='%s', body='%s'}", userId, id, title, body);
	}
}
