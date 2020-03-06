package com.yyy.housingtransactions.model.vo;

import com.yyy.housingtransactions.model.House;
import com.yyy.housingtransactions.model.User;

public class HouseDetailVo {
    private User user;

    private House house;

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
