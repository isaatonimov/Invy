
package isaatonimov.invy.models.musicbrainz;

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
    "release-count",
    "release-offset",
    "releases"
})
@Generated("jsonschema2pojo")
public class ReleaseResponse {

    @JsonProperty("release-count")
    private Integer releaseCount;
    @JsonProperty("release-offset")
    private Integer releaseOffset;
    @JsonProperty("releases")
    private List<Release> releases = new ArrayList<Release>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("release-count")
    public Integer getReleaseCount() {
        return releaseCount;
    }

    @JsonProperty("release-count")
    public void setReleaseCount(Integer releaseCount) {
        this.releaseCount = releaseCount;
    }

    @JsonProperty("release-offset")
    public Integer getReleaseOffset() {
        return releaseOffset;
    }

    @JsonProperty("release-offset")
    public void setReleaseOffset(Integer releaseOffset) {
        this.releaseOffset = releaseOffset;
    }

    @JsonProperty("releases")
    public List<Release> getReleases() {
        return releases;
    }

    @JsonProperty("releases")
    public void setReleases(List<Release> releases) {
        this.releases = releases;
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
        sb.append(ReleaseResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("releaseCount");
        sb.append('=');
        sb.append(((this.releaseCount == null)?"<null>":this.releaseCount));
        sb.append(',');
        sb.append("releaseOffset");
        sb.append('=');
        sb.append(((this.releaseOffset == null)?"<null>":this.releaseOffset));
        sb.append(',');
        sb.append("releases");
        sb.append('=');
        sb.append(((this.releases == null)?"<null>":this.releases));
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
        result = ((result* 31)+((this.releaseOffset == null)? 0 :this.releaseOffset.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.releaseCount == null)? 0 :this.releaseCount.hashCode()));
        result = ((result* 31)+((this.releases == null)? 0 :this.releases.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReleaseResponse) == false) {
            return false;
        }
        ReleaseResponse rhs = ((ReleaseResponse) other);
        return (((((this.releaseOffset == rhs.releaseOffset)||((this.releaseOffset!= null)&&this.releaseOffset.equals(rhs.releaseOffset)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.releaseCount == rhs.releaseCount)||((this.releaseCount!= null)&&this.releaseCount.equals(rhs.releaseCount))))&&((this.releases == rhs.releases)||((this.releases!= null)&&this.releases.equals(rhs.releases))));
    }

}
