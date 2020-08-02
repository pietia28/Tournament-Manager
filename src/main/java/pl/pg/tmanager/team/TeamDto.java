package pl.pg.tmanager.team;

import org.springframework.stereotype.Component;
import pl.pg.tmanager.manager.Manager;
import pl.pg.tmanager.player.Player;
import java.util.List;

@Component
public class TeamDto {
    Long id;
    private String name;
    private List<Manager> managers;
    private List<Player> players;
}
