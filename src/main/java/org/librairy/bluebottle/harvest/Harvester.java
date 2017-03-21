package org.librairy.bluebottle.harvest;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.text.Normalizer;
import java.util.List;

import org.librairy.bluebottle.conf.Conf;

import org.neo4j.ogm.json.JSONException;
import org.neo4j.ogm.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import com.google.gson.Gson;

public class Harvester {

	public void harvest(String seoBook){
  	  //int page = p;
	Conf cfg = new Conf();
	
	String domain = cfg.getDomainUUID();
	
	   //get list of books
	  RestTemplate restTemplate = new RestTemplate();

	  //Build Headers
    HttpHeaders headers = new HttpHeaders();
    headers.add("x-api-key", cfg.getApikey());
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    headers.setContentType(MediaType.APPLICATION_JSON);

    //Build Request
    HttpEntity<String> request = new HttpEntity<String>(headers);
	
  	  //pe.execute(() -> processBook(restTemplate, request, book, domain,  booksNoData, booksNoComponents, booksComponents, numConsistentResources, page));
  	 
    BBBResource book = new BBBResource();
    book.setSeoBook(seoBook);
    processBook(restTemplate, request, book, domain);

	}
	
	
	

	private void processBook(RestTemplate restTemplate, HttpEntity<String> request, BBBResource book, String domain) {
  	  System.out.println("Resource: " + book.getSeoBook());
  	  //Retrieving Chapters
      BBResourceUnit resource = null;
      

     resource = retrieveChapters(restTemplate, request, book.getSeoBook());

	  
	  int cont = 0;
	  while (resource == null && cont<20){
		  	resource = retrieveChapters(restTemplate, request, book.getSeoBook());
             cont++;
	  }
	  
      book.setHash(resource.getData().getBook().getHash());
      book.setIsbn(resource.getData().getBook().getIsbn());
      book.setName(resource.getData().getBook().getName());

  	  
  	  
  	  System.out.println("Resource: " + book.getSeoBook());

	  	//Clean 
	 	 Escaper escaper = Escapers.builder()
	             .addEscape('\'',"_")
	             .addEscape('('," ")
	             .addEscape(')'," ")
	             .addEscape('['," ")
	             .addEscape(']'," ")
	             .addEscape('“',"\"")
	             .addEscape('"'," ")
	             .addEscape('…'," ")
	             .addEscape('‘'," ")
	             .addEscape('\n'," ")
	             .addEscape('‘'," ")
	             .build();
	 	 ;
	 	
 	 
 		  if (resource.getData() != null) { //Checking books with no Data

 			  if(resource.getData().getComponents() != null) {//Checking books with no Components


     			 //Generate book
     			  //LibrairyDocument document = saveBookLibrairy(book, "");
     			  
     			  
  		          String textBook = "";
  		          
     			  //Retrieving text 
     			  for (Component c : resource.getData().getComponents()){
     	  	  			//LOG.info("       Chapter: " + c.getId());
     				  String text = "";
     				  
     				  

     	       	  	   text = retrieveTextChapter(restTemplate, request, book.getSeoBook(), c.getId());
     	       	  	   text = Normalizer.normalize(text, Normalizer.Form.NFD);

     	       	  	  	text = escaper.escape(text);
    	       	  	  	text = text.replaceAll("\\P{Print}", "");

    	       	  	  	byte ptext[] = text.getBytes(ISO_8859_1); 
     	       	  	  	text = new String(ptext, UTF_8); 
     			    	  

     	  	  			book.getChapters().add(new DataChapter(c.getId(),text ));
     	  	  			textBook = textBook + " " + text;
     			  }
     			  LibrairyDocument document = saveBookLibrairy(book, textBook);
  		          System.out.println("Book id "+ document.getId());


     			  savePartItemLibrairy(book, document);
     			  
     			  
     			 
      			 //Add book to Domain
     			  addDocumentToDomain(domain, document);

     			  
 			  }

 		  }

		
	}
	
	

