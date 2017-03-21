package org.librairy.bluebottle.tags;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.librairy.bluebottle.similarity.LetterPairSimilarity;

import io.swagger.model.Tag;

public class TagUtils {

	public static String cleanCornerCases(String rawAnnotations) {
		rawAnnotations = rawAnnotations.replaceAll("et_al.", "");
		rawAnnotations = rawAnnotations.replaceAll("et_al", "");

		return rawAnnotations;
	}
	
	public static List<Tag> rankAnnotations(String[] annotations, String type, double correction) {
		List<Tag> result = new ArrayList<Tag>();

		if (annotations.length==0)return result;
	    Hashtable<String, ArrayList<String>> tokensCount = new Hashtable<String, ArrayList<String>>();
	    for (String token : annotations){
	    	if (!containsKeyTable(tokensCount, token)){
	    		ArrayList<String> listWords = new ArrayList<String>();
	    		listWords.add(token);
	    		tokensCount.put(token, listWords);
	 
	    	}
	    }
	    
	    ArrayList<Map.Entry<?, ArrayList<String>>> l = new ArrayList<Map.Entry<?, ArrayList<String>>>(tokensCount.entrySet());
	    Collections.sort(l, new Comparator<Map.Entry<?, ArrayList<String>>>(){

	      public int compare(Map.Entry<?, ArrayList<String>> o1, Map.Entry<?, ArrayList<String>> o2) {
	         return Integer.compare(o2.getValue().size(), o1.getValue().size());
	     }});

	    
	    int maxFreq = l.get(0).getValue().size();
	    for (Map.Entry<?, ArrayList<String>> word : l){
	    	//System.out.println(type +": "+word.getKey() + "  " + word.getValue());
	    	Tag t = new Tag();
	    	t.setScore((double)word.getValue().size()/maxFreq * correction);
	    	t.setSurface(maxLengthSurface (word.getValue()));
	    	t.setType(type);
	    	result.add(t);
	    	System.out.println("CENTROID ("+correction+") -> "+word.getKey() );
	    	for (String candidate : word.getValue()){
	        	System.out.println("   -> " +candidate);
	    	}
	    }
	    
	    return result;
	}

	private static String maxLengthSurface(ArrayList<String> value) {
		String maxSurface =value.get(0);
		int maxSurfaceLength = value.get(0).length();
		for (String compound : value){
			if (compound.length() > maxSurfaceLength){
				maxSurface = compound;
				maxSurfaceLength = compound.length();
			}
		}
		return maxSurface ;
	}

	private static boolean containsKeyTable(Hashtable<String, ArrayList<String>> tokensCount, String token) {
		
		Iterator<Entry<String, ArrayList<String>>> iterator = tokensCount.entrySet().iterator();
		while (iterator.hasNext()){
			Entry<String, ArrayList<String>> entry = iterator.next();
			
			if (LetterPairSimilarity.compareStrings(entry.getKey(), token)>0.7){
				entry.getValue().add(token);
				return true;
			}
		}
		
			
		return false;
	}
	
	
	public static void filterStandfordErrors(List<Tag> result) {
		Iterator<Tag> iterator = result.iterator();
		while (iterator.hasNext()){
			Tag tag = iterator.next();
			if (!isValidTag(tag)){
				iterator.remove();
			}
		}
	}

	private static boolean isValidTag(Tag item) {
		if (item.getSurface().contains("et_al")){
			return false;
		}
		if (item.getSurface().compareToIgnoreCase("Whats_Story") == 0){
			return false;
		}
		return true;
	}
}
