package com.medina.rest.client.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterfaceMessage {
	
	@GET("messages")
	Call<List<RetrofitModelMessage>> loadMessages();

}
