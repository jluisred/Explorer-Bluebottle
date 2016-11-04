package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * Chapter
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-04T11:07:26.201Z")

public class Chapter   {
  private String id = null;

  private String text = null;

  public Chapter id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the chapter inside the book
   * @return id
  **/
  @ApiModelProperty(value = "ID of the chapter inside the book")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Chapter text(String text) {
    this.text = text;
    return this;
  }

   /**
   * Textual content of the chapter
   * @return text
  **/
  @ApiModelProperty(value = "Textual content of the chapter")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Chapter chapter = (Chapter) o;
    return Objects.equals(this.id, chapter.id) &&
        Objects.equals(this.text, chapter.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Chapter {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
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

