package io.swagger.api;

import io.swagger.model.Book;
import io.swagger.model.Error;
import io.swagger.model.TopicDistribution;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-04T11:07:26.201Z")

@Api(value = "documents", description = "the documents API")
public interface DocumentsApi {

    @ApiOperation(value = "Provide a new document to be indexed", notes = "This operation allows to add a new document that is automatically indexed in the collection and annotated with topics.  ", response = String.class, tags={ "Documents", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "ID of the document added to the collection", response = String.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = String.class),
        @ApiResponse(code = 405, message = "Validation exception", response = String.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
    @RequestMapping(value = "/documents/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<String> documentsIdPost(
@ApiParam(value = "ID of the document",required=true ) @PathVariable("id") String id


,

@ApiParam(value = "Book and its chapters in a textual form."  ) @RequestBody Book body

);


    @ApiOperation(value = "Get Document's Topic", notes = "This operation returns a list of weighted LDA topics associated to a particular document D. Each topic is a list of ranked words. ", response = TopicDistribution.class, responseContainer = "List", tags={ "Documents","Topics", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of topics", response = TopicDistribution.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = TopicDistribution.class) })
    @RequestMapping(value = "/documents/{id}/topicDistribution",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<TopicDistribution>> documentsIdTopicDistributionGet(
@ApiParam(value = "ID of the document.",required=true ) @PathVariable("id") String id


);

}
