package net.smallacademy.myprivatedoc;
public class Users {
    public String username;
    public String password;
    public String id_number;

    Users(String username, String password, String id_number) {
        this.username = username;
        this.password = password;
        this.id_number = id_number;
    }

    boolean validPassword() {
        if (password.length() < 8 || password.length() > 10)
            return false;
        boolean flag_num = false, flag_char = false, flag_sign = false;
        for (char c : password.toCharArray()) {
            if (c >= '0' && c <= '9')
                flag_num = true;
            else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                flag_char = true;
            else {
                flag_sign = true;
            }
        }
        if (flag_num && flag_char && flag_sign)
            return true;
        return false;
    }

    boolean validName() {
        if (username.length() < 6 || username.length() > 8)
            return false;
        boolean flag_char = false, flag_sign = false;
        int digits=0;
        for (char c : username.toCharArray()) {
            if (c >= '0' && c <= '9')
                digits++;
            else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                flag_char = true;
            else {
                flag_sign = true;
            }
        }
        if (digits<=2 && flag_char && !flag_sign)
            return true;
        return false;
    }
    boolean validID() {
        boolean flag_num = false, flag_char = false, flag_sign = false;
        for (char c : id_number.toCharArray()) {
            if (c >= '0' && c <= '9')
                flag_num = true;
            else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                flag_char = true;
            else {
                flag_sign = true;
            }
        }
        if (flag_num && !flag_char && !flag_sign)
            return true;
        return false;
    }
}
