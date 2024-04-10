
package isaatonimov.invy.models.piped;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "urls",
    "frameWidth",
    "frameHeight",
    "totalCount",
    "durationPerFrame",
    "framesPerPageX",
    "framesPerPageY"
})
@Generated("jsonschema2pojo")
public class PreviewFrame {

    @JsonProperty("urls")
    private List<String> urls = new ArrayList<String>();
    @JsonProperty("frameWidth")
    private Integer frameWidth;
    @JsonProperty("frameHeight")
    private Integer frameHeight;
    @JsonProperty("totalCount")
    private Integer totalCount;
    @JsonProperty("durationPerFrame")
    private Integer durationPerFrame;
    @JsonProperty("framesPerPageX")
    private Integer framesPerPageX;
    @JsonProperty("framesPerPageY")
    private Integer framesPerPageY;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("urls")
    public List<String> getUrls() {
        return urls;
    }

    @JsonProperty("urls")
    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @JsonProperty("frameWidth")
    public Integer getFrameWidth() {
        return frameWidth;
    }

    @JsonProperty("frameWidth")
    public void setFrameWidth(Integer frameWidth) {
        this.frameWidth = frameWidth;
    }

    @JsonProperty("frameHeight")
    public Integer getFrameHeight() {
        return frameHeight;
    }

    @JsonProperty("frameHeight")
    public void setFrameHeight(Integer frameHeight) {
        this.frameHeight = frameHeight;
    }

    @JsonProperty("totalCount")
    public Integer getTotalCount() {
        return totalCount;
    }

    @JsonProperty("totalCount")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty("durationPerFrame")
    public Integer getDurationPerFrame() {
        return durationPerFrame;
    }

    @JsonProperty("durationPerFrame")
    public void setDurationPerFrame(Integer durationPerFrame) {
        this.durationPerFrame = durationPerFrame;
    }

    @JsonProperty("framesPerPageX")
    public Integer getFramesPerPageX() {
        return framesPerPageX;
    }

    @JsonProperty("framesPerPageX")
    public void setFramesPerPageX(Integer framesPerPageX) {
        this.framesPerPageX = framesPerPageX;
    }

    @JsonProperty("framesPerPageY")
    public Integer getFramesPerPageY() {
        return framesPerPageY;
    }

    @JsonProperty("framesPerPageY")
    public void setFramesPerPageY(Integer framesPerPageY) {
        this.framesPerPageY = framesPerPageY;
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
        sb.append(PreviewFrame.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("urls");
        sb.append('=');
        sb.append(((this.urls == null)?"<null>":this.urls));
        sb.append(',');
        sb.append("frameWidth");
        sb.append('=');
        sb.append(((this.frameWidth == null)?"<null>":this.frameWidth));
        sb.append(',');
        sb.append("frameHeight");
        sb.append('=');
        sb.append(((this.frameHeight == null)?"<null>":this.frameHeight));
        sb.append(',');
        sb.append("totalCount");
        sb.append('=');
        sb.append(((this.totalCount == null)?"<null>":this.totalCount));
        sb.append(',');
        sb.append("durationPerFrame");
        sb.append('=');
        sb.append(((this.durationPerFrame == null)?"<null>":this.durationPerFrame));
        sb.append(',');
        sb.append("framesPerPageX");
        sb.append('=');
        sb.append(((this.framesPerPageX == null)?"<null>":this.framesPerPageX));
        sb.append(',');
        sb.append("framesPerPageY");
        sb.append('=');
        sb.append(((this.framesPerPageY == null)?"<null>":this.framesPerPageY));
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
        result = ((result* 31)+((this.frameHeight == null)? 0 :this.frameHeight.hashCode()));
        result = ((result* 31)+((this.urls == null)? 0 :this.urls.hashCode()));
        result = ((result* 31)+((this.frameWidth == null)? 0 :this.frameWidth.hashCode()));
        result = ((result* 31)+((this.durationPerFrame == null)? 0 :this.durationPerFrame.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.totalCount == null)? 0 :this.totalCount.hashCode()));
        result = ((result* 31)+((this.framesPerPageY == null)? 0 :this.framesPerPageY.hashCode()));
        result = ((result* 31)+((this.framesPerPageX == null)? 0 :this.framesPerPageX.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PreviewFrame) == false) {
            return false;
        }
        PreviewFrame rhs = ((PreviewFrame) other);
        return (((((((((this.frameHeight == rhs.frameHeight)||((this.frameHeight!= null)&&this.frameHeight.equals(rhs.frameHeight)))&&((this.urls == rhs.urls)||((this.urls!= null)&&this.urls.equals(rhs.urls))))&&((this.frameWidth == rhs.frameWidth)||((this.frameWidth!= null)&&this.frameWidth.equals(rhs.frameWidth))))&&((this.durationPerFrame == rhs.durationPerFrame)||((this.durationPerFrame!= null)&&this.durationPerFrame.equals(rhs.durationPerFrame))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.totalCount == rhs.totalCount)||((this.totalCount!= null)&&this.totalCount.equals(rhs.totalCount))))&&((this.framesPerPageY == rhs.framesPerPageY)||((this.framesPerPageY!= null)&&this.framesPerPageY.equals(rhs.framesPerPageY))))&&((this.framesPerPageX == rhs.framesPerPageX)||((this.framesPerPageX!= null)&&this.framesPerPageX.equals(rhs.framesPerPageX))));
    }

}
