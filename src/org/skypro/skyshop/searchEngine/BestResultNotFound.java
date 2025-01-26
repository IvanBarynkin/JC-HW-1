package org.skypro.skyshop.searchEngine;

import java.io.IOException;

public class BestResultNotFound extends IOException {
    public BestResultNotFound(String message) {
        super(message);
    }
}
