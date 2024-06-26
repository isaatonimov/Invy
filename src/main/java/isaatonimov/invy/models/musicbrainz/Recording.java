
package isaatonimov.invy.models.musicbrainz;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "first-release-date",
    "id",
    "length",
    "title",
    "video",
    "disambiguation"
})
@Generated("jsonschema2pojo")
public class Recording extends MusicMetadata
{
    //public SimpleObjectProperty<Artist> ArtistProperty  = new SimpleObjectProperty<>();
    //public SimpleObjectProperty<Release> ReleaseProperty        = new SimpleObjectProperty<>();
    //public SimpleStringProperty TitleProperty                 = new SimpleStringProperty();
    private Artist artist;
    @JsonProperty("first-release-date")
    private String firstReleaseDate;
    @JsonProperty("id")
    private String id;
    @JsonProperty("length")
    private Object length;
    @JsonProperty("title")
    private String title;
    @JsonProperty("video")
    private Boolean video;
    @JsonProperty("disambiguation")
    private String disambiguation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    private Release release;

    public Artist getArtist()
    {
        //return this.ArtistProperty.get();
        return artist;
    }

    public void setArtist(Artist artist)
    {
        //this.ArtistProperty.set(artist);
        this.artist = artist;
    }
    @JsonProperty("first-release-date")
    public String getFirstReleaseDate() {
        return firstReleaseDate;
    }

    @JsonProperty("first-release-date")
    public void setFirstReleaseDate(String firstReleaseDate) {
        this.firstReleaseDate = firstReleaseDate;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("length")
    public Object getLength() {
        return length;
    }

    @JsonProperty("length")
    public void setLength(Object length) {
        this.length = length;
    }

    @JsonProperty("title")
    public String getTitle() {
        //return TitleProperty.get();
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        //this.TitleProperty.set(title);
        this.title = title;
    }

    @JsonProperty("video")
    public Boolean getVideo() {
        return video;
    }

    @JsonProperty("video")
    public void setVideo(Boolean video) {
        this.video = video;
    }

    @JsonProperty("disambiguation")
    public String getDisambiguation() {
        return disambiguation;
    }

    @JsonProperty("disambiguation")
    public void setDisambiguation(String disambiguation) {
        this.disambiguation = disambiguation;
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

        return getTitle() + " (" + getArtist().getName() + ")";
    }

    @Override
    public boolean equals(Object other)
    {
        if(other instanceof Recording && ((Recording)other).getTitle().contains(this.getTitle()))
            return true;
        else
            return false;
    }

    public String toSearchTerm()
    {
        String searchTerm = this.getArtist().getName() + " band "+ " song " + this.getTitle();
        System.out.println("Search Term used: " + searchTerm);
        return searchTerm;
    }

    public void setRelease(Release release)
    {
        this.release = release;
    }

    public Release getRelease()
    {
        return release;
    }
}
