package com.ohgiraffers.opez.model.dto;

public class MasterUsersDTO {
    private int userCode;
    private int masterCode;
    private int championCode;
    private int totalGames;
    private int winningRate;

    public MasterUsersDTO() {
    }

    public MasterUsersDTO(int userCode, int masterCode, int championCode, int totalGames, int winningRate) {
        this.userCode = userCode;
        this.masterCode = masterCode;
        this.championCode = championCode;
        this.totalGames = totalGames;
        this.winningRate = winningRate;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public int getMasterCode() {
        return masterCode;
    }

    public void setMasterCode(int masterCode) {
        this.masterCode = masterCode;
    }

    public int getChampionCode() {
        return championCode;
    }

    public void setChampionCode(int championCode) {
        this.championCode = championCode;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getWinningRate() {
        return winningRate;
    }

    public void setWinningRate(int winningRate) {
        this.winningRate = winningRate;
    }

    @Override
    public String toString() {
        return "MasterUsersDTO{" +
                "userCode=" + userCode +
                ", masterCode=" + masterCode +
                ", championCode=" + championCode +
                ", totalGames=" + totalGames +
                ", winningRate=" + winningRate +
                '}';
    }
}
