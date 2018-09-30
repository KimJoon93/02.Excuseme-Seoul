package joon.seoul.excusme.excusemeseoul;

import java.util.ArrayList;
import java.util.Objects;

public class Userdata {

    String email;
    String password;
    String name;
    String contextid;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getContextid() {
        return contextid;
    }

    public ArrayList<String> getLikecontents() {
        return likecontents;
    }

    ArrayList<String> likecontents;

    private Userdata(){

    }

    public Userdata(String email, String password, String name,String contextid, ArrayList<String> likecontents) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.contextid = contextid;
        this.likecontents = likecontents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Userdata userdata = (Userdata) o;
        return Objects.equals(email, userdata.email) &&
                Objects.equals(password, userdata.password) &&
                Objects.equals(name, userdata.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email, password, name);
    }

    @Override
    public String toString() {
        return "Userdata{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
