package com.example.main.controllers;

import com.example.main.dao.PlayerDAO;
import com.example.main.models.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class HomeController {
    private final PlayerDAO playerDAO;

    @Autowired
    public HomeController(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @GetMapping("/")
    public String newPerson(@ModelAttribute("player") Player player, Model model){
        model.addAttribute("teams", playerDAO.teams());
        return "home";
    }

    @GetMapping("/players")
    public String index(Model model){
        model.addAttribute("players", playerDAO.index());
        return "players";
    }

    @GetMapping("/players/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("player", playerDAO.show(id));
        return "edit";
    }

    @PatchMapping("/players/{id}")
    public String update(@ModelAttribute("player") Player player, @PathVariable("id") int id){
        playerDAO.update(id, player);
        log.info("Update info about player: " + player);
        return "redirect:/players";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("player") Player player){
        playerDAO.save(player);
        log.info("Create new player: " + player);
        return "redirect:/";
    }

    @DeleteMapping("/players/{id}")
    public String delete(@PathVariable("id") int id){
        log.info("Delete player: " + playerDAO.show(id));
        playerDAO.delete(id);
        return "redirect:/players";
    }
}
