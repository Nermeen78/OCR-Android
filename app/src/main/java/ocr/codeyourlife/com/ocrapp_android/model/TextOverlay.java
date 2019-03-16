package ocr.codeyourlife.com.ocrapp_android.model;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TextOverlay {

    @SerializedName("Lines")
    @Expose
    private List<Line> lines = new ArrayList<>();
    @SerializedName("HasOverlay")
    @Expose
    private boolean hasOverlay;
    @SerializedName("Message")
    @Expose
    private String message;

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public boolean isHasOverlay() {
        return hasOverlay;
    }

    public void setHasOverlay(boolean hasOverlay) {
        this.hasOverlay = hasOverlay;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}