package org.example.coping_with_services.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

//@Getter
//@Setter
//@Entity
//@Table(name = "user_crisis_plans")
//public class UserCrisisPlan {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonProperty("id")
//    private Long id;
//
//    @JsonProperty("userDummyId")
//    @Column(name = "user_dummy_id", length = 36) // Store as String (UUID is 36 chars)
//    private String userDummyId;
//
//    @JsonProperty("responseDetails")
//    @Column(name = "response_details", columnDefinition = "TEXT")
//    private String responseDetails;
//
//    // Convert UUID to String before storing in DB
//    public void setUserDummyId(UUID uuid) {
//        this.userDummyId = uuid.toString();
//    }
//
//    // Convert String back to UUID when retrieving from DB
//    public UUID getUserDummyId() {
//        return UUID.fromString(this.userDummyId);
//    }
//}
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

//@Getter
//@Setter
//@Entity
//@Table(name = "user_crisis_plans")
//public class UserCrisisPlan {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @JsonProperty("user_dummy_id")
//    @Column(name = "user_dummy_id", columnDefinition = "CHAR(36)")
//    private UUID userDummyId;
//
//    @JsonProperty("selected_steps")
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "plan_id") // Links responses to this plan
//    private List<UserSelectedStep> selectedSteps;
//}
//@Getter
//@Setter
//@Entity
//@Table(name = "user_crisis_plans")
//public class UserCrisisPlan {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @JsonProperty("user_dummy_id")
//    @Column(name = "user_dummy_id", length = 36, nullable = false) // Store UUID as a String
//    private String userDummyId;
//
//    @JsonProperty("selected_steps")
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "plan_id") // Links responses to this plan
//    private List<UserSelectedStep> selectedSteps;
//
//    // ✅ Convert UUID to String before storing
//    public void setUserDummyId(UUID uuid) {
//        this.userDummyId = uuid.toString();
//    }
//
//    // ✅ Convert String back to UUID when retrieving
//    public UUID getUserDummyId() {
//        return UUID.fromString(this.userDummyId);
//    }
//}
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user_crisis_plans")
public class UserCrisisPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("user_dummy_id")
    @Column(name = "user_dummy_id", length = 36, nullable = false) // Store UUID as a String
    private String userDummyId;  // ✅ Store directly as a String

    @JsonProperty("selected_steps")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "plan_id")
    private List<UserSelectedStep> selectedSteps;
}
