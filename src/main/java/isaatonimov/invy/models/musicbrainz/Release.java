
package isaatonimov.invy.models.musicbrainz;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "packaging",
    "id",
    "packaging-id",
    "asin",
    "cover-art-archive",
    "status",
    "disambiguation",
    "barcode",
    "release-events",
    "status-id",
    "country",
    "title",
    "date",
    "quality",
    "text-representation"
})
@Generated("jsonschema2pojo")
public class Release {

    @JsonProperty("packaging")
    private String packaging;
    @JsonProperty("id")
    private String id;
    @JsonProperty("packaging-id")
    private String packagingId;
    @JsonProperty("asin")
    private Object asin;
    @JsonProperty("cover-art-archive")
    private CoverArtArchive coverArtArchive;
    @JsonProperty("status")
    private String status;
    @JsonProperty("disambiguation")
    private String disambiguation;
    @JsonProperty("barcode")
    private Object barcode;
    @JsonProperty("release-events")
    private List<ReleaseEvent> releaseEvents = new ArrayList<ReleaseEvent>();
    @JsonProperty("status-id")
    private String statusId;
    @JsonProperty("country")
    private String country;
    @JsonProperty("title")
    private String title;
    @JsonProperty("date")
    private String date;
    @JsonProperty("quality")
    private String quality;
    @JsonProperty("text-representation")
    private TextRepresentation textRepresentation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    private Artist artist;
    private URL coverArtURL;

    @JsonProperty("packaging")
    public String getPackaging() {
        return packaging;
    }

    @JsonProperty("packaging")
    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("packaging-id")
    public String getPackagingId() {
        return packagingId;
    }

    @JsonProperty("packaging-id")
    public void setPackagingId(String packagingId) {
        this.packagingId = packagingId;
    }

    @JsonProperty("asin")
    public Object getAsin() {
        return asin;
    }

    @JsonProperty("asin")
    public void setAsin(Object asin) {
        this.asin = asin;
    }

    @JsonProperty("cover-art-archive")
    public CoverArtArchive getCoverArtArchive() {
        return coverArtArchive;
    }

