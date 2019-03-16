package ocr.codeyourlife.com.ocrapp_android.service;


import ocr.codeyourlife.com.ocrapp_android.model.ImageTextResponse;


import ocr.codeyourlife.com.ocrapp_android.model.RequstBody;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.*;
import rx.Observable;

public interface OCRServiceInterface {


    @POST("image")
    Observable<ImageTextResponse> processImage(@Body RequestBody requestbody);

}
