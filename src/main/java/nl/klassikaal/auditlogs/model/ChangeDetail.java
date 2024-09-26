package nl.klassikaal.auditlogs.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangeDetail {

    private String propertyName;
    private Object oldValue;
    private Object newValue;

    public ChangeDetail(String propertyName, Object oldValue, Object newValue) {
        this.propertyName = propertyName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public ChangeDetail(String propertyName, Map<String, Object> oldValue, Map<String, Object> newValue) {
        this.propertyName = propertyName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

}
