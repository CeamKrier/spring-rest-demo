package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Alien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * AlienDao
 */
public interface AlienDao extends JpaRepository<Alien, Integer> {

  /**
   * As long as the convention below has followed, the JPA will automatically handle the retrieval logic of the query
   * 
   * start with -> findBy/getBy
   * then       -> the property name that you want to use in the query
   * then       -> operation: GreaterThan/LessThan
   * 
   * check for more options: https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
   */

  List<Alien> findByAidGreaterThan(int aid);

  @Query("from Alien where aid >= ?1 order by aid desc")
  List<Alien> findByIdGreaterThanSorted(int aid);
  
}