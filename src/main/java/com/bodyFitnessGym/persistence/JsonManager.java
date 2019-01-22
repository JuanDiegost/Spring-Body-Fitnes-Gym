package com.bodyFitnessGym.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonManager {

	public static String toJson(Object obj) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
		return gson.toJson(obj);
	}
}
