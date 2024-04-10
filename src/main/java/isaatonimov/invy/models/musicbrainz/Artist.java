
package isaatonimov.invy.models.musicbrainz;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "type",
    "type-id",
    "score",
    "name",
    "sort-name",
    "country",
    "area",
    "begin-area",
    "disambiguation",
    "life-span",
    "tags",
    "isnis",
    "gender-id",
    "gender",
    "end-area",
    "ipis",
    "aliases"
})
@Generated("jsonschema2pojo")
public class Artist {

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("type-id")
    private String typeId;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sort-name")
    private String sortName;
    @JsonProperty("country")
    private String country;
    @JsonProperty("area")
    private Area area;
    @JsonProperty("begin-area")
    private BeginArea beginArea;
    @JsonProperty("disambiguation")
    private String disambiguation;
    @JsonProperty("life-span")
    private LifeSpan__2 lifeSpan;
    @JsonProperty("tags")
    private List<Tag> tags = new ArrayList<Tag>();
    @JsonProperty("isnis")
    private List<String> isnis = new ArrayList<String>();
    @JsonProperty("gender-id")
    private String genderId;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("end-area")
    private EndArea endArea;
    @JsonProperty("ipis")
    private List<String> ipis = new ArrayList<String>();
    @JsonProperty("aliases")
    private List<Alias> aliases = new ArrayList<Alias>();
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

    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
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

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("area")
    public Area getArea() {
        return area;
    }

    @JsonProperty("area")
    public void setArea(Area area) {
        this.area = area;
    }

    @JsonProperty("begin-area")
    public BeginArea getBeginArea() {
        return beginArea;
    }

    @JsonProperty("begin-area")
    public void setBeginArea(BeginArea beginArea) {
        this.beginArea = beginArea;
    }

    @JsonProperty("disambiguation")
    public String getDisambiguation() {
        return disambiguation;
    }

    @JsonProperty("disambiguation")
    public void setDisambiguation(String disambiguation) {
        this.disambiguation = disambiguation;
    }

    @JsonProperty("life-span")
    public LifeSpan__2 getLifeSpan() {
        return lifeSpan;
    }

    @JsonProperty("life-span")
    public void setLifeSpan(LifeSpan__2 lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    @JsonProperty("tags")
    public List<Tag> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @JsonProperty("isnis")
    public List<String> getIsnis() {
        return isnis;
    }

    @JsonProperty("isnis")
    public void setIsnis(List<String> isnis) {
        this.isnis = isnis;
    }

    @JsonProperty("gender-id")
    public String getGenderId() {
        return genderId;
    }

    @JsonProperty("gender-id")
    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("end-area")
    public EndArea getEndArea() {
        return endArea;
    }

    @JsonProperty("end-area")
    public void setEndArea(EndArea endArea) {
        this.endArea = endArea;
    }

    @JsonProperty("ipis")
    public List<String> getIpis() {
        return ipis;
    }

    @JsonProperty("ipis")
    public void setIpis(List<String> ipis) {
        this.ipis = ipis;
    }

    @JsonProperty("aliases")
    public List<Alias> getAliases() {
        return aliases;
    }

    @JsonProperty("aliases")
    public void setAliases(List<Alias> aliases) {
        this.aliases = aliases;
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
    public String toString()
    {
        String artistString = getName();
        
        if(getDisambiguation() != null)
            artistString += " (" + getDisambiguation() + ")";
        else if (getLifeSpan().getBegin() != null)
            artistString += " (" + getLifeSpan().getBegin().trim() + ")";

        return artistString;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.area == null)? 0 :this.area.hashCode()));
        result = ((result* 31)+((this.ipis == null)? 0 :this.ipis.hashCode()));
        result = ((result* 31)+((this.country == null)? 0 :this.country.hashCode()));
        result = ((result* 31)+((this.endArea == null)? 0 :this.endArea.hashCode()));
        result = ((result* 31)+((this.sortName == null)? 0 :this.sortName.hashCode()));
        result = ((result* 31)+((this.aliases == null)? 0 :this.aliases.hashCode()));
        result = ((result* 31)+((this.gender == null)? 0 :this.gender.hashCode()));
        result = ((result* 31)+((this.genderId == null)? 0 :this.genderId.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        result = ((result* 31)+((this.score == null)? 0 :this.score.hashCode()));
        result = ((result* 31)+((this.beginArea == null)? 0 :this.beginArea.hashCode()));
        result = ((result* 31)+((this.isnis == null)? 0 :this.isnis.hashCode()));
        result = ((result* 31)+((this.lifeSpan == null)? 0 :this.lifeSpan.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.disambiguation == null)? 0 :this.disambiguation.hashCode()));
        result = ((result* 31)+((this.typeId == null)? 0 :this.typeId.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Artist) == false) {
            return false;
        }
        Artist rhs = ((Artist) other);
        return ((((((((((((((((((((this.area == rhs.area)||((this.area!= null)&&this.area.equals(rhs.area)))&&((this.ipis == rhs.ipis)||((this.ipis!= null)&&this.ipis.equals(rhs.ipis))))&&((this.country == rhs.country)||((this.country!= null)&&this.country.equals(rhs.country))))&&((this.endArea == rhs.endArea)||((this.endArea!= null)&&this.endArea.equals(rhs.endArea))))&&((this.sortName == rhs.sortName)||((this.sortName!= null)&&this.sortName.equals(rhs.sortName))))&&((this.aliases == rhs.aliases)||((this.aliases!= null)&&this.aliases.equals(rhs.aliases))))&&((this.gender == rhs.gender)||((this.gender!= null)&&this.gender.equals(rhs.gender))))&&((this.genderId == rhs.genderId)||((this.genderId!= null)&&this.genderId.equals(rhs.genderId))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))))&&((this.score == rhs.score)||((this.score!= null)&&this.score.equals(rhs.score))))&&((this.beginArea == rhs.beginArea)||((this.beginArea!= null)&&this.beginArea.equals(rhs.beginArea))))&&((this.isnis == rhs.isnis)||((this.isnis!= null)&&this.isnis.equals(rhs.isnis))))&&((this.lifeSpan == rhs.lifeSpan)||((this.lifeSpan!= null)&&this.lifeSpan.equals(rhs.lifeSpan))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.disambiguation == rhs.disambiguation)||((this.disambiguation!= null)&&this.disambiguation.equals(rhs.disambiguation))))&&((this.typeId == rhs.typeId)||((this.typeId!= null)&&this.typeId.equals(rhs.typeId))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
