package io.swagger.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.librairy.bluebottle.conf.*;
import org.librairy.bluebottle.harvest.Annotation;
import org.librairy.bluebottle.harvest.Harvester;
import org.librairy.bluebottle.tags.TagUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-04T11:07:26.201Z")

@Controller
public class DocumentsApiController implements DocumentsApi {

    private static Logger LOG = LoggerFactory.getLogger(DocumentsApiController.class);
    Conf c = new Conf();
	
   // @Autowired
	//UDM udm;
    
   // @Autowired
    //EventBus bus;
    
    //@Autowired
   // URIGenerator uriGenerator;
    
    
   // @Autowired
   // LDAModelerAPI ldaApi;
    
    
    public ResponseEntity<List<Resource>> documentsIdDocSimilarChaptersGet(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc) {
    	RestTemplate restTemplate = new RestTemplate();

    	List<Resource> result = new ArrayList<Resource>();

    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key",  Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/documents/"+idDoc+"/relations")
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

    public ResponseEntity<InlineResponse200> documentsIdDocSimilarChaptersIdChapGet(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc,
        @ApiParam(value = "ID of the Chapter",required=true ) @PathVariable("idChap") String idChap) {
    	RestTemplate restTemplate = new RestTemplate();

    	InlineResponse200 result = new InlineResponse200();
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key",  Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/documents/"+idDoc+"/relations")
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

    public ResponseEntity<List<Resource>> documentsIdDocSimilarDocumentsGet(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc) {
      	RestTemplate restTemplate = new RestTemplate();

    	List<Resource> result = new ArrayList<Resource>();

    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key",  Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/documents/"+idDoc+"/relations")
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

    public ResponseEntity<InlineResponse200> documentsIdDocSimilarDocumentsIdDoc2Get(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc,
        @ApiParam(value = "ID of the second Document",required=true ) @PathVariable("idDoc2") String idDoc2) {
    	RestTemplate restTemplate = new RestTemplate();

    	InlineResponse200 result = new InlineResponse200();
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key",  Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/documents/"+idDoc+"/relations")
    			.queryParam("type", "similarity").queryParam("relatedId", idDoc2)
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

    public ResponseEntity<List<Resource>> documentsIdDocSimilarGet(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc) {
        // http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/b3LZ5XbhY2SLn/relations?type=similarity&size=100
    	RestTemplate restTemplate = new RestTemplate();

    	List<Resource> result = new ArrayList<Resource>();

    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key",  Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/documents/"+idDoc+"/relations")
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

    public ResponseEntity<List<Resource>> documentsIdDocSimilarUsersGet(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc) {
       	RestTemplate restTemplate = new RestTemplate();

    	List<Resource> result = new ArrayList<Resource>();

    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key",  Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/documents/"+idDoc+"/relations")
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

    public ResponseEntity<InlineResponse200> documentsIdDocSimilarUsersIdUserGet(@ApiParam(value = "ID of the Document",required=true ) @PathVariable("idDoc") String idDoc,
        @ApiParam(value = "ID of the User",required=true ) @PathVariable("idUser") String idUser) {
    	RestTemplate restTemplate = new RestTemplate();

    	InlineResponse200 result = new InlineResponse200();
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key",  Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/documents/"+idDoc+"/relations")
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
    
    
    public ResponseEntity<String> documentsIdPost(
@ApiParam(value = "ID of the document",required=true ) @PathVariable("id") String nameId
//@ApiParam(value = "Book and its chapters in a textual form."  ) @RequestBody Book body
) 
    {
    	Harvester har = new Harvester ();
        har.harvest(nameId);
    	
        return new ResponseEntity<String>(HttpStatus.OK); 
    }

