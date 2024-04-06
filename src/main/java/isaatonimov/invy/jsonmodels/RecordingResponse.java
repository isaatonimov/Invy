
package isaatonimov.invy.jsonmodels;

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
    "recordings",
    "recording-count",
    "recording-offset"
})
@Generated("jsonschema2pojo")
public class RecordingResponse {

    @JsonProperty("recordings")
    private List<Recording> recordings = new ArrayList<Recording>();
    @JsonProperty("recording-count")
    private Integer recordingCount;
    @JsonProperty("recording-offset")
    private Integer recordingOffset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("recordings")
    public List<Recording> getRecordings() {
        return recordings;
    }

    @JsonProperty("recordings")
    public void setRecordings(List<Recording> recordings) {
        this.recordings = recordings;
    }

    @JsonProperty("recording-count")
    public Integer getRecordingCount() {
        return recordingCount;
    }

    @JsonProperty("recording-count")
    public void setRecordingCount(Integer recordingCount) {
        this.recordingCount = recordingCount;
    }

    @JsonProperty("recording-offset")
    public Integer getRecordingOffset() {
        return recordingOffset;
    }

    @JsonProperty("recording-offset")
    public void setRecordingOffset(Integer recordingOffset) {
        this.recordingOffset = recordingOffset;
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
        sb.append(RecordingResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("recordings");
        sb.append('=');
        sb.append(((this.recordings == null)?"<null>":this.recordings));
        sb.append(',');
        sb.append("recordingCount");
        sb.append('=');
        sb.append(((this.recordingCount == null)?"<null>":this.recordingCount));
        sb.append(',');
        sb.append("recordingOffset");
        sb.append('=');
        sb.append(((this.recordingOffset == null)?"<null>":this.recordingOffset));
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
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.recordingOffset == null)? 0 :this.recordingOffset.hashCode()));
        result = ((result* 31)+((this.recordings == null)? 0 :this.recordings.hashCode()));
        result = ((result* 31)+((this.recordingCount == null)? 0 :this.recordingCount.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RecordingResponse) == false) {
            return false;
        }
        RecordingResponse rhs = ((RecordingResponse) other);
        return (((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.recordingOffset == rhs.recordingOffset)||((this.recordingOffset!= null)&&this.recordingOffset.equals(rhs.recordingOffset))))&&((this.recordings == rhs.recordings)||((this.recordings!= null)&&this.recordings.equals(rhs.recordings))))&&((this.recordingCount == rhs.recordingCount)||((this.recordingCount!= null)&&this.recordingCount.equals(rhs.recordingCount))));
    }

}
