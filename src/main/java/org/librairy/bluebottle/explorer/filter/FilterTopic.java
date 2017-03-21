package org.librairy.bluebottle.explorer.filter;

import java.util.List;

import io.swagger.model.TopicDistribution;

public class FilterTopic {

	
	static public List<TopicDistribution> filterByWeight(List<TopicDistribution> result) {
		
		if (result.isEmpty()) return result;
		
		
		double maxWeight = result.get(0).getWeight();
		double minWeight = result.get(0).getWeight();

		for (TopicDistribution td : result){
			if (td.getWeight()>maxWeight) maxWeight = td.getWeight();
			if (td.getWeight()<minWeight) minWeight = td.getWeight();
		}
		
		//Space between topics if all were equally distributed in relevance dimension
		
		double width =(int) ((double)result.size() * 0.2);
		double step = (maxWeight - minWeight) / result.size();
		
		
		double ref =  result.get(0).getWeight();
		for (int i = 0; i < result.size(); i++){
			if (ref - result.get(i).getWeight()>step*width) {
				return  result.subList(0, i);
			}
			ref = result.get(i).getWeight();
		}
		
		return result;
		
	}
}
