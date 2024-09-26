package nl.klassikaal.auditlogs.configuration;

import org.javers.core.json.BasicStringTypeAdapter;
import org.javers.core.json.JsonTypeAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nl.klassikaal.auditlogs.model.AppUserPersonalInfo;

@Configuration
public class JsonTypeAdapterConfiguration {
    @Bean
    public JsonTypeAdapter<AppUserPersonalInfo> appUserPersonalInfoJsonAdapter() {

        return new BasicStringTypeAdapter<AppUserPersonalInfo>() {
            @Override
            public String serialize(AppUserPersonalInfo sourceValue) {
                return sourceValue.toString();
            }

            @Override
            public AppUserPersonalInfo deserialize(String serializedValue) {
                return new AppUserPersonalInfo(new AppUserPersonalInfo(serializedValue));
            }

            @Override
            public Class<AppUserPersonalInfo> getValueType() {
                return AppUserPersonalInfo.class;
            }
        };
    }

}
