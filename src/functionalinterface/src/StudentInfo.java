package functionalinterface.src;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfo {
    private String name;
    private Integer age;
    private Double height;
    private LocalDate birthday;

    public StudentInfo(String name, Integer age, double height, LocalDate birthday) {
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getHeight() {
        return height;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
