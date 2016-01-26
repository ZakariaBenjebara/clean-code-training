package com.sqli.nespresso.train.writer;

import com.sqli.nespresso.train.wagon.Restaurant;

final class RestaurantWriter extends WagonWriterTemplate<Restaurant, String> {

    @Override
    protected String shape(final Restaurant restaurant) {
        return "|hThT|";
    }
}
