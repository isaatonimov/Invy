
package isaatonimov.invy.models.piped;

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
    "url",
    "type",
    "title",
    "thumbnail",
    "uploaderName",
    "uploaderUrl",
    "uploaderAvatar",
    "uploadedDate",
    "shortDescription",
    "duration",
    "views",
    "uploaded",
    "uploaderVerified",
    "isShort",
    "name",
    "playlistType",
    "videos"
})
@Generated("jsonschema2pojo")
public class RelatedStream {

    @JsonProperty("url")
    private String url;
    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonProperty("uploaderName")
    private String uploaderName;
    @JsonProperty("uploaderUrl")
    private String uploaderUrl;
    @JsonProperty("uploaderAvatar")
    private String uploaderAvatar;
    @JsonProperty("uploadedDate")
    private String uploadedDate;
    @JsonProperty("shortDescription")
    private Object shortDescription;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("views")
    private Integer views;
    @JsonProperty("uploaded")
    private Long uploaded;
    @JsonProperty("uploaderVerified")
    private Boolean uploaderVerified;
    @JsonProperty("isShort")
    private Boolean isShort;
    @JsonProperty("name")
    private String name;
    @JsonProperty("playlistType")
    private String playlistType;
    @JsonProperty("videos")
    private Integer videos;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("uploaderName")
    public String getUploaderName() {
        return uploaderName;
    }

    @JsonProperty("uploaderName")
    public void setUploaderName(String uploaderName) {
        this.uploaderName = uploaderName;
    }

    @JsonProperty("uploaderUrl")
    public String getUploaderUrl() {
        return uploaderUrl;
    }

    @JsonProperty("uploaderUrl")
    public void setUploaderUrl(String uploaderUrl) {
        this.uploaderUrl = uploaderUrl;
    }

    @JsonProperty("uploaderAvatar")
    public String getUploaderAvatar() {
        return uploaderAvatar;
    }

    @JsonProperty("uploaderAvatar")
    public void setUploaderAvatar(String uploaderAvatar) {
        this.uploaderAvatar = uploaderAvatar;
    }

    @JsonProperty("uploadedDate")
    public String getUploadedDate() {
        return uploadedDate;
    }

