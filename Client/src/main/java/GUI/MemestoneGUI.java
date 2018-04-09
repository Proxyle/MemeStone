package GUI;


import javafx.application.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.*;

import javax.swing.*;
import javax.swing.text.html.ImageView;

public class MemestoneGUI extends Application {
    //own elements
    ImageView ivHero;
    ImageView ivLeftMinion1;
    ImageView ivLveftMinion2;
    ImageView ivLeftMinion3;
    ImageView ivRightMinion1;
    ImageView ivRightMinion2;
    ImageView ivRightMinion3;
    Label lblLeftMinion1Attack;
    Label lblLeftMinion1Health;
    Label lblLeftMinion2Attack;
    Label lblLeftMinion2Health;
    Label lblLeftMinion3Attack;
    Label lblLeftMinion3Health;
    Label lblRightMinion1Attack;
    Label lblRightMinion1Health;
    Label lblRightMinion2Attack;
    Label lblRightMinion2Health;
    Label lblRightMinion3Attack;
    Label lblRightMinion3Health;

    ImageView ivHand1;
    ImageView ivHand2;
    ImageView ivHand3;
    ImageView ivHand4;
    ImageView ivHand5;
    ImageView ivHand6;
    ImageView ivHand7;
    Label lblHand1Attack;
    Label lblHand1Health;
    Label lblHand2Attack;
    Label lblHand2Health;
    Label lblHand3Attack;
    Label lblHand3Health;
    Label lblHand4Attack;
    Label lblHand4Health;
    Label lblHand5Attack;
    Label lblHand5Health;
    Label lblHand6Attack;
    Label lblHand6Health;
    Label lblHand7Attack;
    Label lblHand7Health;

    ProgressIndicator piHealth;
    ProgressIndicator piEnergy;

    //opponent elements
    ImageView ivLeftMinion1Opponent;
    ImageView ivLveftMinion2Opponent;
    ImageView ivLeftMinion3Opponent;
    ImageView ivRightMinion1Opponent;
    ImageView ivRightMinion2Opponent;
    ImageView ivRightMinion3Opponent;
    Label lblLeftMinion1AttackOpponent;
    Label lblLeftMinion1HealthOpponent;
    Label lblLeftMinion2AttackOpponent;
    Label lblLeftMinion2HealthOpponent;
    Label lblLeftMinion3AttackOpponent;
    Label lblLeftMinion3HealthOpponent;
    Label lblRightMinion1AttackOpponent;
    Label lblRightMinion1HealthOpponent;
    Label lblRightMinion2AttackOpponent;
    Label lblRightMinion2HealthOpponent;
    Label lblRightMinion3AttackOpponent;
    Label lblRightMinion3HealthOpponent;

    ImageView ivHand1Opponent;
    ImageView ivHand2Opponent;
    ImageView ivHand3Opponent;
    ImageView ivHand4Opponent;
    ImageView ivHand5Opponent;
    ImageView ivHand6Opponent;
    ImageView ivHand7Opponent;

    //neutral elements
    ImageView ivLeftBuff;
    ImageView ivRightBuff;
    Button btnMenu;
    Button btnEndTurn;
    Label lblTurnTimer;

    //submenu elements
    Button btnForfeit;
    Button btnOptions;
    Button btnQuit;

    public void start(Stage primaryStage) throws Exception {

    }
}
