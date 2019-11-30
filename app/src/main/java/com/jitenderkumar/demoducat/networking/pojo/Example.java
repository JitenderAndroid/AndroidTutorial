package com.jitenderkumar.demoducat.networking.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jitenderkumar.demoducat.networking.Hero;

public class Example {

    @SerializedName("heroes")
    @Expose
    private List<Hero> heroes = null;

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

}
