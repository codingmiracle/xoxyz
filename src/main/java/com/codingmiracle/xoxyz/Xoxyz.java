package com.codingmiracle.xoxyz;

import com.codingmiracle.xoxyz.core.GameManager;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;


@ApplicationPath("/api")
public class Xoxyz extends Application {

    GameManager gameManager;
    public Xoxyz() {

    }

}