package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.InlineResponse200;
import io.swagger.model.Resource;
import io.swagger.model.Tag;
import io.swagger.model.TopicDistribution;
import io.swagger.model.UserDeprecated;
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


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-15T17:52:24.109Z")

@Api(value = "documents", description = "the documents API")
public interface DocumentsApi {
	
    @ApiOperation(value = "Get Document's similar Chapters", notes = "Obtain the most similar chapters given a Document. ", response = Resource.class, responseContainer = "List", tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Chapters", response = Resource.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Resource.class) })
    @RequestMapping(value = "/documents/{idDoc}/similar/chapters",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Resource>> documentsIdDocSimilarChaptersGet(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc);

    @ApiOperation(value = "Get list of Documents indexed in the Platform", notes = "Obtain the list of available documents. ", response = String.class, responseContainer = "List", tags={ "Documents", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of Documents", response = String.class)})
    @RequestMapping(value = "/documents",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> documentsGet(
            @ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
    		);

    
    @ApiOperation(value = "Get Document's similarity with a Chapter", notes = "Obtain similarity score between an Document and a Chapter. ", response = InlineResponse200.class, tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Similarity score", response = InlineResponse200.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = InlineResponse200.class) })
    @RequestMapping(value = "/documents/{idDoc}/similar/chapters/{idChap}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> documentsIdDocSimilarChaptersIdChapGet(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc,
        @ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap);


    @ApiOperation(value = "Get Document's similar Documents", notes = "Obtain the most similar documents given another document. ", response = Resource.class, responseContainer = "List", tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Documents", response = Resource.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Resource.class) })
    @RequestMapping(value = "/documents/{idDoc}/similar/documents",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Resource>> documentsIdDocSimilarDocumentsGet(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc);


    @ApiOperation(value = "Get Document's similarity with a Document", notes = "Obtain similarity score between Documents. ", response = InlineResponse200.class, tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Similarity score", response = InlineResponse200.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = InlineResponse200.class) })
    @RequestMapping(value = "/documents/{idDoc}/similar/documents/{idDoc2}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> documentsIdDocSimilarDocumentsIdDoc2Get(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc,
        @ApiParam(value = "ID of the second Document",required=true ) @PathVariable("idDoc2") String idDoc2);


    @ApiOperation(value = "Get Document's similar Resources", notes = "Obtain the most similar resources given a document. ", response = Resource.class, responseContainer = "List", tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Resources", response = Resource.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Resource.class) })
    @RequestMapping(value = "/documents/{idDoc}/similar",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Resource>> documentsIdDocSimilarGet(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc);


    @ApiOperation(value = "Get Document's similar Users", notes = "Obtain the most similar users given a document. ", response = Resource.class, responseContainer = "List", tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Users", response = Resource.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Resource.class) })
    @RequestMapping(value = "/documents/{idDoc}/similar/users",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Resource>> documentsIdDocSimilarUsersGet(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc);


    @ApiOperation(value = "Get Document's similarity with another User", notes = "Obtain the similarity score between a document and user. ", response = InlineResponse200.class, tags={ "Similarities", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Similarity score", response = InlineResponse200.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = InlineResponse200.class) })
    @RequestMapping(value = "/documents/{idDoc}/similar/users/{idUser}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> documentsIdDocSimilarUsersIdUserGet(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc,
        @ApiParam(value = "ID of the User",required=true ) @PathVariable("idUser") String idUser);


    @ApiOperation(value = "Provide a new document to be indexed", notes = "This operation allows to add a new document that is automatically indexed in the collection and annotated with topics.  ", response = String.class, tags={ "Documents", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "ID of the document added to the collection", response = String.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = String.class),
        @ApiResponse(code = 405, message = "Validation exception", response = String.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
    @RequestMapping(value = "/documents/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<String> documentsIdPost(
@ApiParam(value = "Name ID of the document",required=true ) @PathVariable("nameId") String nameId
);


    @ApiOperation(value = "Get Document's top Explorative Tags", notes = "This operation returns a list of weighted Tags associated to a particular document D. Each tag is accompanied by a relevance score ", response = Tag.class, responseContainer = "List", tags={ "Documents", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Tags", response = Tag.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Tag.class) })
    @RequestMapping(value = "/documents/{id}/topExplorativeTags",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Tag>> documentsIdTopExplorativeTagsGet(
@ApiParam(value = "ID of the document",required=true ) @PathVariable("id") String id


);

    @ApiOperation(value = "Get Document's top Specific Tags", notes = "This operation returns a list of weighted Tags associated to a particular document D. Each tag is accompanied by a relevance score ", response = Tag.class, responseContainer = "List", tags={ "Documents", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Tags", response = Tag.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Tag.class) })
    @RequestMapping(value = "/documents/{id}/topSpecificTags",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Tag>> documentsIdTopSpecificTagsGet(
@ApiParam(value = "ID of the document",required=true ) @PathVariable("id") String id


);

    @ApiOperation(value = "Get Document's Topics", notes = "This operation returns a list of weighted LDA topics associated to a particular document D. Each topic is a list of ranked words. ", response = TopicDistribution.class, responseContainer = "List", tags={ "Documents", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of topics", response = TopicDistribution.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = TopicDistribution.class) })
    @RequestMapping(value = "/documents/{id}/topicDistribution",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<TopicDistribution>> documentsIdTopicDistributionGet(
@ApiParam(value = "ID of the document",required=true ) @PathVariable("id") String id


,@ApiParam(value = "Smart filtering flag") @RequestParam(value = "filter", required = false) Boolean filter



);

}
