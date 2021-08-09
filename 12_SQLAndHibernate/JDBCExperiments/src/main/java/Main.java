import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "Ra485ki34";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select purchaselist.course_name, " +
                    "count(purchaselist.course_name)/max(month(purchaselist.subscription_date)) " +
                    "from purchaselist group by purchaselist.course_name;");
            while (resultSet.next()){
                String courseName = resultSet.getString("purchaselist.course_name");
                String midleCountOfPurchasesInMonth =
                        resultSet.getString("count(purchaselist.course_name)/" +
                                "max(month(purchaselist.subscription_date))");
                System.out.println(courseName + " = " + midleCountOfPurchasesInMonth);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
