package ocr.codeyourlife.com.ocrapp_android.service;

import android.database.Observable;
import ocr.codeyourlife.com.ocrapp_android.service.response.ImageTextResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface OCRServiceInterface {

    @FormUrlEncoded
    @POST("/processDocument")
    Observable<ImageTextResponse> processImage(@Field("language") String language,
                                               @Field("gettext") String gettext,
                                               @Field("outputformat") String outputformat ) ;

}
