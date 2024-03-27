package MuleSoftDeveloper.com.Students_Mangement.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Students {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long studentId;
    private String studentName;
    @Max(value = 50,message = "age must be less then equal to 50")
    @Min(value = 15,message = "age must be grater then equal to 15")
    private Integer studentAge;
    @Email
    private String emailId;
    private String collegeName;
    private String courseName;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
