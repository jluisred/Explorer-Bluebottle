package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * Tag
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-15T17:52:24.109Z")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Tag   {
  private String surface = null;

  private Double score = null;
  private String type = null;

  public Tag surface(String surface) {
    this.surface = surface;
    return this;
  }

   /**
   * Word belonging to a particular topic
   * @return surface
  **/
  @ApiModelProperty(value = "Word belonging to a particular topic")
  public String getSurface() {
    return surface;
  }

  public void setSurface(String surface) {
    this.surface = surface;
  }

  public Tag score(Double score) {
    this.score = score;
    return this;
  }

   /**
   * Importancy of the word inside the topic
   * @return score
  **/
  @ApiModelProperty(value = "Importancy of the word inside the topic")
  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }


  public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tag tag = (Tag) o;
    return Objects.equals(this.surface, tag.surface) &&
        Objects.equals(this.score, tag.score);
  }

  @Override
  public int hashCode() {
    return Objects.hash(surface, score);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tag {\n");
    
    sb.append("    surface: ").append(toIndentedString(surface)).append("\n");
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

