package com.andela.bookmarkit.data;


import com.andela.bookmarkit.data.local.service.CityServiceImpl;

public class AppRepo {
    public CityServiceImpl localStore;

    public AppRepo(CityServiceImpl localStore) {
        this.localStore = localStore;
    }
}
