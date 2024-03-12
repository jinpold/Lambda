import com.james.api.enums.Navigation;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        while(Navigation.navigate(sc));
    }
}
