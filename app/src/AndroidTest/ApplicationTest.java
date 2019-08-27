package AndroidTest;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;
import android.util.Pair;

import com.example.joclib.joker;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getTargetContext;

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
        EndpointsAsyncTask coolecter = new EndpointsAsyncTask();

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
