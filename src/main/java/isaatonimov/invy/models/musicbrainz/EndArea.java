
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
    "id",
    "type",
    "type-id",
    "name",
    "sort-name",
    "life-span"
})
@Generated("jsonschema2pojo")
public class EndArea {

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("type-id")
    private String typeId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sort-name")
    private String sortName;
    @JsonProperty("life-span")
    private LifeSpan__3 lifeSpan;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("type-id")
    public String getTypeId() {
        return typeId;
    }

    @JsonProperty("type-id")
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("sort-name")
    public String getSortName() {
        return sortName;
    }

    @JsonProperty("sort-name")
    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    @JsonProperty("life-span")
    public LifeSpan__3 getLifeSpan() {
        return lifeSpan;
    }

    @JsonProperty("life-span")
    public void setLifeSpan(LifeSpan__3 lifeSpan) {
        this.lifeSpan = lifeSpan;
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
        sb.append(EndArea.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("typeId");
        sb.append('=');
        sb.append(((this.typeId == null)?"<null>":this.typeId));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("sortName");
        sb.append('=');
        sb.append(((this.sortName == null)?"<null>":this.sortName));
        sb.append(',');
        sb.append("lifeSpan");
        sb.append('=');
        sb.append(((this.lifeSpan == null)?"<null>":this.lifeSpan));
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
        result = ((result* 31)+((this.sortName == null)? 0 :this.sortName.hashCode()));
        result = ((result* 31)+((this.lifeSpan == null)? 0 :this.lifeSpan.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.typeId == null)? 0 :this.typeId.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EndArea) == false) {
            return false;
        }
        EndArea rhs = ((EndArea) other);
        return ((((((((this.sortName == rhs.sortName)||((this.sortName!= null)&&this.sortName.equals(rhs.sortName)))&&((this.lifeSpan == rhs.lifeSpan)||((this.lifeSpan!= null)&&this.lifeSpan.equals(rhs.lifeSpan))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.typeId == rhs.typeId)||((this.typeId!= null)&&this.typeId.equals(rhs.typeId))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))));
    }

}
