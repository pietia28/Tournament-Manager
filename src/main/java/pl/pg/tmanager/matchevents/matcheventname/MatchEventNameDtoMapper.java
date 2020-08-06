package pl.pg.tmanager.matchevents.matcheventname;

public class MatchEventNameDtoMapper {
    private MatchEventNameDtoMapper() {
    }

    public static MatchEventName DtoToEntity(MatchEventNameDto matchEventNameDto) {
        return new MatchEventName().setId(matchEventNameDto.getId())
                .setName(matchEventNameDto.getName());
    }

    public static MatchEventNameDto EntityToDto(MatchEventName matchEventName) {
        return new MatchEventNameDto().setId(matchEventName.getId())
                .setName(matchEventName.getName());
    }
}
