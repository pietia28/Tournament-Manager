package pl.pg.tmanager.matchevents.matchevent;

import pl.pg.tmanager.matchevents.matcheventname.MatchEventNameDtoMapper;
import pl.pg.tmanager.player.PlayerDtoMapper;

public class MatchEventDtoMapper {
    private MatchEventDtoMapper() {
    }

    public static MatchEvent DtoToEntity(MatchEventDto matchEventDto) {
        return new MatchEvent().setId(matchEventDto.getId())
                .setTime(matchEventDto.getTime())
                .setPlayer(PlayerDtoMapper.DtoToEntity(matchEventDto.getPlayer()))
                .setMatchEventName(MatchEventNameDtoMapper.DtoToEntity(matchEventDto.getMatchEventName()));
    }

    public static MatchEventDto EntityToDto(MatchEvent matchEvent) {
        return new MatchEventDto().setId(matchEvent.getId())
                .setTime(matchEvent.getTime())
                .setPlayer(PlayerDtoMapper.EntityToDto(matchEvent.getPlayer()))
                .setMatchEventName(MatchEventNameDtoMapper.EntityToDto(matchEvent.getMatchEventName()));
    }
}
