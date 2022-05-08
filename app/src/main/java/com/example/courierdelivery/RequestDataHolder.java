package com.example.courierdelivery;

public class RequestDataHolder {
    String email,type,weight,fromadd,toadd;

    RequestDataHolder()
    {

    }
    RequestDataHolder(String email,String type,String weight,String fromadd,String toadd)
    {
        this.email=email;
        this.type=type;
        this.weight=weight;
        this.fromadd=fromadd;
        this.toadd=toadd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getFromadd() {
        return fromadd;
    }

    public void setFromadd(String fromadd) {
        this.fromadd = fromadd;
    }

    public String getToadd() {
        return toadd;
    }

    public void setToadd(String toadd) {
        this.toadd = toadd;
    }
}
