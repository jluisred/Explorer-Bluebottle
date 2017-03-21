package io.swagger.api;

import org.librairy.bluebottle.conf.Conf;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-01-16T15:47:55.484Z")

@Controller
public class PathsApiController implements PathsApi {


	double defaultMinScore = 0.7;
	int defaultMaxLength = 7;
	int defaultMaxTimeout = 5;

    public ResponseEntity<String> pathsChaptersIdChapStartChaptersIdChapEndGet(@ApiParam(value = "ID of the first Resource",required=true ) @PathVariable("idChapStart") String idChapStart,
            @ApiParam(value = "ID of the second Resource",required=true ) @PathVariable("idChapEnd") String idChapEnd,
            @ApiParam(value = "Maximun Length of the path",required=false ) @RequestParam(value="maxLength", required=false ) Integer maxLength,
            @ApiParam(value = "Minimum score between resources") @RequestParam(value="minScore", required=false ) Double minScore,
            @ApiParam(value = "Specify if resources in path are from the same type than origin") @RequestParam(value="sameType",required=false) Boolean sameType,
            @ApiParam(value = "Timeout in minutes") @RequestParam(value="sameType",required=false) Integer minutesTimeout

        	){
        	
        	
        	if (minutesTimeout == null ){
        		minutesTimeout = defaultMaxTimeout;
        	}
        	if (maxLength == null ){
        		maxLength = defaultMaxLength;
        	}
        	if (minScore == null ){
        		minScore = defaultMinScore;
        	}
        	String resources = "";
        	if (sameType != null ){
        		if (sameType) resources = "part";
        	}
    	
    	RestTemplate restTemplate = new RestTemplate();

    	
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/paths")
      	        .queryParam("startId", idChapStart)
      	        .queryParam("endId", idChapEnd)
      	        .queryParam("type", "similarity")
      	        .queryParam("lenght", maxLength)
      	        .queryParam("threshold", minScore)
      	        .queryParam("size", "5")
      	        .queryParam("time", minutesTimeout);
    	if (!resources.equals("")) builder.queryParam("resources", resources);
      	        //.queryParam("resources", "100")

    
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  String.class);
          
          

