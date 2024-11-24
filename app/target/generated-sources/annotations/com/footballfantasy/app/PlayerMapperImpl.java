package com.footballfantasy.app;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-22T11:30:34+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public Player toEntity(PlayerDTO playerDTO) {
        if ( playerDTO == null ) {
            return null;
        }

        Player player = new Player();

        player.setId( playerDTO.getId() );
        player.setName( playerDTO.getName() );
        player.setAge( playerDTO.getAge() );
        player.setPosition( playerDTO.getPosition() );

        return player;
    }

    @Override
    public PlayerResponse toResponse(Player player) {
        if ( player == null ) {
            return null;
        }

        PlayerResponse playerResponse = new PlayerResponse();

        playerResponse.setId( player.getId() );
        playerResponse.setName( player.getName() );
        playerResponse.setAge( player.getAge() );
        playerResponse.setPosition( player.getPosition() );

        return playerResponse;
    }

    @Override
    public List<PlayerResponse> toResponseList(List<Player> players) {
        if ( players == null ) {
            return null;
        }

        List<PlayerResponse> list = new ArrayList<PlayerResponse>( players.size() );
        for ( Player player : players ) {
            list.add( toResponse( player ) );
        }

        return list;
    }
}
