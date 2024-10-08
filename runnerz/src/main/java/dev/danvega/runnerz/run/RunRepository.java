package dev.danvega.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    public List<Run> findAllRuns() {
        return runs;
    }

    @PostConstruct
    private void init (){
        runs.add(new Run(1,
                "first run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(1, ChronoUnit.HOURS),
                5,
                Location.OUTDOOR));

        runs.add(new Run(2,
                "second run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(130, ChronoUnit.MINUTES),
                6,
                Location.OUTDOOR));

        runs.add(new Run(3,
                "third run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                1,
                Location.INDOOR));
    }
}
