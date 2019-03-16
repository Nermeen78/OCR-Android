package ocr.codeyourlife.com.ocrapp_android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.File;

public class RequstBody {

    @SerializedName("apikey")
    @Expose
    String apikey;
    @SerializedName("language")
    @Expose
    String  language;
    @SerializedName("isOverlayRequired")
    @Expose
    boolean isOverlayRequired;
    @SerializedName("url")
    @Expose
    String url;

    public RequstBody(String apikey, String language, boolean isOverlayRequired, File file) {
        this.apikey = apikey;
        this.language = language;
        this.isOverlayRequired = isOverlayRequired;
        this.url = "http://dl.a9t9.com/blog/ocr-online/screenshot.jpg";
    }



}
