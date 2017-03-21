package io.swagger.api;

import org.librairy.bluebottle.conf.Conf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.model.Collection;
import io.swagger.model.api.CollectionAPI;



@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-04T11:07:26.201Z")

@Controller
public class CollectionApiController implements CollectionApi {
    private static Logger LOG = LoggerFactory.getLogger(CollectionApiController.class);
	
  /*  @Autowired
	UDM udm;
    
    @Autowired
    EventBus bus;
    
    @Autowired
    URIGenerator uriGenerator;
    
    @Autowired
    LDAModelerAPI ldaApi;
    */
    public ResponseEntity<Collection> collectionGet() {
        // do some magic!
    	
    	
    	
    	
    	
    	
    	RestTemplate restTemplate = new RestTemplate();

    	
    	Collection c = new Collection();
    	
    	
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID())
      	        .queryParam("size", "100");

    	
    	System.out.println("URL " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<CollectionAPI> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.GET,
                  request,
                  CollectionAPI.class);
          
          
      	if (response.getBody() == null) return ResponseEntity.ok(c);
      	
      	c.setNumDocuments(response.getBody().getDocuments());
      	c.setNumTopics(response.getBody().getTopics());
      	c.setLDA(response.getBody().getTopics().doubleValue()> 0);

        //LOG.info("  number of documents in the collection " + udm.find(Resource.Type.DOCUMENT).all().size() );
        //LOG.info("  number of topics in the collection " + udm.find(Resource.Type.TOPIC).all().size() );
        //LOG.info("  number of parts in the collection " + udm.find(Resource.Type.PART).all().size() );
        //LOG.info("  first document in the collection " + udm.find(Resource.Type.DOCUMENT).all().get(0).getUri() );
        //LOG.info("  url " + uriGenerator.from(Resource.Type.DOCUMENT, id)) ;
    	
    	
     	//Criteria criteria = new Criteria ();
     	
     	//List<ScoredTopic> topics = ldaApi.getTopics(criteria);
     	
     	
    	//int numTopics = topics.size();
    	//boolean LDA = (!topics.isEmpty()) ? true : false;

    			
    	//c.setLDA(LDA);
    	//c.setNumDocuments(new BigDecimal(udm.count(Resource.Type.ITEM).all()));
    	//c.setNumTopics(new BigDecimal(numTopics));
    	
    	/*if (LDA){
    		Criteria cr = new Criteria();
    		cr.setMax(1);//we only need one
    		
    		List<ScoredTopic> topics = ldaApi.getTopics(cr);
    		if (!topics.isEmpty()){
        		//Optional<Resource> topicFirst = udm.read(Resource.Type.TOPIC).byUri(topics.get(0).getUri());

    			//c.setDateLDA(topicFirst.get().getCreationTime());
    		}
    		
        	
    	}*/
    	
        return ResponseEntity.ok(c);
    }

	@Override
	public ResponseEntity<String> collectionReprocessTopic() {
		
    	RestTemplate restTemplate = new RestTemplate();

    	
    	
    	
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Build Request
        HttpEntity<String> request = new HttpEntity<String>(headers);
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Conf.getApiURL()+"/domains/"+Conf.getDomainUUID()+"/topics")
      	        .queryParam("size", "100");

    	
    	System.out.println("URL PUT " + builder.build().encode().toUri());

          // Launch Get           
          ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                  HttpMethod.PUT,
                  request,
                  String.class);
          
          

		// TODO Auto-generated method stub
		return response;
	}

}
