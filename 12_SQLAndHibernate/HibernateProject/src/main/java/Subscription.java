import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription
{
    @EmbeddedId
    private SubscriptionKey subscriptionKey;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "subscription_date")
    private Date subscriptionDate;

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

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public SubscriptionKey getSubscriptionKey() {
        return subscriptionKey;
    }

    public void setSubscriptionKey(SubscriptionKey subscriptionKey) {
        this.subscriptionKey = subscriptionKey;
    }
}
