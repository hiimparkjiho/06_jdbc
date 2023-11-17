package com.ohgiraffers.opez.model.dto;

public class ChampionDTO {
    private int championCode;
    private String championName;

    public ChampionDTO() {
    }

    public ChampionDTO(int championCode, String championName) {
        this.championCode = championCode;
        this.championName = championName;
    }

    public int getChampionCode() {
        return championCode;
    }

    public void setChampionCode(int championCode) {
        this.championCode = championCode;
    }

    public String getChampionName() {
        return championName;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
    }

    @Override
    public String toString() {
        return "ChampionDTO{" +
                "championCode=" + championCode +
                ", championName='" + championName + '\'' +
                '}';
    }
}
