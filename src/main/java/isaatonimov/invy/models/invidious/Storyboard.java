
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
    "templateUrl",
    "width",
    "height",
    "count",
    "interval",
    "storyboardWidth",
    "storyboardHeight",
    "storyboardCount"
})
@Generated("jsonschema2pojo")
public class Storyboard {

    @JsonProperty("url")
    private String url;
    @JsonProperty("templateUrl")
    private String templateUrl;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("interval")
    private Integer interval;
    @JsonProperty("storyboardWidth")
    private Integer storyboardWidth;
    @JsonProperty("storyboardHeight")
    private Integer storyboardHeight;
    @JsonProperty("storyboardCount")
    private Integer storyboardCount;
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

    @JsonProperty("templateUrl")
    public String getTemplateUrl() {
        return templateUrl;
    }

    @JsonProperty("templateUrl")
    public void setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("interval")
    public Integer getInterval() {
        return interval;
    }

    @JsonProperty("interval")
    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    @JsonProperty("storyboardWidth")
    public Integer getStoryboardWidth() {
        return storyboardWidth;
    }

    @JsonProperty("storyboardWidth")
    public void setStoryboardWidth(Integer storyboardWidth) {
        this.storyboardWidth = storyboardWidth;
    }

    @JsonProperty("storyboardHeight")
    public Integer getStoryboardHeight() {
        return storyboardHeight;
    }

    @JsonProperty("storyboardHeight")
    public void setStoryboardHeight(Integer storyboardHeight) {
        this.storyboardHeight = storyboardHeight;
    }

    @JsonProperty("storyboardCount")
    public Integer getStoryboardCount() {
        return storyboardCount;
    }

    @JsonProperty("storyboardCount")
    public void setStoryboardCount(Integer storyboardCount) {
        this.storyboardCount = storyboardCount;
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
        sb.append(Storyboard.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("templateUrl");
        sb.append('=');
        sb.append(((this.templateUrl == null)?"<null>":this.templateUrl));
        sb.append(',');
        sb.append("width");
        sb.append('=');
        sb.append(((this.width == null)?"<null>":this.width));
        sb.append(',');
        sb.append("height");
        sb.append('=');
        sb.append(((this.height == null)?"<null>":this.height));
        sb.append(',');
        sb.append("count");
        sb.append('=');
        sb.append(((this.count == null)?"<null>":this.count));
        sb.append(',');
        sb.append("interval");
        sb.append('=');
        sb.append(((this.interval == null)?"<null>":this.interval));
        sb.append(',');
        sb.append("storyboardWidth");
        sb.append('=');
        sb.append(((this.storyboardWidth == null)?"<null>":this.storyboardWidth));
        sb.append(',');
        sb.append("storyboardHeight");
        sb.append('=');
        sb.append(((this.storyboardHeight == null)?"<null>":this.storyboardHeight));
        sb.append(',');
        sb.append("storyboardCount");
        sb.append('=');
        sb.append(((this.storyboardCount == null)?"<null>":this.storyboardCount));
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
        result = ((result* 31)+((this.storyboardWidth == null)? 0 :this.storyboardWidth.hashCode()));
        result = ((result* 31)+((this.storyboardCount == null)? 0 :this.storyboardCount.hashCode()));
        result = ((result* 31)+((this.width == null)? 0 :this.width.hashCode()));
        result = ((result* 31)+((this.count == null)? 0 :this.count.hashCode()));
        result = ((result* 31)+((this.interval == null)? 0 :this.interval.hashCode()));
        result = ((result* 31)+((this.storyboardHeight == null)? 0 :this.storyboardHeight.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.templateUrl == null)? 0 :this.templateUrl.hashCode()));
        result = ((result* 31)+((this.height == null)? 0 :this.height.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Storyboard) == false) {
            return false;
        }
        Storyboard rhs = ((Storyboard) other);
        return (((((((((((this.storyboardWidth == rhs.storyboardWidth)||((this.storyboardWidth!= null)&&this.storyboardWidth.equals(rhs.storyboardWidth)))&&((this.storyboardCount == rhs.storyboardCount)||((this.storyboardCount!= null)&&this.storyboardCount.equals(rhs.storyboardCount))))&&((this.width == rhs.width)||((this.width!= null)&&this.width.equals(rhs.width))))&&((this.count == rhs.count)||((this.count!= null)&&this.count.equals(rhs.count))))&&((this.interval == rhs.interval)||((this.interval!= null)&&this.interval.equals(rhs.interval))))&&((this.storyboardHeight == rhs.storyboardHeight)||((this.storyboardHeight!= null)&&this.storyboardHeight.equals(rhs.storyboardHeight))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.templateUrl == rhs.templateUrl)||((this.templateUrl!= null)&&this.templateUrl.equals(rhs.templateUrl))))&&((this.height == rhs.height)||((this.height!= null)&&this.height.equals(rhs.height))));
    }

}
