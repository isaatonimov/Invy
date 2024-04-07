
package isaatonimov.invy.models.invidious;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "title",
    "videoId",
    "author",
    "authorId",
    "authorUrl",
    "authorVerified",
    "videoThumbnails",
    "description",
    "descriptionHtml",
    "viewCount",
    "viewCountText",
    "published",
    "publishedText",
    "lengthSeconds",
    "liveNow",
    "premium",
    "isUpcoming"
})
@Generated("jsonschema2pojo")
public class SearchResponse {

    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("videoId")
    private String videoId;
    @JsonProperty("author")
    private String author;
    @JsonProperty("authorId")
    private String authorId;
    @JsonProperty("authorUrl")
    private String authorUrl;
    @JsonProperty("authorVerified")
    private Boolean authorVerified;
    @JsonProperty("videoThumbnails")
    private List<VideoThumbnail> videoThumbnails = new ArrayList<VideoThumbnail>();
    @JsonProperty("description")
    private String description;
    @JsonProperty("descriptionHtml")
    private String descriptionHtml;
    @JsonProperty("viewCount")
    private Integer viewCount;
    @JsonProperty("viewCountText")
    private String viewCountText;
    @JsonProperty("published")
    private Integer published;
    @JsonProperty("publishedText")
    private String publishedText;
    @JsonProperty("lengthSeconds")
    private Integer lengthSeconds;
    @JsonProperty("liveNow")
    private Boolean liveNow;
    @JsonProperty("premium")
    private Boolean premium;
    @JsonProperty("isUpcoming")
    private Boolean isUpcoming;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

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

    @JsonProperty("videoId")
    public String getVideoId() {
        return videoId;
    }

    @JsonProperty("videoId")
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("authorId")
    public String getAuthorId() {
        return authorId;
    }

    @JsonProperty("authorId")
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @JsonProperty("authorUrl")
    public String getAuthorUrl() {
        return authorUrl;
    }

    @JsonProperty("authorUrl")
    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    @JsonProperty("authorVerified")
    public Boolean getAuthorVerified() {
        return authorVerified;
    }

    @JsonProperty("authorVerified")
    public void setAuthorVerified(Boolean authorVerified) {
        this.authorVerified = authorVerified;
    }

    @JsonProperty("videoThumbnails")
    public List<VideoThumbnail> getVideoThumbnails() {
        return videoThumbnails;
    }

    @JsonProperty("videoThumbnails")
    public void setVideoThumbnails(List<VideoThumbnail> videoThumbnails) {
        this.videoThumbnails = videoThumbnails;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("descriptionHtml")
    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    @JsonProperty("descriptionHtml")
    public void setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
    }

    @JsonProperty("viewCount")
    public Integer getViewCount() {
        return viewCount;
    }

    @JsonProperty("viewCount")
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @JsonProperty("viewCountText")
    public String getViewCountText() {
        return viewCountText;
    }

    @JsonProperty("viewCountText")
    public void setViewCountText(String viewCountText) {
        this.viewCountText = viewCountText;
    }

    @JsonProperty("published")
    public Integer getPublished() {
        return published;
    }

    @JsonProperty("published")
    public void setPublished(Integer published) {
        this.published = published;
    }

    @JsonProperty("publishedText")
    public String getPublishedText() {
        return publishedText;
    }

    @JsonProperty("publishedText")
    public void setPublishedText(String publishedText) {
        this.publishedText = publishedText;
    }

    @JsonProperty("lengthSeconds")
    public Integer getLengthSeconds() {
        return lengthSeconds;
    }

    @JsonProperty("lengthSeconds")
    public void setLengthSeconds(Integer lengthSeconds) {
        this.lengthSeconds = lengthSeconds;
    }

    @JsonProperty("liveNow")
    public Boolean getLiveNow() {
        return liveNow;
    }

    @JsonProperty("liveNow")
    public void setLiveNow(Boolean liveNow) {
        this.liveNow = liveNow;
    }

    @JsonProperty("premium")
    public Boolean getPremium() {
        return premium;
    }

    @JsonProperty("premium")
    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    @JsonProperty("isUpcoming")
    public Boolean getIsUpcoming() {
        return isUpcoming;
    }

