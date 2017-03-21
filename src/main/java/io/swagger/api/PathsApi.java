package io.swagger.api;

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
import io.swagger.model.Resource;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-01-16T15:47:55.484Z")

@Api(value = "paths", description = "the paths API")
public interface PathsApi {

    @ApiOperation(value = "Get discovery path between two Chapters", notes = "Get discovery path between two Chapters. ", response = Resource.class, responseContainer = "List", tags={ "Discovery Paths", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Resources", response = String.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
    @RequestMapping(value = "/paths/chapters/{idChapStart}/chapters/{idChapEnd}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> pathsChaptersIdChapStartChaptersIdChapEndGet(@ApiParam(value = "ID of the first Resource",required=true ) @PathVariable("idChapStart") String idChapStart,
            @ApiParam(value = "ID of the second Resource",required=true ) @PathVariable("idUserEnd") String idUserEnd,        
            @ApiParam(value = "Maximun Length of the path",required=false ) @RequestParam(value="maxLength", required=false ) Integer maxLength,
            @ApiParam(value = "Minimum score between resources") @RequestParam(value="minScore", required=false ) Double minScore,
            @ApiParam(value = "Specify if resources in path are from the same type than origin") @RequestParam(value="sameType",required=false) Boolean sameType,
            @ApiParam(value = "Timeout in minutes") @RequestParam(value="minutesTimeout",required=false) Integer minutesTimeout

            );

    @ApiOperation(value = "Get discovery path between a Chapter and a User", notes = "Get discovery path between a chapter and a user. ", response = Resource.class, responseContainer = "List", tags={ "Discovery Paths", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Resources", response = String.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
    @RequestMapping(value = "/paths/chapters/{idChapStart}/users/{idUserEnd}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> pathsChaptersIdChapStartUsersIdUserEndGet(@ApiParam(value = "ID of the first Resource",required=true ) @PathVariable("idChapStart") String idChapStart,
            @ApiParam(value = "ID of the second Resource",required=true ) @PathVariable("idUserEnd") String idUserEnd,        
            @ApiParam(value = "Maximun Length of the path",required=false ) @RequestParam(value="maxLength", required=false ) Integer maxLength,
            @ApiParam(value = "Minimum score between resources") @RequestParam(value="minScore", required=false ) Double minScore,
            @ApiParam(value = "Specify if resources in path are from the same type than origin") @RequestParam(value="sameType",required=false) Boolean sameType,
            @ApiParam(value = "Timeout in minutes") @RequestParam(value="minutesTimeout",required=false) Integer minutesTimeout

            );


    @ApiOperation(value = "Get discovery path between a Document and a Chapter", notes = "Get discovery path between a document and a chapter. ", response = Resource.class, responseContainer = "List", tags={ "Discovery Paths", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Resources", response = String.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
    @RequestMapping(value = "/paths/documents/{idDocStart}/chapters/{idChapEnd}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> pathsDocumentsIdDocStartChaptersIdChapEndGet(@ApiParam(value = "ID of the first Resource",required=true ) @PathVariable("idDocStart") String idDocStart,
            @ApiParam(value = "ID of the second Resource",required=true ) @PathVariable("idUserEnd") String idUserEnd,        
            @ApiParam(value = "Maximun Length of the path",required=false ) @RequestParam(value="maxLength", required=false ) Integer maxLength,
            @ApiParam(value = "Minimum score between resources") @RequestParam(value="minScore", required=false ) Double minScore,
            @ApiParam(value = "Specify if resources in path are from the same type than origin") @RequestParam(value="sameType",required=false) Boolean sameType,
            @ApiParam(value = "Timeout in minutes") @RequestParam(value="minutesTimeout",required=false) Integer minutesTimeout

            );

    @ApiOperation(value = "Get discovery path between two Documents", notes = "Get discovery path between two Books. ", response = Resource.class, responseContainer = "List", tags={ "Discovery Paths", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Resources", response = String.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
    @RequestMapping(value = "/paths/documents/{idDocStart}/documents/{idDocEnd}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> pathsDocumentsIdDocStartDocumentsIdDocEndGet(@ApiParam(value = "ID of the first Resource",required=true ) @PathVariable("idDocStart") String idDocStart,
            @ApiParam(value = "ID of the second Resource",required=true ) @PathVariable("idUserEnd") String idUserEnd,        
            @ApiParam(value = "Maximun Length of the path",required=false ) @RequestParam(value="maxLength", required=false ) Integer maxLength,
            @ApiParam(value = "Minimum score between resources") @RequestParam(value="minScore", required=false ) Double minScore,
            @ApiParam(value = "Specify if resources in path are from the same type than origin") @RequestParam(value="sameType",required=false) Boolean sameType,
            @ApiParam(value = "Timeout in minutes") @RequestParam(value="minutesTimeout",required=false) Integer minutesTimeout

            );


    @ApiOperation(value = "Get discovery path between a Document and a User", notes = "Get discovery path between a document and a user. ", response = Resource.class, responseContainer = "List", tags={ "Discovery Paths", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Resources", response = String.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
    @RequestMapping(value = "/paths/documents/{idDocStart}/users/{idUserEnd}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> pathsDocumentsIdDocStartUsersIdUserEndGet(@ApiParam(value = "ID of the first Resource",required=true ) @PathVariable("idDocStart") String idDocStart,
            @ApiParam(value = "ID of the second Resource",required=true ) @PathVariable("idUserEnd") String idUserEnd,        
            @ApiParam(value = "Maximun Length of the path",required=false ) @RequestParam(value="maxLength", required=false ) Integer maxLength,
            @ApiParam(value = "Minimum score between resources") @RequestParam(value="minScore", required=false ) Double minScore,
            @ApiParam(value = "Specify if resources in path are from the same type than origin") @RequestParam(value="sameType",required=false) Boolean sameType,
            @ApiParam(value = "Timeout in minutes") @RequestParam(value="minutesTimeout",required=false) Integer minutesTimeout

            );

    @ApiOperation(value = "Get discovery path between two Users", notes = "Get discovery path between two Users. ", response = Resource.class, responseContainer = "List", tags={ "Discovery Paths", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Resources", response = String.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
    @RequestMapping(value = "/paths/users/{idUserStart}/users/{idUserEnd}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> pathsUsersIdUserStartUsersIdUserEndGet(@ApiParam(value = "ID of the first Resource",required=true ) @PathVariable("idUserStart") String idUserStart,
        @ApiParam(value = "ID of the second Resource",required=true ) @PathVariable("idUserEnd") String idUserEnd,        
        @ApiParam(value = "Maximun Length of the path",required=false ) @RequestParam(value="maxLength", required=false ) Integer maxLength,
        @ApiParam(value = "Minimum score between resources") @RequestParam(value="minScore", required=false ) Double minScore,
        @ApiParam(value = "Specify if resources in path are from the same type than origin") @RequestParam(value="sameType",required=false) Boolean sameType,
        @ApiParam(value = "Timeout in minutes") @RequestParam(value="minutesTimeout",required=false) Integer minutesTimeout

        );

}
