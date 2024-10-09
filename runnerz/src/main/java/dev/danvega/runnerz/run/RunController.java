package dev.danvega.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository){
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> findAllRuns() {
        return runRepository.findAll();
    }

    @GetMapping("/{Id}")
    Run findById(@PathVariable Integer Id){
        Optional<Run> run = runRepository.findById(Id);

        if (run.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return run.get();
    }

    void create(@RequestBody Run run){
        runRepository.create(run);
    }
}
