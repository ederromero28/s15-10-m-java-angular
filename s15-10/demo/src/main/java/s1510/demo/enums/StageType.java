package s1510.demo.enums;

import org.springframework.context.annotation.Profile;

@Profile(value = {"dev", "prod", "test"})
public enum StageType {
    FINALS,
    SEMI_FINALS,
    QUARTER_FINALS,
    ROUND_OF_16,
    ROUND_OF_32,
    ROUND_OF_64,
    LOW_BRACKET,
    HIGH_BRACKET
}
