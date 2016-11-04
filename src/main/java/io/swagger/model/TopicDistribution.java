package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Word;
import java.util.ArrayList;
import java.util.List;




/**
 * TopicDistribution
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-04T11:07:26.201Z")

public class TopicDistribution   {
  private List<Word> topic = new ArrayList<Word>();

  private Double weight = null;

  public TopicDistribution topic(List<Word> topic) {
    this.topic = topic;
    return this;
  }

  public TopicDistribution addTopicItem(Word topicItem) {
    this.topic.add(topicItem);
    return this;
  }

   /**
   * Words belonging to a particular topic
   * @return topic
  **/
  @ApiModelProperty(value = "Words belonging to a particular topic")
  public List<Word> getTopic() {
    return topic;
  }

  public void setTopic(List<Word> topic) {
    this.topic = topic;
  }

  public TopicDistribution weight(Double weight) {
    this.weight = weight;
    return this;
  }

   /**
   * Importancy of the topic inside the document
   * @return weight
  **/
  @ApiModelProperty(value = "Importancy of the topic inside the document")
  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TopicDistribution topicDistribution = (TopicDistribution) o;
    return Objects.equals(this.topic, topicDistribution.topic) &&
        Objects.equals(this.weight, topicDistribution.weight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topic, weight);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TopicDistribution {\n");
    
    sb.append("    topic: ").append(toIndentedString(topic)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
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