    @JsonProperty("cover-art-archive")
    public void setCoverArtArchive(CoverArtArchive coverArtArchive) {
        this.coverArtArchive = coverArtArchive;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("disambiguation")
    public String getDisambiguation() {
        return disambiguation;
    }

    @JsonProperty("disambiguation")
    public void setDisambiguation(String disambiguation) {
        this.disambiguation = disambiguation;
    }

    @JsonProperty("barcode")
    public Object getBarcode() {
        return barcode;
    }

    @JsonProperty("barcode")
    public void setBarcode(Object barcode) {
        this.barcode = barcode;
    }

    @JsonProperty("release-events")
    public List<ReleaseEvent> getReleaseEvents() {
        return releaseEvents;
    }

    @JsonProperty("release-events")
    public void setReleaseEvents(List<ReleaseEvent> releaseEvents) {
        this.releaseEvents = releaseEvents;
    }

    @JsonProperty("status-id")
    public String getStatusId() {
        return statusId;
    }

    @JsonProperty("status-id")
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("quality")
    public String getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(String quality) {
        this.quality = quality;
    }

    @JsonProperty("text-representation")
    public TextRepresentation getTextRepresentation() {
        return textRepresentation;
    }

    @JsonProperty("text-representation")
    public void setTextRepresentation(TextRepresentation textRepresentation) {
        this.textRepresentation = textRepresentation;
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
        sb.append(Release.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("packaging");
        sb.append('=');
        sb.append(((this.packaging == null)?"<null>":this.packaging));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("packagingId");
        sb.append('=');
        sb.append(((this.packagingId == null)?"<null>":this.packagingId));
        sb.append(',');
        sb.append("asin");
        sb.append('=');
        sb.append(((this.asin == null)?"<null>":this.asin));
        sb.append(',');
        sb.append("coverArtArchive");
        sb.append('=');
        sb.append(((this.coverArtArchive == null)?"<null>":this.coverArtArchive));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("disambiguation");
        sb.append('=');
        sb.append(((this.disambiguation == null)?"<null>":this.disambiguation));
        sb.append(',');
        sb.append("barcode");
        sb.append('=');
        sb.append(((this.barcode == null)?"<null>":this.barcode));
        sb.append(',');
        sb.append("releaseEvents");
        sb.append('=');
        sb.append(((this.releaseEvents == null)?"<null>":this.releaseEvents));
        sb.append(',');
        sb.append("statusId");
        sb.append('=');
        sb.append(((this.statusId == null)?"<null>":this.statusId));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null)?"<null>":this.country));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("quality");
        sb.append('=');
        sb.append(((this.quality == null)?"<null>":this.quality));
        sb.append(',');
        sb.append("textRepresentation");
        sb.append('=');
        sb.append(((this.textRepresentation == null)?"<null>":this.textRepresentation));
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
        result = ((result* 31)+((this.date == null)? 0 :this.date.hashCode()));
        result = ((result* 31)+((this.country == null)? 0 :this.country.hashCode()));
        result = ((result* 31)+((this.textRepresentation == null)? 0 :this.textRepresentation.hashCode()));
        result = ((result* 31)+((this.packaging == null)? 0 :this.packaging.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.packagingId == null)? 0 :this.packagingId.hashCode()));
        result = ((result* 31)+((this.quality == null)? 0 :this.quality.hashCode()));
        result = ((result* 31)+((this.statusId == null)? 0 :this.statusId.hashCode()));
        result = ((result* 31)+((this.coverArtArchive == null)? 0 :this.coverArtArchive.hashCode()));
        result = ((result* 31)+((this.disambiguation == null)? 0 :this.disambiguation.hashCode()));
        result = ((result* 31)+((this.asin == null)? 0 :this.asin.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.releaseEvents == null)? 0 :this.releaseEvents.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.barcode == null)? 0 :this.barcode.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Release) == false) {
            return false;
        }
        Release rhs = ((Release) other);
        return (((((((((((((((((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.country == rhs.country)||((this.country!= null)&&this.country.equals(rhs.country))))&&((this.textRepresentation == rhs.textRepresentation)||((this.textRepresentation!= null)&&this.textRepresentation.equals(rhs.textRepresentation))))&&((this.packaging == rhs.packaging)||((this.packaging!= null)&&this.packaging.equals(rhs.packaging))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.packagingId == rhs.packagingId)||((this.packagingId!= null)&&this.packagingId.equals(rhs.packagingId))))&&((this.quality == rhs.quality)||((this.quality!= null)&&this.quality.equals(rhs.quality))))&&((this.statusId == rhs.statusId)||((this.statusId!= null)&&this.statusId.equals(rhs.statusId))))&&((this.coverArtArchive == rhs.coverArtArchive)||((this.coverArtArchive!= null)&&this.coverArtArchive.equals(rhs.coverArtArchive))))&&((this.disambiguation == rhs.disambiguation)||((this.disambiguation!= null)&&this.disambiguation.equals(rhs.disambiguation))))&&((this.asin == rhs.asin)||((this.asin!= null)&&this.asin.equals(rhs.asin))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.releaseEvents == rhs.releaseEvents)||((this.releaseEvents!= null)&&this.releaseEvents.equals(rhs.releaseEvents))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.barcode == rhs.barcode)||((this.barcode!= null)&&this.barcode.equals(rhs.barcode))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

    public void setArtist(Artist artist)
    {
        this.artist = artist;
    }

    public Artist getArtist()
    {
        return artist;
    }

    public void setCoverArtURL(URL coverArtURL)
    {
        this.coverArtURL = coverArtURL;
    }

    public URL getCoverArtURL()
    {
        return this.coverArtURL;
    }
}
