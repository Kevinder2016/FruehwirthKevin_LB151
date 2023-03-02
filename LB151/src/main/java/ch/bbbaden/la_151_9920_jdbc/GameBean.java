package ch.bbbaden.la_151_9920_jdbc;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "gameBean")
@SessionScoped
public class GameBean implements Serializable {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/wordgame";
    private static final String DB_USERNAME = "Kevin";
    private static final String DB_PASSWORD = "Kevinmatias";
    
    private static final int MAX_PHRASES = 10;
    private List<String> usedPhrases = new ArrayList<>(); // Liste der verwendeten Phrasen
    private static final int MAX_TRIES = 3;
    private static final int COINS_PER_LETTER = 100;
    
        private Set<Character> guessedLetters = new HashSet<>();

    private String highscoreMessage = "";
    private String isLetterEqualMessage = "";
    private String spielername;
    private String category;
    private String phrase;
    private String letterInput;
    private String phraseHidden;
    private int triesLeft = MAX_TRIES;
    private int coins;
    private int spielrunden = 1;
    private boolean highscoreInsertedSuccessfully = false;


    public void generateRandom() throws SQLException {
    if (usedPhrases.size() == MAX_PHRASES) {
        return; // alle Phrasen wurden bereits verwendet
    }

    Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    String phraseQuery = "SELECT phrase.phrase, kategorie.name "
            + "FROM phrase "
            + "JOIN kategorie ON phrase.kategorie_id = kategorie.id ";

    if (!usedPhrases.isEmpty()) {
        phraseQuery += "WHERE NOT phrase.phrase IN (" + String.join(",", Collections.nCopies(usedPhrases.size(), "?")) + ") ";
    }

    phraseQuery += "ORDER BY RAND() LIMIT 1";

    PreparedStatement phraseStmt = conn.prepareStatement(phraseQuery);

    int index = 1;
    for (String usedPhrase : usedPhrases) {
        phraseStmt.setString(index++, usedPhrase);
    }

    ResultSet phraseResult = phraseStmt.executeQuery();

    if (phraseResult.next()) {
        String phraseText = phraseResult.getString("phrase");
        usedPhrases.add(phraseText); // Hinzufügen der Phrase zur Liste der verwendeten Phrasen
        StringBuilder sb = new StringBuilder();
        StringBuilder sbHidden = new StringBuilder();
        for (char c : phraseText.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append("_ ");
                sbHidden.append(c); // nur den Buchstaben hinzufügen
            } else {
                sb.append("   ");
                sbHidden.append("   ");
            }
        }
        phrase = sb.toString().trim();
        phraseHidden = sbHidden.toString().trim();
        category = phraseResult.getString("name");
    }

    spielrunden++;
    phraseResult.close();
    phraseStmt.close();
    conn.close();

    guessedLetters.clear();
    }

    public void guessLetter() {
    char letter = letterInput.toLowerCase().charAt(0);

    // Check if the letter has already been guessed
    if (guessedLetters.contains(letter)) {
        return;
    }

    guessedLetters.add(letter); // Add the guessed letter to the set

    StringBuilder sb = new StringBuilder();
    boolean letterFound = false;
    boolean isLetterEqual = false;
    for (int i = 0; i < phraseHidden.length(); i++) {
        char c = phraseHidden.charAt(i);
        if (Character.isLetter(c) && Character.toLowerCase(c) == letter) {
            sb.append(letter).append(" ");
            letterFound = true;
            isLetterEqual = true;
        } else {
            if (2 * i < phrase.length()) {
                sb.append(phrase.charAt(2 * i)).append(" ");
                if (Character.toLowerCase(phrase.charAt(2 * i)) == letter) {
                    isLetterEqual = true;
                }
            }
        }
    }
    if (letterFound) {
        coins += COINS_PER_LETTER; // hinzufügen von coins
    } else {
        decreaseTriesLeft();
        if (triesLeft == 0) {
            resetPlayer();
        }
    }
    phrase = sb.toString().trim();

    // Check if the guessed letter is equal to a letter in the phrase
    if (isLetterEqual) {
        isLetterEqualMessage = "Die Antwort war Richtig";
    } else {
        isLetterEqualMessage = "Die Antwort war Falsch, du bekommst 1 Leben abgezogen";
    }
}

    
    public void insertHighscore() throws SQLException {
    Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    PreparedStatement stmt = conn.prepareStatement("INSERT INTO highscore (spielername, betrag, spielrunden) VALUES (?, ?, ?)");
    stmt.setString(1, spielername);
    stmt.setDouble(2, coins);
    stmt.setInt(3, spielrunden);
    int rowsInserted = stmt.executeUpdate();
    stmt.close();
    conn.close();
    if (rowsInserted > 0) {
        highscoreInsertedSuccessfully = true;
        highscoreMessage = "Highscore inserted successfully!";
    } else {
        highscoreInsertedSuccessfully = false;
        highscoreMessage = "Error inserting highscore.";
    }
}



    private void decreaseTriesLeft() {
        triesLeft--;
    }

    private void resetTriesLeft() {
        triesLeft = MAX_TRIES;
    }

    public void resetPlayer() {
    if (triesLeft == 0) {
        triesLeft = MAX_TRIES;
        coins = 0;
        usedPhrases.clear();
    }
}
    public String getHighscoreMessage() {
        return highscoreMessage;
    }

    public void setHighscoreMessage(String highscoreMessage) {
        this.highscoreMessage = highscoreMessage;
    }
    
    public String getIsLetterEqualMessage() {
        return isLetterEqualMessage;
    }
    
    public String getSpielername() {
    return spielername;
    }
    
    public void setSpielername(String spielername) {
    this.spielername = spielername; 
    }
    


    public int getTriesLeft() {
        return triesLeft;
    }

    public String getCategory() {
        return category;
    }

    public String getPhrase() {
        return phrase;
    }

    public String getLetterInput() {
        return letterInput;
    }

    public void setLetterInput(String letterInput) {
        this.letterInput = letterInput;
    }

    public int getCoins() {
        return coins;
    }
    
}