package utilities.DB_Utilities;

import hooks.Base;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DB_InsertInto_Methods extends Base {

    public static int idGenerator(String givenQuery) throws SQLException {
        resultSet = DBUtils.getStatement().executeQuery(givenQuery);

        List<Integer> ids = new ArrayList<>();
        while (resultSet.next()){
            ids.add(resultSet.getInt("id"));
        }

        do {
            id = random.nextInt(10001) + 50000;
        } while (ids.contains(id));
        return id;
    }

    public static void citiesInsert() throws SQLException {
        query = queryManage.getQueryUS02Q01();
        preparedStatement = DBUtils.getConnection().prepareStatement(query);

        id = idGenerator(queryManage.getQueryUS02Q01ID());
        name = faker.name().fullName();
        state_id = random.nextInt(2);
        status = random.nextInt(2);
        date = Date.valueOf(LocalDate.now());

        preparedStatement.setLong(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, state_id);
        preparedStatement.setInt(4, status);
        preparedStatement.setDate(5, date);

        System.out.println("NEW DATA: |" + id + "| |" + name + "| |" + state_id + "|" + status + "| |" + date);
    }

}
