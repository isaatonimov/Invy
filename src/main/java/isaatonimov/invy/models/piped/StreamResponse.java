
package isaatonimov.invy.models.piped;

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
    "title",
    "description",
    "uploadDate",
    "uploader",
    "uploaderUrl",
    "uploaderAvatar",
    "thumbnailUrl",
    "hls",
    "dash",
    "lbryId",
    "category",
    "license",
    "visibility",
    "tags",
    "metaInfo",
    "uploaderVerified",
    "duration", "isaatonimov/invy/views",
    "likes",
    "dislikes",
    "uploaderSubscriberCount",
    "audioStreams",
    "videoStreams",
    "relatedStreams",
    "subtitles",
    "livestream",
    "proxyUrl",
    "chapters",
    "previewFrames"
})
@Generated("jsonschema2pojo")
public class StreamResponse {

    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("uploadDate")
    private String uploadDate;
    @JsonProperty("uploader")
    private String uploader;
    @JsonProperty("uploaderUrl")
    private String uploaderUrl;
    @JsonProperty("uploaderAvatar")
    private String uploaderAvatar;
    @JsonProperty("thumbnailUrl")
    private String thumbnailUrl;
    @JsonProperty("hls")
    private String hls;
    @JsonProperty("dash")
    private Object dash;
    @JsonProperty("lbryId")
    private Object lbryId;
    @JsonProperty("category")
    private String category;
    @JsonProperty("license")
    private String license;
    @JsonProperty("visibility")
    private String visibility;
    @JsonProperty("tags")
    private List<Object> tags = new ArrayList<Object>();
    @JsonProperty("metaInfo")
    private List<Object> metaInfo = new ArrayList<Object>();
    @JsonProperty("uploaderVerified")
    private Boolean uploaderVerified;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("isaatonimov/invy/views")
    private Integer views;
    @JsonProperty("likes")
    private Integer likes;
    @JsonProperty("dislikes")
    private Integer dislikes;
    @JsonProperty("uploaderSubscriberCount")
    private Integer uploaderSubscriberCount;
    @JsonProperty("audioStreams")
    private List<AudioStream> audioStreams = new ArrayList<AudioStream>();
    @JsonProperty("videoStreams")
    private List<VideoStream> videoStreams = new ArrayList<VideoStream>();
    @JsonProperty("relatedStreams")
    private List<RelatedStream> relatedStreams = new ArrayList<RelatedStream>();
    @JsonProperty("subtitles")
    private List<Subtitle> subtitles = new ArrayList<Subtitle>();
    @JsonProperty("livestream")
    private Boolean livestream;
    @JsonProperty("proxyUrl")
    private String proxyUrl;
    @JsonProperty("chapters")
    private List<Object> chapters = new ArrayList<Object>();
    @JsonProperty("previewFrames")
    private List<PreviewFrame> previewFrames = new ArrayList<PreviewFrame>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("uploadDate")
    public String getUploadDate() {
        return uploadDate;
    }

    @JsonProperty("uploadDate")
    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    @JsonProperty("uploader")
    public String getUploader() {
        return uploader;
    }

