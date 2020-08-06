package pl.pg.tmanager.team;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.exception.ObjectNotFoundException;
import pl.pg.tmanager.message.Message;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public List<TeamDto> findAll() {
        return teamRepository.findAll().stream()
                .map(TeamDtoMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public TeamDto findById(Long id) {
        return TeamDtoMapper.EntityToDto(
                teamRepository.findById(id)
                        .orElseThrow((() -> new ObjectNotFoundException(Message.TEAM_NOT_FOUND + id)))
        );
    }

    public Team save(TeamDto teamDto) {
        return teamRepository.save(TeamDtoMapper.DtoToEntity(teamDto));
    }

    public void delete(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow((() -> new ObjectNotFoundException(Message.TEAM_NOT_FOUND + id)));
        teamRepository.deleteById(team.getId());
    }

    public Long count() {
        return teamRepository.count();
    }
}