    @JsonProperty("isUpcoming")
    public void setIsUpcoming(Boolean isUpcoming) {
        this.isUpcoming = isUpcoming;
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
        sb.append(SearchResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("videoId");
        sb.append('=');
        sb.append(((this.videoId == null)?"<null>":this.videoId));
        sb.append(',');
        sb.append("author");
        sb.append('=');
        sb.append(((this.author == null)?"<null>":this.author));
        sb.append(',');
        sb.append("authorId");
        sb.append('=');
        sb.append(((this.authorId == null)?"<null>":this.authorId));
        sb.append(',');
        sb.append("authorUrl");
        sb.append('=');
        sb.append(((this.authorUrl == null)?"<null>":this.authorUrl));
        sb.append(',');
        sb.append("authorVerified");
        sb.append('=');
        sb.append(((this.authorVerified == null)?"<null>":this.authorVerified));
        sb.append(',');
        sb.append("videoThumbnails");
        sb.append('=');
        sb.append(((this.videoThumbnails == null)?"<null>":this.videoThumbnails));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("descriptionHtml");
        sb.append('=');
        sb.append(((this.descriptionHtml == null)?"<null>":this.descriptionHtml));
        sb.append(',');
        sb.append("viewCount");
        sb.append('=');
        sb.append(((this.viewCount == null)?"<null>":this.viewCount));
        sb.append(',');
        sb.append("viewCountText");
        sb.append('=');
        sb.append(((this.viewCountText == null)?"<null>":this.viewCountText));
        sb.append(',');
        sb.append("published");
        sb.append('=');
        sb.append(((this.published == null)?"<null>":this.published));
        sb.append(',');
        sb.append("publishedText");
        sb.append('=');
        sb.append(((this.publishedText == null)?"<null>":this.publishedText));
        sb.append(',');
        sb.append("lengthSeconds");
        sb.append('=');
        sb.append(((this.lengthSeconds == null)?"<null>":this.lengthSeconds));
        sb.append(',');
        sb.append("liveNow");
        sb.append('=');
        sb.append(((this.liveNow == null)?"<null>":this.liveNow));
        sb.append(',');
        sb.append("premium");
        sb.append('=');
        sb.append(((this.premium == null)?"<null>":this.premium));
        sb.append(',');
        sb.append("isUpcoming");
        sb.append('=');
        sb.append(((this.isUpcoming == null)?"<null>":this.isUpcoming));
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
        result = ((result* 31)+((this.author == null)? 0 :this.author.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.lengthSeconds == null)? 0 :this.lengthSeconds.hashCode()));
        result = ((result* 31)+((this.videoId == null)? 0 :this.videoId.hashCode()));
        result = ((result* 31)+((this.published == null)? 0 :this.published.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.authorId == null)? 0 :this.authorId.hashCode()));
        result = ((result* 31)+((this.authorVerified == null)? 0 :this.authorVerified.hashCode()));
        result = ((result* 31)+((this.liveNow == null)? 0 :this.liveNow.hashCode()));
        result = ((result* 31)+((this.premium == null)? 0 :this.premium.hashCode()));
        result = ((result* 31)+((this.videoThumbnails == null)? 0 :this.videoThumbnails.hashCode()));
        result = ((result* 31)+((this.viewCountText == null)? 0 :this.viewCountText.hashCode()));
        result = ((result* 31)+((this.publishedText == null)? 0 :this.publishedText.hashCode()));
        result = ((result* 31)+((this.authorUrl == null)? 0 :this.authorUrl.hashCode()));
        result = ((result* 31)+((this.descriptionHtml == null)? 0 :this.descriptionHtml.hashCode()));
        result = ((result* 31)+((this.viewCount == null)? 0 :this.viewCount.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.isUpcoming == null)? 0 :this.isUpcoming.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchResponse) == false) {
            return false;
        }
        SearchResponse rhs = ((SearchResponse) other);
        return ((((((((((((((((((((this.author == rhs.author)||((this.author!= null)&&this.author.equals(rhs.author)))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.lengthSeconds == rhs.lengthSeconds)||((this.lengthSeconds!= null)&&this.lengthSeconds.equals(rhs.lengthSeconds))))&&((this.videoId == rhs.videoId)||((this.videoId!= null)&&this.videoId.equals(rhs.videoId))))&&((this.published == rhs.published)||((this.published!= null)&&this.published.equals(rhs.published))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.authorId == rhs.authorId)||((this.authorId!= null)&&this.authorId.equals(rhs.authorId))))&&((this.authorVerified == rhs.authorVerified)||((this.authorVerified!= null)&&this.authorVerified.equals(rhs.authorVerified))))&&((this.liveNow == rhs.liveNow)||((this.liveNow!= null)&&this.liveNow.equals(rhs.liveNow))))&&((this.premium == rhs.premium)||((this.premium!= null)&&this.premium.equals(rhs.premium))))&&((this.videoThumbnails == rhs.videoThumbnails)||((this.videoThumbnails!= null)&&this.videoThumbnails.equals(rhs.videoThumbnails))))&&((this.viewCountText == rhs.viewCountText)||((this.viewCountText!= null)&&this.viewCountText.equals(rhs.viewCountText))))&&((this.publishedText == rhs.publishedText)||((this.publishedText!= null)&&this.publishedText.equals(rhs.publishedText))))&&((this.authorUrl == rhs.authorUrl)||((this.authorUrl!= null)&&this.authorUrl.equals(rhs.authorUrl))))&&((this.descriptionHtml == rhs.descriptionHtml)||((this.descriptionHtml!= null)&&this.descriptionHtml.equals(rhs.descriptionHtml))))&&((this.viewCount == rhs.viewCount)||((this.viewCount!= null)&&this.viewCount.equals(rhs.viewCount))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.isUpcoming == rhs.isUpcoming)||((this.isUpcoming!= null)&&this.isUpcoming.equals(rhs.isUpcoming))));
    }

}
