
package isaatonimov.invy.models.invidious;

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
    "init",
    "index",
    "bitrate",
    "url",
    "itag",
    "type",
    "clen",
    "lmt",
    "projectionType",
    "fps",
    "container",
    "encoding",
    "audioQuality",
    "audioSampleRate",
    "audioChannels",
    "resolution",
    "qualityLabel",
    "colorInfo"
})
@Generated("jsonschema2pojo")
public class AdaptiveFormat {

    @JsonProperty("init")
    private String init;
    @JsonProperty("index")
    private String index;
    @JsonProperty("bitrate")
    private String bitrate;
    @JsonProperty("url")
    private String url;
    @JsonProperty("itag")
    private String itag;
    @JsonProperty("type")
    private String type;
    @JsonProperty("clen")
    private String clen;
    @JsonProperty("lmt")
    private String lmt;
    @JsonProperty("projectionType")
    private String projectionType;
    @JsonProperty("fps")
    private Integer fps;
    @JsonProperty("container")
    private String container;
    @JsonProperty("encoding")
    private String encoding;
    @JsonProperty("audioQuality")
    private String audioQuality;
    @JsonProperty("audioSampleRate")
    private Integer audioSampleRate;
    @JsonProperty("audioChannels")
    private Integer audioChannels;
    @JsonProperty("resolution")
    private String resolution;
    @JsonProperty("qualityLabel")
    private String qualityLabel;
    @JsonProperty("colorInfo")
    private ColorInfo colorInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("init")
    public String getInit() {
        return init;
    }

    @JsonProperty("init")
    public void setInit(String init) {
        this.init = init;
    }

    @JsonProperty("index")
    public String getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(String index) {
        this.index = index;
    }

    @JsonProperty("bitrate")
    public String getBitrate() {
        return bitrate;
    }

    @JsonProperty("bitrate")
    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("itag")
    public String getItag() {
        return itag;
    }

