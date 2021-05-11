package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User entry : users) {
            if (login.equals(entry.getUsername())) {
                result = entry;
                break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("Пользователь не найден.");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean result = user.isValid() && user.getUsername().length() >= 3;
        if (!result) {
            throw new UserInvalidException("У этого пользователя нет доступа.");
        }
        return result;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("ar", true),
                new User("user3217", false)
        };
        try {
            User user = findUser(users, "user2317");
            if (validate(user)) {
                System.out.println("У этого пользователя есть доступ.");
            }
        } catch (UserInvalidException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        } catch (UserNotFoundException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }
}
