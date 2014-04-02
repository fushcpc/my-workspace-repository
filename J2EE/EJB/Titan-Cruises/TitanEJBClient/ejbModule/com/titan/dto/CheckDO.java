package com.titan.dto;

import java.io.Serializable;

public class CheckDO implements Serializable {

    private static final long serialVersionUID = -1428509237343298071L;
    public String checkBarCode;
    public int checkNumber;

    public CheckDO(String checkBarCode, int checkNumber) {
        super();
        this.checkBarCode = checkBarCode;
        this.checkNumber = checkNumber;
    }

}
