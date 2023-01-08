package com.example.main.dao;

import com.example.main.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PlayerDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PlayerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Player> index() {
        return jdbcTemplate.query("SELECT * FROM Players", new BeanPropertyRowMapper<>(Player.class));
    }

    public void save(Player player) {
        jdbcTemplate.update("INSERT INTO Players VALUES(default, ?, ?, ?, ?, ?, ?)",
                player.getName(), player.getSurname(), player.getSex(),
                player.getBirthDay(), player.getTeam(), player.getCountry());
    }

    public Player show(int id) {
        return jdbcTemplate.query("SELECT * FROM Players WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Player.class)).stream().findAny().orElse(null);
    }

    public void update(int id, Player updatedPlayer) {
        jdbcTemplate.update("UPDATE Players SET name=?, surname=?, sex=?, birthDay=?, team=?, country=? WHERE id=?",
                updatedPlayer.getName(), updatedPlayer.getSurname(), updatedPlayer.getSex(), updatedPlayer.getBirthDay(),
                updatedPlayer.getTeam(), updatedPlayer.getCountry(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Players WHERE id=?", id);
    }

    public List<String> teams(){
        return jdbcTemplate.queryForList("SELECT team FROM Players GROUP BY team", String.class);
    }
}
