package com.tmjonker.burgerbonanza.menu;

public enum Category {

    APPETIZER {
        @Override
        public String toString() {
            return "Appetizer";
        }
    },

    SALAD {
        @Override
        public String toString() {
            return "Salad";
        }
    },

    BURGER {
        @Override
        public String toString() {
            return "Burger";
        }
    },

    SPECIAL {
        @Override
        public String toString() {
            return "Special";
        }
    },

    DESSERT {
        @Override
        public String toString() {
            return "Dessert";
        }
    },

    ENTREE {
        @Override
        public String toString() {
            return "Entree";
        }
    },

    SIDE {
        @Override
        public String toString() {
            return "Side";
        }
    },

    DRINK {
        @Override
        public String toString() {
            return "Drink";
        }
    }
}
