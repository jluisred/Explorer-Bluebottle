package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Author;
import io.swagger.model.Chapter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;




/**
 * Book
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-04T11:07:26.201Z")

public class Book   {
  private String isbn = null;

  private List<Chapter> chapters = new ArrayList<Chapter>();

  private String name = null;

  private String subtitle = null;

  private String summary = null;

  private BigDecimal avgRating = null;

  private BigDecimal numRating = null;

  private BigDecimal shares = null;

  private String status = null;

  private String seoBook = null;

  private String bookBover = null;

  private String contentType = null;

  private String editionYear = null;

  private List<Author> authors = new ArrayList<Author>();

  public Book isbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

   /**
   * ID of the document
   * @return isbn
  **/
  @ApiModelProperty(value = "ID of the document")
  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Book chapters(List<Chapter> chapters) {
    this.chapters = chapters;
    return this;
  }

  public Book addChaptersItem(Chapter chaptersItem) {
    this.chapters.add(chaptersItem);
    return this;
  }

   /**
   * List of chapters belonging to a document
   * @return chapters
  **/
  @ApiModelProperty(value = "List of chapters belonging to a document")
  public List<Chapter> getChapters() {
    return chapters;
  }

  public void setChapters(List<Chapter> chapters) {
    this.chapters = chapters;
  }

  public Book name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Title of the Document
   * @return name
  **/
  @ApiModelProperty(value = "Title of the Document")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Book subtitle(String subtitle) {
    this.subtitle = subtitle;
    return this;
  }

   /**
   * Subtitle of the Document
   * @return subtitle
  **/
  @ApiModelProperty(value = "Subtitle of the Document")
  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public Book summary(String summary) {
    this.summary = summary;
    return this;
  }

   /**
   * Summary of the Document
   * @return summary
  **/
  @ApiModelProperty(value = "Summary of the Document")
  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public Book avgRating(BigDecimal avgRating) {
    this.avgRating = avgRating;
    return this;
  }

   /**
   * Average Rating
   * @return avgRating
  **/
  @ApiModelProperty(value = "Average Rating")
  public BigDecimal getAvgRating() {
    return avgRating;
  }

  public void setAvgRating(BigDecimal avgRating) {
    this.avgRating = avgRating;
  }

  public Book numRating(BigDecimal numRating) {
    this.numRating = numRating;
    return this;
  }

   /**
   * Number of ratings available
   * @return numRating
  **/
  @ApiModelProperty(value = "Number of ratings available")
  public BigDecimal getNumRating() {
    return numRating;
  }

  public void setNumRating(BigDecimal numRating) {
    this.numRating = numRating;
  }

  public Book shares(BigDecimal shares) {
    this.shares = shares;
    return this;
  }

   /**
   * Number of times being shared
   * @return shares
  **/
  @ApiModelProperty(value = "Number of times being shared")
  public BigDecimal getShares() {
    return shares;
  }

  public void setShares(BigDecimal shares) {
    this.shares = shares;
  }

  public Book status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Book seoBook(String seoBook) {
    this.seoBook = seoBook;
    return this;
  }

   /**
   * Get seoBook
   * @return seoBook
  **/
  @ApiModelProperty(value = "")
  public String getSeoBook() {
    return seoBook;
  }

  public void setSeoBook(String seoBook) {
    this.seoBook = seoBook;
  }

  public Book bookBover(String bookBover) {
    this.bookBover = bookBover;
    return this;
  }

   /**
   * Get bookBover
   * @return bookBover
  **/
  @ApiModelProperty(value = "")
  public String getBookBover() {
    return bookBover;
  }

  public void setBookBover(String bookBover) {
    this.bookBover = bookBover;
  }

  public Book contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

   /**
   * Get contentType
   * @return contentType
  **/
  @ApiModelProperty(value = "")
  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public Book editionYear(String editionYear) {
    this.editionYear = editionYear;
    return this;
  }

   /**
   * Year of edition
   * @return editionYear
  **/
  @ApiModelProperty(value = "Year of edition")
  public String getEditionYear() {
    return editionYear;
  }

  public void setEditionYear(String editionYear) {
    this.editionYear = editionYear;
  }

  public Book authors(List<Author> authors) {
    this.authors = authors;
    return this;
  }

  public Book addAuthorsItem(Author authorsItem) {
    this.authors.add(authorsItem);
    return this;
  }

   /**
   * List of authors
   * @return authors
  **/
  @ApiModelProperty(value = "List of authors")
  public List<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(List<Author> authors) {
    this.authors = authors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(this.isbn, book.isbn) &&
        Objects.equals(this.chapters, book.chapters) &&
        Objects.equals(this.name, book.name) &&
        Objects.equals(this.subtitle, book.subtitle) &&
        Objects.equals(this.summary, book.summary) &&
        Objects.equals(this.avgRating, book.avgRating) &&
        Objects.equals(this.numRating, book.numRating) &&
        Objects.equals(this.shares, book.shares) &&
        Objects.equals(this.status, book.status) &&
        Objects.equals(this.seoBook, book.seoBook) &&
        Objects.equals(this.bookBover, book.bookBover) &&
        Objects.equals(this.contentType, book.contentType) &&
        Objects.equals(this.editionYear, book.editionYear) &&
        Objects.equals(this.authors, book.authors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isbn, chapters, name, subtitle, summary, avgRating, numRating, shares, status, seoBook, bookBover, contentType, editionYear, authors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Book {\n");
    
    sb.append("    isbn: ").append(toIndentedString(isbn)).append("\n");
    sb.append("    chapters: ").append(toIndentedString(chapters)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    subtitle: ").append(toIndentedString(subtitle)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
    sb.append("    avgRating: ").append(toIndentedString(avgRating)).append("\n");
    sb.append("    numRating: ").append(toIndentedString(numRating)).append("\n");
    sb.append("    shares: ").append(toIndentedString(shares)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    seoBook: ").append(toIndentedString(seoBook)).append("\n");
    sb.append("    bookBover: ").append(toIndentedString(bookBover)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    editionYear: ").append(toIndentedString(editionYear)).append("\n");
    sb.append("    authors: ").append(toIndentedString(authors)).append("\n");
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

