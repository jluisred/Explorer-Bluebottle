package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * User
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-01-16T15:15:21.846Z")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class UserDeprecated   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;
  
  @JsonProperty("score")
  private double score;

  public UserDeprecated id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the User
   * @return id
  **/
  @ApiModelProperty(value = "ID of the User")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  
  
  public UserDeprecated score(double score) {
	    this.score = score;
	    return this;
	  }

	   /**
	   * Score of the Resource
	   * @return score
	  **/
	  @ApiModelProperty(value = "Score of the User")
	  public double getScore() {
	    return score;
	  }

	  public void setScore(double score) {
	    this.score = score;
	  }
	  
	  
	  
	  
  public UserDeprecated name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the User
   * @return name
  **/
  @ApiModelProperty(value = "Name of the User")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDeprecated user = (UserDeprecated) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

