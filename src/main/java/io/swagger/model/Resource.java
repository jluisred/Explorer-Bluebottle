package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Resource
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-01-16T15:15:21.846Z")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Resource   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("content")
  private String content = null;
  
  @JsonProperty("score")
  private double score;

  public Resource id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the Resource
   * @return id
  **/
  @ApiModelProperty(value = "ID of the Resource")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Resource name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the Resource
   * @return name
  **/
  @ApiModelProperty(value = "Name of the Resource")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  
  public Resource score(double score) {
	    this.score = score;
	    return this;
	  }

	   /**
	   * Score of the Resource
	   * @return score
	  **/
	  @ApiModelProperty(value = "Score of the Resource")
	  public double getScore() {
	    return score;
	  }

	  public void setScore(double score) {
	    this.score = score;
	  }
	  
	  
	  

  public Resource content(String content) {
    this.content = content;
    return this;
  }

   /**
   * Content of the Resource
   * @return content
  **/
  @ApiModelProperty(value = "Content of the Resource")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Resource resource = (Resource) o;
    return Objects.equals(this.id, resource.id) &&
        Objects.equals(this.name, resource.name) &&
        Objects.equals(this.content, resource.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resource {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");

    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

