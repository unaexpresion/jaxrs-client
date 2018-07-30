package com.medina.rest.client.retrofit;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientMessage implements Callback<List<RetrofitModelMessage>> {
	
	static final String BASE_URL = "http://localhost:8080/jaxrs-messenger/";
	
	public void start() {
		Gson gson = new GsonBuilder()
				.setLenient()
				.create();
		
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();
		
		RetrofitInterfaceMessage retrofitInterfaceMessage = retrofit.create(RetrofitInterfaceMessage.class);
		Call<List<RetrofitModelMessage>> call = retrofitInterfaceMessage.loadMessages();
		call.enqueue(this);
	}

	@Override
	public void onResponse(Call<List<RetrofitModelMessage>> call, Response<List<RetrofitModelMessage>> response) {
		if (response.isSuccessful()) {
			List<RetrofitModelMessage> messageList = response.body();
			messageList.forEach(RetrofitModelMessage ->
					System.out.println("Autor: " + RetrofitModelMessage.author));
		} else {
			System.out.println(response.errorBody());
		}
		
	}

	@Override
	public void onFailure(Call<List<RetrofitModelMessage>> call, Throwable t) {
		t.printStackTrace();
	}

}
