package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.jokefactory.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {

        if(myApiService == null){
            MyApi.Builder apibulid= new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory() ,null).setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

                    myApiService=apibulid.build();

        }


                context=pairs[0].first;

        try {
            return myApiService.getDataJoke().execute().getData();
        } catch (IOException e) {
         return    e.getMessage();
        }


    }

    @Override
    protected void onPostExecute(String s) {
        Intent intent=new Intent(context, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_KEY,s);
        context.startActivity(intent);
    }
}
