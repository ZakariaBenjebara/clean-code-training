package com.nespresso.sofa.interview.parking.bay;

public enum BayFactory {

    NORMAL_PEOPLE {
        @Override
        public AbstractBay create(int number) {
            return new ForNormalPeople(number);
        }
    },
    DISABLED_PEOPLE {
        @Override
        public AbstractBay create(int number) {
            return new ForDisabledPeople(number);
        }
    },
    PEDESTRIAN {
        @Override
        public AbstractBay create(int number) {
            return new Pedestrian(number);
        }
    };

    public abstract AbstractBay create(int number);
}
