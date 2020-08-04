package pl.pg.tmanager.team;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public ResponseEntity<String> save(Team team) {
        teamRepository.save(team);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");
        return new ResponseEntity<> ("Custom header set", headers, HttpStatus.ACCEPTED);
    }
}
