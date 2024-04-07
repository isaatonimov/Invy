
package isaatonimov.invy.models.invidious;

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
    "videoId",
    "title",
    "videoThumbnails",
    "author",
    "authorUrl",
    "authorId",
    "lengthSeconds",
    "viewCountText",
    "viewCount"
})
@Generated("jsonschema2pojo")
public class RecommendedVideo {

    @JsonProperty("videoId")
    private String videoId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("videoThumbnails")
    private List<VideoThumbnail__1> videoThumbnails = new ArrayList<VideoThumbnail__1>();
    @JsonProperty("author")
    private String author;
    @JsonProperty("authorUrl")
    private String authorUrl;
    @JsonProperty("authorId")
    private String authorId;
    @JsonProperty("lengthSeconds")
    private Integer lengthSeconds;
    @JsonProperty("viewCountText")
    private String viewCountText;
    @JsonProperty("viewCount")
    private Integer viewCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("videoId")
    public String getVideoId() {
        return videoId;
    }

    @JsonProperty("videoId")
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("videoThumbnails")
    public List<VideoThumbnail__1> getVideoThumbnails() {
        return videoThumbnails;
    }

    @JsonProperty("videoThumbnails")
    public void setVideoThumbnails(List<VideoThumbnail__1> videoThumbnails) {
        this.videoThumbnails = videoThumbnails;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("authorUrl")
    public String getAuthorUrl() {
        return authorUrl;
    }

    @JsonProperty("authorUrl")
    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    @JsonProperty("authorId")
    public String getAuthorId() {
        return authorId;
    }

    @JsonProperty("authorId")
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @JsonProperty("lengthSeconds")
    public Integer getLengthSeconds() {
        return lengthSeconds;
    }

    @JsonProperty("lengthSeconds")
    public void setLengthSeconds(Integer lengthSeconds) {
        this.lengthSeconds = lengthSeconds;
    }

    @JsonProperty("viewCountText")
    public String getViewCountText() {
        return viewCountText;
    }

    @JsonProperty("viewCountText")
    public void setViewCountText(String viewCountText) {
        this.viewCountText = viewCountText;
    }

    @JsonProperty("viewCount")
    public Integer getViewCount() {
        return viewCount;
    }

    @JsonProperty("viewCount")
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
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
        sb.append(RecommendedVideo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("videoId");
        sb.append('=');
        sb.append(((this.videoId == null)?"<null>":this.videoId));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("videoThumbnails");
        sb.append('=');
        sb.append(((this.videoThumbnails == null)?"<null>":this.videoThumbnails));
        sb.append(',');
        sb.append("author");
        sb.append('=');
        sb.append(((this.author == null)?"<null>":this.author));
        sb.append(',');
        sb.append("authorUrl");
        sb.append('=');
        sb.append(((this.authorUrl == null)?"<null>":this.authorUrl));
        sb.append(',');
        sb.append("authorId");
        sb.append('=');
        sb.append(((this.authorId == null)?"<null>":this.authorId));
        sb.append(',');
        sb.append("lengthSeconds");
        sb.append('=');
        sb.append(((this.lengthSeconds == null)?"<null>":this.lengthSeconds));
        sb.append(',');
        sb.append("viewCountText");
        sb.append('=');
        sb.append(((this.viewCountText == null)?"<null>":this.viewCountText));
        sb.append(',');
        sb.append("viewCount");
        sb.append('=');
        sb.append(((this.viewCount == null)?"<null>":this.viewCount));
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
        result = ((result* 31)+((this.videoThumbnails == null)? 0 :this.videoThumbnails.hashCode()));
        result = ((result* 31)+((this.viewCountText == null)? 0 :this.viewCountText.hashCode()));
        result = ((result* 31)+((this.author == null)? 0 :this.author.hashCode()));
        result = ((result* 31)+((this.authorUrl == null)? 0 :this.authorUrl.hashCode()));
        result = ((result* 31)+((this.lengthSeconds == null)? 0 :this.lengthSeconds.hashCode()));
        result = ((result* 31)+((this.videoId == null)? 0 :this.videoId.hashCode()));
        result = ((result* 31)+((this.viewCount == null)? 0 :this.viewCount.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.authorId == null)? 0 :this.authorId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RecommendedVideo) == false) {
            return false;
        }
        RecommendedVideo rhs = ((RecommendedVideo) other);
        return (((((((((((this.videoThumbnails == rhs.videoThumbnails)||((this.videoThumbnails!= null)&&this.videoThumbnails.equals(rhs.videoThumbnails)))&&((this.viewCountText == rhs.viewCountText)||((this.viewCountText!= null)&&this.viewCountText.equals(rhs.viewCountText))))&&((this.author == rhs.author)||((this.author!= null)&&this.author.equals(rhs.author))))&&((this.authorUrl == rhs.authorUrl)||((this.authorUrl!= null)&&this.authorUrl.equals(rhs.authorUrl))))&&((this.lengthSeconds == rhs.lengthSeconds)||((this.lengthSeconds!= null)&&this.lengthSeconds.equals(rhs.lengthSeconds))))&&((this.videoId == rhs.videoId)||((this.videoId!= null)&&this.videoId.equals(rhs.videoId))))&&((this.viewCount == rhs.viewCount)||((this.viewCount!= null)&&this.viewCount.equals(rhs.viewCount))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.authorId == rhs.authorId)||((this.authorId!= null)&&this.authorId.equals(rhs.authorId))));
    }

}