    @JsonProperty("itag")
    public void setItag(String itag) {
        this.itag = itag;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("clen")
    public String getClen() {
        return clen;
    }

    @JsonProperty("clen")
    public void setClen(String clen) {
        this.clen = clen;
    }

    @JsonProperty("lmt")
    public String getLmt() {
        return lmt;
    }

    @JsonProperty("lmt")
    public void setLmt(String lmt) {
        this.lmt = lmt;
    }

    @JsonProperty("projectionType")
    public String getProjectionType() {
        return projectionType;
    }

    @JsonProperty("projectionType")
    public void setProjectionType(String projectionType) {
        this.projectionType = projectionType;
    }

    @JsonProperty("fps")
    public Integer getFps() {
        return fps;
    }

    @JsonProperty("fps")
    public void setFps(Integer fps) {
        this.fps = fps;
    }

    @JsonProperty("container")
    public String getContainer() {
        return container;
    }

    @JsonProperty("container")
    public void setContainer(String container) {
        this.container = container;
    }

    @JsonProperty("encoding")
    public String getEncoding() {
        return encoding;
    }

    @JsonProperty("encoding")
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    @JsonProperty("audioQuality")
    public String getAudioQuality() {
        return audioQuality;
    }

    @JsonProperty("audioQuality")
    public void setAudioQuality(String audioQuality) {
        this.audioQuality = audioQuality;
    }

    @JsonProperty("audioSampleRate")
    public Integer getAudioSampleRate() {
        return audioSampleRate;
    }

    @JsonProperty("audioSampleRate")
    public void setAudioSampleRate(Integer audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    @JsonProperty("audioChannels")
    public Integer getAudioChannels() {
        return audioChannels;
    }

    @JsonProperty("audioChannels")
    public void setAudioChannels(Integer audioChannels) {
        this.audioChannels = audioChannels;
    }

    @JsonProperty("resolution")
    public String getResolution() {
        return resolution;
    }

    @JsonProperty("resolution")
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @JsonProperty("qualityLabel")
    public String getQualityLabel() {
        return qualityLabel;
    }

    @JsonProperty("qualityLabel")
    public void setQualityLabel(String qualityLabel) {
        this.qualityLabel = qualityLabel;
    }

    @JsonProperty("colorInfo")
    public ColorInfo getColorInfo() {
        return colorInfo;
    }

    @JsonProperty("colorInfo")
    public void setColorInfo(ColorInfo colorInfo) {
        this.colorInfo = colorInfo;
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
        sb.append(AdaptiveFormat.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("init");
        sb.append('=');
        sb.append(((this.init == null)?"<null>":this.init));
        sb.append(',');
        sb.append("index");
        sb.append('=');
        sb.append(((this.index == null)?"<null>":this.index));
        sb.append(',');
        sb.append("bitrate");
        sb.append('=');
        sb.append(((this.bitrate == null)?"<null>":this.bitrate));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("itag");
        sb.append('=');
        sb.append(((this.itag == null)?"<null>":this.itag));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("clen");
        sb.append('=');
        sb.append(((this.clen == null)?"<null>":this.clen));
        sb.append(',');
        sb.append("lmt");
        sb.append('=');
        sb.append(((this.lmt == null)?"<null>":this.lmt));
        sb.append(',');
        sb.append("projectionType");
        sb.append('=');
        sb.append(((this.projectionType == null)?"<null>":this.projectionType));
        sb.append(',');
        sb.append("fps");
        sb.append('=');
        sb.append(((this.fps == null)?"<null>":this.fps));
        sb.append(',');
        sb.append("container");
        sb.append('=');
        sb.append(((this.container == null)?"<null>":this.container));
        sb.append(',');
        sb.append("encoding");
        sb.append('=');
        sb.append(((this.encoding == null)?"<null>":this.encoding));
        sb.append(',');
        sb.append("audioQuality");
        sb.append('=');
        sb.append(((this.audioQuality == null)?"<null>":this.audioQuality));
        sb.append(',');
        sb.append("audioSampleRate");
        sb.append('=');
        sb.append(((this.audioSampleRate == null)?"<null>":this.audioSampleRate));
        sb.append(',');
        sb.append("audioChannels");
        sb.append('=');
        sb.append(((this.audioChannels == null)?"<null>":this.audioChannels));
        sb.append(',');
        sb.append("resolution");
        sb.append('=');
        sb.append(((this.resolution == null)?"<null>":this.resolution));
        sb.append(',');
        sb.append("qualityLabel");
        sb.append('=');
        sb.append(((this.qualityLabel == null)?"<null>":this.qualityLabel));
        sb.append(',');
        sb.append("colorInfo");
        sb.append('=');
        sb.append(((this.colorInfo == null)?"<null>":this.colorInfo));
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
        result = ((result* 31)+((this.container == null)? 0 :this.container.hashCode()));
        result = ((result* 31)+((this.init == null)? 0 :this.init.hashCode()));
        result = ((result* 31)+((this.projectionType == null)? 0 :this.projectionType.hashCode()));
        result = ((result* 31)+((this.fps == null)? 0 :this.fps.hashCode()));
        result = ((result* 31)+((this.index == null)? 0 :this.index.hashCode()));
        result = ((result* 31)+((this.bitrate == null)? 0 :this.bitrate.hashCode()));
        result = ((result* 31)+((this.audioQuality == null)? 0 :this.audioQuality.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.encoding == null)? 0 :this.encoding.hashCode()));
        result = ((result* 31)+((this.resolution == null)? 0 :this.resolution.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.audioSampleRate == null)? 0 :this.audioSampleRate.hashCode()));
        result = ((result* 31)+((this.lmt == null)? 0 :this.lmt.hashCode()));
        result = ((result* 31)+((this.qualityLabel == null)? 0 :this.qualityLabel.hashCode()));
        result = ((result* 31)+((this.audioChannels == null)? 0 :this.audioChannels.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.clen == null)? 0 :this.clen.hashCode()));
        result = ((result* 31)+((this.colorInfo == null)? 0 :this.colorInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AdaptiveFormat) == false) {
            return false;
        }
        AdaptiveFormat rhs = ((AdaptiveFormat) other);
        return ((((((((((((((((((((this.itag == rhs.itag)||((this.itag!= null)&&this.itag.equals(rhs.itag)))&&((this.container == rhs.container)||((this.container!= null)&&this.container.equals(rhs.container))))&&((this.init == rhs.init)||((this.init!= null)&&this.init.equals(rhs.init))))&&((this.projectionType == rhs.projectionType)||((this.projectionType!= null)&&this.projectionType.equals(rhs.projectionType))))&&((this.fps == rhs.fps)||((this.fps!= null)&&this.fps.equals(rhs.fps))))&&((this.index == rhs.index)||((this.index!= null)&&this.index.equals(rhs.index))))&&((this.bitrate == rhs.bitrate)||((this.bitrate!= null)&&this.bitrate.equals(rhs.bitrate))))&&((this.audioQuality == rhs.audioQuality)||((this.audioQuality!= null)&&this.audioQuality.equals(rhs.audioQuality))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.encoding == rhs.encoding)||((this.encoding!= null)&&this.encoding.equals(rhs.encoding))))&&((this.resolution == rhs.resolution)||((this.resolution!= null)&&this.resolution.equals(rhs.resolution))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.audioSampleRate == rhs.audioSampleRate)||((this.audioSampleRate!= null)&&this.audioSampleRate.equals(rhs.audioSampleRate))))&&((this.lmt == rhs.lmt)||((this.lmt!= null)&&this.lmt.equals(rhs.lmt))))&&((this.qualityLabel == rhs.qualityLabel)||((this.qualityLabel!= null)&&this.qualityLabel.equals(rhs.qualityLabel))))&&((this.audioChannels == rhs.audioChannels)||((this.audioChannels!= null)&&this.audioChannels.equals(rhs.audioChannels))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.clen == rhs.clen)||((this.clen!= null)&&this.clen.equals(rhs.clen))))&&((this.colorInfo == rhs.colorInfo)||((this.colorInfo!= null)&&this.colorInfo.equals(rhs.colorInfo))));
    }

}
