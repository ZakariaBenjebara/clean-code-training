package com.sqli.nespresso.train.wagon;

import static com.sqli.nespresso.train.utils.Preconditions.assertNotNull;

public enum  WagonType {

    HEAD,
    PASSENGER,
    RESTAURANT,
    CARGO;

    public static WagonType fromCharConstant(char wagonId) {
        assertNotNull(wagonId);
        switch (wagonId) {
            case 'H':
                return HEAD;
            case 'P':
                return PASSENGER;
            case 'R':
                return RESTAURANT;
            case 'C':
                return CARGO;
            default:
                throw new IllegalStateException();
        }
    }

    public static boolean isHead(final WagonType type) {
        assertNotNull(type);
        return type == HEAD;
    }
}
