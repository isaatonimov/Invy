
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
public class Release extends MusicMetadata
{
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
    public String toString()
    {
        return getTitle() + " (" + getArtist().getName() + ")";
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
    public boolean equals(Object other)
    {
        if(other instanceof Release != true)
            return false;

        if(this.getArtist().getName().equals(((Release) other).getArtist().getName()))
            return true;
        else
            return false;
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
