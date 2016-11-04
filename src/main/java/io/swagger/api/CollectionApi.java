package io.swagger.api;

import io.swagger.model.Collection;
import io.swagger.model.Error;

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

@Api(value = "collection", description = "the collection API")
public interface CollectionApi {

    @ApiOperation(value = "Get Details about the indexed collection", notes = "This method returns a set of attributes about the collection of documents that have been indexed in the backend ", response = Collection.class, responseContainer = "List", tags={ "Collection", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An object with different attributes shaping the status of the collection", response = Collection.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Collection.class) })
    @RequestMapping(value = "/collection",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Collection>> collectionGet();

}
