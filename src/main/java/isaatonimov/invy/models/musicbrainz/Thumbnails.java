
package isaatonimov.invy.models.musicbrainz;

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
    "1200",
    "250",
    "500",
    "large",
    "small"
})
@Generated("jsonschema2pojo")
public class Thumbnails {

    @JsonProperty("1200")
    private String _1200;
    @JsonProperty("250")
    private String _250;
    @JsonProperty("500")
    private String _500;
    @JsonProperty("large")
    private String large;
    @JsonProperty("small")
    private String small;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("1200")
    public String get1200() {
        return _1200;
    }

    @JsonProperty("1200")
    public void set1200(String _1200) {
        this._1200 = _1200;
    }

    @JsonProperty("250")
    public String get250() {
        return _250;
    }

    @JsonProperty("250")
    public void set250(String _250) {
        this._250 = _250;
    }

    @JsonProperty("500")
    public String get500() {
        return _500;
    }

    @JsonProperty("500")
    public void set500(String _500) {
        this._500 = _500;
    }

    @JsonProperty("large")
    public String getLarge() {
        return large;
    }

    @JsonProperty("large")
    public void setLarge(String large) {
        this.large = large;
    }

    @JsonProperty("small")
    public String getSmall() {
        return small;
    }

    @JsonProperty("small")
    public void setSmall(String small) {
        this.small = small;
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
        sb.append(Thumbnails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("_1200");
        sb.append('=');
        sb.append(((this._1200 == null)?"<null>":this._1200));
        sb.append(',');
        sb.append("_250");
        sb.append('=');
        sb.append(((this._250 == null)?"<null>":this._250));
        sb.append(',');
        sb.append("_500");
        sb.append('=');
        sb.append(((this._500 == null)?"<null>":this._500));
        sb.append(',');
        sb.append("large");
        sb.append('=');
        sb.append(((this.large == null)?"<null>":this.large));
        sb.append(',');
        sb.append("small");
        sb.append('=');
        sb.append(((this.small == null)?"<null>":this.small));
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
        result = ((result* 31)+((this.small == null)? 0 :this.small.hashCode()));
        result = ((result* 31)+((this._1200 == null)? 0 :this._1200 .hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.large == null)? 0 :this.large.hashCode()));
        result = ((result* 31)+((this._250 == null)? 0 :this._250 .hashCode()));
        result = ((result* 31)+((this._500 == null)? 0 :this._500 .hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Thumbnails) == false) {
            return false;
        }
        Thumbnails rhs = ((Thumbnails) other);
        return (((((((this.small == rhs.small)||((this.small!= null)&&this.small.equals(rhs.small)))&&((this._1200 == rhs._1200)||((this._1200 != null)&&this._1200 .equals(rhs._1200))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.large == rhs.large)||((this.large!= null)&&this.large.equals(rhs.large))))&&((this._250 == rhs._250)||((this._250 != null)&&this._250 .equals(rhs._250))))&&((this._500 == rhs._500)||((this._500 != null)&&this._500 .equals(rhs._500))));
    }

}
