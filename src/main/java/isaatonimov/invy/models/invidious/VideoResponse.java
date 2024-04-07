
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
    "type",
    "title",
    "videoId",
    "videoThumbnails",
    "storyboards",
    "description",
    "descriptionHtml",
    "published",
    "publishedText",
    "keywords",
    "viewCount",
    "likeCount",
    "dislikeCount",
    "paid",
    "premium",
    "isFamilyFriendly",
    "allowedRegions",
    "genre",
    "genreUrl",
    "author",
    "authorId",
    "authorUrl",
    "authorVerified",
    "authorThumbnails",
    "subCountText",
    "lengthSeconds",
    "allowRatings",
    "rating",
    "isListed",
    "liveNow",
    "isUpcoming",
    "dashUrl",
    "adaptiveFormats",
    "formatStreams",
    "captions",
    "recommendedVideos"
})
@Generated("jsonschema2pojo")
public class VideoResponse {

    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("videoId")
    private String videoId;
    @JsonProperty("videoThumbnails")
    private List<VideoThumbnail> videoThumbnails = new ArrayList<VideoThumbnail>();
    @JsonProperty("storyboards")
    private List<Storyboard> storyboards = new ArrayList<Storyboard>();
    @JsonProperty("description")
    private String description;
    @JsonProperty("descriptionHtml")
    private String descriptionHtml;
    @JsonProperty("published")
    private Integer published;
    @JsonProperty("publishedText")
    private String publishedText;
    @JsonProperty("keywords")
    private List<Object> keywords = new ArrayList<Object>();
    @JsonProperty("viewCount")
    private Integer viewCount;
    @JsonProperty("likeCount")
    private Integer likeCount;
    @JsonProperty("dislikeCount")
    private Integer dislikeCount;
    @JsonProperty("paid")
    private Boolean paid;
    @JsonProperty("premium")
    private Boolean premium;
    @JsonProperty("isFamilyFriendly")
    private Boolean isFamilyFriendly;
    @JsonProperty("allowedRegions")
    private List<String> allowedRegions = new ArrayList<String>();
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("genreUrl")
    private String genreUrl;
    @JsonProperty("author")
    private String author;
    @JsonProperty("authorId")
    private String authorId;
    @JsonProperty("authorUrl")
    private String authorUrl;
    @JsonProperty("authorVerified")
    private Boolean authorVerified;
    @JsonProperty("authorThumbnails")
    private List<AuthorThumbnail> authorThumbnails = new ArrayList<AuthorThumbnail>();
    @JsonProperty("subCountText")
    private String subCountText;
    @JsonProperty("lengthSeconds")
    private Integer lengthSeconds;
    @JsonProperty("allowRatings")
    private Boolean allowRatings;
    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("isListed")
    private Boolean isListed;
    @JsonProperty("liveNow")
    private Boolean liveNow;
    @JsonProperty("isUpcoming")
    private Boolean isUpcoming;
    @JsonProperty("dashUrl")
    private String dashUrl;
    @JsonProperty("adaptiveFormats")
    private List<AdaptiveFormat> adaptiveFormats = new ArrayList<AdaptiveFormat>();
    @JsonProperty("formatStreams")
    private List<FormatStream> formatStreams = new ArrayList<FormatStream>();
    @JsonProperty("captions")
    private List<Caption> captions = new ArrayList<Caption>();
    @JsonProperty("recommendedVideos")
    private List<RecommendedVideo> recommendedVideos = new ArrayList<RecommendedVideo>();
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

    @JsonProperty("videoThumbnails")
    public List<VideoThumbnail> getVideoThumbnails() {
        return videoThumbnails;
    }

    @JsonProperty("videoThumbnails")
    public void setVideoThumbnails(List<VideoThumbnail> videoThumbnails) {
        this.videoThumbnails = videoThumbnails;
    }

    @JsonProperty("storyboards")
    public List<Storyboard> getStoryboards() {
        return storyboards;
    }

