
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
    "count",
    "front",
    "darkened",
    "artwork",
    "back"
})
@Generated("jsonschema2pojo")
public class CoverArtArchive {

    @JsonProperty("count")
    private Integer count;
    @JsonProperty("front")
    private Boolean front;
    @JsonProperty("darkened")
    private Boolean darkened;
    @JsonProperty("artwork")
    private Boolean artwork;
    @JsonProperty("back")
    private Boolean back;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("front")
    public Boolean getFront() {
        return front;
    }

    @JsonProperty("front")
    public void setFront(Boolean front) {
        this.front = front;
    }

    @JsonProperty("darkened")
    public Boolean getDarkened() {
        return darkened;
    }

    @JsonProperty("darkened")
    public void setDarkened(Boolean darkened) {
        this.darkened = darkened;
    }

    @JsonProperty("artwork")
    public Boolean getArtwork() {
        return artwork;
    }

    @JsonProperty("artwork")
    public void setArtwork(Boolean artwork) {
        this.artwork = artwork;
    }

    @JsonProperty("back")
    public Boolean getBack() {
        return back;
    }

    @JsonProperty("back")
    public void setBack(Boolean back) {
        this.back = back;
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
        sb.append(CoverArtArchive.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("count");
        sb.append('=');
        sb.append(((this.count == null)?"<null>":this.count));
        sb.append(',');
        sb.append("front");
        sb.append('=');
        sb.append(((this.front == null)?"<null>":this.front));
        sb.append(',');
        sb.append("darkened");
        sb.append('=');
        sb.append(((this.darkened == null)?"<null>":this.darkened));
        sb.append(',');
        sb.append("artwork");
        sb.append('=');
        sb.append(((this.artwork == null)?"<null>":this.artwork));
        sb.append(',');
        sb.append("back");
        sb.append('=');
        sb.append(((this.back == null)?"<null>":this.back));
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
        result = ((result* 31)+((this.count == null)? 0 :this.count.hashCode()));
        result = ((result* 31)+((this.back == null)? 0 :this.back.hashCode()));
        result = ((result* 31)+((this.front == null)? 0 :this.front.hashCode()));
        result = ((result* 31)+((this.darkened == null)? 0 :this.darkened.hashCode()));
        result = ((result* 31)+((this.artwork == null)? 0 :this.artwork.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CoverArtArchive) == false) {
            return false;
        }
        CoverArtArchive rhs = ((CoverArtArchive) other);
        return (((((((this.count == rhs.count)||((this.count!= null)&&this.count.equals(rhs.count)))&&((this.back == rhs.back)||((this.back!= null)&&this.back.equals(rhs.back))))&&((this.front == rhs.front)||((this.front!= null)&&this.front.equals(rhs.front))))&&((this.darkened == rhs.darkened)||((this.darkened!= null)&&this.darkened.equals(rhs.darkened))))&&((this.artwork == rhs.artwork)||((this.artwork!= null)&&this.artwork.equals(rhs.artwork))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
