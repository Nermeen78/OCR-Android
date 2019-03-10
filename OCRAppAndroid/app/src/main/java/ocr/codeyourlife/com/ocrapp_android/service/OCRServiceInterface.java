package ocr.codeyourlife.com.ocrapp_android.service;


import ocr.codeyourlife.com.ocrapp_android.model.ImageTextResponse;


import okhttp3.MultipartBody;
import retrofit2.http.*;
import rx.Observable;

public interface OCRServiceInterface {

    @Multipart
    @POST("/processDocument")
    Observable<ImageTextResponse> processImage(@Query("language") String language,
                                               @Query("gettext") String gettext,
                                               @Query("outputformat") String outputformat,
                                               @Part MultipartBody.Part file
                                               ) ;

}
