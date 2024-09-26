package nl.klassikaal.auditlogs.controller;

import java.util.ArrayList;
import java.util.List;

import org.javers.core.Javers;
import org.javers.core.diff.Change;
import org.javers.core.diff.changetype.PropertyChange;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.klassikaal.auditlogs.model.AppUser;
import nl.klassikaal.auditlogs.model.ChangeDetail;

@RestController
@RequestMapping(value = "/audits/users")
public class AppUserAuditController {

    private final Javers javers;

    public AppUserAuditController(Javers javers) {
        this.javers = javers;
    }

    @GetMapping("/{id}")
    public String getPersonChanges(@PathVariable String id) {
        QueryBuilder jqlQuery = QueryBuilder.byInstanceId(Long.parseLong(id), AppUser.class);
        List<Change> changes = javers.findChanges(jqlQuery.build());
        List<ChangeDetail> changeDetails = new ArrayList<>();

        for (Change change : changes) {
            if (change instanceof PropertyChange) {
                PropertyChange<?> propertyChange = (PropertyChange<?>) change;
                Object oldValue = propertyChange.getLeft();
                Object newValue = propertyChange.getRight();

                changeDetails.add(new ChangeDetail(
                        propertyChange.getPropertyName(),
                        oldValue != null ? oldValue.toString() : null,
                        newValue != null ? newValue.toString() : null));
            }
        }

        return javers.getJsonConverter().toJson(changeDetails);
    }

}