
package isaatonimov.invy.models.piped;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "api_url",
    "locations",
    "version",
    "up_to_date",
    "cdn",
    "registered",
    "last_checked",
    "cache",
    "s3_enabled",
    "image_proxy_url",
    "registration_disabled",
    "uptime_24h",
    "uptime_7d",
    "uptime_30d"
})
@Generated("jsonschema2pojo")
public class PipedInstanceInformation
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("api_url")
    private String apiUrl;
    @JsonProperty("locations")
    private String locations;
    @JsonProperty("version")
    private String version;
    @JsonProperty("up_to_date")
    private Boolean upToDate;
    @JsonProperty("cdn")
    private Boolean cdn;
    @JsonProperty("registered")
    private Integer registered;
    @JsonProperty("last_checked")
    private Integer lastChecked;
    @JsonProperty("cache")
    private Boolean cache;
    @JsonProperty("s3_enabled")
    private Boolean s3Enabled;
    @JsonProperty("image_proxy_url")
    private String imageProxyUrl;
    @JsonProperty("registration_disabled")
    private Boolean registrationDisabled;
    @JsonProperty("uptime_24h")
    private Double uptime24h;
    @JsonProperty("uptime_7d")
    private Double uptime7d;
    @JsonProperty("uptime_30d")
    private Double uptime30d;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("api_url")
    public String getApiUrl() {
        return apiUrl;
    }

    @JsonProperty("api_url")
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    @JsonProperty("locations")
    public String getLocations() {
        return locations;
    }

    @JsonProperty("locations")
    public void setLocations(String locations) {
        this.locations = locations;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("up_to_date")
    public Boolean getUpToDate() {
        return upToDate;
    }

    @JsonProperty("up_to_date")
    public void setUpToDate(Boolean upToDate) {
        this.upToDate = upToDate;
    }

    @JsonProperty("cdn")
    public Boolean getCdn() {
        return cdn;
    }

    @JsonProperty("cdn")
    public void setCdn(Boolean cdn) {
        this.cdn = cdn;
    }

    @JsonProperty("registered")
    public Integer getRegistered() {
        return registered;
    }

    @JsonProperty("registered")
    public void setRegistered(Integer registered) {
        this.registered = registered;
    }

    @JsonProperty("last_checked")
    public Integer getLastChecked() {
        return lastChecked;
    }

    @JsonProperty("last_checked")
    public void setLastChecked(Integer lastChecked) {
        this.lastChecked = lastChecked;
    }

    @JsonProperty("cache")
    public Boolean getCache() {
        return cache;
    }

    @JsonProperty("cache")
    public void setCache(Boolean cache) {
        this.cache = cache;
    }

    @JsonProperty("s3_enabled")
    public Boolean getS3Enabled() {
        return s3Enabled;
    }

    @JsonProperty("s3_enabled")
    public void setS3Enabled(Boolean s3Enabled) {
        this.s3Enabled = s3Enabled;
    }

    @JsonProperty("image_proxy_url")
    public String getImageProxyUrl() {
        return imageProxyUrl;
    }

    @JsonProperty("image_proxy_url")
    public void setImageProxyUrl(String imageProxyUrl) {
        this.imageProxyUrl = imageProxyUrl;
    }

    @JsonProperty("registration_disabled")
    public Boolean getRegistrationDisabled() {
        return registrationDisabled;
    }

    @JsonProperty("registration_disabled")
    public void setRegistrationDisabled(Boolean registrationDisabled) {
        this.registrationDisabled = registrationDisabled;
    }

    @JsonProperty("uptime_24h")
    public Double getUptime24h() {
        return uptime24h;
    }

    @JsonProperty("uptime_24h")
    public void setUptime24h(Double uptime24h) {
        this.uptime24h = uptime24h;
    }

    @JsonProperty("uptime_7d")
    public Double getUptime7d() {
        return uptime7d;
    }

    @JsonProperty("uptime_7d")
    public void setUptime7d(Double uptime7d) {
        this.uptime7d = uptime7d;
    }

    @JsonProperty("uptime_30d")
    public Double getUptime30d() {
        return uptime30d;
    }

    @JsonProperty("uptime_30d")
    public void setUptime30d(Double uptime30d) {
        this.uptime30d = uptime30d;
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
        sb.append(PipedInstanceInformation.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("apiUrl");
        sb.append('=');
        sb.append(((this.apiUrl == null)?"<null>":this.apiUrl));
        sb.append(',');
        sb.append("locations");
        sb.append('=');
        sb.append(((this.locations == null)?"<null>":this.locations));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("upToDate");
        sb.append('=');
        sb.append(((this.upToDate == null)?"<null>":this.upToDate));
        sb.append(',');
        sb.append("cdn");
        sb.append('=');
        sb.append(((this.cdn == null)?"<null>":this.cdn));
        sb.append(',');
        sb.append("registered");
        sb.append('=');
        sb.append(((this.registered == null)?"<null>":this.registered));
        sb.append(',');
        sb.append("lastChecked");
        sb.append('=');
        sb.append(((this.lastChecked == null)?"<null>":this.lastChecked));
        sb.append(',');
        sb.append("cache");
        sb.append('=');
        sb.append(((this.cache == null)?"<null>":this.cache));
        sb.append(',');
        sb.append("s3Enabled");
        sb.append('=');
        sb.append(((this.s3Enabled == null)?"<null>":this.s3Enabled));
        sb.append(',');
        sb.append("imageProxyUrl");
        sb.append('=');
        sb.append(((this.imageProxyUrl == null)?"<null>":this.imageProxyUrl));
        sb.append(',');
        sb.append("registrationDisabled");
        sb.append('=');
        sb.append(((this.registrationDisabled == null)?"<null>":this.registrationDisabled));
        sb.append(',');
        sb.append("uptime24h");
        sb.append('=');
        sb.append(((this.uptime24h == null)?"<null>":this.uptime24h));
        sb.append(',');
        sb.append("uptime7d");
        sb.append('=');
        sb.append(((this.uptime7d == null)?"<null>":this.uptime7d));
        sb.append(',');
        sb.append("uptime30d");
        sb.append('=');
        sb.append(((this.uptime30d == null)?"<null>":this.uptime30d));
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
        result = ((result* 31)+((this.s3Enabled == null)? 0 :this.s3Enabled.hashCode()));
        result = ((result* 31)+((this.cache == null)? 0 :this.cache.hashCode()));
        result = ((result* 31)+((this.registrationDisabled == null)? 0 :this.registrationDisabled.hashCode()));
        result = ((result* 31)+((this.uptime7d == null)? 0 :this.uptime7d.hashCode()));
        result = ((result* 31)+((this.uptime24h == null)? 0 :this.uptime24h.hashCode()));
        result = ((result* 31)+((this.uptime30d == null)? 0 :this.uptime30d.hashCode()));
        result = ((result* 31)+((this.registered == null)? 0 :this.registered.hashCode()));
        result = ((result* 31)+((this.imageProxyUrl == null)? 0 :this.imageProxyUrl.hashCode()));
        result = ((result* 31)+((this.cdn == null)? 0 :this.cdn.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.upToDate == null)? 0 :this.upToDate.hashCode()));
        result = ((result* 31)+((this.apiUrl == null)? 0 :this.apiUrl.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.locations == null)? 0 :this.locations.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.lastChecked == null)? 0 :this.lastChecked.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PipedInstanceInformation) == false) {
            return false;
        }
        PipedInstanceInformation rhs = ((PipedInstanceInformation) other);
        return (((((((((((((((((this.s3Enabled == rhs.s3Enabled)||((this.s3Enabled!= null)&&this.s3Enabled.equals(rhs.s3Enabled)))&&((this.cache == rhs.cache)||((this.cache!= null)&&this.cache.equals(rhs.cache))))&&((this.registrationDisabled == rhs.registrationDisabled)||((this.registrationDisabled!= null)&&this.registrationDisabled.equals(rhs.registrationDisabled))))&&((this.uptime7d == rhs.uptime7d)||((this.uptime7d!= null)&&this.uptime7d.equals(rhs.uptime7d))))&&((this.uptime24h == rhs.uptime24h)||((this.uptime24h!= null)&&this.uptime24h.equals(rhs.uptime24h))))&&((this.uptime30d == rhs.uptime30d)||((this.uptime30d!= null)&&this.uptime30d.equals(rhs.uptime30d))))&&((this.registered == rhs.registered)||((this.registered!= null)&&this.registered.equals(rhs.registered))))&&((this.imageProxyUrl == rhs.imageProxyUrl)||((this.imageProxyUrl!= null)&&this.imageProxyUrl.equals(rhs.imageProxyUrl))))&&((this.cdn == rhs.cdn)||((this.cdn!= null)&&this.cdn.equals(rhs.cdn))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.upToDate == rhs.upToDate)||((this.upToDate!= null)&&this.upToDate.equals(rhs.upToDate))))&&((this.apiUrl == rhs.apiUrl)||((this.apiUrl!= null)&&this.apiUrl.equals(rhs.apiUrl))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.locations == rhs.locations)||((this.locations!= null)&&this.locations.equals(rhs.locations))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.lastChecked == rhs.lastChecked)||((this.lastChecked!= null)&&this.lastChecked.equals(rhs.lastChecked))));
    }


}
