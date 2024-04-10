
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
    "format",
    "quality",
    "mimeType",
    "codec",
    "audioTrackId",
    "audioTrackName",
    "audioTrackType",
    "audioTrackLocale",
    "videoOnly",
    "itag",
    "bitrate",
    "initStart",
    "initEnd",
    "indexStart",
    "indexEnd",
    "width",
    "height",
    "fps",
    "contentLength"
})
@Generated("jsonschema2pojo")
public class VideoStream {

    @JsonProperty("url")
    private String url;
    @JsonProperty("format")
    private String format;
    @JsonProperty("quality")
    private String quality;
    @JsonProperty("mimeType")
    private String mimeType;
    @JsonProperty("codec")
    private Object codec;
    @JsonProperty("audioTrackId")
    private Object audioTrackId;
    @JsonProperty("audioTrackName")
    private Object audioTrackName;
    @JsonProperty("audioTrackType")
    private Object audioTrackType;
    @JsonProperty("audioTrackLocale")
    private Object audioTrackLocale;
    @JsonProperty("videoOnly")
    private Boolean videoOnly;
    @JsonProperty("itag")
    private Integer itag;
    @JsonProperty("bitrate")
    private Integer bitrate;
    @JsonProperty("initStart")
    private Integer initStart;
    @JsonProperty("initEnd")
    private Integer initEnd;
    @JsonProperty("indexStart")
    private Integer indexStart;
    @JsonProperty("indexEnd")
    private Integer indexEnd;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("fps")
    private Integer fps;
    @JsonProperty("contentLength")
    private Integer contentLength;
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

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("quality")
    public String getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(String quality) {
        this.quality = quality;
    }

    @JsonProperty("mimeType")
    public String getMimeType() {
        return mimeType;
    }

    @JsonProperty("mimeType")
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @JsonProperty("codec")
    public Object getCodec() {
        return codec;
    }

    @JsonProperty("codec")
    public void setCodec(Object codec) {
        this.codec = codec;
    }

    @JsonProperty("audioTrackId")
    public Object getAudioTrackId() {
        return audioTrackId;
    }

    @JsonProperty("audioTrackId")
    public void setAudioTrackId(Object audioTrackId) {
        this.audioTrackId = audioTrackId;
    }

    @JsonProperty("audioTrackName")
    public Object getAudioTrackName() {
        return audioTrackName;
    }

    @JsonProperty("audioTrackName")
    public void setAudioTrackName(Object audioTrackName) {
        this.audioTrackName = audioTrackName;
    }

    @JsonProperty("audioTrackType")
    public Object getAudioTrackType() {
        return audioTrackType;
    }

    @JsonProperty("audioTrackType")
    public void setAudioTrackType(Object audioTrackType) {
        this.audioTrackType = audioTrackType;
    }

    @JsonProperty("audioTrackLocale")
    public Object getAudioTrackLocale() {
        return audioTrackLocale;
    }

    @JsonProperty("audioTrackLocale")
    public void setAudioTrackLocale(Object audioTrackLocale) {
        this.audioTrackLocale = audioTrackLocale;
    }

    @JsonProperty("videoOnly")
    public Boolean getVideoOnly() {
        return videoOnly;
    }

    @JsonProperty("videoOnly")
    public void setVideoOnly(Boolean videoOnly) {
        this.videoOnly = videoOnly;
    }

    @JsonProperty("itag")
    public Integer getItag() {
        return itag;
    }

    @JsonProperty("itag")
    public void setItag(Integer itag) {
        this.itag = itag;
    }

    @JsonProperty("bitrate")
    public Integer getBitrate() {
        return bitrate;
    }

    @JsonProperty("bitrate")
    public void setBitrate(Integer bitrate) {
        this.bitrate = bitrate;
    }

    @JsonProperty("initStart")
    public Integer getInitStart() {
        return initStart;
    }

    @JsonProperty("initStart")
    public void setInitStart(Integer initStart) {
        this.initStart = initStart;
    }

    @JsonProperty("initEnd")
    public Integer getInitEnd() {
        return initEnd;
    }