      	return ResponseEntity.ok(response.getBody());
    	
    }

    public ResponseEntity<String> pathsChaptersIdChapStartUsersIdUserEndGet(@ApiParam(value = "ID of the first Resource",required=true ) @PathVariable("idChapStart") String idChapStart,
            @ApiParam(value = "ID of the second Resource",required=true ) @PathVariable("idUserEnd") String idUserEnd,
            @ApiParam(value = "Maximun Length of the path",required=false ) @RequestParam(value="maxLength", required=false ) Integer maxLength,
            @ApiParam(value = "Minimum score between resources") @RequestParam(value="minScore", required=false ) Double minScore,
            @ApiParam(value = "Specify if resources in path are from the same type than origin") @RequestParam(value="sameType",required=false) Boolean sameType,
            @ApiParam(value = "Timeout in minutes") @RequestParam(value="sameType",required=false) Integer minutesTimeout

        	){
        	
        	
        	if (minutesTimeout == null ){
        		minutesTimeout = defaultMaxTimeout;
        	}
        	if (maxLength == null ){
        		maxLength = defaultMaxLength;
        	}
        	if (minScore == null ){
        		minScore = defaultMinScore;
        	}
        	String resources = "";
        	if (sameType != null ){
        		if (sameType) resources = "part";
        	}
           	
    	RestTemplate restTemplate = new RestTemplate();

    	
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/paths")
      	        .queryParam("startId", idChapStart)
      	        .queryParam("endId", idUserEnd)
      	        .queryParam("type", "similarity")
      	        .queryParam("lenght", maxLength)
      	        .queryParam("threshold", minScore)
      	        .queryParam("size", "5")
      	        .queryParam("time", minutesTimeout);
    	if (!resources.equals("")) builder.queryParam("resources", resources);

    
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  String.class);
          
          

      	return ResponseEntity.ok(response.getBody());
    	
    }

    public ResponseEntity<String> pathsDocumentsIdDocStartChaptersIdChapEndGet(@ApiParam(value = "ID of the first Resource",required=true ) @PathVariable("idDocStart") String idDocStart,
            @ApiParam(value = "ID of the second Resource",required=true ) @PathVariable("idChapEnd") String idChapEnd,
            @ApiParam(value = "Maximun Length of the path",required=false ) @RequestParam(value="maxLength", required=false ) Integer maxLength,
            @ApiParam(value = "Minimum score between resources") @RequestParam(value="minScore", required=false ) Double minScore,
            @ApiParam(value = "Specify if resources in path are from the same type than origin") @RequestParam(value="sameType",required=false) Boolean sameType,
            @ApiParam(value = "Timeout in minutes") @RequestParam(value="sameType",required=false) Integer minutesTimeout

        	){
        	
        	
        	if (minutesTimeout == null ){
        		minutesTimeout = defaultMaxTimeout;
        	}
        	if (maxLength == null ){
        		maxLength = defaultMaxLength;
        	}
        	if (minScore == null ){
        		minScore = defaultMinScore;
        	}
        	String resources = "";
        	if (sameType != null ){
        		if (sameType) resources = "item";
        	}
           	
       	
    	RestTemplate restTemplate = new RestTemplate();

    	
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/paths")
      	        .queryParam("startId", idDocStart)
      	        .queryParam("endId", idChapEnd)
      	        .queryParam("type", "similarity")
      	        .queryParam("lenght", maxLength)
      	        .queryParam("threshold", minScore)
      	        .queryParam("size", "5")
      	        .queryParam("time", minutesTimeout);
    	if (!resources.equals("")) builder.queryParam("resources", resources);

      	        //.queryParam("resources", "100")


    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  String.class);
          
          

      	return ResponseEntity.ok(response.getBody());
    	
    }

    public ResponseEntity<String> pathsDocumentsIdDocStartDocumentsIdDocEndGet(@ApiParam(value = "ID of the first Resource",required=true ) @PathVariable("idDocStart") String idDocStart,
        @ApiParam(value = "ID of the second Resource",required=true ) @PathVariable("idDocEnd") String idDocEnd,
        @ApiParam(value = "Maximun Length of the path",required=false ) @RequestParam(value="maxLength", required=false ) Integer maxLength,
        @ApiParam(value = "Minimum score between resources") @RequestParam(value="minScore", required=false ) Double minScore,
        @ApiParam(value = "Specify if resources in path are from the same type than origin") @RequestParam(value="sameType",required=false) Boolean sameType,
        @ApiParam(value = "Timeout in minutes") @RequestParam(value="sameType",required=false) Integer minutesTimeout

    	){
    	
    	
    	if (minutesTimeout == null ){
    		minutesTimeout = defaultMaxTimeout;
    	}
    	if (maxLength == null ){
    		maxLength = defaultMaxLength;
    	}
    	if (minScore == null ){
    		minScore = defaultMinScore;
    	}
    	String resources = "";
    	if (sameType != null ){
    		if (sameType) resources = "item";
    	}
       	
    	RestTemplate restTemplate = new RestTemplate();

    	
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/paths")
      	        .queryParam("startId", idDocStart)
      	        .queryParam("endId", idDocEnd)
      	        .queryParam("type", "similarity")
      	        .queryParam("lenght", maxLength)
      	        .queryParam("threshold", minScore)
      	        .queryParam("size", "5")
      	        .queryParam("time", minutesTimeout);
;
    	if (!resources.equals("")) builder.queryParam("resources", resources);

      	        //.queryParam("resources", "100")

    
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  String.class);
          
    	return ResponseEntity.ok(response.getBody());

    	
    }

    public ResponseEntity<String> pathsDocumentsIdDocStartUsersIdUserEndGet(@ApiParam(value = "ID of the first Resource",required=true ) @PathVariable("idDocStart") String idDocStart,
        @ApiParam(value = "ID of the second Resource",required=true ) @PathVariable("idUserEnd") String idUserEnd,
        @ApiParam(value = "Maximun Length of the path",required=false ) @RequestParam(value="maxLength", required=false ) Integer maxLength,
        @ApiParam(value = "Minimum score between resources") @RequestParam(value="minScore", required=false ) Double minScore,
        @ApiParam(value = "Specify if resources in path are from the same type than origin") @RequestParam(value="sameType",required=false) Boolean sameType,
        @ApiParam(value = "Timeout in minutes") @RequestParam(value="sameType",required=false) Integer minutesTimeout

    	){
    	
    	
    	if (minutesTimeout == null ){
    		minutesTimeout = defaultMaxTimeout;
    	}
    	if (maxLength == null ){
    		maxLength = defaultMaxLength;
    	}
    	if (minScore == null ){
    		minScore = defaultMinScore;
    	}
    	String resources = "";
    	if (sameType != null ){
    		if (sameType) resources = "item";
    	}
       	
       	
    	RestTemplate restTemplate = new RestTemplate();

    	
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/paths")
      	        .queryParam("startId", idDocStart)
      	        .queryParam("endId", idUserEnd)
      	        .queryParam("type", "similarity")
      	        .queryParam("lenght", maxLength)
      	        .queryParam("threshold", minScore)
      	        .queryParam("size", "5")
      	        .queryParam("time", minutesTimeout);
    	if (!resources.equals("")) builder.queryParam("resources", resources);
      	        //.queryParam("resources", "100")

    
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  String.class);
          
          

      	return ResponseEntity.ok(response.getBody());
    	
    }

    public ResponseEntity<String> pathsUsersIdUserStartUsersIdUserEndGet(@ApiParam(value = "ID of the first Resource",required=true ) @PathVariable("idUserStart") String idUserStart,
            @ApiParam(value = "ID of the second Resource",required=true ) @PathVariable("idUserEnd") String idUserEnd,
            @ApiParam(value = "Maximun Length of the path",required=false ) @RequestParam(value="maxLength", required=false ) Integer maxLength,
            @ApiParam(value = "Minimum score between resources") @RequestParam(value="minScore", required=false ) Double minScore,
            @ApiParam(value = "Specify if resources in path are from the same type than origin") @RequestParam(value="sameType",required=false) Boolean sameType,
            @ApiParam(value = "Timeout in minutes") @RequestParam(value="sameType",required=false) Integer minutesTimeout

        	){
        	
        	
        	if (minutesTimeout == null ){
        		minutesTimeout = defaultMaxTimeout;
        	}
        	if (maxLength == null ){
        		maxLength = defaultMaxLength;
        	}
        	if (minScore == null ){
        		minScore = defaultMinScore;
        	}
        	String resources = "";
        	if (sameType != null ){
        		if (sameType) resources = "domain";
        	}
           	
    	
    	
        
       	
    	RestTemplate restTemplate = new RestTemplate();

    	
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/paths")
      	        .queryParam("startId", idUserStart)
      	        .queryParam("endId", idUserEnd)
      	        .queryParam("type", "similarity")
      	        .queryParam("lenght", maxLength)
      	        .queryParam("threshold", minScore)
      	        .queryParam("size", "5")
      	        .queryParam("time", minutesTimeout);
    	if (!resources.equals("")) builder.queryParam("resources", resources);
      	        //.queryParam("resources", "100")

    
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  String.class);
          
          

      	return ResponseEntity.ok(response.getBody());
    	
    	
    	
    }

}
