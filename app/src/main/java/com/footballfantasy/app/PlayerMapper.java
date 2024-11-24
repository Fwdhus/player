package com.footballfantasy.app;

import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 */
@Mapper(componentModel = "spring")
public interface PlayerMapper {
    
    public Player toEntity(PlayerDTO playerDTO);
    
    public PlayerResponse toResponse(Player player);
    
    public List<PlayerResponse> toResponseList(List<Player> players);
}
