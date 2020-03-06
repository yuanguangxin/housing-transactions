package com.yyy.housingtransactions.model.vo;

import com.yyy.housingtransactions.model.House;

import java.math.BigDecimal;

public class HouseQueryVo extends House {
    private String sizeStr;
    private String priceStr;
    private BigDecimal beginPrice;
    private BigDecimal endPrice;
    private BigDecimal beginSize;
    private BigDecimal endSize;
    private int pageNum;

    public String getSizeStr() {
        return sizeStr;
    }

    public void setSizeStr(String sizeStr) {
        this.sizeStr = sizeStr;
    }

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public BigDecimal getBeginPrice() {
        return beginPrice;
    }

    public void setBeginPrice(BigDecimal beginPrice) {
        this.beginPrice = beginPrice;
    }

    public BigDecimal getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(BigDecimal endPrice) {
        this.endPrice = endPrice;
    }

    public BigDecimal getBeginSize() {
        return beginSize;
    }

    public void setBeginSize(BigDecimal beginSize) {
        this.beginSize = beginSize;
    }

    public BigDecimal getEndSize() {
        return endSize;
    }

    public void setEndSize(BigDecimal endSize) {
        this.endSize = endSize;
    }
}
