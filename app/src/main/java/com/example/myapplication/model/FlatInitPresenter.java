package com.example.myapplication.model;

import com.example.myapplication.view.FlatInit;

public class FlatInitPresenter {

    private FlatInitView view;

    public FlatInitPresenter(FlatInitView view) {
        this.view = view;
    }

    public void showFlats() {
        view.showFlats();
    }

    public void showFlatsResult() {
        view.showFlatsResult();
    }
}
