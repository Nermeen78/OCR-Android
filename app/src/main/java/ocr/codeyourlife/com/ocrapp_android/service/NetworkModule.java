package ocr.codeyourlife.com.ocrapp_android.service;

import android.os.Build;

import android.support.annotation.RequiresApi;
import android.util.Log;
import dagger.Module;

import dagger.Provides;
import ocr.codeyourlife.com.ocrapp_android.BuildConfig;
import okhttp3.*;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.Base64;


import static java.util.Base64.getEncoder;


@Module
public class NetworkModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();

                        // Customize the request

                        Request request = original.newBuilder()
                                .header("Content-Type", "application/json")
                                // .removeHeader("Pragma")
                                // .header("Authorization","Basic "+"TkVSTUVFTjo0NjIzMzlCMC0yMDI4LTRBRjgtODJFNi0wMTYwRkU5Q0U1RDI=")
                                .build();
                        Log.d("LOGREQBODY",bodyToString(request.body()));

                        Response response = chain.proceed(request);
                        Log.d("LOGBODY", response.body().string());

                        // response.cacheResponse();
                        // Customize or return the response
                        return response;
                    }
                })


                .build();
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }


    @Provides
    @Singleton
    public OCRServiceInterface providesOCRService(
            Retrofit retrofit) {
        return retrofit.create(OCRServiceInterface.class);
    }

    private String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }


}
