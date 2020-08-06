package pl.pg.tmanager.player;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.exception.ObjectNotFoundException;
import pl.pg.tmanager.message.Message;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public List<PlayerDto> findAll() {
        return playerRepository.findAll().stream()
                .map(PlayerDtoMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public PlayerDto findById(Long id) {
        return PlayerDtoMapper.EntityToDto(
                playerRepository.findById(id)
                        .orElseThrow((() -> new ObjectNotFoundException(Message.PLAYER_NOT_FOUND + id)))
        );
    }

    public Player save(PlayerDto playerDto) {
        return playerRepository.save(PlayerDtoMapper.DtoToEntity(playerDto));
    }

    public void delete(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow((() -> new ObjectNotFoundException(Message.PLAYER_NOT_FOUND + id)));
        playerRepository.deleteById(player.getId());
    }

    public Long count() {
        return playerRepository.count();
    }
}
