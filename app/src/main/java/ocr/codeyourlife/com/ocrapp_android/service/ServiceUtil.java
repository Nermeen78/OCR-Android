package ocr.codeyourlife.com.ocrapp_android.service;

import ocr.codeyourlife.com.ocrapp_android.model.ImageTextResponse;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import javax.inject.Inject;
import java.io.File;

public class ServiceUtil {


    final OCRServiceInterface ocrServiceInterface;

    @Inject
    public ServiceUtil(OCRServiceInterface ocrServiceInterface
    ) {
        this.ocrServiceInterface = ocrServiceInterface;

    }

    public Subscription getImageText(final GetTextCallback getTextCallback, String langauge, final String getText, String outFormat, File file) {

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        return ocrServiceInterface.processImage("english", "true", "doc", multipartBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ImageTextResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getTextCallback.onError(e);
                    }

                    @Override
                    public void onNext(ImageTextResponse imageTextResponse) {
                        getTextCallback.onSuccess(imageTextResponse);
                    }
                });
    }

    public interface GetTextCallback {
        void onSuccess(ImageTextResponse imageTextResponse);

        void onError(Throwable networkError);
    }
}
