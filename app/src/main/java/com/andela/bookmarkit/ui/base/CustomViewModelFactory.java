package com.andela.bookmarkit.ui.base;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.andela.bookmarkit.data.AppRepo;
import com.andela.bookmarkit.data.service.CityServiceImpl;
import com.andela.bookmarkit.ui.cities.CityDetailsFragmentViewModel;

public class CustomViewModelFactory implements ViewModelProvider.Factory {
    private AppRepo repo;

    public CustomViewModelFactory(Context context) {
        CityServiceImpl cityService = new CityServiceImpl(context);
        repo = new AppRepo(cityService);
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CityDetailsFragmentViewModel.class)) {
            return (T) new CityDetailsFragmentViewModel(repo);
        } else {
            throw new IllegalArgumentException("View Model Not Found!");
        }
    }
}