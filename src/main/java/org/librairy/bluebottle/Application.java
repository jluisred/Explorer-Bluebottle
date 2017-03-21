/*
 * Copyright (c) 2016. Universidad Politecnica de Madrid
 *
 * @author Badenes Olmedo, Carlos <cbadenes@fi.upm.es>
 *
 */

package org.librairy.bluebottle;

import org.librairy.bluebottle.conf.Conf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "io.swagger")

//@ComponentScan({"org.librairy.boot", "io.swagger", "org.librairy.storage.system.column", "org.librairy.modeler.lda.api"})
//@PropertySource({"classpath:boot.properties"})
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    static int port = 8888;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public static EmbeddedServletContainerFactory getTomcatEmbeddedFactory(){
        TomcatEmbeddedServletContainerFactory servlet = new TomcatEmbeddedServletContainerFactory();
        servlet.setPort(port);
        return servlet;
    }

    public static void main(String[] args){
        try {

            if (args != null && args.length > 0){

                port = Integer.valueOf(args[0]);
            }
            loadEnvironment();


    		//new SpringApplication(Application.class).run(args);

            ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
            
            LOG.info("Listening on port: " + port);

        } catch (Exception e) {
            LOG.error("Error executing test",e);
            System.exit(-1);
        }

    }
    
    
	private static void loadEnvironment() {
		
		
		 String varApi = System.getenv("LIBRAIRY_EXPLORER_API_ENDPOINT");
		 String varDomainID = System.getenv("LIBRAIRY_EXPLORER_DOMAIN_ID");
		 String varEndpoint = System.getenv("LIBRAIRY_HARVESTER_ENDPOINT_CLIENT");
		 String varApikey = System.getenv("LIBRAIRY_HARVESTER_ENDPOINT_CLIENT_APIKEY");

        //String var = "testIdCorpus";

        if (varApi != null && !varApi.isEmpty()) 
        	Conf.setApiURL(varApi);
        if (varDomainID != null && !varDomainID.isEmpty()) 
        	Conf.setDomainUUID(varDomainID);
        if (varApikey != null && !varApikey.isEmpty()) 
          	Conf.setApikey(varApikey);
         if (varEndpoint != null && !varEndpoint.isEmpty()) 
           	Conf.setEndpointURL(varEndpoint);

        
        System.out.println("====    EXPLORER CONFIGURATION    ====");

        System.out.println("API Endpoint: " + Conf.getApikey());
        System.out.println("Domain Name: " + Conf.getDomainUUID());
        System.out.println("Endpoint URL: " + Conf.getEndpointURL());
        System.out.println("API key: " + Conf.getApikey());
        
        System.out.println("=======================================");

	}
}



