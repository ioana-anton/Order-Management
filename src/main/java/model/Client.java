package model;

import java.lang.annotation.*;

public class Client {

    private int id;
    private String name;
    private String address;
    private String email;

    public Client(){

    }
    public Client(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Client(int id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] toStringArray(){
        String[] res=new String[4];
        res[0]=Integer.toString(id);
        res[1]=name;
        res[2]=address;
        res[3]=email;
       // System.out.println(res[0]+" "+res[1]+" "+res[2]+" "+res[3]);
        return res;
    }

    public boolean equalClient(Client c2){
        if(id!=c2.getId())
            return false;
        if(name.compareToIgnoreCase(c2.getName())!=0)
            return false;
        if(email.compareToIgnoreCase(c2.getEmail())!=0)
            return false;

        return true;
    }
}
