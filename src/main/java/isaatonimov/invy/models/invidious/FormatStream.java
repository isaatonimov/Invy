
package isaatonimov.invy.models.invidious;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "itag",
    "type",
    "quality",
    "fps",
    "container",
    "encoding",
    "resolution",
    "qualityLabel",
    "size"
})
@Generated("jsonschema2pojo")
public class FormatStream {

    @JsonProperty("url")
    private String url;
    @JsonProperty("itag")
    private String itag;
    @JsonProperty("type")
    private String type;
    @JsonProperty("quality")
    private String quality;
    @JsonProperty("fps")
    private Integer fps;
    @JsonProperty("container")
    private String container;
    @JsonProperty("encoding")
    private String encoding;
    @JsonProperty("resolution")
    private String resolution;
    @JsonProperty("qualityLabel")
    private String qualityLabel;
    @JsonProperty("size")
    private String size;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("itag")
    public String getItag() {
        return itag;
    }

    @JsonProperty("itag")
    public void setItag(String itag) {
        this.itag = itag;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("quality")
    public String getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(String quality) {
        this.quality = quality;
    }

    @JsonProperty("fps")
    public Integer getFps() {
        return fps;
    }

    @JsonProperty("fps")
    public void setFps(Integer fps) {
        this.fps = fps;
    }

    @JsonProperty("container")
    public String getContainer() {
        return container;
    }

    @JsonProperty("container")
    public void setContainer(String container) {
        this.container = container;
    }

    @JsonProperty("encoding")
    public String getEncoding() {
        return encoding;
    }

    @JsonProperty("encoding")
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    @JsonProperty("resolution")
    public String getResolution() {
        return resolution;
    }

    @JsonProperty("resolution")
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @JsonProperty("qualityLabel")
    public String getQualityLabel() {
        return qualityLabel;
    }

    @JsonProperty("qualityLabel")
    public void setQualityLabel(String qualityLabel) {
        this.qualityLabel = qualityLabel;
    }

    @JsonProperty("size")
    public String getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FormatStream.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("itag");
        sb.append('=');
        sb.append(((this.itag == null)?"<null>":this.itag));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("quality");
        sb.append('=');
        sb.append(((this.quality == null)?"<null>":this.quality));
        sb.append(',');
        sb.append("fps");
        sb.append('=');
        sb.append(((this.fps == null)?"<null>":this.fps));
        sb.append(',');
        sb.append("container");
        sb.append('=');
        sb.append(((this.container == null)?"<null>":this.container));
        sb.append(',');
        sb.append("encoding");
        sb.append('=');
        sb.append(((this.encoding == null)?"<null>":this.encoding));
        sb.append(',');
        sb.append("resolution");
        sb.append('=');
        sb.append(((this.resolution == null)?"<null>":this.resolution));
        sb.append(',');
        sb.append("qualityLabel");
        sb.append('=');
        sb.append(((this.qualityLabel == null)?"<null>":this.qualityLabel));
        sb.append(',');
        sb.append("size");
        sb.append('=');
        sb.append(((this.size == null)?"<null>":this.size));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.itag == null)? 0 :this.itag.hashCode()));
        result = ((result* 31)+((this.container == null)? 0 :this.container.hashCode()));
        result = ((result* 31)+((this.qualityLabel == null)? 0 :this.qualityLabel.hashCode()));
        result = ((result* 31)+((this.size == null)? 0 :this.size.hashCode()));
        result = ((result* 31)+((this.fps == null)? 0 :this.fps.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.encoding == null)? 0 :this.encoding.hashCode()));
        result = ((result* 31)+((this.resolution == null)? 0 :this.resolution.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.quality == null)? 0 :this.quality.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FormatStream) == false) {
            return false;
        }
        FormatStream rhs = ((FormatStream) other);
        return ((((((((((((this.itag == rhs.itag)||((this.itag!= null)&&this.itag.equals(rhs.itag)))&&((this.container == rhs.container)||((this.container!= null)&&this.container.equals(rhs.container))))&&((this.qualityLabel == rhs.qualityLabel)||((this.qualityLabel!= null)&&this.qualityLabel.equals(rhs.qualityLabel))))&&((this.size == rhs.size)||((this.size!= null)&&this.size.equals(rhs.size))))&&((this.fps == rhs.fps)||((this.fps!= null)&&this.fps.equals(rhs.fps))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.encoding == rhs.encoding)||((this.encoding!= null)&&this.encoding.equals(rhs.encoding))))&&((this.resolution == rhs.resolution)||((this.resolution!= null)&&this.resolution.equals(rhs.resolution))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.quality == rhs.quality)||((this.quality!= null)&&this.quality.equals(rhs.quality))));
    }

}
