package fuze.tikal.com.androidfuze.data.source.remote;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by shaulr on 10/07/2017.
 */

public class HttpInterceptor implements Interceptor {
    private final String token;

    public HttpInterceptor(String token) {
        this.token = token;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        //Build new request
        Request.Builder builder = request.newBuilder();
        builder.header("Accept", "application/json"); //if necessary, say to consume JSON

        setAuthHeader(builder, token); //write current token to request

        request = builder.build(); //overwrite old request
        Response response = chain.proceed(request); //perform request, here original request will be executed

        if (response.code() == 401) { //if unauthorized
//            synchronized (httpClient) { //perform all 401 in sync blocks, to avoid multiply token updates
                String currentToken = token; //get currently stored token

                if(currentToken != null && currentToken.equals(token)) { //compare current token with token that was stored before, if it was not updated - do update

                    int code = refreshToken() / 100; //refresh token
                    if(code != 2) { //if refresh token failed for some reason
                        if(code == 4) //only if response is 400, 500 might mean that token was not updated
                            logout(); //go to login screen
                        return response; //if token refresh failed - show error to user
                    }
                }

                if(token != null) { //retry requires new auth token,
                    setAuthHeader(builder, token); //set auth token to updated
                    request = builder.build();
                    return chain.proceed(request); //repeat request with new token
                }
            }
//        }

        return response;
    }

    private void setAuthHeader(Request.Builder builder, String token) {
        if (token != null) //Add Auth token to each request if authorized
            builder.header("Authorization", String.format("Bearer %s", token));
    }

    private int refreshToken() {
        //Refresh token, synchronously, save it, and return result code
        //you might use retrofit here
        return -1;
    }

    private int logout() {
        //logout your user
        return -1;
    }


}
