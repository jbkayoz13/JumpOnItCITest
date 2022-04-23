package JumpOnIt.ClassManagementMicroservice.model;


import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "classID",
        "className",
        "classLocation",
        "classTrainer",
        "classDate",
        "classTime"
})
@Generated("jsonschema2pojo")
public class ClassManagement {

    @JsonProperty("classID")
    private Integer classID;
    @JsonProperty("className")
    private String className;
    @JsonProperty("classLocation")
    private String classLocation;
    @JsonProperty("classTrainer")
    private String classTrainer;
    @JsonProperty("classDate")
    private String classDate;
    @JsonProperty("classTime")
    private String classTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("classID")
    public Integer getClassID() {
        return classID;
    }

    @JsonProperty("classID")
    public void setClassID(Integer classID) {
        this.classID = classID;
    }

    @JsonProperty("className")
    public String getClassName() {
        return className;
    }

    @JsonProperty("className")
    public void setClassName(String className) {
        this.className = className;
    }

    @JsonProperty("classLocation")
    public String getClassLocation() {
        return classLocation;
    }

    @JsonProperty("classLocation")
    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
    }

    @JsonProperty("classTrainer")
    public String getClassTrainer() {
        return classTrainer;
    }

    @JsonProperty("classTrainer")
    public void setClassTrainer(String classTrainer) {
        this.classTrainer = classTrainer;
    }

    @JsonProperty("classDate")
    public String getClassDate() {
        return classDate;
    }

    @JsonProperty("classDate")
    public void setClassDate(String classDate) {
        this.classDate = classDate;
    }

    @JsonProperty("classTime")
    public String getClassTime() {
        return classTime;
    }

    @JsonProperty("classTime")
    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
