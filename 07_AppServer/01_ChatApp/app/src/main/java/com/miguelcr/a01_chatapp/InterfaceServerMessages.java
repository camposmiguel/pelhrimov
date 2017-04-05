package com.miguelcr.a01_chatapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

/**
 * Created by miguelcampos on 5/4/17.
 */

public interface InterfaceServerMessages {

    @GET("get_all_messages.php")
    Call<ServerMessageResponse> getMessages();
}
