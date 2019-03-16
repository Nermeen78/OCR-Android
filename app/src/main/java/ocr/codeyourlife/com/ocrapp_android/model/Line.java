package ocr.codeyourlife.com.ocrapp_android.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Line {

    @SerializedName("Words")
    @Expose
    private List<Word> words = new ArrayList<>();
    @SerializedName("MaxHeight")
    @Expose
    private float maxHeight;
    @SerializedName("MinTop")
    @Expose
    private float minTop;

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public float getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(float maxHeight) {
        this.maxHeight = maxHeight;
    }

    public float getMinTop() {
        return minTop;
    }

    public void setMinTop(float minTop) {
        this.minTop = minTop;
    }

}
