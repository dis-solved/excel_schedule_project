package excel_schedule;

import java.time.LocalDate;
import java.util.Objects;

public class CourseInformation {
    private String name;
    private double totalHours;
    private LocalDate startDate = LocalDate.now();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseInformation that = (CourseInformation) o;
        return totalHours == that.totalHours &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalHours);
    }

    @Override
    public String toString() {
        return "CourseInformation{" +
                "name='" + name + '\'' +
                ", totalHours=" + totalHours +
                '}';
    }
}