package com.vk.agen.agen.DB;

/**
 * Created by root on 24.04.2018.
 */

public class Company {

    private long id;
    private String Company;
    private String Location;
    private String Uses_bases;
    private String Subway_station;
    private String Responsible_user;

    private String Phone;
    private String Email;
    private int Updated_status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        this.Company = company;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }

    public String getUses_bases() {
        return Uses_bases;
    }

    public void setUses_bases(String uses_bases) {
        this.Uses_bases = uses_bases;
    }

    public String getSubway_station() {
        return Subway_station;
    }

    public void setSubway_station(String subway_station) {
        this.Subway_station = subway_station;
    }

    public String getResponsible_user() {
        return Responsible_user;
    }

    public void setResponsible_user(String responsible_user) {
        this.Responsible_user = responsible_user;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public int getUpdated_status() {
        return Updated_status;
    }

    public void setUpdated_status(int updated_status) {
        this.Updated_status = updated_status;
    }

    public String toString() {
        return Company;
    }
}
