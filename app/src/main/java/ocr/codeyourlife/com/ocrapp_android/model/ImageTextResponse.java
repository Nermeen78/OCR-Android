package ocr.codeyourlife.com.ocrapp_android.model;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ImageTextResponse {
    @SerializedName("ParsedResults")
    @Expose
    private List<ParsedResult> parsedResults = new ArrayList<>();
    @SerializedName("OCRExitCode")
    @Expose
    private int oCRExitCode;
    @SerializedName("IsErroredOnProcessing")
    @Expose
    private boolean isErroredOnProcessing;
    @SerializedName("ProcessingTimeInMilliseconds")
    @Expose
    private String processingTimeInMilliseconds;
    @SerializedName("SearchablePDFURL")
    @Expose
    private String searchablePDFURL;

    public List<ParsedResult> getParsedResults() {
        return parsedResults;
    }

    public void setParsedResults(List<ParsedResult> parsedResults) {
        this.parsedResults = parsedResults;
    }

    public int getOCRExitCode() {
        return oCRExitCode;
    }

    public void setOCRExitCode(int oCRExitCode) {
        this.oCRExitCode = oCRExitCode;
    }

    public boolean isIsErroredOnProcessing() {
        return isErroredOnProcessing;
    }

    public void setIsErroredOnProcessing(boolean isErroredOnProcessing) {
        this.isErroredOnProcessing = isErroredOnProcessing;
    }

    public String getProcessingTimeInMilliseconds() {
        return processingTimeInMilliseconds;
    }

    public void setProcessingTimeInMilliseconds(String processingTimeInMilliseconds) {
        this.processingTimeInMilliseconds = processingTimeInMilliseconds;
    }

    public String getSearchablePDFURL() {
        return searchablePDFURL;
    }

    public void setSearchablePDFURL(String searchablePDFURL) {
        this.searchablePDFURL = searchablePDFURL;
    }


}
