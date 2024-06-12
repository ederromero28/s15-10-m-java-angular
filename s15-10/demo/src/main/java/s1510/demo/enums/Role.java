package s1510.demo.enums;

import org.springframework.context.annotation.Profile;

@Profile(value = {"dev", "prod", "test"})
public enum Role {
    ADMIN,
    PLAYER,
    TEAM,
    USER
}
