package com.codegym;

public class TennisGame {

    public static final String LOVEALL = "Love-All";
    public static final String FIFTEENALL = "Fifteen-All";
    public static final String THIRTYALL = "Thirty-All";
    public static final String FORTYALL = "Forty-All";
    public static final String DEUCE = "Deuce";
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String ADVANTAGEPLAYER1 = "Advantage player1";
    public static final String ADVANTAGEPLAYER2 = "Advantage player2";
    public static final String WINFORPLAYER1 = "Win for player1";
    public static final String WINFORPLAYER2 = "Win for player2";

    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        String score = "";
        if (scorePlayer1 == scorePlayer2) {
            score = getStringPlayerSameScore(scorePlayer1);
        } else {
            boolean scorePlayerMoreThan4 = scorePlayer1 >= 4 || scorePlayer2 >= 4;
            if (scorePlayerMoreThan4) {
                score = getStringPlayerOtherScore(scorePlayer1, scorePlayer2);
            } else {
                score = getStringScore(scorePlayer1, scorePlayer2, score);
            }
        }
        return score;
    }

    private static String getStringPlayerSameScore(int scorePlayer1) {
        String score;
        switch (scorePlayer1) {
            case 0:
                score = LOVEALL;
                break;
            case 1:
                score = FIFTEENALL;
                break;
            case 2:
                score = THIRTYALL;
                break;
            case 3:
                score = FORTYALL;
                break;
            default:
                score = DEUCE;
                break;
        }
        return score;
    }

    private static String getStringPlayerOtherScore(int scorePlayer1, int scorePlayer2) {
        String score;
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult == 1) score = ADVANTAGEPLAYER1;
        else if (minusResult == -1) score = ADVANTAGEPLAYER2;
        else if (minusResult >= 2) score = WINFORPLAYER1;
        else score = WINFORPLAYER2;
        return score;
    }

    private static String getStringScore(int scorePlayer1, int scorePlayer2, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = scorePlayer1;
            }
            else {
                score += "-";
                tempScore = scorePlayer2;
            }
            switch (tempScore) {
                case 0:
                    score += LOVE;
                    break;
                case 1:
                    score += FIFTEEN;
                    break;
                case 2:
                    score += THIRTY;
                    break;
                case 3:
                    score += FORTY;
                    break;
            }
        }
        return score;
    }
}