package isaatonimov.invy.jsonmodels;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sort-name",
    "type-id",
    "name",
    "locale",
    "type",
    "primary",
    "begin-date",
    "end-date"
})
@Generated("jsonschema2pojo")
public class Alias {

    @JsonProperty("sort-name")
    private String sortName;
    @JsonProperty("type-id")
    private String typeId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("locale")
    private Object locale;
    @JsonProperty("type")
    private Object type;
    @JsonProperty("primary")
    private Object primary;
    @JsonProperty("begin-date")
    private Object beginDate;
    @JsonProperty("end-date")
    private Object endDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("sort-name")
    public String getSortName() {
        return sortName;
    }

    @JsonProperty("sort-name")
    public void setSortName(String sortName) {
        this.sortName = sortName;
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

    @JsonProperty("locale")
    public Object getLocale() {
        return locale;
    }

    @JsonProperty("locale")
    public void setLocale(Object locale) {
        this.locale = locale;
    }

    @JsonProperty("type")
    public Object getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Object type) {
        this.type = type;
    }

    @JsonProperty("primary")
    public Object getPrimary() {
        return primary;
    }

    @JsonProperty("primary")
    public void setPrimary(Object primary) {
        this.primary = primary;
    }

    @JsonProperty("begin-date")
    public Object getBeginDate() {
        return beginDate;
    }

    @JsonProperty("begin-date")
    public void setBeginDate(Object beginDate) {
        this.beginDate = beginDate;
    }

    @JsonProperty("end-date")
    public Object getEndDate() {
        return endDate;
    }

    @JsonProperty("end-date")
    public void setEndDate(Object endDate) {
        this.endDate = endDate;
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
        sb.append(Alias.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("sortName");
        sb.append('=');
        sb.append(((this.sortName == null)?"<null>":this.sortName));
        sb.append(',');
        sb.append("typeId");
        sb.append('=');
        sb.append(((this.typeId == null)?"<null>":this.typeId));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("locale");
        sb.append('=');
        sb.append(((this.locale == null)?"<null>":this.locale));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("primary");
        sb.append('=');
        sb.append(((this.primary == null)?"<null>":this.primary));
        sb.append(',');
        sb.append("beginDate");
        sb.append('=');
        sb.append(((this.beginDate == null)?"<null>":this.beginDate));
        sb.append(',');
        sb.append("endDate");
        sb.append('=');
        sb.append(((this.endDate == null)?"<null>":this.endDate));
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
        result = ((result* 31)+((this.beginDate == null)? 0 :this.beginDate.hashCode()));
        result = ((result* 31)+((this.sortName == null)? 0 :this.sortName.hashCode()));
        result = ((result* 31)+((this.endDate == null)? 0 :this.endDate.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.typeId == null)? 0 :this.typeId.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.locale == null)? 0 :this.locale.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.primary == null)? 0 :this.primary.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Alias) == false) {
            return false;
        }
        Alias rhs = ((Alias) other);
        return ((((((((((this.beginDate == rhs.beginDate)||((this.beginDate!= null)&&this.beginDate.equals(rhs.beginDate)))&&((this.sortName == rhs.sortName)||((this.sortName!= null)&&this.sortName.equals(rhs.sortName))))&&((this.endDate == rhs.endDate)||((this.endDate!= null)&&this.endDate.equals(rhs.endDate))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.typeId == rhs.typeId)||((this.typeId!= null)&&this.typeId.equals(rhs.typeId))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.locale == rhs.locale)||((this.locale!= null)&&this.locale.equals(rhs.locale))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.primary == rhs.primary)||((this.primary!= null)&&this.primary.equals(rhs.primary))));
    }

}
