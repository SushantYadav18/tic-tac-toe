package com.example.tictacgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, startButton;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int flag = 0; //
    int count = 0; // To count the number of moves
    boolean isGameActive = false; // To check if the game is started
    TextView footerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init(); // Initialize all buttons and views

        // Set up the Start Game button
        startButton.setOnClickListener(v -> startGame());
    }

    private void init() {
        // Initialize all buttons
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        startButton = findViewById(R.id.startButton);
        footerText = findViewById(R.id.footerText);

        // Set up listeners for game buttons
        setButtonListeners();
    }

    private void setButtonListeners() {
        View.OnClickListener gameListener = this::onButtonClick;
        btn1.setOnClickListener(gameListener);
        btn2.setOnClickListener(gameListener);
        btn3.setOnClickListener(gameListener);
        btn4.setOnClickListener(gameListener);
        btn5.setOnClickListener(gameListener);
        btn6.setOnClickListener(gameListener);
        btn7.setOnClickListener(gameListener);
        btn8.setOnClickListener(gameListener);
        btn9.setOnClickListener(gameListener);
    }

    public void startGame() {
        resetGame(); // Reset the game state
        isGameActive = true;
        Toast.makeText(this, "Game Started! X goes first.", Toast.LENGTH_SHORT).show();
    }

    public void onButtonClick(View view) {
        if (!isGameActive) {
            Toast.makeText(this, "Press 'Start Game' to begin!", Toast.LENGTH_SHORT).show();
            return;
        }

        Button currentButton = (Button) view;

        // If the button already has a value, return
        if (!currentButton.getText().toString().isEmpty()) {
            Toast.makeText(this, "Invalid Move!", Toast.LENGTH_SHORT).show();
            return;
        }

        count++; // Increment move count
        if (flag == 0) {
            currentButton.setText("X");
            flag = 1;
        } else {
            currentButton.setText("O");
            flag = 0;
        }

        // Check for a winner if moves are sufficient
        if (count >= 5) {
            checkWinner();
        }

        // If all buttons are filled and no winner, it's a draw
        if (count == 9 && isGameActive) {
            isGameActive = false;
            Toast.makeText(this, "It's a Draw!", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkWinner() {
        // Get button text values
        b1 = btn1.getText().toString();
        b2 = btn2.getText().toString();
        b3 = btn3.getText().toString();
        b4 = btn4.getText().toString();
        b5 = btn5.getText().toString();
        b6 = btn6.getText().toString();
        b7 = btn7.getText().toString();
        b8 = btn8.getText().toString();
        b9 = btn9.getText().toString();

        // Winning conditions
        if (checkLine(b1, b2, b3) || checkLine(b4, b5, b6) || checkLine(b7, b8, b9) || // Rows
                checkLine(b1, b4, b7) || checkLine(b2, b5, b8) || checkLine(b3, b6, b9) || // Columns
                checkLine(b1, b5, b9) || checkLine(b3, b5, b7)) { // Diagonals
            isGameActive = false;
            Toast.makeText(this, "Winner: " + (flag == 0 ? "O" : "X"), Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkLine(String s1, String s2, String s3) {
        return !s1.isEmpty() && s1.equals(s2) && s2.equals(s3);
    }

    private void resetGame() {
        // Clear all button texts
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        // Reset game state
        flag = 0;
        count = 0;
        isGameActive = false;
    }
}
//Start Button: Initiates the game and resets any previous state.
//Move Logic: Tracks moves alternately for X and O.
//Winning Conditions: Checks all rows, columns, and diagonals for a match.
//Reset Game: Clears the board and state when starting a new game.
//Draw Check: Alerts if all cells are filled without a winner.



//package com.example.tictacgame;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class MainActivity extends AppCompatActivity {
//    Button btn1,btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
//    String b1,b2,b3,b4, b5, b6, b7,b8,b9;
//    int flag =0;
//    int count =0;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        init();
//
//
//    }
//    private void init(){
//        btn1 = findViewById(R.id.btn1);
//        btn2 = findViewById(R.id.btn2);
//        btn3 = findViewById(R.id.btn3);
//        btn4 = findViewById(R.id.btn4);
//        btn5 = findViewById(R.id.btn5);
//        btn6 = findViewById(R.id.btn6);
//        btn7 = findViewById(R.id.btn7);
//        btn8 = findViewById(R.id.btn8);
//        btn9 = findViewById(R.id.btn9);
//
//    }
//    public void Check(View view){
//     Button btnCurrent = (Button) view;
//     count++;
//          if (flag==0){
//              btnCurrent.setText("X");
//              flag=1;
//          }
//          else {
//              btnCurrent.setText("O");
//              flag=0;
//          }
//if(count>4){
//
//    b1= btn1.getText().toString();
//    b2= btn2.getText().toString();
//    b3= btn3.getText().toString();
//    b4= btn4.getText().toString();
//    b5= btn5.getText().toString();
//    b6= btn6.getText().toString();
//    b7= btn7.getText().toString();
//    b8= btn8.getText().toString();
//    b9= btn9.getText().toString();
//}
//
//    }
//}