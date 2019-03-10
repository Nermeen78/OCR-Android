package ocr.codeyourlife.com.ocrapp_android.service;

import android.os.Build;
import dagger.Module;

import dagger.Provides;
import ocr.codeyourlife.com.ocrapp_android.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit()
    {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
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
