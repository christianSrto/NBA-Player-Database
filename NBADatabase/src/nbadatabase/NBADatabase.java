/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nbadatabase;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author chris
 */
public class NBADatabase {

    /**
     * @param args the command line arguments
     */
    public static void getPlayerName(String url){
          Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        String query = "SELECT * FROM Players WHERE playerName = ?"; // Use ? as a placeholder

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, playerName); // Set user input into query
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) { // If a player is found
                System.out.println("Player Found:");
                System.out.println("ID: " + rs.getInt("playerID"));
                System.out.println("Name: " + rs.getString("playerName"));
                System.out.println("Position: " + rs.getString("position"));
                System.out.println("Height: " + rs.getDouble("height") + "ft");
                System.out.println("Weight: " + rs.getDouble("weight") + "lbs");
                System.out.println("Team ID: " + rs.getInt("teamID"));
            } else {
                System.out.println("No player found with that name.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    public static void getPlayerPosition(String url){
          Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        String query = "SELECT * FROM Players WHERE playerName = ?"; // Use ? as a placeholder

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, playerName); // Set user input into query
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) { // If a player is found
                System.out.println("Player Found:");
                System.out.println("Position: " + rs.getString("position"));
            } else {
                System.out.println("No player found with that name.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    public static void getPlayerHeight(String url){
          Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        String query = "SELECT * FROM Players WHERE playerName = ?"; // Use ? as a placeholder

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, playerName); // Set user input into query
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) { // If a player is found
                System.out.println("Player Found:");
                System.out.println("Height: " + rs.getString("height")+" ft");
            } else {
                System.out.println("No player found with that name.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    public static void getPlayerPointsPerGame(String url){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        String query = """
            SELECT ps.pointsPerGame, ps.seasonYear
            FROM PlayerStats ps
            JOIN Players p ON ps.playerID = p.playerID
            WHERE p.playerName = ?
            ORDER BY ps.seasonYear DESC;
        """;

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, playerName); // Set user input into query
            
            ResultSet rs = pstmt.executeQuery();
            
            boolean found = false;
            while (rs.next()) { // If there are results
                found = true;
                System.out.println("Season: " + rs.getInt("seasonYear") + 
                                   " | Points Per Game: " + rs.getDouble("pointsPerGame"));
            }

            if (!found) {
                System.out.println("No stats found for player: " + playerName);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    public static void getPlayerAssistsPerGame(String url){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        String query = """
            SELECT ps.assistsPerGame, ps.seasonYear
            FROM PlayerStats ps
            JOIN Players p ON ps.playerID = p.playerID
            WHERE p.playerName = ?
            ORDER BY ps.seasonYear DESC;
        """;

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, playerName); // Set user input into query
            
            ResultSet rs = pstmt.executeQuery();
            
            boolean found = false;
            while (rs.next()) { // If there are results
                found = true;
                System.out.println("Season: " + rs.getInt("seasonYear") + 
                                   " | Assists Per Game: " + rs.getDouble("assistsPerGame"));
            }

            if (!found) {
                System.out.println("No stats found for player: " + playerName);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    public static void getPlayerReboundsPerGame(String url){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        String query = """
            SELECT ps.reboundsPerGame, ps.seasonYear
            FROM PlayerStats ps
            JOIN Players p ON ps.playerID = p.playerID
            WHERE p.playerName = ?
            ORDER BY ps.seasonYear DESC;
        """;

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, playerName); // Set user input into query
            
            ResultSet rs = pstmt.executeQuery();
            
            boolean found = false;
            while (rs.next()) { // If there are results
                found = true;
                System.out.println("Season: " + rs.getInt("seasonYear") + 
                                   " | Rebounds Per Game: " + rs.getDouble("reboundsPerGame"));
            }

            if (!found) {
                System.out.println("No stats found for player: " + playerName);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    public static void getPlayerFgp(String url){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        String query = """
            SELECT ps.fieldGoalPercentage, ps.seasonYear
            FROM PlayerStats ps
            JOIN Players p ON ps.playerID = p.playerID
            WHERE p.playerName = ?
            ORDER BY ps.seasonYear DESC;
        """;

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, playerName); // Set user input into query
            
            ResultSet rs = pstmt.executeQuery();
            
            boolean found = false;
            while (rs.next()) { // If there are results
                found = true;
                System.out.println("Season: " + rs.getInt("seasonYear") + 
                                   " | Field Goal Percentage: " + rs.getDouble("fieldGoalPercentage"));
            }

            if (!found) {
                System.out.println("No stats found for player: " + playerName);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    public static void getPlayerTeam(String url){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        String query = """
            SELECT t.teamName, t.city
            FROM Players p
            JOIN Teams t ON p.teamID = t.teamID
            WHERE p.playerName = ?;
        """;

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, playerName); // Set user input into query
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) { // If the player has a team
                System.out.println(playerName + " currently plays for: the " + 
                                   rs.getString("city") + " " + rs.getString("teamName") + "");
            } else {
                System.out.println("No team found for player: " + playerName);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    } 
    
    public static void getCoachName(String url){
          Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Coaches first name: ");
        String firstName = scanner.nextLine();

        String query = "SELECT * FROM Coaches WHERE firstName = ?"; // Use ? as a placeholder

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, firstName); // Set user input into query
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) { // If a player is found
                System.out.println("Coach Found:");
                System.out.println("ID: " + rs.getInt("coachID"));
                System.out.println("Name: " + rs.getString("firstName")+ " "+rs.getString("lastName"));
                System.out.println("Wins: " + rs.getInt("wins"));
                System.out.println("Losses: " + rs.getInt("losses"));
                System.out.println("Win/Loss Ratio: " + rs.getDouble("winLossRatio"));
            } else {
                System.out.println("No coach found with that name.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    public static void getCoachWLRatio(String url){
          Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Coaches first name: ");
        String firstName = scanner.nextLine();

        String query = "SELECT * FROM Coaches WHERE firstName = ?"; // Use ? as a placeholder

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, firstName); // Set user input into query
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) { // If a player is found
                System.out.println("Coach Found:");
                System.out.println("Name: " + rs.getString("firstName")+ " "+rs.getString("lastName"));
                System.out.println("Wins: " + rs.getInt("wins"));
                System.out.println("Losses: " + rs.getInt("losses"));
                System.out.println("Win/Loss Ratio: " + rs.getDouble("winLossRatio"));
            } else {
                System.out.println("No coach found with that name.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    
    
    public static void main(String[] args) {
       
        
        //Change the location of the database-  jdbc:sqlite:NEW PATH 
        String url = "jdbc:sqlite:C:\\Users\\chris\\Documents\\GitHub\\ProjectDatabase\\project.db";
        
        
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("1 - Find Player stats by name");
        System.out.println("2 - Find a Player's position");
        System.out.println("3 - Find a Player's height by name");
        System.out.println("4 - Find a Player's points per game by name");
        System.out.println("5 - Find a Player's assists per game by name");
        System.out.println("6 - Find a Player's rebounds by name");
        System.out.println("7 - Find a Player's field goal percentage by name");
        System.out.println("8 - Find a Player's current team by name");
        System.out.println("9 - Find a Coaches's statistics by name");
        System.out.println("10 - Find a Coaches's win/loss ratio by name");
        System.out.println("Enter the number of which task you want to do");
        
        int task = scanner.nextInt();
        
        switch(task){
            case 1:
                getPlayerName(url);
                break;
            case 2:
                getPlayerPosition(url);
                break;
            case 3:
                getPlayerHeight(url);
                break;
            case 4:
                getPlayerPointsPerGame(url);
                break;
            case 5:
                getPlayerAssistsPerGame(url);
                break;
            case 6:
                getPlayerReboundsPerGame(url);
                break;  
            case 7:
                getPlayerFgp(url);
                break;
            case 8:
                getPlayerTeam(url);
                break;
            case 9:
                getCoachName(url);
                break;
            case 10:
                getCoachWLRatio(url);
                break;    
            default:
                System.out.println("\nPlease enter a valid task number:");
                break;
            
        }
    }
    
}
