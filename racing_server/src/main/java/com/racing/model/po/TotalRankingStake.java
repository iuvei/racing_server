package com.racing.model.po;

import java.math.BigDecimal;

public class TotalRankingStake {
    private Integer id;

    private String racingNum;

    private Integer rankingNum;

    private BigDecimal big;

    private BigDecimal small;

    private BigDecimal odd;

    private BigDecimal even;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRacingNum() {
        return racingNum;
    }

    public void setRacingNum(String racingNum) {
        this.racingNum = racingNum;
    }

    public Integer getRankingNum() {
        return rankingNum;
    }

    public void setRankingNum(Integer rankingNum) {
        this.rankingNum = rankingNum;
    }

    public BigDecimal getBig() {
        return big;
    }

    public void setBig(BigDecimal big) {
        this.big = big;
    }

    public BigDecimal getSmall() {
        return small;
    }

    public void setSmall(BigDecimal small) {
        this.small = small;
    }

    public BigDecimal getOdd() {
        return odd;
    }

    public void setOdd(BigDecimal odd) {
        this.odd = odd;
    }

    public BigDecimal getEven() {
        return even;
    }

    public void setEven(BigDecimal even) {
        this.even = even;
    }
}