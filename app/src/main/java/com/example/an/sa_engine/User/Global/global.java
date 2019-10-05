package com.example.an.sa_engine.User.Global;

public class global {//singleton
































    private static class globalHolder {
        public static final global global = new global();
    }

    public static global getglobal() {
        return globalHolder.global;
    }
}
