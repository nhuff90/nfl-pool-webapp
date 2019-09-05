package info.natehuff.demo.dto;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Pick {
    @Id
    @GeneratedValue
    private Long id;
    String name;
    String line;
    int week;

    public Pick(String name, String line, int week) {
        this.name = name;
        this.line = line;
        this.week = week;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "Pick{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", line=" + line +
                ", week=" + week +
                '}';
    }
}
