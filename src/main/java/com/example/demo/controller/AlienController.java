package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.AlienDao;
import com.example.demo.model.Alien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * AlienController
 */
@RestController
public class AlienController {

  /**
   * Using the RestController annotation will help us to not write @ResponseBody on top of the each function again and again.
   * 
   * With new spring version (dunno which but mentioned it at the video) the @RequestMapping annotation fragmented into @GetMapping and @PostMapping
   */

  @Autowired
  AlienDao dao;

  @RequestMapping("/")
  public String home() {
    return "home.jsp";
  }

  @RequestMapping("/addAlien")
  public String addAlien(Alien alien) {
    dao.save(alien);
    return "home.jsp";
  }

  @RequestMapping("/getAlien")
  public ModelAndView getAlien(@RequestParam int aid) {
    ModelAndView mv = new ModelAndView("showAlien.jsp");
    Alien alien = dao.findById(aid).orElse(null);

    System.out.println(dao.findByAidGreaterThan(aid));
    System.out.println(dao.findByIdGreaterThanSorted(aid));
    mv.addObject("alien", alien);
    return mv;
  }

  @GetMapping("/aliens")
  public List<Alien> getAliens() {
    return dao.findAll();
  }

  @GetMapping("/alien/{aid}")
  public Optional<Alien> getAlienById(@PathVariable("aid") int aid) {
    return dao.findById(aid);
  }

  @PostMapping("/alien")
  public Alien addAlienViaPost(Alien alien) {
    dao.save(alien);
    return alien;
  }

  @DeleteMapping("/alien/{aid}")
  public String deleteAlienViaPost(@PathVariable("aid") int aid) {
    
    Alien alien = dao.getOne(aid);

    dao.delete(alien);
    return "Deleted";
  }

  @PutMapping("/alien")
  public Alien updateAlienViaPost(@RequestBody Alien alien) {
    
    dao.save(alien);
    return alien;
  }
}