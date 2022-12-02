package aoc_template;
import java.io.*;
import java.util.*;

public class Aoc_template {
    public static void main(String[] args) {
        
        List<String> my_play = new ArrayList<>();
        List<String> opp_play = new ArrayList<>();
        
        // Rock
        int score_rock = 1;
        
        // Paper
        int score_paper = 2;
        
        // Scissors
        int score_scissor = 3;
        
        // Score for win
        int score_win = 6;
        
        // Score for draw
        int score_draw = 3;
        
        // Score for lose
        int score_lose = 0;
        
        // Total score
        int total_score = 0;
        int total_score_two = 0;
        
        
        try  
        {  
            File file=new File("C:/aoc_input/02/input.txt");
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            StringBuffer sb=new StringBuffer();
            String line;  
            
            while((line=br.readLine())!=null)  
            {  
                String opponent_side = line.substring(0,1);
                String my_side = line.substring(2,3);
                my_play.add(my_side);
                opp_play.add(opponent_side);
            }
            fr.close();
        }  
        catch(IOException e)  
        {  
            e.printStackTrace();
        }
/////////////////////////////////////////// START PART 1 /////////////////////////////////////////////////////

/*
   My side

   X = ROCK
   Y = PAPER
   Z = SCISSORS

    Opponent side

   A = ROCK
   B = PAPER
   C = SCISSORS
*/
        for (int i = 0; i<my_play.size();i++) {
            switch(opp_play.get(i)) {
           
            case "A": // Rock
                if (my_play.get(i).equals("X")) {
                    // DRAW WITH ROCK 
                    total_score = total_score + score_rock + score_draw;
                }
                if (my_play.get(i).equals("Y")) {
                    // WIN WITH PAPER
                    total_score = total_score + score_paper + score_win;
                }
                    // LOSE WITH SCISSORS
                if (my_play.get(i).equals("Z")) {
                    total_score = total_score + score_scissor + score_lose;
                }
                break;
            
            case "B": // Paper
                if (my_play.get(i).equals("Y")){
                    // DRAW WITH PAPER
                    total_score = total_score + score_paper + score_draw;
                }
               if (my_play.get(i).equals("Z")) {
                    // WIN WITH SCISSORS
                    total_score = total_score + score_scissor + score_win;
                }
                    // LOSE WITH ROCK
                if (my_play.get(i).equals("X")) {
                    total_score = total_score + score_rock + score_lose;
                }
                break;
           
            case "C": // Scissors
                // Eqaul with scissors
                if (my_play.get(i).equals("Z")) {
                    total_score = total_score + score_scissor + score_draw;
                }
                // Win with rock
                if (my_play.get(i).equals("X")) {
                    total_score = total_score + score_rock + score_win;
                }
                // Lose with paper
                if (my_play.get(i).equals("Y")) {
                    total_score = total_score + score_paper + score_lose;
                }
                break;
            }
        }
        
       
/////////////////////////////////////////// END PART 1 //////////////////////////////////////////////////////

/////////////////////////////////////////// START PART 2 ////////////////////////////////////////////////////

/*
    If i get Y = draw
    If i get X = lose
    If i get Z = win

    My side
    X = ROCK
    Y = PAPER
    Z = SCISSORS

    Opponent side

    A = ROCK
    B = PAPER
    C = SCISSORS

*/
    
    
    for (int i = 0; i<my_play.size();i++){
        switch (my_play.get(i)) {
            case "Y": // Y = DRAW
                if (opp_play.get(i).equals("A")){
                    total_score_two = total_score_two + score_rock + score_draw;
                }
                if (opp_play.get(i).equals("B")) {
                    total_score_two = total_score_two + score_paper + score_draw;
                }
                if (opp_play.get(i).equals("C")){
                    total_score_two = total_score_two + score_scissor + score_draw;
                }
                break;
                
            
            case "X": // X = LOSE
                if (opp_play.get(i).equals("A")) {
                    total_score_two = total_score_two + score_lose + score_scissor;
                }
                if (opp_play.get(i).equals("B")){
                    total_score_two = total_score_two + score_lose + score_rock;
                }
                
                if (opp_play.get(i).equals("C")) {
                    total_score_two = total_score_two + score_lose + score_paper;
                }
                break;
                
            
            case "Z": // Z = WIN
                if ((opp_play.get(i).equals("A"))) {
                    total_score_two = total_score_two + score_paper + score_win;
                }
                if (opp_play.get(i).equals("B")) {
                    total_score_two = total_score_two + score_scissor + score_win;
                }
                if (opp_play.get(i).equals("C")) {
                    total_score_two = total_score_two  + score_rock + score_win;
                }
                break;
        }
    }
    /////////////////////////////////////////// END PART 2 /////////////////////////////////////////////////////
    
    // Print the scores
    System.out.println("Score part 1: " + total_score);
    System.out.println("Score part 2: " + total_score_two);
    }  

}
