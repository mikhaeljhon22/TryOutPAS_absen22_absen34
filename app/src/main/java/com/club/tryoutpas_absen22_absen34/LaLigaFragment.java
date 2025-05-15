package com.club.tryoutpas_absen22_absen34;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaLigaFragment extends Fragment {

    RecyclerView rvTeam;
    TeamAdapter teamAdapter;

    ProgressBar pbLoading;

    public LaLigaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laliga, container, false);

        pbLoading = view.findViewById(R.id.pbLoading);
        rvTeam = view.findViewById(R.id.rvTeam);
        rvTeam.setLayoutManager(new LinearLayoutManager(getContext()));

        fetchLaligaTeams();

        return view;
    }

    private void fetchLaligaTeams() {
        TeamApi api = RetrofitClient.getInstance().create(TeamApi.class);
        api.getLaliga("Spanish La Liga").enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ItemModel> teams = response.body().getTeams();
                    teamAdapter = new TeamAdapter(teams);
                    rvTeam.setAdapter(teamAdapter);
                    rvTeam.setVisibility(View.VISIBLE);
                    pbLoading.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage());
                Toast.makeText(getContext(), "Failed to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }

}


