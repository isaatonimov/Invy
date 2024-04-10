
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
    "items",
    "nextpage",
    "suggestion",
    "corrected"
})
@Generated("jsonschema2pojo")
public class PipedSearchResponse {

    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();
    @JsonProperty("nextpage")
    private String nextpage;
    @JsonProperty("suggestion")
    private String suggestion;
    @JsonProperty("corrected")
    private Boolean corrected;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @JsonProperty("nextpage")
    public String getNextpage() {
        return nextpage;
    }

    @JsonProperty("nextpage")
    public void setNextpage(String nextpage) {
        this.nextpage = nextpage;
    }

    @JsonProperty("suggestion")
    public String getSuggestion() {
        return suggestion;
    }

    @JsonProperty("suggestion")
    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    @JsonProperty("corrected")
    public Boolean getCorrected() {
        return corrected;
    }

    @JsonProperty("corrected")
    public void setCorrected(Boolean corrected) {
        this.corrected = corrected;
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
        sb.append(PipedSearchResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("items");
        sb.append('=');
        sb.append(((this.items == null)?"<null>":this.items));
        sb.append(',');
        sb.append("nextpage");
        sb.append('=');
        sb.append(((this.nextpage == null)?"<null>":this.nextpage));
        sb.append(',');
        sb.append("suggestion");
        sb.append('=');
        sb.append(((this.suggestion == null)?"<null>":this.suggestion));
        sb.append(',');
        sb.append("corrected");
        sb.append('=');
        sb.append(((this.corrected == null)?"<null>":this.corrected));
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
        result = ((result* 31)+((this.nextpage == null)? 0 :this.nextpage.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.items == null)? 0 :this.items.hashCode()));
        result = ((result* 31)+((this.suggestion == null)? 0 :this.suggestion.hashCode()));
        result = ((result* 31)+((this.corrected == null)? 0 :this.corrected.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PipedSearchResponse) == false) {
            return false;
        }
        PipedSearchResponse rhs = ((PipedSearchResponse) other);
        return ((((((this.nextpage == rhs.nextpage)||((this.nextpage!= null)&&this.nextpage.equals(rhs.nextpage)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.items == rhs.items)||((this.items!= null)&&this.items.equals(rhs.items))))&&((this.suggestion == rhs.suggestion)||((this.suggestion!= null)&&this.suggestion.equals(rhs.suggestion))))&&((this.corrected == rhs.corrected)||((this.corrected!= null)&&this.corrected.equals(rhs.corrected))));
    }

}
