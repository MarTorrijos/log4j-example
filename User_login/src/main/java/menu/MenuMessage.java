package menu;

public record MenuMessage() {

    public static final String OPTIONS =
             "===  YO! WELCOME TO YOUR FAVE APP \uD83E\uDD19 === \n" +
             "________________________________________\n" +
             "1. Register\n" +
             "2. Log in\n" +
             "3. Exit\n" +
             "________________________________________\n" +
             "Pick an option, fam \uD83D\uDE0E\uD83D\uDC49";

    public static final String ENTER_NAME =
            "Enter username: ";

    public static final String ENTER_PASS =
            "Enter password: ";

    public static final String INVALID_OPTION =
            "*****************************************\n" +
            "| Oof! Not a valid move \uD83D\uDEAB\uD83C\uDFAE Try again! |\n" +
            "*****************************************\n";

    public static final String EXIT =
            "---------------------------\n" +
            "| See ya! Stay awesome! 🤘 |\n" +
            "---------------------------\n";


}
