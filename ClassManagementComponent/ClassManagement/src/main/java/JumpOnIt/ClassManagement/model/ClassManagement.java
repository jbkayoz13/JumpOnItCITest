package JumpOnIt.ClassManagement.model;



import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


@Entity
public class ClassManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classID;

    @NotBlank
    private String className;

    @NotBlank
    private String classLocation;

    @NotBlank
    private String classTrainer;

    @NotNull
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date classDate;

    @NotBlank
    String classTime;

    public ClassManagement() {

    }

    public ClassManagement(String className, String classLocation, String classTrainer, Date classDate, String classTime){
        this.className=className;
        this.classLocation=classLocation;
        this.classTrainer=classTrainer;
        this.classDate=classDate;
        this.classTime=classTime;

    }

    public Long getClassID() {
        return classID;
    }

    public void setClassID(Long classID) {
        this.classID = classID;
    }


    public String getClassTrainer() {
        return classTrainer;
    }

    public void setClassTrainer(String classTrainer) {
        this.classTrainer = classTrainer;
    }

    public String getClassLocation() {
        return classLocation;
    }

    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getClassDate() {
        return classDate;
    }

    public void setClassDate(Date classDateTime) {
        this.classDate = classDateTime;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }
}
