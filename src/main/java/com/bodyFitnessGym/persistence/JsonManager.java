package com.bodyFitnessGym.persistence;

import java.util.ArrayList;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class JsonManager {

	public static String toJson(Object obj) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd-HH:mm:ss").create();
		return gson.toJson(obj);
	}
	
	public static ArrayList<Double> getClusterValues(String url) throws UnirestException {
		ArrayList<Double> clusters = new ArrayList<Double>();
		HttpResponse<JsonNode> jsonResponse = Unirest.get(
				"http://mkweb.bcgsc.ca/color-summarizer/?url="+url+"&precision=low&json=1&num_clusters=3")
				.asJson();

		JSONObject a = jsonResponse.getBody().getObject().getJSONObject("clusters");
		int backgroundcluster = (Integer) ((JSONObject) ((JSONObject) jsonResponse.getBody().getObject().get("pixels"))
				.get("0")).get("cluster");
		for (int i = 0; i < 3; i++) {
			if (backgroundcluster != i) {
				clusters.add((Double) ((JSONObject) a.get(i + "")).get("f"));
			}
		}
		return clusters;
	}
	
}
