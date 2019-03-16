package ocr.codeyourlife.com.ocrapp_android.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Word {

    @SerializedName("WordText")
    @Expose
    private String wordText;
    @SerializedName("Left")
    @Expose
    private float left;
    @SerializedName("Top")
    @Expose
    private float top;
    @SerializedName("Height")
    @Expose
    private float height;
    @SerializedName("Width")
    @Expose
    private float width;

    public String getWordText() {
        return wordText;
    }

    public void setWordText(String wordText) {
        this.wordText = wordText;
    }

    public float getLeft() {
        return left;
    }

    public void setLeft(float left) {
        this.left = left;
    }

    public float getTop() {
        return top;
    }

    public void setTop(float top) {
        this.top = top;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

}