package org.librairy.bluebottle.conf;

public class Conf {
	static String endpointURL = "http://api.staging.bluebottlebiz.com/";
	static String apiURL = "http://librairy.linkeddata.es/api/";

	static String apikey = "e62f85c0-8ed2-11e6-96d5-b8aeed74afe3";
	//String domainUUID = "141fc5bbcf0212ec9bee5ef66c6096ab"; //BLUEBOTTLE ALL
	static String domainUUID = "ae5753952f7db4b1d56a5942e08476f9"; //BLUEBOTTLE 200
	//String domainUUID = "2de4b3245d79606bdd31176b201b1ab6"; //BLUEBOTTLE 200B

//	static String domainTestUUID = "141fc5bbcf0212ec9bee5ef66c7000ab";

	static int maxTopics = 10;
	static int maxWordsPerTopic = 20;
	
	
	public static int getMaxTopics() {
		return maxTopics;
	}
	public static void setMaxTopics(int maxTopics) {
		Conf.maxTopics = maxTopics;
	}
	public static int getMaxWordsPerTopic() {
		return maxWordsPerTopic;
	}
	public static void setMaxWordsPerTopic(int maxWordsPerTopic) {
		Conf.maxWordsPerTopic = maxWordsPerTopic;
	}
	public static String getEndpointURL() {
		return endpointURL;
	}
	public static void setEndpointURL(String endpointURL) {
		Conf.endpointURL = endpointURL;
	}
	public static String getApikey() {
		return apikey;
	}
	public static void setApikey(String apikey) {
		Conf.apikey = apikey;
	}
	public static String getApiURL() {
		return apiURL;
	}
	public static void setApiURL(String apiURL) {
		Conf.apiURL = apiURL;
	}
	public static String getDomainUUID() {
		// TODO Auto-generated method stub
		return domainUUID;
	}
/*	public static String getDomainTestUUID() {
		return domainTestUUID;
	}
	public static void setDomainTestUUID(String domainTestUUID) {
		Conf.domainTestUUID = domainTestUUID;
	}*/
	public static void setDomainUUID(String domainUUID) {
		Conf.domainUUID = domainUUID;
	}
	
	
	

}
