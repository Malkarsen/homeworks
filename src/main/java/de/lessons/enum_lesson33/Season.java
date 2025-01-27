package de.lessons.enum_lesson33;

public enum Season {
    // Зима: средняя температура -10°C, минимальная -25°C, максимальная 5°C
    WINTER(-10, -25, 5),
    // Весна: средняя температура 0°C, минимальная 15°C, максимальная 25°C
    SPRING(0, 15, 25),
    // Лето: средняя температура 10°C, минимальная 20°C, максимальная 30°C
    SUMMER(10, 20, 30),
    // Осень: средняя температура 20°C, минимальная 30°C, максимальная 40°C
    FALL(20, 30, 40);

    private int averageTemperature;
    private int min;
    private int max;

    Season(int averageTemperature, int min, int max) {
        this.averageTemperature = averageTemperature;
        this.min = min;
        this.max = max;
    }

    public int getAverageTemperature() {
        return averageTemperature;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
