package com.nav.shopcart.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "privileges")
public class Privilege extends Base{

    private String privilegeName;

    private String description;

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
