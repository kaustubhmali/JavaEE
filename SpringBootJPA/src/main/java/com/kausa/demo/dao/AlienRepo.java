package com.kausa.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.kausa.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{
	
}
