package fuze.tikal.com.androidfuze.data.source.remote;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shaulr on 10/07/2017.
 */

public class GithubRemote {
    public static final String API_URL = "https://api.github.com";

    private Context mContext;
    private GitHub github;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public interface GitHub {
        @GET("/user/repos")
        Call<List<GithubRepository>> repos();

        @GET("/user")
        Call<GithubUser> user();
    }

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public void init(Context context) {
        mContext = context;
        // Create a very simple REST adapter which points the GitHub API.
        Retrofit retrofit = builder.build();

        String token = mContext.getSharedPreferences("github_prefs", Context.MODE_PRIVATE).getString("oauth_token", "");;
        HttpInterceptor interceptor =
                new HttpInterceptor(token);

        if (!httpClient.interceptors().contains(interceptor)) {
            httpClient.addInterceptor(interceptor);

            builder.client(httpClient.build());
            retrofit = builder.build();
        }
        // Create an instance of our GitHub API interface.
        github = retrofit.create(GitHub.class);



    }

    public List<GithubRepository> repos() {
        Call<List<GithubRepository>> call = github.repos();
        try {
            return call.execute().body();
        } catch (IOException e) {
            return null;
        }
    }


}
