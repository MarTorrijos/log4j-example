package user;

public record UserMessage() {

    public static final String USER_ALREADY_REGISTERED =
            "*******************************************************************************\n" +
                    "That user’s already in the game ⚡\uFE0F, try a different one \uD83E\uDD14, don’t get stuck! \uD83D\uDE80 \n" +
                    "*******************************************************************************\n";

    public static final String INVALID_CREDENTIALS =
            "****************************************************************\n" +
                    "| Yo, those creds ain’t legit \uD83D\uDE15, double-check and try again! |\n" +
                    "****************************************************************\n";

    public static final String LOGIN_SUCCESS =
            "----------------------\n" +
                    "Boom! You’re in! \uD83D\uDCA5✅\n" +
                    "----------------------\n";

    public static final String REGISTER_SUCCESS =
            "------------------------------------\n" +
                    "Boom! You just joined the crew \uD83D\uDCA5\uD83D\uDE4C\n" +
                    "------------------------------------\n";

}