package HW9;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class CompareDistinctCategoryHands {
   public static void main(String[] args) {
      int p1wins = 0;
      try {
         for (String line : Files.readAllLines(Paths.get("distinctHandPairs.txt"))) {
            Hand hand1 = new Hand(line.substring(0, 14));
            Hand hand2 = new Hand(line.substring(14, 29).trim());

            hand1.getRankFrequency();
            //decending order
            Integer arr1[] = hand1.getCardRanks();
            Integer arr2[] = hand2.getCardRanks();

            
            
            if (hand1.getHandValue() > hand2.getHandValue()) {
               System.out.println("Player 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
                     ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                     ")\n\t\t\t    Player 1 wins.\n");
               p1wins++;
            } else if (hand1.getHandValue() < hand2.getHandValue())
               System.out.println("Player 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
                     ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                     ")\n\t\t\t    Player 2 wins.\n");
            else if (hand1.getHandValue() == hand2.getHandValue() && Arrays.compare(arr1,arr2) == 1) {
            	System.out.println("Player 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
                        ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                        ")\n\t\t\t    Player 1 wins.\n");
                  p1wins++;
            }
            else if(hand1.getHandValue() == hand2.getHandValue() && Arrays.compare(arr1,arr2) != 1){
                    System.out.println("Player 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
                            ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                            ")\n\t\t\t    Player 2 wins.\n");
            }
            else
               System.out.println("Player 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
                     ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                     ")\n\t\t\t\t Tie.\n");
                     
         }
         System.out.println("Number of hands won by player 1: " + p1wins);
      } catch (Exception e) {
         System.out.println(e);
      }
   }

}
