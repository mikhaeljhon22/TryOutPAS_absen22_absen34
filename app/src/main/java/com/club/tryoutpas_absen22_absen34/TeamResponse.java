package com.club.tryoutpas_absen22_absen34;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TeamResponse {
    @SerializedName("teams")
    private List<ItemModel> teams;

    public List<ItemModel> getTeams() {
        return teams;
    }
}
