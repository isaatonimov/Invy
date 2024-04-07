
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
    "begin",
    "ended",
    "end"
})
@Generated("jsonschema2pojo")
public class LifeSpan__2 {

    @JsonProperty("begin")
    private String begin;
    @JsonProperty("ended")
    private Object ended;
    @JsonProperty("end")
    private String end;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("begin")
    public String getBegin() {
        return begin;
    }

    @JsonProperty("begin")
    public void setBegin(String begin) {
        this.begin = begin;
    }

    @JsonProperty("ended")
    public Object getEnded() {
        return ended;
    }

    @JsonProperty("ended")
    public void setEnded(Object ended) {
        this.ended = ended;
    }

    @JsonProperty("end")
    public String getEnd() {
        return end;
    }

    @JsonProperty("end")
    public void setEnd(String end) {
        this.end = end;
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
        sb.append(LifeSpan__2 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("begin");
        sb.append('=');
        sb.append(((this.begin == null)?"<null>":this.begin));
        sb.append(',');
        sb.append("ended");
        sb.append('=');
        sb.append(((this.ended == null)?"<null>":this.ended));
        sb.append(',');
        sb.append("end");
        sb.append('=');
        sb.append(((this.end == null)?"<null>":this.end));
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
        result = ((result* 31)+((this.ended == null)? 0 :this.ended.hashCode()));
        result = ((result* 31)+((this.end == null)? 0 :this.end.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.begin == null)? 0 :this.begin.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LifeSpan__2) == false) {
            return false;
        }
        LifeSpan__2 rhs = ((LifeSpan__2) other);
        return (((((this.ended == rhs.ended)||((this.ended!= null)&&this.ended.equals(rhs.ended)))&&((this.end == rhs.end)||((this.end!= null)&&this.end.equals(rhs.end))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.begin == rhs.begin)||((this.begin!= null)&&this.begin.equals(rhs.begin))));
    }

}
