package ss8_clean_code.excercise.excercise1;

public class TennisGame {
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static String getScore(int firstPlayerScore, int secondPlayerScore) {
        String score = "";
        int tempScore = 0;
        if (firstPlayerScore == secondPlayerScore) {
            score += result(firstPlayerScore);
        } else if (firstPlayerScore >= 4 || secondPlayerScore >= 4) {
            return win(firstPlayerScore, secondPlayerScore);
        }
        return currentScore(firstPlayerScore, secondPlayerScore, score);
    }

    /**
     * @param playerScore : điểm số của người chơi ( trong trường hợp điểm 2 người chơi bằng nhau)
     * @return điểm số của người chơi theo cách gọi trong Tennis.
     */
    public static String result(int playerScore) {
        switch (playerScore) {
            case LOVE:
                return "Love-All";
            case FIFTEEN:
                return "Fifteen-All";
            case THIRTY:
                return "Thirty-All";
            case FORTY:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    /**
     * @param firstPlayerScore:  điểm số của người chơi thứ nhất
     * @param secondPlayerScore: điểm số của người chơi thứ hai
     * @return lợi thể hoặc thông báo chiến thắng cho một trong hai người chơi
     */
    public static String win(int firstPlayerScore, int secondPlayerScore) {
        int minusResult = firstPlayerScore - secondPlayerScore;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    /**
     * @param firstPlayerScore:  điểm số của người chơi thứ nhất
     * @param secondPlayerScore: điểm số của người chơi thứ hai
     * @param score:             điểm ghi được hiện tại
     * @return điểm ghi được hiện tại
     */
    public static String currentScore(int firstPlayerScore, int secondPlayerScore, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = firstPlayerScore;
            } else {
                score += "-";
                tempScore = secondPlayerScore;
            }
            switch (tempScore) {
                case LOVE:
                    score += "Love";
                    break;
                case FIFTEEN:
                    score += "Fifteen";
                    break;
                case THIRTY:
                    score += "Thirty";
                    break;
                case FORTY:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }
}
