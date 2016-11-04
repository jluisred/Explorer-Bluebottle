package io.swagger.api;

import io.swagger.model.Book;
import io.swagger.model.Error;
import io.swagger.model.TopicDistribution;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-04T11:07:26.201Z")

@Controller
public class DocumentsApiController implements DocumentsApi {

    public ResponseEntity<String> documentsIdPost(
@ApiParam(value = "ID of the document",required=true ) @PathVariable("id") String id


,
        

@ApiParam(value = "Book and its chapters in a textual form."  ) @RequestBody Book body

) {
        // do some magic!
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public ResponseEntity<List<TopicDistribution>> documentsIdTopicDistributionGet(
@ApiParam(value = "ID of the document.",required=true ) @PathVariable("id") String id


) {
        // do some magic!
        return new ResponseEntity<List<TopicDistribution>>(HttpStatus.OK);
    }

}
