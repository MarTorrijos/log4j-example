package menu;

import user.User;
import user.UserManager;

import java.util.Scanner;

public class MenuManager {

    private final UserManager userManager;
    private final Scanner scan;

    public MenuManager(){
        this.userManager = new UserManager();
        this.scan = new Scanner(System.in);
    }

    public void showMainMenu(){
        String option;

        do{
            System.out.println(MenuMessage.OPTIONS);
            option = scan.nextLine();
            showSubMenu(option);

        } while(!option.equalsIgnoreCase("3"));

        scan.close();
    }

    private void showSubMenu(String option){
        switch (option){
            case "1" -> menuRegister();
            case "2" -> menuLog();
            case "3" -> exitApp();
            default -> System.out.println(MenuMessage.INVALID_OPTION);
        }
    }

    private void menuRegister(){
        String name = requestUserName();
        String pass = requestPassword();
        userManager.saveUser(new User(name, pass));
    }

    private void menuLog(){
        String name = requestUserName();
        String pass = requestPassword();
        userManager.validateUser(name, pass);
    }

    private void exitApp(){
        System.out.println(MenuMessage.EXIT);
    }

    private String requestUserName(){
        System.out.println(MenuMessage.ENTER_NAME);
        return scan.nextLine();
    }

    private String requestPassword(){
        System.out.println(MenuMessage.ENTER_PASS);
        return scan.nextLine();
    }

}