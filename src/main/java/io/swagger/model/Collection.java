package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;




/**
 * Collection
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-04T11:07:26.201Z")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Collection   {
  private BigDecimal numDocuments = null;

  private Boolean LDA = null;

 
  private String dateLDA = null;

  private BigDecimal numTopics = null;

  public Collection numDocuments(BigDecimal numDocuments) {
    this.numDocuments = numDocuments;
    return this;
  }

   /**
   * Number of documents in the collection
   * @return numDocuments
  **/
  @ApiModelProperty(value = "Number of documents in the collection")
  public BigDecimal getNumDocuments() {
    return numDocuments;
  }

  public void setNumDocuments(BigDecimal numDocuments) {
    this.numDocuments = numDocuments;
  }

  public Collection LDA(Boolean LDA) {
    this.LDA = LDA;
    return this;
  }

   /**
   * Indicates if the Topic Modelling has been calculated for this collection
   * @return LDA
  **/
  @ApiModelProperty(value = "Indicates if the Topic Modelling has been calculated for this collection")
  public Boolean getLDA() {
    return LDA;
  }

  public void setLDA(Boolean LDA) {
    this.LDA = LDA;
  }

  public Collection dateLDA(String dateLDA) {
    this.dateLDA = dateLDA;
    return this;
  }

   /**
   * date/time when the last LDA iteration was performed
   * @return dateLDA
  **/
  @ApiModelProperty(value = "date/time when the last LDA iteration was performed")
  public String getDateLDA() {
    return dateLDA;
  }

  public void setDateLDA(String dateLDA) {
    this.dateLDA = dateLDA;
  }

  public Collection numTopics(BigDecimal numTopics) {
    this.numTopics = numTopics;
    return this;
  }

   /**
   * Number of topics found in the corpus
   * @return numTopics
  **/
  @ApiModelProperty(value = "Number of topics found in the corpus")
  public BigDecimal getNumTopics() {
    return numTopics;
  }

  public void setNumTopics(BigDecimal numTopics) {
    this.numTopics = numTopics;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Collection collection = (Collection) o;
    return Objects.equals(this.numDocuments, collection.numDocuments) &&
        Objects.equals(this.LDA, collection.LDA) &&
        Objects.equals(this.dateLDA, collection.dateLDA) &&
        Objects.equals(this.numTopics, collection.numTopics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numDocuments, LDA, dateLDA, numTopics);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Collection {\n");
    
    sb.append("    numDocuments: ").append(toIndentedString(numDocuments)).append("\n");
    sb.append("    LDA: ").append(toIndentedString(LDA)).append("\n");
    sb.append("    dateLDA: ").append(toIndentedString(dateLDA)).append("\n");
    sb.append("    numTopics: ").append(toIndentedString(numTopics)).append("\n");
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

