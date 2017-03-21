package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.InlineResponse200;
import io.swagger.model.Resource;
import io.swagger.model.SimilarityScore;
import io.swagger.model.Tag;
import io.swagger.model.TopicDistribution;
import io.swagger.model.UserDeprecated;
import io.swagger.model.api.SimilarAPI;
import io.swagger.annotations.*;

import org.librairy.bluebottle.conf.Conf;
import org.neo4j.ogm.json.JSONException;
import org.neo4j.ogm.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-01-16T15:15:21.846Z")

@Controller
public class UsersApiController implements UsersApi {

    public ResponseEntity<String> usersGet(            
    		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
    		) {

    	if(size == null) size = 100; 
    	RestTemplate restTemplate = new RestTemplate();

    	//http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/rV_NJKNSdiL/tags?size=100

    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/subdomains")
      	        .queryParam("size", size);

    	
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  String.class);
          
          

        
    	return ResponseEntity.ok(response.getBody());
    }

    public ResponseEntity<String> usersIdDelete(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id) {
        //Create Domain
       	RestTemplate restTemplate = new RestTemplate();
       	
   		    

   	    
   	   	    //Build Headers
   	         HttpHeaders headers = new HttpHeaders();
   	         headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
   	         headers.setContentType(MediaType.APPLICATION_JSON);


   	         //Build Request
   	    	
   	         HttpEntity<String> request = new HttpEntity<String>(headers);

   	         
   	       	
   	       	UriComponentsBuilder builderDom = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/subdomains/"+id);

   	       	
   	       	System.out.println("URL " + builderDom.build().encode().toUri());

   	             // Launch Get           
   	             ResponseEntity<String> responseDom = restTemplate.exchange( builderDom.build().encode().toUri(),
   	                     HttpMethod.DELETE,
   	                     request,
   	                     String.class);
   	             
   	             
   	             
           //Build Request
       	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+id);
       	System.out.println("URL " + builder.build().encode().toUri());

             // Launch Get           
             ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                     HttpMethod.DELETE,
                     request,
                     String.class);
             
       return response;

          
             
    }

    

    public ResponseEntity<String> usersIdPost(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id) {
        //Create Domain
    	RestTemplate restTemplate = new RestTemplate();
    	
    	   JSONObject domainJson = new JSONObject();
		    try {
				domainJson.put("name", id);
				domainJson.put("description", "User with id " + id);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    

	    
	   	    //Build Headers
	         HttpHeaders headers = new HttpHeaders();
	         headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	         headers.setContentType(MediaType.APPLICATION_JSON);


	         //Build Request
	    	
	         HttpEntity<String> request = new HttpEntity<String>(domainJson.toString(), headers);

        //Build Request
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+id);

    	
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.POST,
                  request,
                  String.class);
          
          if (response.getStatusCode() != HttpStatus.CREATED) return response;

        
    	//Associate subdomain to main domain 
          
    	

    	UriComponentsBuilder builderDom = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/subdomains/"+id);

    	
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<String> responseDom = restTemplate.exchange( builderDom.build().encode().toUri(),
                  HttpMethod.POST,
                  request,
                  String.class);
          
    	
      	return ResponseEntity.ok(responseDom.getBody());
    }
    
    
    public ResponseEntity<String> usersIdDocumentGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
	@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size)

    {
        // do some magic!
    	if(size == null) size = 100; 

    	RestTemplate restTemplate = new RestTemplate();

    	//http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/rV_NJKNSdiL/tags?size=100

    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+id+"/documents")
      	        .queryParam("size", size);

    	
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  String.class);
          
          

        
    	return ResponseEntity.ok(response.getBody());
    	
    	
    	
    }
    
     

    public ResponseEntity<String> usersIdDocumentIdDocPost(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc) {
        
    	RestTemplate restTemplate = new RestTemplate();

    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	

    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+id+"/documents/"+idDoc);

    	

          // Launch Get           
          ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.POST,
                  request,
                  String.class);
          
    	
      	return ResponseEntity.ok(response.getBody());
      	
      	
      	
    }
    
   
    public ResponseEntity<String> usersIdDocumentIdDocTagsGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc,
   		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
    		) {

    	if(size == null) size = 100; 
    	RestTemplate restTemplate = new RestTemplate();

    	//http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/rV_NJKNSdiL/tags?size=100

    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+id+"/documents/"+idDoc+"/tags")
      	        .queryParam("size", size);

    	
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  String.class);
          
          

        
    	return ResponseEntity.ok(response.getBody());


    	
    	
    }

    
    
    
    
    
    public ResponseEntity<String> usersIdDocumentIdDocTopicsGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc,
   		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
		) {

	if(size == null) size = 100; 
	RestTemplate restTemplate = new RestTemplate();

	//http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/rV_NJKNSdiL/tags?size=100

	
    HttpHeaders headers = new HttpHeaders();
   // headers.add("x-api-key", Conf.getApikey());
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    headers.setContentType(MediaType.APPLICATION_JSON);

    //Build Request
    HttpEntity<String> request = new HttpEntity<String>(headers);
	
	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+id+"/documents/"+idDoc+"/topics")
  	        .queryParam("size", size);

	
	System.out.println("URL " + builder.build().encode().toUri());

      // Launch Get           
      ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
              HttpMethod.GET,
              request,
              String.class);
	return ResponseEntity.ok(response.getBody());
    }
    
    
    
    public ResponseEntity<String> usersIdTagsGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
   		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
		) {

	if(size == null) size = 100; 
	RestTemplate restTemplate = new RestTemplate();

	//http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/rV_NJKNSdiL/tags?size=100

	
    HttpHeaders headers = new HttpHeaders();
   // headers.add("x-api-key", Conf.getApikey());
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    headers.setContentType(MediaType.APPLICATION_JSON);

    //Build Request
    HttpEntity<String> request = new HttpEntity<String>(headers);
	
	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+id+"/topics")
  	        .queryParam("size", size);

	
	System.out.println("URL " + builder.build().encode().toUri());

      // Launch Get           
      ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
              HttpMethod.GET,
              request,
              String.class);
	return ResponseEntity.ok(response.getBody());
    }

    public ResponseEntity<String> usersIdTopicsGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
   		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
		) {

	if(size == null) size = 100; 
	RestTemplate restTemplate = new RestTemplate();

	//http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/rV_NJKNSdiL/tags?size=100

	
    HttpHeaders headers = new HttpHeaders();
   // headers.add("x-api-key", Conf.getApikey());
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    headers.setContentType(MediaType.APPLICATION_JSON);

    //Build Request
    HttpEntity<String> request = new HttpEntity<String>(headers);
	
	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+id+"/topics")
  	        .queryParam("size", size);

	
	System.out.println("URL " + builder.build().encode().toUri());

      // Launch Get           
      ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
              HttpMethod.GET,
              request,
              String.class);
	return ResponseEntity.ok(response.getBody());
    }
    
    public ResponseEntity<List<Resource>> usersIdSimilarChaptersGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
       		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
    		) {

    	if(size == null) size = 100; 
        // http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/b3LZ5XbhY2SLn/relations?type=similarity&size=100
      	RestTemplate restTemplate = new RestTemplate();

      	List<Resource> result = new ArrayList<Resource>();

      	
          HttpHeaders headers = new HttpHeaders();
         // headers.add("x-api-key",  Conf.getApikey());
          headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
          headers.setContentType(MediaType.APPLICATION_JSON);

          //Build Request
          HttpEntity<String> request = new HttpEntity<String>(headers);
      	
      	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/subdomains/"+id+"/relations")
      			.queryParam("type", "similarity").queryParam("size", size).queryParam("resourceType", "part")
  	        ;

        	        //.queryParam("resourceTypet", "part");
        	        //.queryParam("resources", "100")

      
      	System.out.println("URL " + builder.build().encode().toUri());

            // Launch Get           
            ResponseEntity<SimilarAPI[]> response = restTemplate.exchange( builder.build().encode().toUri(),
                    HttpMethod.GET,
                    request,
                    SimilarAPI[].class);
            
         
            
          if (response.getBody() == null) 
          	return ResponseEntity.ok(result);

          for (SimilarAPI s: response.getBody()){
          	Resource r = new Resource();
          	
          	r.setScore(s.getScore());
          	r.setId(s.getTo().getUri());
          	r.setName(s.getTo().getName());

          	result.add(r);
          }
          
          
      	return ResponseEntity.ok(result);
    }


    public ResponseEntity<List<Resource>> usersIdSimilarDocumentsGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
   		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
		) {

	if(size == null) size = 100; 
    // http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/b3LZ5XbhY2SLn/relations?type=similarity&size=100
  	RestTemplate restTemplate = new RestTemplate();

  	List<Resource> result = new ArrayList<Resource>();

  	
      HttpHeaders headers = new HttpHeaders();
     // headers.add("x-api-key",  Conf.getApikey());
      headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
      headers.setContentType(MediaType.APPLICATION_JSON);

      //Build Request
      HttpEntity<String> request = new HttpEntity<String>(headers);
  	
  	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/subdomains/"+id+"/relations")
  			.queryParam("type", "similarity").queryParam("size", size).queryParam("resourceType", "item")
	        ;

    	        //.queryParam("resourceTypet", "part");
    	        //.queryParam("resources", "100")

  
  	System.out.println("URL " + builder.build().encode().toUri());

        // Launch Get           
        ResponseEntity<SimilarAPI[]> response = restTemplate.exchange( builder.build().encode().toUri(),
                HttpMethod.GET,
                request,
                SimilarAPI[].class);
        
     
        
      if (response.getBody() == null) 
      	return ResponseEntity.ok(result);

      for (SimilarAPI s: response.getBody()){
      	Resource r = new Resource();
      	
      	r.setScore(s.getScore());
      	r.setId(s.getTo().getUri());
      	r.setName(s.getTo().getName());

      	result.add(r);
      }
      
      
  	return ResponseEntity.ok(result);
    }

    
    
    public ResponseEntity<List<Resource>> usersIdSimilarGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
    		
       		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
    		) {

    	if(size == null) size = 100; 
        // http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/b3LZ5XbhY2SLn/relations?type=similarity&size=100
      	RestTemplate restTemplate = new RestTemplate();

      	List<Resource> result = new ArrayList<Resource>();

      	
          HttpHeaders headers = new HttpHeaders();
         // headers.add("x-api-key",  Conf.getApikey());
          headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
          headers.setContentType(MediaType.APPLICATION_JSON);

          //Build Request
          HttpEntity<String> request = new HttpEntity<String>(headers);
      	
      	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/subdomains/"+id+"/relations")
      			.queryParam("type", "similarity").queryParam("size", size)
    	        ;

        	        //.queryParam("resourceTypet", "part");
        	        //.queryParam("resources", "100")

      
      	System.out.println("URL " + builder.build().encode().toUri());

            // Launch Get           
            ResponseEntity<SimilarAPI[]> response = restTemplate.exchange( builder.build().encode().toUri(),
                    HttpMethod.GET,
                    request,
                    SimilarAPI[].class);
            
         
            
          if (response.getBody() == null) 
          	return ResponseEntity.ok(result);

          for (SimilarAPI s: response.getBody()){
          	Resource r = new Resource();
          	
          	r.setScore(s.getScore());
          	r.setId(s.getTo().getUri());
          	r.setName(s.getTo().getName());

          	result.add(r);
          }
          
          
      	return ResponseEntity.ok(result);
 
    }
    
    public ResponseEntity<List<Resource>> usersIdSimilarUsersGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
   		@ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size
		) {

	if(size == null) size = 100; 
    // http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/b3LZ5XbhY2SLn/relations?type=similarity&size=100
  	RestTemplate restTemplate = new RestTemplate();

  	List<Resource> result = new ArrayList<Resource>();

  	
      HttpHeaders headers = new HttpHeaders();
     // headers.add("x-api-key",  Conf.getApikey());
      headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
      headers.setContentType(MediaType.APPLICATION_JSON);

      //Build Request
      HttpEntity<String> request = new HttpEntity<String>(headers);
  	
  	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/subdomains/"+id+"/relations")
  			.queryParam("type", "similarity").queryParam("size", size).queryParam("resourceType", "domain")
	        ;

    	        //.queryParam("resourceTypet", "part");
    	        //.queryParam("resources", "100")

  
  	System.out.println("URL " + builder.build().encode().toUri());

        // Launch Get           
        ResponseEntity<SimilarAPI[]> response = restTemplate.exchange( builder.build().encode().toUri(),
                HttpMethod.GET,
                request,
                SimilarAPI[].class);
        
     
        
      if (response.getBody() == null) 
      	return ResponseEntity.ok(result);

      for (SimilarAPI s: response.getBody()){
      	Resource r = new Resource();
      	
      	r.setScore(s.getScore());
      	r.setId(s.getTo().getUri());
      	r.setName(s.getTo().getName());

      	result.add(r);
      }
      
      
  	return ResponseEntity.ok(result);
    }
    
    
    

    public ResponseEntity<InlineResponse200> usersIdSimilarChaptersIdChapGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap){ 


    	
    	RestTemplate restTemplate = new RestTemplate();

    	InlineResponse200 result = new InlineResponse200();
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key",  Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/subdomains/"+id+"/relations")
    			.queryParam("type", "similarity").queryParam("relatedId", idChap)
	        ;

      	        //.queryParam("resourceTypet", "part");
      	        //.queryParam("resources", "100")

    
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<SimilarAPI[]> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  SimilarAPI[].class);
          
       
          
        if (response.getBody() == null) 
        	return ResponseEntity.ok(result);
        
        SimilarAPI s = response.getBody()[0];
        SimilarityScore sc = new SimilarityScore();
        sc.setScore(s.getScore());
        
        result.setData(sc);

        
    	return ResponseEntity.ok(result);
    	
    	
    }
    public ResponseEntity<InlineResponse200> usersIdSimilarDocumentsIdDocGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc) {
    	RestTemplate restTemplate = new RestTemplate();

    	InlineResponse200 result = new InlineResponse200();
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key",  Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/subdomains/"+id+"/relations")
    			.queryParam("type", "similarity").queryParam("relatedId", idDoc)
	        ;

      	        //.queryParam("resourceTypet", "part");
      	        //.queryParam("resources", "100")

    
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<SimilarAPI[]> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  SimilarAPI[].class);
          
       
          
        if (response.getBody() == null) 
        	return ResponseEntity.ok(result);
        
        SimilarAPI s = response.getBody()[0];
        SimilarityScore sc = new SimilarityScore();
        sc.setScore(s.getScore());
        
        result.setData(sc);

        
    	return ResponseEntity.ok(result);
    	
    }
    public ResponseEntity<InlineResponse200> usersIdSimilarUsersIdUserGet(@ApiParam(value = "ID of the User",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "ID of the second User",required=true ) @PathVariable("idUser") String idUser) {
    	RestTemplate restTemplate = new RestTemplate();

    	InlineResponse200 result = new InlineResponse200();
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key",  Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/subdomains/"+id+"/relations")
    			.queryParam("type", "similarity").queryParam("relatedId", idUser)
	        ;

      	        //.queryParam("resourceTypet", "part");
      	        //.queryParam("resources", "100")

    
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<SimilarAPI[]> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  SimilarAPI[].class);
          
       
          
        if (response.getBody() == null) 
        	return ResponseEntity.ok(result);
        
        SimilarAPI s = response.getBody()[0];
        SimilarityScore sc = new SimilarityScore();
        sc.setScore(s.getScore());
        
        result.setData(sc);

        
    	return ResponseEntity.ok(result);
    }



}
