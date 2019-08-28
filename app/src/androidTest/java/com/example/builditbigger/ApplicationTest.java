package com.example.builditbigger;

import android.content.Context;
import android.util.Log;
import android.util.Pair;

import androidx.multidex.MultiDex;

import com.example.javajoker.Joker;

import com.udacity.gradle.builditbigger.EndpointAsyncTask;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import static androidx.test.InstrumentationRegistry.getTargetContext;

public class ApplicationTest extends TestCase {

    public final String TAG = ".AppTest";
    private Context context;
    public ApplicationTest(){

    }


    @Before
    public void setup(){
        context = getTargetContext();
        MultiDex.install(getTargetContext());

    }

    @Test
    public void testApp(){

        Joker joke = new Joker();

        String data = null;
        EndpointAsyncTask coolecter = new EndpointAsyncTask(new EndpointAsyncTask.AsyncResponse() {
            @Override
            public void processFinish(String output) {

            }
        });

        coolecter.execute(new Pair<Context, String>(context , "second"));
        try {
            data = coolecter.get();
            if (data != null) {
                if (data.equals("Connection refused")) {
                    Log.d(TAG, "No DATA FOUND ");
                    data = null;
                } else {
                    Log.d(TAG, "DATA FOUND " + data);
                }
            }else{
                Log.d(TAG, "Null DATA ");
            }

        }catch(Exception e){
            Log.d(TAG, "No DATA FOUND ");

            e.printStackTrace();
        }
        assertNotNull(data);


    }
}
