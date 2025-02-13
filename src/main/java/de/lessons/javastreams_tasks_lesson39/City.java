package de.lessons.javastreams_tasks_lesson39;

public class City {
    private String name;
    private String country;
    private int population;
    private boolean isCoastal;

    public City(String name, String country, int population, boolean isCoastal) {
        this.name = name;
        this.country = country;
        this.population = population;
        this.isCoastal = isCoastal;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public boolean isCoastal() {
        return isCoastal;
    }

    @Override
    public String toString() {
        return String.format(
                "City{name='%s', country='%s', population=%d, isCoastal=%b}",
                name, country, population, isCoastal
        );
    }
}
