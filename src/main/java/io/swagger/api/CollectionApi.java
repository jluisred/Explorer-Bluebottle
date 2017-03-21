package io.swagger.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Collection;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-04T11:07:26.201Z")

@Api(value = "collection", description = "the collection API")
public interface CollectionApi {

    @ApiOperation(value = "Get Details about the indexed collection", notes = "This method returns a set of attributes about the collection of documents that have been indexed in the backend ", response = Collection.class, responseContainer = "List", tags={ "Collection", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An object with different attributes shaping the status of the collection", response = Collection.class),
        @ApiResponse(code = 404, message = "Unexpected error", response = Collection.class) })
    @RequestMapping(value = "/collection",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Collection> collectionGet();

    
    
    @ApiOperation(value = "Recalculate Topic Model over current collection", notes = "This method re-launch the topic modelling process over the collection of documents, and updates the corresponding similarity links ", response = String.class, responseContainer = "List", tags={ "Collection", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Topic Modelling has been launched", response = String.class),
        @ApiResponse(code = 404, message = "Unexpected error", response = Collection.class) })
    @RequestMapping(value = "/collection/topicModel",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> collectionReprocessTopic();
    
    
}
