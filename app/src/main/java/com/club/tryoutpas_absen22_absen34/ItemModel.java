package com.club.tryoutpas_absen22_absen34;

import com.google.gson.annotations.SerializedName;

public class ItemModel {

    @SerializedName("strTeam")
    private String teamName;

    @SerializedName("strStadium")
    private String stadiumName;
    @SerializedName("strBadge")
    private String logo;

    public String getTeamName() {
        return teamName;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public String getLogo() {
        return logo;
    }
}

