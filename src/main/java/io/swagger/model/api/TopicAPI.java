package io.swagger.model.api;

import java.util.List;

public class TopicAPI {
	Ref ref ;
	String description;
	double score;
	List<WordAPI> words;
	public Ref getRef() {
		return ref;
	}
	public void setRef(Ref ref) {
		this.ref = ref;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public List<WordAPI> getWords() {
		return words;
	}
	public void setWords(List<WordAPI> words) {
		this.words = words;
	}
	
	
}


class Ref{
	String id;
	String uri;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
}
