
package isaatonimov.invy.models.musicbrainz;

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
    "approved",
    "back",
    "comment",
    "edit",
    "front",
    "id",
    "image",
    "thumbnails",
    "types"
})
@Generated("jsonschema2pojo")
public class Image {

    @JsonProperty("approved")
    private Boolean approved;
    @JsonProperty("back")
    private Boolean back;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("edit")
    private Integer edit;
    @JsonProperty("front")
    private Boolean front;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("image")
    private String image;
    @JsonProperty("thumbnails")
    private Thumbnails thumbnails;
    @JsonProperty("types")
    private List<String> types = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("approved")
    public Boolean getApproved() {
        return approved;
    }

    @JsonProperty("approved")
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @JsonProperty("back")
    public Boolean getBack() {
        return back;
    }

    @JsonProperty("back")
    public void setBack(Boolean back) {
        this.back = back;
    }

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    @JsonProperty("edit")
    public Integer getEdit() {
        return edit;
    }

    @JsonProperty("edit")
    public void setEdit(Integer edit) {
        this.edit = edit;
    }

    @JsonProperty("front")
    public Boolean getFront() {
        return front;
    }

    @JsonProperty("front")
    public void setFront(Boolean front) {
        this.front = front;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("thumbnails")
    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    @JsonProperty("thumbnails")
    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    @JsonProperty("types")
    public List<String> getTypes() {
        return types;
    }

    @JsonProperty("types")
    public void setTypes(List<String> types) {
        this.types = types;
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
        sb.append(Image.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("approved");
        sb.append('=');
        sb.append(((this.approved == null)?"<null>":this.approved));
        sb.append(',');
        sb.append("back");
        sb.append('=');
        sb.append(((this.back == null)?"<null>":this.back));
        sb.append(',');
        sb.append("comment");
        sb.append('=');
        sb.append(((this.comment == null)?"<null>":this.comment));
        sb.append(',');
        sb.append("edit");
        sb.append('=');
        sb.append(((this.edit == null)?"<null>":this.edit));
        sb.append(',');
        sb.append("front");
        sb.append('=');
        sb.append(((this.front == null)?"<null>":this.front));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("image");
        sb.append('=');
        sb.append(((this.image == null)?"<null>":this.image));
        sb.append(',');
        sb.append("thumbnails");
        sb.append('=');
        sb.append(((this.thumbnails == null)?"<null>":this.thumbnails));
        sb.append(',');
        sb.append("types");
        sb.append('=');
        sb.append(((this.types == null)?"<null>":this.types));
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
        result = ((result* 31)+((this.image == null)? 0 :this.image.hashCode()));
        result = ((result* 31)+((this.approved == null)? 0 :this.approved.hashCode()));
        result = ((result* 31)+((this.types == null)? 0 :this.types.hashCode()));
        result = ((result* 31)+((this.edit == null)? 0 :this.edit.hashCode()));
        result = ((result* 31)+((this.back == null)? 0 :this.back.hashCode()));
        result = ((result* 31)+((this.comment == null)? 0 :this.comment.hashCode()));
        result = ((result* 31)+((this.front == null)? 0 :this.front.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.thumbnails == null)? 0 :this.thumbnails.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Image) == false) {
            return false;
        }
        Image rhs = ((Image) other);
        return (((((((((((this.image == rhs.image)||((this.image!= null)&&this.image.equals(rhs.image)))&&((this.approved == rhs.approved)||((this.approved!= null)&&this.approved.equals(rhs.approved))))&&((this.types == rhs.types)||((this.types!= null)&&this.types.equals(rhs.types))))&&((this.edit == rhs.edit)||((this.edit!= null)&&this.edit.equals(rhs.edit))))&&((this.back == rhs.back)||((this.back!= null)&&this.back.equals(rhs.back))))&&((this.comment == rhs.comment)||((this.comment!= null)&&this.comment.equals(rhs.comment))))&&((this.front == rhs.front)||((this.front!= null)&&this.front.equals(rhs.front))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.thumbnails == rhs.thumbnails)||((this.thumbnails!= null)&&this.thumbnails.equals(rhs.thumbnails))));
    }

}
