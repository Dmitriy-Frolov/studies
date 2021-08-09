import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(PurchaselistKey.class)
@Table(name = "PurchaseList")
public class PurchaseList
{
    @Id
    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Id
    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    private int price;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

