package com.bilous.BK_LMS_diploma.presentation.views;

import com.bilous.BK_LMS_diploma.domain.Student;
import com.bilous.BK_LMS_diploma.domain.Teacher;
import com.bilous.BK_LMS_diploma.domain.User;
import com.bilous.BK_LMS_diploma.presentation.Command;
import com.bilous.BK_LMS_diploma.presentation.CommandDispatcher;
import com.bilous.BK_LMS_diploma.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;


public class StartViewDispatcher extends CommandDispatcher {


    private static final Logger log = LogManager.getLogger(StartViewDispatcher.class);
    private static final String SUPERPASS;

    static {
        SUPERPASS = "kek";
    }

    private final UserService userService;


    public StartViewDispatcher(UserService userService) {
        super(Arrays.asList(Command.REGISTER, Command.LOGIN));
        this.userService = userService;

    }

    @Override
    public void executeCommand(Command command) {
        switch (command) {
            case REGISTER:
                executeRegister();
                break;
            case LOGIN:
                executeLogin();
                break;
            default:
                executeRootCommand(command);


        }

    }


    private void executeRegister() {
        User newUser;
        String role;
        String lastName;
        String firstName;
        LocalDate dateOfBirth;
        String login;
        String password;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            log.info("Please enter your role (S - student, T - teacher, P - personnel...)");
            String input = scanner.next();
            if (parseCommandStringInput(input).isPresent()) {
                executeRootCommand(parseCommandStringInput(input).get());
                return;
            }

            if (validateRoleChoice(input)) {
                role = input;
                break;

            }
            log.warn("Choose your role from provided options");

        }
        while (true) {
            log.info("Please enter your last name");
            String input = scanner.next();
            if (parseCommandStringInput(input).isPresent()) {
                executeCommand(parseCommandStringInput(input).get());
                return;
            }
            if (!input.isEmpty()) {
                lastName = input;
                break;
            }
        }
        while (true) {
            log.info("Please enter your first name");
            String input = scanner.next();
            if (parseCommandStringInput(input).isPresent()) {
                executeCommand(parseCommandStringInput(input).get());
                return;
            }
            if (!input.isEmpty()) {
                firstName = input;
                break;
            }
        }

        while (true) {
            log.info("Please enter your DOB");
            String input = scanner.next();
            if (parseCommandStringInput(input).isPresent()) {
                executeCommand(parseCommandStringInput(input).get());
                return;
            }
            if (checkMarhcesDateFormat(input)) {
                dateOfBirth = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            }
        }
        while (true) {
            log.info("Please enter your login");
            String input = scanner.next();
            if (parseCommandStringInput(input).isPresent()) {
                executeCommand(parseCommandStringInput(input).get());
                return;
            }
            if (!input.isEmpty()) {
                login = input;
                break;
            }
        }

        while (true) {
            log.info("Please enter your pass");
            String input = scanner.next();
            if (parseCommandStringInput(input).isPresent()) {
                executeCommand(parseCommandStringInput(input).get());
                return;
            }
            if (input.isEmpty()) {
                log.warn("Enter valid pass");
                continue;
            } else {
                password = input;
            }
            log.info("Please enter your password again");
            input = scanner.next();
            if (parseCommandStringInput(input).isPresent()) {
                executeCommand(parseCommandStringInput(input).get());
                return;

            }
            if(input.isEmpty() || !password.equals(input)) {
                log.warn("SAD! Password does nor much, try again!");
                continue;
            }
            break;
    }
        if (role.equalsIgnoreCase("admin") || role.equals("P")) {
            int i = 0;
            while (i < 3) {
                log.info("You are trying to create an admin pass or personnel. Enter a password created by root ");
                String input = scanner.next();
                if (parseCommandStringInput(input).isPresent()) {
                    executeCommand(parseCommandStringInput(input).get());
                    return;
                }
                if (SUPERPASS.equals(input)) {
                    log.info("hi, admin");
                    break;
                }else{
                log.warn("Wrong superpass");
                log.info(i + " attempts left");
                i++;}
            }
            if (i == 4) {
                return;
            }
            executeHelp();

        }


        if ("S".equalsIgnoreCase(role)) {
            newUser = userService.createUser(new Student(firstName, lastName, dateOfBirth),
                    login,
                    password);
        } else if ("T".equalsIgnoreCase(role)) {
            newUser = userService.createUser(new Teacher(firstName, lastName, dateOfBirth), login,
                    password);
        } else {
            log.error("Could not register a new account");
        }
        log.info("A new user register");

    }


    private boolean validateRoleChoice(String input) {
        return input.equalsIgnoreCase("S") ||
                input.equalsIgnoreCase("T") ||
                input.equalsIgnoreCase("P") ||
                input.equalsIgnoreCase("admin");

    }

    private boolean checkMarhcesDateFormat(String input) {
        try {
            LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            log.warn("Enter date in provided format");
            return false;
        }

    }

    private void executeLogin() {
        String login;
        String password;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            log.info("Please enter your login");
            String input = scanner.next();
            if (parseCommandStringInput(input).isPresent()) {
                executeCommand(parseCommandStringInput(input).get());
                return;
            }
            if (!input.isEmpty()) {
                login = input;
                break;
            }

        }
        while (true) {
            log.info("Please enter your password");
            String input = scanner.next();
            if (parseCommandStringInput(input).isPresent()) {
                executeCommand(parseCommandStringInput(input).get());
                return;
            }
            if (!input.isEmpty()) {
                password = input;
                break;
            }
        }

      /*  User user = userService.getByLogin(login);
        if (user.isPresent){
           if (user.get().getPassword.equals(password)) {
               log.info("Hello {} ! You can start your work with LMS!", user.get().getFirstName());
               //sessionService.startSession(user.get());

           }
        }else{
            log.info("SAD! Logim or password is wrong, please try again");
            executeLogin();
        }*/
    }


}
