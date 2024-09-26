package nl.klassikaal.auditlogs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppUserPersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String phonenumber;

    private String address;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private AppUser user;

    public AppUserPersonalInfo(AppUserPersonalInfo appUserPersonalInfo) {
        this.firstname = appUserPersonalInfo.getFirstname();
        this.lastname = appUserPersonalInfo.getLastname();
        this.email = appUserPersonalInfo.getEmail();
        this.phonenumber = appUserPersonalInfo.getPhonenumber();
        this.address = appUserPersonalInfo.getAddress();
    }

    @Override
    public String toString() {
        return "AppUserPersonalInfo{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public AppUserPersonalInfo(String csv) {
        String[] values = csv.split(",");
        this.firstname = values[0];
        this.lastname = values[1];
        this.email = values[2];
        this.phonenumber = values[3];
        this.address = values[4];
    }
}