    @JsonProperty("storyboards")
    public void setStoryboards(List<Storyboard> storyboards) {
        this.storyboards = storyboards;
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

    @JsonProperty("keywords")
    public List<Object> getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(List<Object> keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("viewCount")
    public Integer getViewCount() {
        return viewCount;
    }

    @JsonProperty("viewCount")
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @JsonProperty("likeCount")
    public Integer getLikeCount() {
        return likeCount;
    }

    @JsonProperty("likeCount")
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    @JsonProperty("dislikeCount")
    public Integer getDislikeCount() {
        return dislikeCount;
    }

    @JsonProperty("dislikeCount")
    public void setDislikeCount(Integer dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    @JsonProperty("paid")
    public Boolean getPaid() {
        return paid;
    }

    @JsonProperty("paid")
    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @JsonProperty("premium")
    public Boolean getPremium() {
        return premium;
    }

    @JsonProperty("premium")
    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    @JsonProperty("isFamilyFriendly")
    public Boolean getIsFamilyFriendly() {
        return isFamilyFriendly;
    }

    @JsonProperty("isFamilyFriendly")
    public void setIsFamilyFriendly(Boolean isFamilyFriendly) {
        this.isFamilyFriendly = isFamilyFriendly;
    }

    @JsonProperty("allowedRegions")
    public List<String> getAllowedRegions() {
        return allowedRegions;
    }

    @JsonProperty("allowedRegions")
    public void setAllowedRegions(List<String> allowedRegions) {
        this.allowedRegions = allowedRegions;
    }

    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @JsonProperty("genreUrl")
    public String getGenreUrl() {
        return genreUrl;
    }

    @JsonProperty("genreUrl")
    public void setGenreUrl(String genreUrl) {
        this.genreUrl = genreUrl;
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

    @JsonProperty("authorThumbnails")
    public List<AuthorThumbnail> getAuthorThumbnails() {
        return authorThumbnails;
    }

    @JsonProperty("authorThumbnails")
    public void setAuthorThumbnails(List<AuthorThumbnail> authorThumbnails) {
        this.authorThumbnails = authorThumbnails;
    }

    @JsonProperty("subCountText")
    public String getSubCountText() {
        return subCountText;
    }

    @JsonProperty("subCountText")
    public void setSubCountText(String subCountText) {
        this.subCountText = subCountText;
    }

    @JsonProperty("lengthSeconds")
    public Integer getLengthSeconds() {
        return lengthSeconds;
    }

    @JsonProperty("lengthSeconds")
    public void setLengthSeconds(Integer lengthSeconds) {
        this.lengthSeconds = lengthSeconds;
    }

    @JsonProperty("allowRatings")
    public Boolean getAllowRatings() {
        return allowRatings;
    }

    @JsonProperty("allowRatings")
    public void setAllowRatings(Boolean allowRatings) {
        this.allowRatings = allowRatings;
    }

    @JsonProperty("rating")
    public Integer getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @JsonProperty("isListed")
    public Boolean getIsListed() {
        return isListed;
    }

    @JsonProperty("isListed")
    public void setIsListed(Boolean isListed) {
        this.isListed = isListed;
    }

    @JsonProperty("liveNow")
    public Boolean getLiveNow() {
        return liveNow;
    }

    @JsonProperty("liveNow")
    public void setLiveNow(Boolean liveNow) {
        this.liveNow = liveNow;
    }

    @JsonProperty("isUpcoming")
    public Boolean getIsUpcoming() {
        return isUpcoming;
    }

    @JsonProperty("isUpcoming")
    public void setIsUpcoming(Boolean isUpcoming) {
        this.isUpcoming = isUpcoming;
    }

    @JsonProperty("dashUrl")
    public String getDashUrl() {
        return dashUrl;
    }

    @JsonProperty("dashUrl")
    public void setDashUrl(String dashUrl) {
        this.dashUrl = dashUrl;
    }

    @JsonProperty("adaptiveFormats")
    public List<AdaptiveFormat> getAdaptiveFormats() {
        return adaptiveFormats;
    }

    @JsonProperty("adaptiveFormats")
    public void setAdaptiveFormats(List<AdaptiveFormat> adaptiveFormats) {
        this.adaptiveFormats = adaptiveFormats;
    }

    @JsonProperty("formatStreams")
    public List<FormatStream> getFormatStreams() {
        return formatStreams;
    }

    @JsonProperty("formatStreams")
    public void setFormatStreams(List<FormatStream> formatStreams) {
        this.formatStreams = formatStreams;
    }

    @JsonProperty("captions")
    public List<Caption> getCaptions() {
        return captions;
    }

    @JsonProperty("captions")
    public void setCaptions(List<Caption> captions) {
        this.captions = captions;
    }

    @JsonProperty("recommendedVideos")
    public List<RecommendedVideo> getRecommendedVideos() {
        return recommendedVideos;
    }

    @JsonProperty("recommendedVideos")
    public void setRecommendedVideos(List<RecommendedVideo> recommendedVideos) {
        this.recommendedVideos = recommendedVideos;
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
        sb.append(VideoResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("videoThumbnails");
        sb.append('=');
        sb.append(((this.videoThumbnails == null)?"<null>":this.videoThumbnails));
        sb.append(',');
        sb.append("storyboards");
        sb.append('=');
        sb.append(((this.storyboards == null)?"<null>":this.storyboards));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("descriptionHtml");
        sb.append('=');
        sb.append(((this.descriptionHtml == null)?"<null>":this.descriptionHtml));
        sb.append(',');
        sb.append("published");
        sb.append('=');
        sb.append(((this.published == null)?"<null>":this.published));
        sb.append(',');
        sb.append("publishedText");
        sb.append('=');
        sb.append(((this.publishedText == null)?"<null>":this.publishedText));
        sb.append(',');
        sb.append("keywords");
        sb.append('=');
        sb.append(((this.keywords == null)?"<null>":this.keywords));
        sb.append(',');
        sb.append("viewCount");
        sb.append('=');
        sb.append(((this.viewCount == null)?"<null>":this.viewCount));
        sb.append(',');
        sb.append("likeCount");
        sb.append('=');
        sb.append(((this.likeCount == null)?"<null>":this.likeCount));
        sb.append(',');
        sb.append("dislikeCount");
        sb.append('=');
        sb.append(((this.dislikeCount == null)?"<null>":this.dislikeCount));
        sb.append(',');
        sb.append("paid");
        sb.append('=');
        sb.append(((this.paid == null)?"<null>":this.paid));
        sb.append(',');
        sb.append("premium");
        sb.append('=');
        sb.append(((this.premium == null)?"<null>":this.premium));
        sb.append(',');
        sb.append("isFamilyFriendly");
        sb.append('=');
        sb.append(((this.isFamilyFriendly == null)?"<null>":this.isFamilyFriendly));
        sb.append(',');
        sb.append("allowedRegions");
        sb.append('=');
        sb.append(((this.allowedRegions == null)?"<null>":this.allowedRegions));
        sb.append(',');
        sb.append("genre");
        sb.append('=');
        sb.append(((this.genre == null)?"<null>":this.genre));
        sb.append(',');
        sb.append("genreUrl");
        sb.append('=');
        sb.append(((this.genreUrl == null)?"<null>":this.genreUrl));
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
        sb.append("authorThumbnails");
        sb.append('=');
        sb.append(((this.authorThumbnails == null)?"<null>":this.authorThumbnails));
        sb.append(',');
        sb.append("subCountText");
        sb.append('=');
        sb.append(((this.subCountText == null)?"<null>":this.subCountText));
        sb.append(',');
        sb.append("lengthSeconds");
        sb.append('=');
        sb.append(((this.lengthSeconds == null)?"<null>":this.lengthSeconds));
        sb.append(',');
        sb.append("allowRatings");
        sb.append('=');
        sb.append(((this.allowRatings == null)?"<null>":this.allowRatings));
        sb.append(',');
        sb.append("rating");
        sb.append('=');
        sb.append(((this.rating == null)?"<null>":this.rating));
        sb.append(',');
        sb.append("isListed");
        sb.append('=');
        sb.append(((this.isListed == null)?"<null>":this.isListed));
        sb.append(',');
        sb.append("liveNow");
        sb.append('=');
        sb.append(((this.liveNow == null)?"<null>":this.liveNow));
        sb.append(',');
        sb.append("isUpcoming");
        sb.append('=');
        sb.append(((this.isUpcoming == null)?"<null>":this.isUpcoming));
        sb.append(',');
        sb.append("dashUrl");
        sb.append('=');
        sb.append(((this.dashUrl == null)?"<null>":this.dashUrl));
        sb.append(',');
        sb.append("adaptiveFormats");
        sb.append('=');
        sb.append(((this.adaptiveFormats == null)?"<null>":this.adaptiveFormats));
        sb.append(',');
        sb.append("formatStreams");
        sb.append('=');
        sb.append(((this.formatStreams == null)?"<null>":this.formatStreams));
        sb.append(',');
        sb.append("captions");
        sb.append('=');
        sb.append(((this.captions == null)?"<null>":this.captions));
        sb.append(',');
        sb.append("recommendedVideos");
        sb.append('=');
        sb.append(((this.recommendedVideos == null)?"<null>":this.recommendedVideos));
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
        result = ((result* 31)+((this.authorThumbnails == null)? 0 :this.authorThumbnails.hashCode()));
        result = ((result* 31)+((this.keywords == null)? 0 :this.keywords.hashCode()));
        result = ((result* 31)+((this.isFamilyFriendly == null)? 0 :this.isFamilyFriendly.hashCode()));
        result = ((result* 31)+((this.dashUrl == null)? 0 :this.dashUrl.hashCode()));
        result = ((result* 31)+((this.dislikeCount == null)? 0 :this.dislikeCount.hashCode()));
        result = ((result* 31)+((this.subCountText == null)? 0 :this.subCountText.hashCode()));
        result = ((result* 31)+((this.rating == null)? 0 :this.rating.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.videoId == null)? 0 :this.videoId.hashCode()));
        result = ((result* 31)+((this.likeCount == null)? 0 :this.likeCount.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.storyboards == null)? 0 :this.storyboards.hashCode()));
        result = ((result* 31)+((this.allowedRegions == null)? 0 :this.allowedRegions.hashCode()));
        result = ((result* 31)+((this.captions == null)? 0 :this.captions.hashCode()));
        result = ((result* 31)+((this.premium == null)? 0 :this.premium.hashCode()));
        result = ((result* 31)+((this.authorUrl == null)? 0 :this.authorUrl.hashCode()));
        result = ((result* 31)+((this.genre == null)? 0 :this.genre.hashCode()));
        result = ((result* 31)+((this.allowRatings == null)? 0 :this.allowRatings.hashCode()));
        result = ((result* 31)+((this.viewCount == null)? 0 :this.viewCount.hashCode()));
        result = ((result* 31)+((this.adaptiveFormats == null)? 0 :this.adaptiveFormats.hashCode()));
        result = ((result* 31)+((this.author == null)? 0 :this.author.hashCode()));
        result = ((result* 31)+((this.formatStreams == null)? 0 :this.formatStreams.hashCode()));
        result = ((result* 31)+((this.lengthSeconds == null)? 0 :this.lengthSeconds.hashCode()));
        result = ((result* 31)+((this.published == null)? 0 :this.published.hashCode()));
        result = ((result* 31)+((this.authorId == null)? 0 :this.authorId.hashCode()));
        result = ((result* 31)+((this.authorVerified == null)? 0 :this.authorVerified.hashCode()));
        result = ((result* 31)+((this.liveNow == null)? 0 :this.liveNow.hashCode()));
        result = ((result* 31)+((this.isListed == null)? 0 :this.isListed.hashCode()));
        result = ((result* 31)+((this.videoThumbnails == null)? 0 :this.videoThumbnails.hashCode()));
        result = ((result* 31)+((this.publishedText == null)? 0 :this.publishedText.hashCode()));
        result = ((result* 31)+((this.genreUrl == null)? 0 :this.genreUrl.hashCode()));
        result = ((result* 31)+((this.recommendedVideos == null)? 0 :this.recommendedVideos.hashCode()));
        result = ((result* 31)+((this.paid == null)? 0 :this.paid.hashCode()));
        result = ((result* 31)+((this.descriptionHtml == null)? 0 :this.descriptionHtml.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.isUpcoming == null)? 0 :this.isUpcoming.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VideoResponse) == false) {
            return false;
        }
        VideoResponse rhs = ((VideoResponse) other);
        return ((((((((((((((((((((((((((((((((((((((this.authorThumbnails == rhs.authorThumbnails)||((this.authorThumbnails!= null)&&this.authorThumbnails.equals(rhs.authorThumbnails)))&&((this.keywords == rhs.keywords)||((this.keywords!= null)&&this.keywords.equals(rhs.keywords))))&&((this.isFamilyFriendly == rhs.isFamilyFriendly)||((this.isFamilyFriendly!= null)&&this.isFamilyFriendly.equals(rhs.isFamilyFriendly))))&&((this.dashUrl == rhs.dashUrl)||((this.dashUrl!= null)&&this.dashUrl.equals(rhs.dashUrl))))&&((this.dislikeCount == rhs.dislikeCount)||((this.dislikeCount!= null)&&this.dislikeCount.equals(rhs.dislikeCount))))&&((this.subCountText == rhs.subCountText)||((this.subCountText!= null)&&this.subCountText.equals(rhs.subCountText))))&&((this.rating == rhs.rating)||((this.rating!= null)&&this.rating.equals(rhs.rating))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.videoId == rhs.videoId)||((this.videoId!= null)&&this.videoId.equals(rhs.videoId))))&&((this.likeCount == rhs.likeCount)||((this.likeCount!= null)&&this.likeCount.equals(rhs.likeCount))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.storyboards == rhs.storyboards)||((this.storyboards!= null)&&this.storyboards.equals(rhs.storyboards))))&&((this.allowedRegions == rhs.allowedRegions)||((this.allowedRegions!= null)&&this.allowedRegions.equals(rhs.allowedRegions))))&&((this.captions == rhs.captions)||((this.captions!= null)&&this.captions.equals(rhs.captions))))&&((this.premium == rhs.premium)||((this.premium!= null)&&this.premium.equals(rhs.premium))))&&((this.authorUrl == rhs.authorUrl)||((this.authorUrl!= null)&&this.authorUrl.equals(rhs.authorUrl))))&&((this.genre == rhs.genre)||((this.genre!= null)&&this.genre.equals(rhs.genre))))&&((this.allowRatings == rhs.allowRatings)||((this.allowRatings!= null)&&this.allowRatings.equals(rhs.allowRatings))))&&((this.viewCount == rhs.viewCount)||((this.viewCount!= null)&&this.viewCount.equals(rhs.viewCount))))&&((this.adaptiveFormats == rhs.adaptiveFormats)||((this.adaptiveFormats!= null)&&this.adaptiveFormats.equals(rhs.adaptiveFormats))))&&((this.author == rhs.author)||((this.author!= null)&&this.author.equals(rhs.author))))&&((this.formatStreams == rhs.formatStreams)||((this.formatStreams!= null)&&this.formatStreams.equals(rhs.formatStreams))))&&((this.lengthSeconds == rhs.lengthSeconds)||((this.lengthSeconds!= null)&&this.lengthSeconds.equals(rhs.lengthSeconds))))&&((this.published == rhs.published)||((this.published!= null)&&this.published.equals(rhs.published))))&&((this.authorId == rhs.authorId)||((this.authorId!= null)&&this.authorId.equals(rhs.authorId))))&&((this.authorVerified == rhs.authorVerified)||((this.authorVerified!= null)&&this.authorVerified.equals(rhs.authorVerified))))&&((this.liveNow == rhs.liveNow)||((this.liveNow!= null)&&this.liveNow.equals(rhs.liveNow))))&&((this.isListed == rhs.isListed)||((this.isListed!= null)&&this.isListed.equals(rhs.isListed))))&&((this.videoThumbnails == rhs.videoThumbnails)||((this.videoThumbnails!= null)&&this.videoThumbnails.equals(rhs.videoThumbnails))))&&((this.publishedText == rhs.publishedText)||((this.publishedText!= null)&&this.publishedText.equals(rhs.publishedText))))&&((this.genreUrl == rhs.genreUrl)||((this.genreUrl!= null)&&this.genreUrl.equals(rhs.genreUrl))))&&((this.recommendedVideos == rhs.recommendedVideos)||((this.recommendedVideos!= null)&&this.recommendedVideos.equals(rhs.recommendedVideos))))&&((this.paid == rhs.paid)||((this.paid!= null)&&this.paid.equals(rhs.paid))))&&((this.descriptionHtml == rhs.descriptionHtml)||((this.descriptionHtml!= null)&&this.descriptionHtml.equals(rhs.descriptionHtml))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.isUpcoming == rhs.isUpcoming)||((this.isUpcoming!= null)&&this.isUpcoming.equals(rhs.isUpcoming))));
    }

}
