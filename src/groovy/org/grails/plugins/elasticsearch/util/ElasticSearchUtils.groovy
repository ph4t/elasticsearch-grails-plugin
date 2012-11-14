package org.grails.plugins.elasticsearch.util

import java.util.Map;

import org.codehaus.groovy.grails.commons.ApplicationHolder

class ElasticSearchUtils {
  public static indexDomain(entity){
    def elasticSearchService = ApplicationHolder.application.mainContext.getBean('elasticSearchService')
    elasticSearchService.indexDomain(entity)
  }

  public static deleteDomain(entity){
    def elasticSearchService = ApplicationHolder.application.mainContext.getBean('elasticSearchService')
    elasticSearchService.deleteDomain(entity)
  }
  
  static boolean compareMaps (Map a, Map b) {
	  if (!a || !b){
		  //they are empty
		  return false
	  }
	  if (a.size() != b.size()){
		  //the size is different
		  return false
	  }
	  
	  a?.each{ key, value ->
		  if (b[key] == null){
			  //map B doesn't have the same key
			  return false
		  }
		  // in case that the values are a map then we want to compare them using the same method
		  if (value instanceof Map && b[key] instanceof Map){
			  if (!compareMaps(value, b[key])){
				  return false
			  }
		  }else{
			  //if the values are not map then just compare them
			  if (!value.equals(b[key])){
				  return false
			  }
		  }
	  }
	  //we compared everything so it must be equal
	  return true
  }
}
