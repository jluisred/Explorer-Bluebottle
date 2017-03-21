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
import io.swagger.model.UserDeprecated;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-01-16T15:15:21.846Z")

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "Get the list of all the Users in the platform", notes = "Get the list of all the Users in the platform", response = UserDeprecated.class, responseContainer = "List", tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Users", response = UserDeprecated.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = UserDeprecated.class) })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> usersGet(
            @ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
);


    @ApiOperation(value = "Delete a User", notes = "Delete a User from the platform ", response = String.class, tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = String.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<String> usersIdDelete(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id);

    @ApiOperation(value = "Add a User", notes = "Add a new user in the platform ", response = String.class, tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = String.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<String> usersIdPost(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id);

    
    @ApiOperation(value = "Get all the Documents related to User", notes = "Get all the Documents related to User ", response = Resource.class, responseContainer = "List", tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Resources", response = Resource.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Resource.class) })
    @RequestMapping(value = "/users/{id}/documents",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> usersIdDocumentGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
    		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
);


    @ApiOperation(value = "Add Document to User", notes = "Associate a Document  with a certain user. ", response = String.class, tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = String.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
    @RequestMapping(value = "/users/{id}/documents/{idDoc}",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<String> usersIdDocumentIdDocPost(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc);

    
    @ApiOperation(value = "Get User's tags for a Document D", notes = "Obtain the tags associated with a certain user, for a particular Document ", response = Tag.class, responseContainer = "List", tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of tags", response = Tag.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Tag.class) })
    @RequestMapping(value = "/users/{id}/documents/{idDoc}/tags",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> usersIdDocumentIdDocTagsGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc, 
   		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
);


    @ApiOperation(value = "Get User's Topics for a Document D", notes = "Obtain the topics associated with a certain user, for a particular book ", response = TopicDistribution.class, responseContainer = "List", tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Topics", response = TopicDistribution.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = TopicDistribution.class) })
    @RequestMapping(value = "/users/{id}/documents/{idDoc}/topics",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> usersIdDocumentIdDocTopicsGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc, 
   		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
);


    @ApiOperation(value = "Get User's tags", notes = "Obtain the tags associated with a certain user ", response = Tag.class, responseContainer = "List", tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of tags", response = Tag.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Tag.class) })
    @RequestMapping(value = "/users/{id}/tags",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> usersIdTagsGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id, 
       		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size);


    @ApiOperation(value = "Get User's Topics", notes = "Obtain the topics associated with a certain user ", response = TopicDistribution.class, responseContainer = "List", tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Topics", response = TopicDistribution.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = TopicDistribution.class) })
    @RequestMapping(value = "/users/{id}/topics",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> usersIdTopicsGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
       		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size);

    
    
    
    
    
    
    
    
    
    
    
    
    

    @ApiOperation(value = "Get User's similar Chapters", notes = "Obtain the most similar chapters given a user", response = Resource.class, responseContainer = "List", tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Chapters", response = Resource.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Resource.class) })
    @RequestMapping(value = "/users/{id}/similar/chapters",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Resource>> usersIdSimilarChaptersGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
       		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size);

    @ApiOperation(value = "Get User's similar Documents", notes = "Obtain the most similar documents given a user. ", response = Resource.class, responseContainer = "List", tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Documents", response = Resource.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Resource.class) })
    @RequestMapping(value = "/users/{id}/similar/documents",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Resource>> usersIdSimilarDocumentsGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size);

    @ApiOperation(value = "Get User's similar Resources", notes = "Obtain the most similar resources given a user. ", response = Resource.class, responseContainer = "List", tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Resources", response = Resource.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Resource.class) })
    @RequestMapping(value = "/users/{id}/similar",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Resource>> usersIdSimilarGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
    		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size);


    @ApiOperation(value = "Get User's similar Users", notes = "Obtain the most similar users given a user. ", response = Resource.class, responseContainer = "List", tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Users", response = Resource.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Resource.class) })
    @RequestMapping(value = "/users/{id}/similar/users",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Resource>> usersIdSimilarUsersGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
    		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size);


    
    
    

    @ApiOperation(value = "Get User's similarity with a Chapter", notes = "Obtain similarity score between an User and a Chapter. ", response = InlineResponse200.class, tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Similarity score", response = InlineResponse200.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = InlineResponse200.class) })
    @RequestMapping(value = "/users/{id}/similar/chapters/{idChap}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> usersIdSimilarChaptersIdChapGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap);




    @ApiOperation(value = "Get User's similarity with a Document", notes = "Obtain similarity score between an User and a Document ", response = InlineResponse200.class, tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Similarity score", response = InlineResponse200.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = InlineResponse200.class) })
    @RequestMapping(value = "/users/{id}/similar/documents/{idDoc}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> usersIdSimilarDocumentsIdDocGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc);


    @ApiOperation(value = "Get User's similarity with another User", notes = "Obtain the similarity score between two users ", response = InlineResponse200.class, tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Similarity score between users", response = InlineResponse200.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = InlineResponse200.class) })
    @RequestMapping(value = "/users/{id}/similar/users/{idUser}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> usersIdSimilarUsersIdUserGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "ID of the second User",required=true ) @PathVariable("idUser") String idUser);


}
