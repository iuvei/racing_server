package com.racing.model.po;

public class TotalDayCountIncomeWithBLOBs extends TotalDayCountIncome {
    private String appointStake;

    private String commonStake;

    private String rankingStake;

    public String getAppointStake() {
        return appointStake;
    }

    public void setAppointStake(String appointStake) {
        this.appointStake = appointStake;
    }

    public String getCommonStake() {
        return commonStake;
    }

    public void setCommonStake(String commonStake) {
        this.commonStake = commonStake;
    }

    public String getRankingStake() {
        return rankingStake;
    }

    public void setRankingStake(String rankingStake) {
        this.rankingStake = rankingStake;
    }
}