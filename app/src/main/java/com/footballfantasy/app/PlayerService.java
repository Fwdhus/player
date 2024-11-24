package com.footballfantasy.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class PlayerService {
    
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerMapper playerMapper;

    public PlayerResponse createPlayer(PlayerDTO playerDTO) {
        Player player = playerMapper.toEntity(playerDTO);
        player = playerRepository.save(player);
        return playerMapper.toResponse(player);
    }

    public List<PlayerResponse> getAllPlayers() {
        List<Player> players =  playerRepository.findAll();
        return playerMapper.toResponseList(players);
    }

    public PlayerResponse getPlayerById(Long id) {
        Player player =  playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: " + id));
        return playerMapper.toResponse(player);
    }

    public PlayerResponse updatePlayer(Long id, PlayerDTO updatedPlayer) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: " + id));
        
        player.setName(updatedPlayer.getName());
        player.setAge(updatedPlayer.getAge());
        player.setPosition(updatedPlayer.getPosition());
        
        player = playerRepository.save(player);
        return playerMapper.toResponse(player);
    }

    public void deletePlayer(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: " + id));
        
        playerRepository.delete(player);
    }
}
