package com.streamcollector.processdata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.streamcollector.entity.Country;
import com.streamcollector.entity.Player;

public class PlayerDataProcess {
	
	private static List<Player> players;
	static {
		
		
		Country india = new Country(1, "India");
		Country england = new Country(2, "England");
		Country australia = new Country(4, "Australia");
		
		players = new ArrayList<Player>();
		players.add(new Player("Kohli", 120, 93888, 220, india));
		players.add(new Player("Rohit", 88, 20388, 230, india));
		players.add(new Player("Ricky", 90, 30337, 160, australia));
		players.add(new Player("Sachin", 203, 44348, 244, india));
		players.add(new Player("Flintoff", 245, 20328, 180, england));
		players.add(new Player("Hayden", 128, 38348, 178, australia));
		players.add(new Player("dhoni", 76, 29372, 150, india));
		players.add(new Player("Morgan", 121, 10230, 145, england));
		players.add(new Player("Gilchrist", 80, 32111, 192, australia));
		
		
	}

	public Map<String, List<Player>> getPlayersByCountry() {
		Map<String, List<Player>> playerByCountry = players.stream().collect(Collectors.groupingBy(p -> p.getCountry().getCountryName()));
	        return playerByCountry;
	}

	public Map<String, List<Player>> getPlayersNameByCountry() {
		Map<String, List<Player>> playerNameByCountry = players.stream().filter(p->p.getMatchesPlayed()>100).collect(Collectors.groupingBy(p -> p.getCountry().getCountryName()));
		return playerNameByCountry;
	}

	public Map<String, Integer> getTotalRunsByCountry() {
		Map<String, Integer> totalRunByCountry = players.stream().collect(Collectors.groupingBy(p -> p.getCountry().getCountryName(),
				Collectors.summingInt(p->p.getRuns())
				));
		
			return totalRunByCountry;
	}
	
	public Map<String, Long> getTotalPlayerByCountry() {
		LinkedHashMap<String, Long> totalPlayerByCountry = players.stream().collect(Collectors.groupingBy(p -> p.getCountry().getCountryName(),
				LinkedHashMap::new, Collectors.counting())
				);
		
			return totalPlayerByCountry;
	}
	
	public Map<String, Optional<Player>> getMaxScoreByCountry() {
		Map<String, Optional<Player>> totalPlayerByCountry = players.stream().collect(Collectors.groupingBy(p -> p.getCountry().getCountryName(),
				Collectors.maxBy(Comparator.comparing(p->p.getHighestScore())))
				);
		
			return totalPlayerByCountry;
	}
	
	
}
