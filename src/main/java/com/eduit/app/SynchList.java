package com.eduit.app;

import java.util.ArrayList;

public class SynchList<T> extends ArrayList<T> {

    @Override
    public synchronized int size() {
        return super.size();
    }

    @Override
    public boolean add(T o) {
        synchronized (this){
            return super.add(o);
        }

    }
}
