package ocr.codeyourlife.com.ocrapp_android.model;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ImageTextResponse {
        @SerializedName("ErrorMessage")
        @Expose
        private String errorMessage;
        @SerializedName("AvailablePages")
        @Expose
        private int availablePages;
        @SerializedName("ProcessedPages")
        @Expose
        private int processedPages;
        @SerializedName("OCRText")
        @Expose
        private List<List<String>> oCRText = null;
        @SerializedName("OutputFileUrl")
        @Expose
        private String outputFileUrl;
        @SerializedName("TaskDescription")
        @Expose
        private String taskDescription;
        @SerializedName("Reserved")
        @Expose
        private List<Object> reserved = null;

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public int getAvailablePages() {
            return availablePages;
        }

        public void setAvailablePages(int availablePages) {
            this.availablePages = availablePages;
        }

        public int getProcessedPages() {
            return processedPages;
        }

        public void setProcessedPages(int processedPages) {
            this.processedPages = processedPages;
        }

        public List<List<String>> getOCRText() {
            return oCRText;
        }

        public void setOCRText(List<List<String>> oCRText) {
            this.oCRText = oCRText;
        }

        public String getOutputFileUrl() {
            return outputFileUrl;
        }

        public void setOutputFileUrl(String outputFileUrl) {
            this.outputFileUrl = outputFileUrl;
        }

        public String getTaskDescription() {
            return taskDescription;
        }

        public void setTaskDescription(String taskDescription) {
            this.taskDescription = taskDescription;
        }

        public List<Object> getReserved() {
            return reserved;
        }

        public void setReserved(List<Object> reserved) {
            this.reserved = reserved;
        }

}
