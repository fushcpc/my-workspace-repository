package com.titan.dto;

import java.io.Serializable;
import java.util.Date;

public class CreditCardDO implements Serializable {

    private static final long serialVersionUID = 6828536366585056819L;

    public String number;
    public Date expireation;
    public String type;

    public CreditCardDO(String number, Date expireation, String type) {
        super();
        this.number = number;
        this.expireation = expireation;
        this.type = type;
    }

}
