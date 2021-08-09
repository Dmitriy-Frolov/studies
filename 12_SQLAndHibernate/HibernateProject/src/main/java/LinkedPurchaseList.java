import javax.persistence.*;

@Entity
@IdClass(LinkedPurchaseListKey.class)
@Table(name = "Linkedpurchaselist")
public class LinkedPurchaseList
{
    @Id
    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Id
    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

}