    @JsonProperty("uploader")
    public void setUploader(String uploader) {
        this.uploader = uploader;
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

    @JsonProperty("thumbnailUrl")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @JsonProperty("thumbnailUrl")
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @JsonProperty("hls")
    public String getHls() {
        return hls;
    }

    @JsonProperty("hls")
    public void setHls(String hls) {
        this.hls = hls;
    }

    @JsonProperty("dash")
    public Object getDash() {
        return dash;
    }

    @JsonProperty("dash")
    public void setDash(Object dash) {
        this.dash = dash;
    }

    @JsonProperty("lbryId")
    public Object getLbryId() {
        return lbryId;
    }

    @JsonProperty("lbryId")
    public void setLbryId(Object lbryId) {
        this.lbryId = lbryId;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("license")
    public String getLicense() {
        return license;
    }

    @JsonProperty("license")
    public void setLicense(String license) {
        this.license = license;
    }

    @JsonProperty("visibility")
    public String getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonProperty("metaInfo")
    public List<Object> getMetaInfo() {
        return metaInfo;
    }

    @JsonProperty("metaInfo")
    public void setMetaInfo(List<Object> metaInfo) {
        this.metaInfo = metaInfo;
    }

    @JsonProperty("uploaderVerified")
    public Boolean getUploaderVerified() {
        return uploaderVerified;
    }

    @JsonProperty("uploaderVerified")
    public void setUploaderVerified(Boolean uploaderVerified) {
        this.uploaderVerified = uploaderVerified;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("isaatonimov/invy/views")
    public Integer getViews() {
        return views;
    }

    @JsonProperty("isaatonimov/invy/views")
    public void setViews(Integer views) {
        this.views = views;
    }

    @JsonProperty("likes")
    public Integer getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @JsonProperty("dislikes")
    public Integer getDislikes() {
        return dislikes;
    }

    @JsonProperty("dislikes")
    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    @JsonProperty("uploaderSubscriberCount")
    public Integer getUploaderSubscriberCount() {
        return uploaderSubscriberCount;
    }

    @JsonProperty("uploaderSubscriberCount")
    public void setUploaderSubscriberCount(Integer uploaderSubscriberCount) {
        this.uploaderSubscriberCount = uploaderSubscriberCount;
    }

    @JsonProperty("audioStreams")
    public List<AudioStream> getAudioStreams() {
        return audioStreams;
    }

    @JsonProperty("audioStreams")
    public void setAudioStreams(List<AudioStream> audioStreams) {
        this.audioStreams = audioStreams;
    }

    @JsonProperty("videoStreams")
    public List<VideoStream> getVideoStreams() {
        return videoStreams;
    }

    @JsonProperty("videoStreams")
    public void setVideoStreams(List<VideoStream> videoStreams) {
        this.videoStreams = videoStreams;
    }

    @JsonProperty("relatedStreams")
    public List<RelatedStream> getRelatedStreams() {
        return relatedStreams;
    }

    @JsonProperty("relatedStreams")
    public void setRelatedStreams(List<RelatedStream> relatedStreams) {
        this.relatedStreams = relatedStreams;
    }

    @JsonProperty("subtitles")
    public List<Subtitle> getSubtitles() {
        return subtitles;
    }

    @JsonProperty("subtitles")
    public void setSubtitles(List<Subtitle> subtitles) {
        this.subtitles = subtitles;
    }

    @JsonProperty("livestream")
    public Boolean getLivestream() {
        return livestream;
    }

    @JsonProperty("livestream")
    public void setLivestream(Boolean livestream) {
        this.livestream = livestream;
    }

    @JsonProperty("proxyUrl")
    public String getProxyUrl() {
        return proxyUrl;
    }

    @JsonProperty("proxyUrl")
    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    @JsonProperty("chapters")
    public List<Object> getChapters() {
        return chapters;
    }

    @JsonProperty("chapters")
    public void setChapters(List<Object> chapters) {
        this.chapters = chapters;
    }

    @JsonProperty("previewFrames")
    public List<PreviewFrame> getPreviewFrames() {
        return previewFrames;
    }

    @JsonProperty("previewFrames")
    public void setPreviewFrames(List<PreviewFrame> previewFrames) {
        this.previewFrames = previewFrames;
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
        sb.append(StreamResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("uploadDate");
        sb.append('=');
        sb.append(((this.uploadDate == null)?"<null>":this.uploadDate));
        sb.append(',');
        sb.append("uploader");
        sb.append('=');
        sb.append(((this.uploader == null)?"<null>":this.uploader));
        sb.append(',');
        sb.append("uploaderUrl");
        sb.append('=');
        sb.append(((this.uploaderUrl == null)?"<null>":this.uploaderUrl));
        sb.append(',');
        sb.append("uploaderAvatar");
        sb.append('=');
        sb.append(((this.uploaderAvatar == null)?"<null>":this.uploaderAvatar));
        sb.append(',');
        sb.append("thumbnailUrl");
        sb.append('=');
        sb.append(((this.thumbnailUrl == null)?"<null>":this.thumbnailUrl));
        sb.append(',');
        sb.append("hls");
        sb.append('=');
        sb.append(((this.hls == null)?"<null>":this.hls));
        sb.append(',');
        sb.append("dash");
        sb.append('=');
        sb.append(((this.dash == null)?"<null>":this.dash));
        sb.append(',');
        sb.append("lbryId");
        sb.append('=');
        sb.append(((this.lbryId == null)?"<null>":this.lbryId));
        sb.append(',');
        sb.append("category");
        sb.append('=');
        sb.append(((this.category == null)?"<null>":this.category));
        sb.append(',');
        sb.append("license");
        sb.append('=');
        sb.append(((this.license == null)?"<null>":this.license));
        sb.append(',');
        sb.append("visibility");
        sb.append('=');
        sb.append(((this.visibility == null)?"<null>":this.visibility));
        sb.append(',');
        sb.append("tags");
        sb.append('=');
        sb.append(((this.tags == null)?"<null>":this.tags));
        sb.append(',');
        sb.append("metaInfo");
        sb.append('=');
        sb.append(((this.metaInfo == null)?"<null>":this.metaInfo));
        sb.append(',');
        sb.append("uploaderVerified");
        sb.append('=');
        sb.append(((this.uploaderVerified == null)?"<null>":this.uploaderVerified));
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(((this.duration == null)?"<null>":this.duration));
        sb.append(',');
        sb.append("isaatonimov/invy/views");
        sb.append('=');
        sb.append(((this.views == null)?"<null>":this.views));
        sb.append(',');
        sb.append("likes");
        sb.append('=');
        sb.append(((this.likes == null)?"<null>":this.likes));
        sb.append(',');
        sb.append("dislikes");
        sb.append('=');
        sb.append(((this.dislikes == null)?"<null>":this.dislikes));
        sb.append(',');
        sb.append("uploaderSubscriberCount");
        sb.append('=');
        sb.append(((this.uploaderSubscriberCount == null)?"<null>":this.uploaderSubscriberCount));
        sb.append(',');
        sb.append("audioStreams");
        sb.append('=');
        sb.append(((this.audioStreams == null)?"<null>":this.audioStreams));
        sb.append(',');
        sb.append("videoStreams");
        sb.append('=');
        sb.append(((this.videoStreams == null)?"<null>":this.videoStreams));
        sb.append(',');
        sb.append("relatedStreams");
        sb.append('=');
        sb.append(((this.relatedStreams == null)?"<null>":this.relatedStreams));
        sb.append(',');
        sb.append("subtitles");
        sb.append('=');
        sb.append(((this.subtitles == null)?"<null>":this.subtitles));
        sb.append(',');
        sb.append("livestream");
        sb.append('=');
        sb.append(((this.livestream == null)?"<null>":this.livestream));
        sb.append(',');
        sb.append("proxyUrl");
        sb.append('=');
        sb.append(((this.proxyUrl == null)?"<null>":this.proxyUrl));
        sb.append(',');
        sb.append("chapters");
        sb.append('=');
        sb.append(((this.chapters == null)?"<null>":this.chapters));
        sb.append(',');
        sb.append("previewFrames");
        sb.append('=');
        sb.append(((this.previewFrames == null)?"<null>":this.previewFrames));
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
        result = ((result* 31)+((this.chapters == null)? 0 :this.chapters.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.uploaderVerified == null)? 0 :this.uploaderVerified.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.duration == null)? 0 :this.duration.hashCode()));
        result = ((result* 31)+((this.relatedStreams == null)? 0 :this.relatedStreams.hashCode()));
        result = ((result* 31)+((this.uploader == null)? 0 :this.uploader.hashCode()));
        result = ((result* 31)+((this.previewFrames == null)? 0 :this.previewFrames.hashCode()));
        result = ((result* 31)+((this.lbryId == null)? 0 :this.lbryId.hashCode()));
        result = ((result* 31)+((this.views == null)? 0 :this.views.hashCode()));
        result = ((result* 31)+((this.thumbnailUrl == null)? 0 :this.thumbnailUrl.hashCode()));
        result = ((result* 31)+((this.likes == null)? 0 :this.likes.hashCode()));
        result = ((result* 31)+((this.subtitles == null)? 0 :this.subtitles.hashCode()));
        result = ((result* 31)+((this.visibility == null)? 0 :this.visibility.hashCode()));
        result = ((result* 31)+((this.proxyUrl == null)? 0 :this.proxyUrl.hashCode()));
        result = ((result* 31)+((this.uploaderAvatar == null)? 0 :this.uploaderAvatar.hashCode()));
        result = ((result* 31)+((this.dislikes == null)? 0 :this.dislikes.hashCode()));
        result = ((result* 31)+((this.uploaderUrl == null)? 0 :this.uploaderUrl.hashCode()));
        result = ((result* 31)+((this.hls == null)? 0 :this.hls.hashCode()));
        result = ((result* 31)+((this.livestream == null)? 0 :this.livestream.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        result = ((result* 31)+((this.license == null)? 0 :this.license.hashCode()));
        result = ((result* 31)+((this.metaInfo == null)? 0 :this.metaInfo.hashCode()));
        result = ((result* 31)+((this.uploadDate == null)? 0 :this.uploadDate.hashCode()));
        result = ((result* 31)+((this.videoStreams == null)? 0 :this.videoStreams.hashCode()));
        result = ((result* 31)+((this.audioStreams == null)? 0 :this.audioStreams.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.dash == null)? 0 :this.dash.hashCode()));
        result = ((result* 31)+((this.category == null)? 0 :this.category.hashCode()));
        result = ((result* 31)+((this.uploaderSubscriberCount == null)? 0 :this.uploaderSubscriberCount.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StreamResponse) == false) {
            return false;
        }
        StreamResponse rhs = ((StreamResponse) other);
        return (((((((((((((((((((((((((((((((this.chapters == rhs.chapters)||((this.chapters!= null)&&this.chapters.equals(rhs.chapters)))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.uploaderVerified == rhs.uploaderVerified)||((this.uploaderVerified!= null)&&this.uploaderVerified.equals(rhs.uploaderVerified))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.duration == rhs.duration)||((this.duration!= null)&&this.duration.equals(rhs.duration))))&&((this.relatedStreams == rhs.relatedStreams)||((this.relatedStreams!= null)&&this.relatedStreams.equals(rhs.relatedStreams))))&&((this.uploader == rhs.uploader)||((this.uploader!= null)&&this.uploader.equals(rhs.uploader))))&&((this.previewFrames == rhs.previewFrames)||((this.previewFrames!= null)&&this.previewFrames.equals(rhs.previewFrames))))&&((this.lbryId == rhs.lbryId)||((this.lbryId!= null)&&this.lbryId.equals(rhs.lbryId))))&&((this.views == rhs.views)||((this.views!= null)&&this.views.equals(rhs.views))))&&((this.thumbnailUrl == rhs.thumbnailUrl)||((this.thumbnailUrl!= null)&&this.thumbnailUrl.equals(rhs.thumbnailUrl))))&&((this.likes == rhs.likes)||((this.likes!= null)&&this.likes.equals(rhs.likes))))&&((this.subtitles == rhs.subtitles)||((this.subtitles!= null)&&this.subtitles.equals(rhs.subtitles))))&&((this.visibility == rhs.visibility)||((this.visibility!= null)&&this.visibility.equals(rhs.visibility))))&&((this.proxyUrl == rhs.proxyUrl)||((this.proxyUrl!= null)&&this.proxyUrl.equals(rhs.proxyUrl))))&&((this.uploaderAvatar == rhs.uploaderAvatar)||((this.uploaderAvatar!= null)&&this.uploaderAvatar.equals(rhs.uploaderAvatar))))&&((this.dislikes == rhs.dislikes)||((this.dislikes!= null)&&this.dislikes.equals(rhs.dislikes))))&&((this.uploaderUrl == rhs.uploaderUrl)||((this.uploaderUrl!= null)&&this.uploaderUrl.equals(rhs.uploaderUrl))))&&((this.hls == rhs.hls)||((this.hls!= null)&&this.hls.equals(rhs.hls))))&&((this.livestream == rhs.livestream)||((this.livestream!= null)&&this.livestream.equals(rhs.livestream))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))))&&((this.license == rhs.license)||((this.license!= null)&&this.license.equals(rhs.license))))&&((this.metaInfo == rhs.metaInfo)||((this.metaInfo!= null)&&this.metaInfo.equals(rhs.metaInfo))))&&((this.uploadDate == rhs.uploadDate)||((this.uploadDate!= null)&&this.uploadDate.equals(rhs.uploadDate))))&&((this.videoStreams == rhs.videoStreams)||((this.videoStreams!= null)&&this.videoStreams.equals(rhs.videoStreams))))&&((this.audioStreams == rhs.audioStreams)||((this.audioStreams!= null)&&this.audioStreams.equals(rhs.audioStreams))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.dash == rhs.dash)||((this.dash!= null)&&this.dash.equals(rhs.dash))))&&((this.category == rhs.category)||((this.category!= null)&&this.category.equals(rhs.category))))&&((this.uploaderSubscriberCount == rhs.uploaderSubscriberCount)||((this.uploaderSubscriberCount!= null)&&this.uploaderSubscriberCount.equals(rhs.uploaderSubscriberCount))));
    }

}
