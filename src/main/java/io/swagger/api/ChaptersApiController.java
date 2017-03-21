package io.swagger.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.librairy.bluebottle.conf.Conf;
import org.librairy.bluebottle.harvest.Annotation;
import org.librairy.bluebottle.tags.TagUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import io.swagger.model.InlineResponse200;
import io.swagger.model.Resource;
import io.swagger.model.SimilarityScore;
import io.swagger.model.Tag;
import io.swagger.model.TopicDistribution;
import io.swagger.model.api.SimilarAPI;
import io.swagger.model.api.TagAPI;
import io.swagger.model.api.TopicAPI;
import io.swagger.model.api.WordAPI;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-15T17:52:24.109Z")

@Controller
public class ChaptersApiController implements ChaptersApi {

	
    private static Logger LOG = LoggerFactory.getLogger(ChaptersApiController.class);
    Conf c = new Conf();
	/*
    @Autowired
	UDM udm;
    
    @Autowired
    EventBus bus;
    
    @Autowired
    URIGenerator uriGenerator;
    
    
    @Autowired
    LDAModelerAPI ldaApi;
    */
    public ResponseEntity<List<Resource>> chaptersIdChapSimilarChaptersGet(@ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap) {
    	RestTemplate restTemplate = new RestTemplate();

    	List<Resource> result = new ArrayList<Resource>();

    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/parts/"+idChap+"/relations")
    			.queryParam("type", "similarity").queryParam("size", "10").queryParam("resourceType", "part")
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
        	Resource c = new Resource();
        	
        	c.setScore(s.getScore());
        	c.setId(s.getTo().getUri());

        	result.add(c);
        }
        
        
    	return ResponseEntity.ok(result);
    }

    public ResponseEntity<InlineResponse200> chaptersIdChapSimilarChaptersIdChap2Get(@ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap,
        @ApiParam(value = "ID of the second Chapter",required=true ) @PathVariable("idChap2") String idChap2) {
    	RestTemplate restTemplate = new RestTemplate();

    	InlineResponse200 result = new InlineResponse200();
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/parts/"+idChap+"/relations")
    			.queryParam("type", "similarity").queryParam("relatedId", idChap2)
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

    public ResponseEntity<List<Resource>> chaptersIdChapSimilarDocumentsGet(@ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap) {
      	RestTemplate restTemplate = new RestTemplate();

    	List<Resource> result = new ArrayList<Resource>();

    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/parts/"+idChap+"/relations")
    			.queryParam("type", "similarity").queryParam("size", "10").queryParam("resourceType", "item")
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
        	Resource b = new Resource();
        	
        	b.setScore(s.getScore());
        	b.setId(s.getTo().getId());
        	b.setName(s.getTo().getName());

        	result.add(b);
        }
        
        
    	return ResponseEntity.ok(result);
    }

    public ResponseEntity<InlineResponse200> chaptersIdChapSimilarDocumentsIdDocGet(@ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap,
        @ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc) {
    	RestTemplate restTemplate = new RestTemplate();

    	InlineResponse200 result = new InlineResponse200();
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/parts/"+idChap+"/relations")
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

    public ResponseEntity<List<io.swagger.model.Resource>> chaptersIdChapSimilarGet(@ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap) {
        // http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/b3LZ5XbhY2SLn/relations?type=similarity&size=100
    	RestTemplate restTemplate = new RestTemplate();

    	List<Resource> result = new ArrayList<Resource>();

    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/parts/"+idChap+"/relations")
    			.queryParam("type", "similarity").queryParam("size", "10")
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

    public ResponseEntity<List<Resource>> chaptersIdChapSimilarUsersGet(@ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap) {
      	RestTemplate restTemplate = new RestTemplate();

    	List<Resource> result = new ArrayList<Resource>();

    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/parts/"+idChap+"/relations")
    			.queryParam("type", "similarity").queryParam("size", "10").queryParam("resourceType", "domain")
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

    public ResponseEntity<InlineResponse200> chaptersIdChapSimilarUsersIdUserGet(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idChap") String idChap,
        @ApiParam(value = "ID of the User",required=true ) @PathVariable("idUser") String idUser) {
    	RestTemplate restTemplate = new RestTemplate();

    	InlineResponse200 result = new InlineResponse200();
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/parts/"+idChap+"/relations")
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
    
    
    
    public ResponseEntity<List<Tag>> chaptersIdTopExplorativeTagsGet(
@ApiParam(value = "ID of the chapter",required=true ) @PathVariable("id") String id
    		) {

    	
    	RestTemplate restTemplate = new RestTemplate();

    	List<Tag> result = new ArrayList<Tag>();
    	//http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/rV_NJKNSdiL/tags?size=100

    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/parts/"+id+"/tags")
      	        .queryParam("size", "100");

    	
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<TagAPI[]> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  TagAPI[].class);
          
          
      	if (response.getBody() == null) return ResponseEntity.ok(result);

        for (TagAPI tag : response.getBody()){
        	Tag t = new Tag();
    		t.setScore(tag.getScore());
    		t.setSurface(tag.getName());
    		result.add(t);
        }
        TagUtils.filterStandfordErrors (result);

    	return ResponseEntity.ok(result);
    	
    	

    }
    

    public ResponseEntity<List<TopicDistribution>> chaptersIdTopicDistributionGet(
@ApiParam(value = "ID of the chapter",required=true ) @PathVariable("id") String id
,
@ApiParam(value = "Smart filtering flag") @RequestParam(value = "filter", required = false) Boolean filter


) {
    	
        LOG.info("Trying to obtain topic distribution for chapter " + id );
        
       	
    	RestTemplate restTemplate = new RestTemplate();

    	
    	List<TopicDistribution> result = new ArrayList<TopicDistribution>();
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key", Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/parts/"+id+"/topics")
      	        .queryParam("size", "100");

    	
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<TopicAPI[]> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  TopicAPI[].class);
          
          
      	if (response.getBody() == null) return ResponseEntity.ok(result);

        for (TopicAPI topic : response.getBody()){
        	TopicDistribution t = new TopicDistribution();
    		t.setWeight(topic.getScore());

          	
          	 for (WordAPI word : topic.getWords()){
           		 io.swagger.model.Word w = new io.swagger.model.Word();
           		 w.setScore(word.getValue());
           		 w.setSurface(word.getRef().getName());

           		 t.addTopicItem(w);
           	 }

    		result.add(t);
        }

    	return ResponseEntity.ok(result);

    }



	@Override
	public ResponseEntity<List<Tag>> chaptersIdTopSpecificTagsGet(
		@ApiParam(value = "ID of the chapter",required=true ) @PathVariable("id") String id) {

	RestTemplate restTemplate = new RestTemplate();
	List<Tag> result = new ArrayList<Tag>();


	
    HttpHeaders headers = new HttpHeaders();
   // headers.add("x-api-key", Conf.getApikey());
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    headers.setContentType(MediaType.APPLICATION_JSON);

    //Build Request
    HttpEntity<String> request = new HttpEntity<String>(headers);
    
    
    String[] compounds = getAnnotations("compound", id, request, restTemplate);
    String[] entities = getAnnotations("ner", id, request, restTemplate);

    List<Tag> compoundsRanked = TagUtils.rankAnnotations(compounds, "compound", 1.0);
    double entityCorrection = 1.0;
    if (!compoundsRanked.isEmpty()) entityCorrection =0.8;
    List<Tag> entitiesRanked = TagUtils.rankAnnotations(entities, "ner", entityCorrection);

    
    Collections.sort(compoundsRanked, new TagComparator());

    result.addAll(compoundsRanked);
    int maxEntities = entitiesRanked.size()<5 ? entitiesRanked.size() : 5;
    result.addAll(entitiesRanked.subList(0, maxEntities));

    Collections.sort(result, new TagComparator());
    TagUtils.filterStandfordErrors (result);

	return ResponseEntity.ok(result);


	}
    
	private String[] getAnnotations(String type, String id, HttpEntity<String> request, RestTemplate restTemplate) {
		

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/parts/"+id+"/annotations/"+type);

		
		System.out.println("URL " + builder.build().encode().toUri());

	      // Launch Get           
	      ResponseEntity<Annotation> response = restTemplate.exchange( builder.build().encode().toUri(),
	              HttpMethod.GET,
	              request,
	              Annotation.class);
	      
	      
	      String rawAnnotations =  response.getBody().getValue();

	      rawAnnotations = TagUtils.cleanCornerCases(rawAnnotations);
	      return rawAnnotations.split(" ");
	}


	public ResponseEntity<String> chaptersGet(
			
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
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/parts")
	  	        .queryParam("size", size);

		
		System.out.println("URL " + builder.build().encode().toUri());

	      // Launch Get           
	      ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
	              HttpMethod.GET,
	              request,
	              String.class);
	      
	      

	    
		return ResponseEntity.ok(response.getBody());
	}



}
