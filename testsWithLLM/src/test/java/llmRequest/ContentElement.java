package llmRequest;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ContentElement {
    private String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String text;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ImageUrl image_url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ImageUrl getImage_url() {
        return image_url;
    }

    public void setImage_url(ImageUrl image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "ContentElement{" +
                "type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", image_url=" + image_url +
                '}';
    }
}