    public ResponseEntity<List<TopicDistribution>> documentsIdTopicDistributionGet(
@ApiParam(value = "ID of the document",required=true ) @PathVariable("id") String id

,

        @ApiParam(value = "Smart filtering flag") @RequestParam(value = "filter", required = false) Boolean filter



)  {
    	
    	
    	RestTemplate restTemplate = new RestTemplate();

    	
    	List<TopicDistribution> result = new ArrayList<TopicDistribution>();
    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key",  Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/documents/"+id+"/topics")
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
        
/*
    	
    	if (filter == null) filter = false;
    	List<TopicDistribution> result = new ArrayList<TopicDistribution>();
    	
        LOG.info("Trying to obtain topic distribution for document " + id );
        //LOG.info("  number of documents in the collection " + udm.find(Resource.Type.DOCUMENT).all().size() );
        //LOG.info("  number of topics in the collection " + udm.find(Resource.Type.TOPIC).all().size() );
        //LOG.info("  number of parts in the collection " + udm.find(Resource.Type.PART).all().size() );
        //LOG.info("  first document in the collection " + udm.find(Resource.Type.DOCUMENT).all().get(0).getUri() );
        //LOG.info("  url " + uriGenerator.from(Resource.Type.DOCUMENT, id)) ;
        //LOG.info("  get by id " + udm.read(Resource.Type.DOCUMENT).byUri(uriGenerator.from(Resource.Type.DOCUMENT, id)).get().getUri());

        
        
        //LOG.info("  exists in collection " + udm.find(Resource.Type.DOCUMENT).from(Resource.Type.DOCUMENT, uriGenerator.from(Resource.Type.DOCUMENT, id)).size());
        //Resource resource = udm.read(Resource.Type.DOCUMENT).byUri(uriGenerator.from(Resource.Type.DOCUMENT, id)).get();
        
        
 

        
         
/*            String documentUri = uriGenerator.from(Resource.Type.DOCUMENT, id);
         	LOG.info("Document '" + documentUri+"'");
         	
         	Criteria criteria = new Criteria ();
         	criteria.setMax(20);
         	
         	String item = ldaApi.getItemFromDocument(documentUri);
            List<ScoredTopic> topics = ldaApi.getTopicsDistribution(item, criteria);
             
             for (ScoredTopic topic : topics){
            	 TopicDistribution t = new TopicDistribution();
            	 t.setWeight(topic.getRelevance());
            	 for (ScoredWord word : topic.getWords()){
            		 io.swagger.model.Word w = new io.swagger.model.Word();
            		 w.setScore(word.getScore());
            		 w.setSurface(word.getWord());

            		 t.addTopicItem(w);
            	 }
            	 result.add(t);
             }

             if (filter) result = FilterTopic.filterByWeight(result);
             
         	//if (result.isEmpty()) injectFake(result);

            return ResponseEntity.ok(result);*/


    	
        
    }



    public ResponseEntity<List<Tag>> documentsIdTopExplorativeTagsGet(
@ApiParam(value = "ID of the document",required=true ) @PathVariable("id") String id


    		) {

    	RestTemplate restTemplate = new RestTemplate();

    	List<Tag> result = new ArrayList<Tag>();
    	//http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/rV_NJKNSdiL/tags?size=100

    	
        HttpHeaders headers = new HttpHeaders();
       // headers.add("x-api-key",  Conf.getApikey());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/documents/"+id+"/tags")
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

/*
    	List<Tag> result = new ArrayList<Tag>();


    	LOG.info("Trying to obtain top tags  for document " + id );


    	String documentUri = uriGenerator.from(Resource.Type.DOCUMENT, id);
    	LOG.info("Document '" + documentUri+"'");

    	Criteria criteria = new Criteria ();
    	criteria.setMax(20);

     	String item = ldaApi.getItemFromDocument(documentUri);

    	List<ScoredWord> topics = ldaApi.getTags(item, criteria);

    	for (ScoredWord scoredWord : topics){

    		Tag t = new Tag();
    		t.setScore(scoredWord.getScore());
    		t.setSurface(scoredWord.getWord());
    		result.add(t);
    	}


    	return ResponseEntity.ok(result);*/


    }









