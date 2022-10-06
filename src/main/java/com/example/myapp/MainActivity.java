package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Random r = new Random();
    private Button[] buttons = new Button[9];
    private Button resetGame;
    boolean activePlayer;
    int winPlayer = 0;
    int winCPU = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons[0] = (Button) findViewById(R.id.button0);
        buttons[1] = (Button) findViewById(R.id.button1);
        buttons[2] = (Button) findViewById(R.id.button2);
        buttons[3] = (Button) findViewById(R.id.button3);
        buttons[4] = (Button) findViewById(R.id.button4);
        buttons[5] = (Button) findViewById(R.id.button5);
        buttons[6] = (Button) findViewById(R.id.button6);
        buttons[7] = (Button) findViewById(R.id.button7);
        buttons[8] = (Button) findViewById(R.id.button8);
        resetGame = (Button) findViewById(R.id.button9);

        for (int i = 0; i < 9; i++) {
            buttons[i].setOnClickListener(this);
        }
        resetGame.setOnClickListener(this);
        activePlayer = true;
        resetGame.setText("restart");

    }

    @Override
    public void onClick(View v) {
        if (((Button) v).getText().equals("X") || ((Button) v).getText().equals("O")) {
            return;
        }
        if (((Button) v).getText().equals("restart")) {
            for (int i = 0; i < 9; i++) {
                buttons[i].setText("");
                buttons[i].setEnabled(true);
                buttons[i].setBackgroundColor(Color.parseColor("#8AAEDA"));
            }
            return;
        }
        if (activePlayer) {
            ((Button) v).setText("X");
            activePlayer = false;
        }
        //
        if (!isFull() && !activePlayer) {
            boolean esito = false;
            int n = 0;
            while (!esito) {
                n = r.nextInt(9);
                if (buttons[n].getText().equals("")) {
                    buttons[n].setText("O");
                    esito = true;
                }
            }
            activePlayer = true;
        }
        winner();
    }

    void winner() {
        if (buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) {
            buttons[0].setBackgroundColor(Color.parseColor("green"));
            buttons[1].setBackgroundColor(Color.parseColor("green"));
            buttons[2].setBackgroundColor(Color.parseColor("green"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winPlayer = winPlayer + 1;
        }
        if (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")) {
            buttons[3].setBackgroundColor(Color.parseColor("green"));
            buttons[4].setBackgroundColor(Color.parseColor("green"));
            buttons[5].setBackgroundColor(Color.parseColor("green"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winPlayer = winPlayer + 1;
        }
        if (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")) {
            buttons[6].setBackgroundColor(Color.parseColor("green"));
            buttons[7].setBackgroundColor(Color.parseColor("green"));
            buttons[8].setBackgroundColor(Color.parseColor("green"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winPlayer = winPlayer + 1;
        }
        if (buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")) {
            buttons[0].setBackgroundColor(Color.parseColor("green"));
            buttons[3].setBackgroundColor(Color.parseColor("green"));
            buttons[6].setBackgroundColor(Color.parseColor("green"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winPlayer = winPlayer + 1;
        }
        if (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) {
            buttons[1].setBackgroundColor(Color.parseColor("green"));
            buttons[4].setBackgroundColor(Color.parseColor("green"));
            buttons[7].setBackgroundColor(Color.parseColor("green"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winPlayer = winPlayer + 1;
        }
        if (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) {
            buttons[2].setBackgroundColor(Color.parseColor("green"));
            buttons[5].setBackgroundColor(Color.parseColor("green"));
            buttons[8].setBackgroundColor(Color.parseColor("green"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winPlayer = winPlayer + 1;
        }
        if (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) {
            buttons[0].setBackgroundColor(Color.parseColor("green"));
            buttons[4].setBackgroundColor(Color.parseColor("green"));
            buttons[8].setBackgroundColor(Color.parseColor("green"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winPlayer = winPlayer + 1;
        }
        if (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")) {
            buttons[2].setBackgroundColor(Color.parseColor("green"));
            buttons[4].setBackgroundColor(Color.parseColor("green"));
            buttons[6].setBackgroundColor(Color.parseColor("green"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winPlayer = winPlayer + 1;
        }
        if (buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) {
            buttons[0].setBackgroundColor(Color.parseColor("red"));
            buttons[1].setBackgroundColor(Color.parseColor("red"));
            buttons[2].setBackgroundColor(Color.parseColor("red"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winCPU=winCPU+1;
        }
        if (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")) {
            buttons[3].setBackgroundColor(Color.parseColor("red"));
            buttons[4].setBackgroundColor(Color.parseColor("red"));
            buttons[5].setBackgroundColor(Color.parseColor("red"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winCPU=winCPU+1;
        }
        if (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")) {
            buttons[6].setBackgroundColor(Color.parseColor("red"));
            buttons[7].setBackgroundColor(Color.parseColor("red"));
            buttons[8].setBackgroundColor(Color.parseColor("red"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winCPU=winCPU+1;
        }
        if (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")) {
            buttons[0].setBackgroundColor(Color.parseColor("red"));
            buttons[3].setBackgroundColor(Color.parseColor("red"));
            buttons[6].setBackgroundColor(Color.parseColor("red"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winCPU=winCPU+1;
        }
        if (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) {
            buttons[1].setBackgroundColor(Color.parseColor("red"));
            buttons[4].setBackgroundColor(Color.parseColor("red"));
            buttons[7].setBackgroundColor(Color.parseColor("red"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winCPU=winCPU+1;
        }
        if (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")) {
            buttons[2].setBackgroundColor(Color.parseColor("red"));
            buttons[5].setBackgroundColor(Color.parseColor("red"));
            buttons[8].setBackgroundColor(Color.parseColor("red"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winCPU=winCPU+1;
        }
        if (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) {
            buttons[0].setBackgroundColor(Color.parseColor("red"));
            buttons[4].setBackgroundColor(Color.parseColor("red"));
            buttons[8].setBackgroundColor(Color.parseColor("red"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winCPU = winCPU + 1;
        }
        if (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")) {
            buttons[2].setBackgroundColor(Color.parseColor("red"));
            buttons[4].setBackgroundColor(Color.parseColor("red"));
            buttons[6].setBackgroundColor(Color.parseColor("red"));
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            winCPU = winCPU + 1;
        }

    }

boolean isFull(){
        boolean esito=true;
        for(int i=0;i<9;i++){
            if(buttons[i].getText().equals("")){
                return false;
            }
        }

        return true;
}
}