	private void addDocumentToDomain(String domain, LibrairyDocument document) {

	    JSONObject domainJson = new JSONObject();



    	 RestTemplate restTemplate = new RestTemplate();

   	  //Build Headers
         HttpHeaders headers = new HttpHeaders();
         headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
         headers.setContentType(MediaType.APPLICATION_JSON);

         //Build Request
    	
         HttpEntity<String> request = new HttpEntity<String>(domainJson.toString(), headers);
         UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://librairy.linkeddata.es/api/domains/"+domain+"/documents/"+document.getId());
         
        ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                HttpMethod.POST,
                request,
                String.class);
        
	}
	private void savePartItemLibrairy(BBBResource book, LibrairyDocument document) {
		//GenerateParts
        //ArrayList<Part> parts = new ArrayList<Part>();
        //String textItem ="";
        //for (DataChapter chapter: book.getChapters()){
        //    Part part = Resource.newPart(chapter.getText());
        //    part.setUri(uriGenerator.from(Resource.Type.PART, chapter.getId()));
        //    udm.save(part);
        //    parts.add(part);
        //    textItem = textItem + " " + chapter.getText(); //Concatenate text
        //}
        
        //Create Item

        
        //Item item = Resource.newItem(textItem);
        //item.setFormat("text");

        //item.setUri(uriGenerator.from(Resource.Type.ITEM, URIGenerator.retrieveId(document.getUri())));
        //udm.save(item);
        //LOG.info("New (textual) Item: " + item.getUri() + " from Document: " + document.getUri());

        //Relation parts / item
        //for (Part p :parts){
        //    udm.save(Relation.newDescribes(p.getUri(),item.getUri()));
        //    udm.save(Relation.newContains(uriGenerator.from(Resource.Type.DOMAIN, "default"),p.getUri()));

        //}
        //relation item / document
        //udm.save(Relation.newBundles(document.getUri(),item.getUri()));
        //udm.save(Relation.newContains(uriGenerator.from(Resource.Type.DOMAIN, "default"),item.getUri()));

		
		
        for (DataChapter chapter: book.getChapters()){

        	

        	
    	    JSONObject domainJson = new JSONObject();
    	    try {
    			domainJson.put("language", "EN");
    			domainJson.put("content", chapter.getText());
    			//domainJson.put("id", chapter.getId());
    			//domainJson.put("uri", "http://librairy.org/parts/"+chapter.getId());


    		} catch (JSONException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} 
        	//System.out.println(domainJson.toString());


        	 RestTemplate restTemplate = new RestTemplate();

       	  //Build Headers
             HttpHeaders headers = new HttpHeaders();
             headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
             headers.setContentType(MediaType.APPLICATION_JSON);

             //Build Request
             HttpEntity<String> request = new HttpEntity<String>(domainJson.toString(), headers);
             UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://librairy.linkeddata.es/api/parts/"+chapter.getId());
             
			try {
	        	//System.out.println("chapter CONTENT: " + chapter.getText());

				restTemplate.exchange( builder.build().encode().toUri(),
				        HttpMethod.POST,
				        request,
				        String.class);
	        	System.out.println("Created Part with ID " + chapter.getId() );

			} catch (RestClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
	       	  //Build Headers

            //Build Request
            HttpEntity<String> requestLinkPartDocument = new HttpEntity<String>(headers);
            UriComponentsBuilder builderLinkPartDocument = UriComponentsBuilder.fromHttpUrl("http://librairy.linkeddata.es/api/documents/"+document.getId()+"/parts/"+chapter.getId());
            
			try {
	        	//System.out.println("chapter CONTENT: " + chapter.getText());

				restTemplate.exchange( builderLinkPartDocument.build().encode().toUri(),
				        HttpMethod.POST,
				        requestLinkPartDocument,
				        String.class);
	        	//System.out.println("Created chapter with ID " + chapter.getId());

			} catch (RestClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


        }
		
		
	}
	

	private LibrairyDocument saveBookLibrairy(BBBResource book, String content) {
		
	
	  	//Clean 
	 	 Escaper escaper = Escapers.builder()
	             .addEscape('\'',"_")
	             .addEscape('('," ")
	             .addEscape(')'," ")
	             .addEscape('['," ")
	             .addEscape(']'," ")
	             .addEscape('“',"\"")
	             .addEscape('"'," ")
	             .addEscape('…'," ")
	             .addEscape('‘'," ")
	             .addEscape('\n'," ")
	             .addEscape('‘'," ")
	             .addEscape('´'," ")
	             .build();
	 	 ;
	 	 
	 	 
	  			String nameEncode = Normalizer.normalize(book.getName(), Normalizer.Form.NFD);
	  			nameEncode = escaper.escape(nameEncode);
	  			nameEncode = nameEncode.replaceAll("\\P{Print}", "");


	  			byte ptext[] = nameEncode.getBytes(ISO_8859_1); 
	  			nameEncode = new String(ptext, UTF_8); 
	  			
    	
	    JSONObject domainJson = new JSONObject();
	    try {
			domainJson.put("name", nameEncode);
			domainJson.put("language", "EN");
			domainJson.put("content", content );
			//domainJson.put("uri", "http://librairy.org/items/"+book.getHash());


		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	    


    	
    	 RestTemplate restTemplate = new RestTemplate();

   	  //Build Headers
         HttpHeaders headers = new HttpHeaders();
         headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
         headers.setContentType(MediaType.APPLICATION_JSON);

         //Build Request
    	
         HttpEntity<String> request = new HttpEntity<String>(domainJson.toString(), headers);
         UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://librairy.linkeddata.es/api/documents/"+book.getHash());
         
         if (book.getName().startsWith("When god")){
        	 System.out.println("This is the URL: "  +builder.build().encode().toUri());
        	 System.out.println("This is the name: "  +book.getName());
        	 System.out.println("This is the content: "  +content);
        	 
        	 


         }

        ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
                HttpMethod.POST,
                request,
                String.class);
        
        
        Gson gson = new Gson();
        LibrairyDocument document = gson.fromJson(response.getBody(), LibrairyDocument.class);
        
		
         return document;
		
	}

private static BBResourceUnit retrieveChapters(RestTemplate restTemplate, HttpEntity<String> request,
		String seoBook) {

	Conf cfg = new Conf();
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(cfg.getEndpointURL()+"/resources/"+seoBook+"/reader");
              
    System.out.println( builder.build().encode().toUri().toString());
    ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(),
            HttpMethod.GET,
            request,
            String.class);
    System.out.println( response.getBody());

    Gson gson = new Gson() ;
    BBResourceUnit joc = gson.fromJson( response.getBody(),BBResourceUnit.class) ;
	
    return  joc;
}


private static String retrieveTextChapter(RestTemplate restTemplate, HttpEntity<String> request, String seoBook, String id) {
	Conf cfg = new Conf();

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(cfg.getEndpointURL()+"/resources/"+seoBook+"/components/"+id);
    //System.out.println( builder.build().encode().toUri());
    ResponseEntity<BBChapter> response = restTemplate.exchange( builder.build().encode().toUri(),
            HttpMethod.GET,
            request,
            BBChapter.class);
    
    if (response.getStatusCode() == HttpStatus.OK && response.getBody() == null) return "";
	return response.getBody().getData().getText();
}
}
