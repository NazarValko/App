package dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Users extends User{
    ArrayList<User> userList = new ArrayList<>();

    public Users(){
    }

    public Users(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<User> getUsers() {
        return userList;
    }

    public void setUsers(ArrayList<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + userList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return Objects.equals(userList, users1.userList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userList);
    }
}
