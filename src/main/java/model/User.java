package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class User {

    int id;
    String name;
    String username;
    String password;
    Role role;
    BigDecimal balance;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String name, String username, String password, Role role, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\nUser Id: "+ id +
                "\nName: " + name +
                "\nbalance: " + balance +
                "\n- - - - - - - - - - - - ";
    }

    public static int currentId = 1;

    {
        currentId++;
    }


}
