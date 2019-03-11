package ocr.codeyourlife.com.ocrapp_android.service;

import android.os.Build;

import dagger.Module;

import dagger.Provides;
import ocr.codeyourlife.com.ocrapp_android.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
    Retrofit provideRetrofit()
    {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();

                        // Customize the request

                        Request request = original.newBuilder()
                                .header("Content-Type", "application/json")
                                .removeHeader("Pragma")
                            //    .header("Authorization","Basic " + Base64.getEncoder().encodeToString(("NERMEEN" + ":" + "462339B0-2028-4AF8-82E6-0160FE9CE5D2").getBytes()))
                                .build();

                        Response response = chain.proceed(request);
                       // response.cacheResponse();
                        // Customize or return the response
                        return response;
                    }
                })


                .build();
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .client(okHttpClient)
                .addConverterFactory( GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }


    @Provides
    @Singleton
    public OCRServiceInterface providesOCRService(
            Retrofit retrofit) {
        return retrofit.create(OCRServiceInterface.class);
    }


}
