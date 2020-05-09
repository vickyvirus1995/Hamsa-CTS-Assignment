import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.streamcollector.entity.Player;
import com.streamcollector.processdata.PlayerDataProcess;

public class StreamCollectorExcercise {

	public static void main(String[] args) {
		
		PlayerDataProcess playerDataProcess = new PlayerDataProcess();
		

		System.out.println("Displaying data of Players By Country\n");
		Map<String,List<Player>> playerByCountry = playerDataProcess.getPlayersByCountry();
		playerByCountry.entrySet().stream().forEach(s -> {
	    	System.out.println("Country : "+ s.getKey());
	    	System.out.println("Name   "+ "     MatchesPlayed" + "     HighestScore " + "     Runs");
	    	s.getValue().
	    	stream().forEach(player->System.out.println( player.getPlayerName()+"       "
	    	+player.getMatchesPlayed()+"               "+player.getHighestScore()+"           "+player.getRuns()));
	    System.out.println();
	    }
	    );
		
	    /**Or use this one hamsa  
		
		playerByCountry.entrySet().stream().forEach(s -> 
	    	System.out.println("Country : "+ s.getKey()+"  " +s.getValue())
				);
		**/
		
	    System.out.println("Player who have played more than 100 matches\n");
	    
	    Map<String,List<Player>> playerNameByCountry = playerDataProcess.getPlayersNameByCountry();
	    playerNameByCountry.entrySet().stream().forEach(s -> {
	    	System.out.println("Country : "+ s.getKey());
	    	System.out.println("Name   "+ "     MatchesPlayed" + "     HighestScore " + "     Runs");
	    	s.getValue().
	    	stream().forEach(player->System.out.println( player.getPlayerName()+"       "
	    	+player.getMatchesPlayed()+"               "+player.getHighestScore()+"           "+player.getRuns()));
	    System.out.println();
	    }
	    );
	    
	    /**Or use this one hamsa  
		
		playerNameByCountry.entrySet().stream().forEach(s -> 
	    	System.out.println("Country : "+ s.getKey()+"  " +s.getValue())
				);
		**/
		
	    
	    System.out.println("Total Run by Player in Country\n");
	    
	    Map<String,Integer> totalRunByCountry = playerDataProcess.getTotalRunsByCountry();
	    totalRunByCountry.entrySet().forEach(total->System.out.println(total));
	   
	    System.out.println("\nTotal Player in Country\n");
	    
	    Map<String,Long> totalPlayerByCountry = playerDataProcess.getTotalPlayerByCountry();
	    totalPlayerByCountry.entrySet().forEach(total->System.out.println(total));
	
	    System.out.println("\nMax Score by Player in Country\n");
	    Map<String, Optional<Player>> maxScoreByCountry = playerDataProcess.getMaxScoreByCountry();
	    maxScoreByCountry.entrySet().stream().forEach(s ->{ 
	    	System.out.println("Country : "+ s.getKey() +" "+s.getValue().get().getRuns());
		    System.out.println();
	    }
	    		);
	
	   
	}

    
}
