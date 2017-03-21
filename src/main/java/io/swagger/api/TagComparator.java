package io.swagger.api;

import java.util.Comparator;

import io.swagger.model.Tag;

public  class TagComparator implements Comparator<Tag> {

	public int compare(Tag  o1, Tag o2) {
		// TODO Auto-generated method stub
		return Double.compare(o2.getScore(), o1.getScore());
	}


}
