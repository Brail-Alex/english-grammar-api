package org.example;

import org.example.core.service.IrregularVerbsAdapter;

public class Main {
    public static void main(String[] args) {
        IrregularVerbsAdapter adapter = new IrregularVerbsAdapter();
        adapter.getAll();
    }
}