public ResponseEntity<List<Tag>> documentsIdTopSpecificTagsGet(
@ApiParam(value = "ID of the document",required=true ) @PathVariable("id") String id


		) {

	RestTemplate restTemplate = new RestTemplate();
	List<Tag> result = new ArrayList<Tag>();


	
    HttpHeaders headers = new HttpHeaders();
   // headers.add("x-api-key",  Conf.getApikey());
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
	

	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/documents/"+id+"/annotations/"+type);

	
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

public ResponseEntity<String> documentsGet(
		
        @ApiParam(value = "Number of elements",required=false ) @RequestParam(value="size", required=false ) Integer size

		) {


	if(size == null) size = 100; 
	RestTemplate restTemplate = new RestTemplate();

	//http://librairy.linkeddata.es/api/domains/141fc5bbcf0212ec9bee5ef66c6096ab/documents/rV_NJKNSdiL/tags?size=100

	
    HttpHeaders headers = new HttpHeaders();
   // headers.add("x-api-key",  Conf.getApikey());
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    headers.setContentType(MediaType.APPLICATION_JSON);

    //Build Request
    HttpEntity<String> request = new HttpEntity<String>(headers);
	
	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( Conf.getApiURL()+"/domains/"+ Conf.getDomainUUID()+"/documents")
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

	
/*private void injectFake(List<TopicDistribution> result) {
TopicDistribution topicdis = new TopicDistribution();
topicdis.setWeight(0.00002143959617151895);


io.swagger.model.Word wordApi1 = new  io.swagger.model.Word();
wordApi1.setSurface("maclay");
wordApi1.score(0.000784673671776553);
io.swagger.model.Word wordApi2 = new  io.swagger.model.Word();
wordApi2.setSurface("contributor");
wordApi2.score(0.0007720380476072885);
io.swagger.model.Word wordApi3 = new  io.swagger.model.Word();
wordApi3.setSurface("warranty");
wordApi3.score(0.0007670842138453395);
io.swagger.model.Word wordApi4 = new  io.swagger.model.Word();
wordApi4.setSurface("nothing");
wordApi4.score(0.0007654977848494378);
io.swagger.model.Word wordApi5 = new  io.swagger.model.Word();
wordApi5.setSurface("insecurity");
wordApi5.score(0.0007630433968403283);
io.swagger.model.Word wordApi6 = new  io.swagger.model.Word();
wordApi6.setSurface("thing");
wordApi6.score(0.0007614556025083354);
io.swagger.model.Word wordApi7 = new  io.swagger.model.Word();
wordApi7.setSurface("whenever");
wordApi7.score(0.0007537963632215599);
io.swagger.model.Word wordApi8 = new  io.swagger.model.Word();
wordApi8.setSurface("turnbull");
wordApi8.score(0.0007521516473691009);                
io.swagger.model.Word wordApi9 = new  io.swagger.model.Word();
wordApi9.setSurface("display");
wordApi9.score(0.0007478535610906296);
io.swagger.model.Word wordApi10 = new  io.swagger.model.Word();
wordApi10.setSurface("materiality");
wordApi10.score(0.0007429731024978604);
topicdis.addTopicItem(wordApi1);
topicdis.addTopicItem(wordApi2);
topicdis.addTopicItem(wordApi3);
topicdis.addTopicItem(wordApi4);
topicdis.addTopicItem(wordApi5);
topicdis.addTopicItem(wordApi6);
topicdis.addTopicItem(wordApi7);
topicdis.addTopicItem(wordApi8);
topicdis.addTopicItem(wordApi9);
topicdis.addTopicItem(wordApi10);

result.add(topicdis);

TopicDistribution topicdis1 = new TopicDistribution();
topicdis1.setWeight(0.9999785604038285);
io.swagger.model.Word wordApi11 = new  io.swagger.model.Word();
wordApi11.setSurface("company");
wordApi11.score(0.055929612944930304);
io.swagger.model.Word wordApi12 = new  io.swagger.model.Word();
wordApi12.setSurface("asset");
wordApi12.score(0.022837749135731545);
io.swagger.model.Word wordApi13 = new  io.swagger.model.Word();
wordApi13.setSurface("year");
wordApi13.score(0.020364200601537784);
io.swagger.model.Word wordApi14 = new  io.swagger.model.Word();
wordApi14.setSurface("cash");
wordApi14.score(0.018661275215656033);
io.swagger.model.Word wordApi15 = new  io.swagger.model.Word();
wordApi15.setSurface("profit");
wordApi15.score(0.018315332205248946);
io.swagger.model.Word wordApi16 = new  io.swagger.model.Word();
wordApi16.setSurface("statement");
wordApi16.score(0.014937223512592572);
io.swagger.model.Word wordApi17 = new  io.swagger.model.Word();
wordApi17.setSurface("share");
wordApi17.score(0.013446157201704995);
io.swagger.model.Word wordApi18 = new  io.swagger.model.Word();
wordApi18.setSurface("balance");
wordApi18.score(0.011730385813166475);   

io.swagger.model.Word wordApi19 = new  io.swagger.model.Word();
wordApi19.setSurface("value");
wordApi19.score(0.010719011293483596);

io.swagger.model.Word wordApi110 = new  io.swagger.model.Word();
wordApi110.setSurface("ratio");
wordApi110.score(0.01047880275125892);
topicdis1.addTopicItem(wordApi11);
topicdis1.addTopicItem(wordApi12);
topicdis1.addTopicItem(wordApi13);
topicdis1.addTopicItem(wordApi14);
topicdis1.addTopicItem(wordApi15);
topicdis1.addTopicItem(wordApi16);
topicdis1.addTopicItem(wordApi17);
topicdis1.addTopicItem(wordApi18);
topicdis1.addTopicItem(wordApi19);
topicdis1.addTopicItem(wordApi110);

result.add(topicdis1);

}*/
	
/*List<Resource> items = udm.find(Resource.Type.ITEM).from(Resource.Type.DOCUMENT, documentUri);


if (items.isEmpty()) return new ResponseEntity<List<TopicDistribution>>(HttpStatus.NOT_FOUND);


//LIMIT TO 10??_
udm.find(Relation.Type.DEALS_WITH_FROM_ITEM).from(Resource.Type.ITEM, items.get(0).getUri()).stream().sorted((dt1,dt2)->-dt1.getWeight().compareTo(dt2.getWeight())).limit(c.getMaxTopics()).forEach(td -> {

	TopicDistribution topicdis = new TopicDistribution();

    String topicUri = td.getEndUri();

    Double relevance = td.getWeight();
    LOG.info("Topic '" + td.getEndUri()+"' ("+relevance+")");

    topicdis.setWeight(relevance);
    

    //ARE THE WORDS ORDERED?
    udm.find(Relation.Type.MENTIONS_FROM_TOPIC).from(Resource.Type.TOPIC, topicUri).stream().sorted((rel1,rel2)->-rel1.getWeight().compareTo(rel2.getWeight())).limit(c.getMaxWordsPerTopic()).forEach(rel -> {

        Double weight = rel.getWeight();
        Word word = udm.read(Resource.Type.WORD).byUri(rel.getEndUri())
                .get().asWord();

        LOG.info("Word: '"+word.getContent()+"' ("+weight+")");
        io.swagger.model.Word wordApi = new  io.swagger.model.Word();
        wordApi.setScore(weight);
        wordApi.setSurface(word.getContent());

        topicdis.addTopicItem(wordApi);

    });
    result.add(topicdis);

});

if (result.isEmpty()) {
	
	injectFake(result);
    
}*/