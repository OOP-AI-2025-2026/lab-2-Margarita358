package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    // Конструктор
    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    // Гетери
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    // Додати години та хвилини
    public void add(int addHours, int addMinutes) {
        if (addHours < 0) addHours = 0;
        if (addMinutes < 0) addMinutes = 0;

        int totalMinutes = this.minutes + addMinutes;
        this.hours += addHours + totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    // Додати інший TimeSpan
    public void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    // Повернути загальні години як double
    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    // Повернути загальні хвилини
    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    // Відняти інший TimeSpan
    public void subtract(TimeSpan span) {
        int totalMinutes = getTotalMinutes() - span.getTotalMinutes();
        if (totalMinutes < 0) totalMinutes = 0;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    // Масштабувати TimeSpan на певний коефіцієнт
    public void scale(int factor) {
        if (factor <= 0) return; // нічого не робимо для 0 або негативного коефіцієнта
        int totalMinutes = getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    @Override
    public String toString() {
        return hours + " годин " + minutes + " хвилин";
    }
}