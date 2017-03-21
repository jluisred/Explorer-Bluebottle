package io.swagger.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.InlineResponse200;
import io.swagger.model.Resource;
import io.swagger.model.Tag;
import io.swagger.model.TopicDistribution;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-15T17:52:24.109Z")

@Api(value = "chapters", description = "the chapters API")
public interface ChaptersApi {

	
    @ApiOperation(value = "Get Chapter's similar Chapters", notes = "Obtain the most similar chapters given another. ", response = Resource.class, responseContainer = "List", tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Chapters", response = Resource.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Resource.class) })
    @RequestMapping(value = "/chapters/{idChap}/similar/chapters",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Resource>> chaptersIdChapSimilarChaptersGet(@ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap);


    @ApiOperation(value = "Get Chapter's similarity with another Chapter", notes = "Obtain similarity score between two Chapters. ", response = InlineResponse200.class, tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Similarity score", response = InlineResponse200.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = InlineResponse200.class) })
    @RequestMapping(value = "/chapters/{idChap}/similar/chapters/{idChap2}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> chaptersIdChapSimilarChaptersIdChap2Get(@ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap,
        @ApiParam(value = "ID of the second Chapter",required=true ) @PathVariable("idChap2") String idChap2);


    @ApiOperation(value = "Get Document's similar Documents", notes = "Obtain the most similar documents given a chapter. ", response = Resource.class, responseContainer = "List", tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Documents", response = Resource.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Resource.class) })
    @RequestMapping(value = "/chapters/{idChap}/similar/documents",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Resource>> chaptersIdChapSimilarDocumentsGet(@ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap);


    @ApiOperation(value = "Get Chapter's similarity with a Document", notes = "Obtain similarity score between Chapter and Document. ", response = InlineResponse200.class, tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Similarity score", response = InlineResponse200.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = InlineResponse200.class) })
    @RequestMapping(value = "/chapters/{idChap}/similar/documents/{idDoc}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> chaptersIdChapSimilarDocumentsIdDocGet(@ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap,
        @ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc);


    @ApiOperation(value = "Get Chapter's similar Resources", notes = "Obtain the most similar resources given a chapter. ", response = Resource.class, responseContainer = "List", tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Resources", response = Resource.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Resource.class) })
    @RequestMapping(value = "/chapters/{idChap}/similar",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Resource>> chaptersIdChapSimilarGet(@ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap);


    @ApiOperation(value = "Get Chapter's similar Users", notes = "Obtain the most similar users given a chapter. ", response = Resource.class, responseContainer = "List", tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Users", response = Resource.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Resource.class) })
    @RequestMapping(value = "/chapters/{idChap}/similar/users",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Resource>> chaptersIdChapSimilarUsersGet(@ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap);


    @ApiOperation(value = "Get Chapter's similarity with another User", notes = "Obtain the similarity score between a chapter and user. ", response = InlineResponse200.class, tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Similarity score", response = InlineResponse200.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = InlineResponse200.class) })
    @RequestMapping(value = "/chapters/{idChap}/similar/users/{idUser}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> chaptersIdChapSimilarUsersIdUserGet(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idChap") String idChap,
        @ApiParam(value = "ID of the User",required=true ) @PathVariable("idUser") String idUser);

    
    
    @ApiOperation(value = "Get Chapter's top Explorative Tags", notes = "This operation returns a list of weighted Tags associated to a particular chapter C. Each tag is accompanied by a relevance score ", response = Tag.class, responseContainer = "List", tags={ "Chapters", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Tags", response = Tag.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Tag.class) })
    @RequestMapping(value = "/chapters/{id}/topExplorativeTags",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Tag>> chaptersIdTopExplorativeTagsGet(
@ApiParam(value = "ID of the chapter",required=true ) @PathVariable("id") String id


);
    
    @ApiOperation(value = "Get Chapter's top Specific Tags", notes = "This operation returns a list of weighted Tags associated to a particular chapter C. Each tag is accompanied by a relevance score ", response = Tag.class, responseContainer = "List", tags={ "Chapters", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Tags", response = Tag.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Tag.class) })
    @RequestMapping(value = "/chapters/{id}/topSpecificTags",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Tag>> chaptersIdTopSpecificTagsGet(
@ApiParam(value = "ID of the chapter",required=true ) @PathVariable("id") String id


);


    @ApiOperation(value = "Get Chapter's Topics", notes = "This operation returns a list of weighted LDA topics associated to a particular chapter C. Each topic is a list of ranked words. ", response = TopicDistribution.class, responseContainer = "List", tags={ "Chapters", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of topics", response = TopicDistribution.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = TopicDistribution.class) })
    @RequestMapping(value = "/chapters/{id}/topicDistribution",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<TopicDistribution>> chaptersIdTopicDistributionGet(
@ApiParam(value = "ID of the chapter",required=true ) @PathVariable("id") String id
,@ApiParam(value = "Smart filtering flag") @RequestParam(value = "filter", required = false) Boolean filter


);
    
    @ApiOperation(value = "Get list of Chapters indexed in the Platform", notes = "Obtain the list of available chapters. ", response = String.class, responseContainer = "List", tags={ "Chapters", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of Chapters", response = String.class)})
    @RequestMapping(value = "/chapters",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> chaptersGet(
            @ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
    		);

}
