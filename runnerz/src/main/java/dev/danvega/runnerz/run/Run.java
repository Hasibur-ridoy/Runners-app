package dev.danvega.runnerz.run;

import java.time.LocalDateTime;

public record Run(
        Integer ID,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        Location location
) {}