    @JsonProperty("uploadedDate")
    public void setUploadedDate(String uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    @JsonProperty("shortDescription")
    public Object getShortDescription() {
        return shortDescription;
    }

    @JsonProperty("shortDescription")
    public void setShortDescription(Object shortDescription) {
        this.shortDescription = shortDescription;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("views")
    public Integer getViews() {
        return views;
    }

    @JsonProperty("views")
    public void setViews(Integer views) {
        this.views = views;
    }

    @JsonProperty("uploaded")
    public Long getUploaded() {
        return uploaded;
    }

    @JsonProperty("uploaded")
    public void setUploaded(Long uploaded) {
        this.uploaded = uploaded;
    }

    @JsonProperty("uploaderVerified")
    public Boolean getUploaderVerified() {
        return uploaderVerified;
    }

    @JsonProperty("uploaderVerified")
    public void setUploaderVerified(Boolean uploaderVerified) {
        this.uploaderVerified = uploaderVerified;
    }

    @JsonProperty("isShort")
    public Boolean getIsShort() {
        return isShort;
    }

    @JsonProperty("isShort")
    public void setIsShort(Boolean isShort) {
        this.isShort = isShort;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("playlistType")
    public String getPlaylistType() {
        return playlistType;
    }

    @JsonProperty("playlistType")
    public void setPlaylistType(String playlistType) {
        this.playlistType = playlistType;
    }

    @JsonProperty("videos")
    public Integer getVideos() {
        return videos;
    }

    @JsonProperty("videos")
    public void setVideos(Integer videos) {
        this.videos = videos;
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
        sb.append(RelatedStream.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("thumbnail");
        sb.append('=');
        sb.append(((this.thumbnail == null)?"<null>":this.thumbnail));
        sb.append(',');
        sb.append("uploaderName");
        sb.append('=');
        sb.append(((this.uploaderName == null)?"<null>":this.uploaderName));
        sb.append(',');
        sb.append("uploaderUrl");
        sb.append('=');
        sb.append(((this.uploaderUrl == null)?"<null>":this.uploaderUrl));
        sb.append(',');
        sb.append("uploaderAvatar");
        sb.append('=');
        sb.append(((this.uploaderAvatar == null)?"<null>":this.uploaderAvatar));
        sb.append(',');
        sb.append("uploadedDate");
        sb.append('=');
        sb.append(((this.uploadedDate == null)?"<null>":this.uploadedDate));
        sb.append(',');
        sb.append("shortDescription");
        sb.append('=');
        sb.append(((this.shortDescription == null)?"<null>":this.shortDescription));
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(((this.duration == null)?"<null>":this.duration));
        sb.append(',');
        sb.append("views");
        sb.append('=');
        sb.append(((this.views == null)?"<null>":this.views));
        sb.append(',');
        sb.append("uploaded");
        sb.append('=');
        sb.append(((this.uploaded == null)?"<null>":this.uploaded));
        sb.append(',');
        sb.append("uploaderVerified");
        sb.append('=');
        sb.append(((this.uploaderVerified == null)?"<null>":this.uploaderVerified));
        sb.append(',');
        sb.append("isShort");
        sb.append('=');
        sb.append(((this.isShort == null)?"<null>":this.isShort));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("playlistType");
        sb.append('=');
        sb.append(((this.playlistType == null)?"<null>":this.playlistType));
        sb.append(',');
        sb.append("videos");
        sb.append('=');
        sb.append(((this.videos == null)?"<null>":this.videos));
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
        result = ((result* 31)+((this.thumbnail == null)? 0 :this.thumbnail.hashCode()));
        result = ((result* 31)+((this.uploaderAvatar == null)? 0 :this.uploaderAvatar.hashCode()));
        result = ((result* 31)+((this.uploaderVerified == null)? 0 :this.uploaderVerified.hashCode()));
        result = ((result* 31)+((this.videos == null)? 0 :this.videos.hashCode()));
        result = ((result* 31)+((this.shortDescription == null)? 0 :this.shortDescription.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.uploaderUrl == null)? 0 :this.uploaderUrl.hashCode()));
        result = ((result* 31)+((this.uploadedDate == null)? 0 :this.uploadedDate.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.duration == null)? 0 :this.duration.hashCode()));
        result = ((result* 31)+((this.uploaderName == null)? 0 :this.uploaderName.hashCode()));
        result = ((result* 31)+((this.uploaded == null)? 0 :this.uploaded.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.playlistType == null)? 0 :this.playlistType.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.isShort == null)? 0 :this.isShort.hashCode()));
        result = ((result* 31)+((this.views == null)? 0 :this.views.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RelatedStream) == false) {
            return false;
        }
        RelatedStream rhs = ((RelatedStream) other);
        return (((((((((((((((((((this.thumbnail == rhs.thumbnail)||((this.thumbnail!= null)&&this.thumbnail.equals(rhs.thumbnail)))&&((this.uploaderAvatar == rhs.uploaderAvatar)||((this.uploaderAvatar!= null)&&this.uploaderAvatar.equals(rhs.uploaderAvatar))))&&((this.uploaderVerified == rhs.uploaderVerified)||((this.uploaderVerified!= null)&&this.uploaderVerified.equals(rhs.uploaderVerified))))&&((this.videos == rhs.videos)||((this.videos!= null)&&this.videos.equals(rhs.videos))))&&((this.shortDescription == rhs.shortDescription)||((this.shortDescription!= null)&&this.shortDescription.equals(rhs.shortDescription))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.uploaderUrl == rhs.uploaderUrl)||((this.uploaderUrl!= null)&&this.uploaderUrl.equals(rhs.uploaderUrl))))&&((this.uploadedDate == rhs.uploadedDate)||((this.uploadedDate!= null)&&this.uploadedDate.equals(rhs.uploadedDate))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.duration == rhs.duration)||((this.duration!= null)&&this.duration.equals(rhs.duration))))&&((this.uploaderName == rhs.uploaderName)||((this.uploaderName!= null)&&this.uploaderName.equals(rhs.uploaderName))))&&((this.uploaded == rhs.uploaded)||((this.uploaded!= null)&&this.uploaded.equals(rhs.uploaded))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.playlistType == rhs.playlistType)||((this.playlistType!= null)&&this.playlistType.equals(rhs.playlistType))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.isShort == rhs.isShort)||((this.isShort!= null)&&this.isShort.equals(rhs.isShort))))&&((this.views == rhs.views)||((this.views!= null)&&this.views.equals(rhs.views))));
    }

}
