
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
    "primaries",
    "transferCharacteristics",
    "matrixCoefficients"
})
@Generated("jsonschema2pojo")
public class ColorInfo {

    @JsonProperty("primaries")
    private String primaries;
    @JsonProperty("transferCharacteristics")
    private String transferCharacteristics;
    @JsonProperty("matrixCoefficients")
    private String matrixCoefficients;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("primaries")
    public String getPrimaries() {
        return primaries;
    }

    @JsonProperty("primaries")
    public void setPrimaries(String primaries) {
        this.primaries = primaries;
    }

    @JsonProperty("transferCharacteristics")
    public String getTransferCharacteristics() {
        return transferCharacteristics;
    }

    @JsonProperty("transferCharacteristics")
    public void setTransferCharacteristics(String transferCharacteristics) {
        this.transferCharacteristics = transferCharacteristics;
    }

    @JsonProperty("matrixCoefficients")
    public String getMatrixCoefficients() {
        return matrixCoefficients;
    }

    @JsonProperty("matrixCoefficients")
    public void setMatrixCoefficients(String matrixCoefficients) {
        this.matrixCoefficients = matrixCoefficients;
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
        sb.append(ColorInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("primaries");
        sb.append('=');
        sb.append(((this.primaries == null)?"<null>":this.primaries));
        sb.append(',');
        sb.append("transferCharacteristics");
        sb.append('=');
        sb.append(((this.transferCharacteristics == null)?"<null>":this.transferCharacteristics));
        sb.append(',');
        sb.append("matrixCoefficients");
        sb.append('=');
        sb.append(((this.matrixCoefficients == null)?"<null>":this.matrixCoefficients));
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
        result = ((result* 31)+((this.primaries == null)? 0 :this.primaries.hashCode()));
        result = ((result* 31)+((this.matrixCoefficients == null)? 0 :this.matrixCoefficients.hashCode()));
        result = ((result* 31)+((this.transferCharacteristics == null)? 0 :this.transferCharacteristics.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ColorInfo) == false) {
            return false;
        }
        ColorInfo rhs = ((ColorInfo) other);
        return (((((this.primaries == rhs.primaries)||((this.primaries!= null)&&this.primaries.equals(rhs.primaries)))&&((this.matrixCoefficients == rhs.matrixCoefficients)||((this.matrixCoefficients!= null)&&this.matrixCoefficients.equals(rhs.matrixCoefficients))))&&((this.transferCharacteristics == rhs.transferCharacteristics)||((this.transferCharacteristics!= null)&&this.transferCharacteristics.equals(rhs.transferCharacteristics))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