    @JsonProperty("initEnd")
    public void setInitEnd(Integer initEnd) {
        this.initEnd = initEnd;
    }

    @JsonProperty("indexStart")
    public Integer getIndexStart() {
        return indexStart;
    }

    @JsonProperty("indexStart")
    public void setIndexStart(Integer indexStart) {
        this.indexStart = indexStart;
    }

    @JsonProperty("indexEnd")
    public Integer getIndexEnd() {
        return indexEnd;
    }

    @JsonProperty("indexEnd")
    public void setIndexEnd(Integer indexEnd) {
        this.indexEnd = indexEnd;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("fps")
    public Integer getFps() {
        return fps;
    }

    @JsonProperty("fps")
    public void setFps(Integer fps) {
        this.fps = fps;
    }

    @JsonProperty("contentLength")
    public Integer getContentLength() {
        return contentLength;
    }

    @JsonProperty("contentLength")
    public void setContentLength(Integer contentLength) {
        this.contentLength = contentLength;
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
        sb.append(VideoStream.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("format");
        sb.append('=');
        sb.append(((this.format == null)?"<null>":this.format));
        sb.append(',');
        sb.append("quality");
        sb.append('=');
        sb.append(((this.quality == null)?"<null>":this.quality));
        sb.append(',');
        sb.append("mimeType");
        sb.append('=');
        sb.append(((this.mimeType == null)?"<null>":this.mimeType));
        sb.append(',');
        sb.append("codec");
        sb.append('=');
        sb.append(((this.codec == null)?"<null>":this.codec));
        sb.append(',');
        sb.append("audioTrackId");
        sb.append('=');
        sb.append(((this.audioTrackId == null)?"<null>":this.audioTrackId));
        sb.append(',');
        sb.append("audioTrackName");
        sb.append('=');
        sb.append(((this.audioTrackName == null)?"<null>":this.audioTrackName));
        sb.append(',');
        sb.append("audioTrackType");
        sb.append('=');
        sb.append(((this.audioTrackType == null)?"<null>":this.audioTrackType));
        sb.append(',');
        sb.append("audioTrackLocale");
        sb.append('=');
        sb.append(((this.audioTrackLocale == null)?"<null>":this.audioTrackLocale));
        sb.append(',');
        sb.append("videoOnly");
        sb.append('=');
        sb.append(((this.videoOnly == null)?"<null>":this.videoOnly));
        sb.append(',');
        sb.append("itag");
        sb.append('=');
        sb.append(((this.itag == null)?"<null>":this.itag));
        sb.append(',');
        sb.append("bitrate");
        sb.append('=');
        sb.append(((this.bitrate == null)?"<null>":this.bitrate));
        sb.append(',');
        sb.append("initStart");
        sb.append('=');
        sb.append(((this.initStart == null)?"<null>":this.initStart));
        sb.append(',');
        sb.append("initEnd");
        sb.append('=');
        sb.append(((this.initEnd == null)?"<null>":this.initEnd));
        sb.append(',');
        sb.append("indexStart");
        sb.append('=');
        sb.append(((this.indexStart == null)?"<null>":this.indexStart));
        sb.append(',');
        sb.append("indexEnd");
        sb.append('=');
        sb.append(((this.indexEnd == null)?"<null>":this.indexEnd));
        sb.append(',');
        sb.append("width");
        sb.append('=');
        sb.append(((this.width == null)?"<null>":this.width));
        sb.append(',');
        sb.append("height");
        sb.append('=');
        sb.append(((this.height == null)?"<null>":this.height));
        sb.append(',');
        sb.append("fps");
        sb.append('=');
        sb.append(((this.fps == null)?"<null>":this.fps));
        sb.append(',');
        sb.append("contentLength");
        sb.append('=');
        sb.append(((this.contentLength == null)?"<null>":this.contentLength));
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
        result = ((result* 31)+((this.itag == null)? 0 :this.itag.hashCode()));
        result = ((result* 31)+((this.audioTrackId == null)? 0 :this.audioTrackId.hashCode()));
        result = ((result* 31)+((this.audioTrackName == null)? 0 :this.audioTrackName.hashCode()));
        result = ((result* 31)+((this.audioTrackLocale == null)? 0 :this.audioTrackLocale.hashCode()));
        result = ((result* 31)+((this.format == null)? 0 :this.format.hashCode()));
        result = ((result* 31)+((this.audioTrackType == null)? 0 :this.audioTrackType.hashCode()));
        result = ((result* 31)+((this.fps == null)? 0 :this.fps.hashCode()));
        result = ((result* 31)+((this.initStart == null)? 0 :this.initStart.hashCode()));
        result = ((result* 31)+((this.bitrate == null)? 0 :this.bitrate.hashCode()));
        result = ((result* 31)+((this.mimeType == null)? 0 :this.mimeType.hashCode()));
        result = ((result* 31)+((this.initEnd == null)? 0 :this.initEnd.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.quality == null)? 0 :this.quality.hashCode()));
        result = ((result* 31)+((this.indexStart == null)? 0 :this.indexStart.hashCode()));
        result = ((result* 31)+((this.codec == null)? 0 :this.codec.hashCode()));
        result = ((result* 31)+((this.videoOnly == null)? 0 :this.videoOnly.hashCode()));
        result = ((result* 31)+((this.width == null)? 0 :this.width.hashCode()));
        result = ((result* 31)+((this.contentLength == null)? 0 :this.contentLength.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.indexEnd == null)? 0 :this.indexEnd.hashCode()));
        result = ((result* 31)+((this.height == null)? 0 :this.height.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VideoStream) == false) {
            return false;
        }
        VideoStream rhs = ((VideoStream) other);
        return ((((((((((((((((((((((this.itag == rhs.itag)||((this.itag!= null)&&this.itag.equals(rhs.itag)))&&((this.audioTrackId == rhs.audioTrackId)||((this.audioTrackId!= null)&&this.audioTrackId.equals(rhs.audioTrackId))))&&((this.audioTrackName == rhs.audioTrackName)||((this.audioTrackName!= null)&&this.audioTrackName.equals(rhs.audioTrackName))))&&((this.audioTrackLocale == rhs.audioTrackLocale)||((this.audioTrackLocale!= null)&&this.audioTrackLocale.equals(rhs.audioTrackLocale))))&&((this.format == rhs.format)||((this.format!= null)&&this.format.equals(rhs.format))))&&((this.audioTrackType == rhs.audioTrackType)||((this.audioTrackType!= null)&&this.audioTrackType.equals(rhs.audioTrackType))))&&((this.fps == rhs.fps)||((this.fps!= null)&&this.fps.equals(rhs.fps))))&&((this.initStart == rhs.initStart)||((this.initStart!= null)&&this.initStart.equals(rhs.initStart))))&&((this.bitrate == rhs.bitrate)||((this.bitrate!= null)&&this.bitrate.equals(rhs.bitrate))))&&((this.mimeType == rhs.mimeType)||((this.mimeType!= null)&&this.mimeType.equals(rhs.mimeType))))&&((this.initEnd == rhs.initEnd)||((this.initEnd!= null)&&this.initEnd.equals(rhs.initEnd))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.quality == rhs.quality)||((this.quality!= null)&&this.quality.equals(rhs.quality))))&&((this.indexStart == rhs.indexStart)||((this.indexStart!= null)&&this.indexStart.equals(rhs.indexStart))))&&((this.codec == rhs.codec)||((this.codec!= null)&&this.codec.equals(rhs.codec))))&&((this.videoOnly == rhs.videoOnly)||((this.videoOnly!= null)&&this.videoOnly.equals(rhs.videoOnly))))&&((this.width == rhs.width)||((this.width!= null)&&this.width.equals(rhs.width))))&&((this.contentLength == rhs.contentLength)||((this.contentLength!= null)&&this.contentLength.equals(rhs.contentLength))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.indexEnd == rhs.indexEnd)||((this.indexEnd!= null)&&this.indexEnd.equals(rhs.indexEnd))))&&((this.height == rhs.height)||((this.height!= null)&&this.height.equals(rhs.height))));
    }

}
