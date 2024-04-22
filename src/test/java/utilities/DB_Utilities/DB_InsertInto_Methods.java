package utilities.DB_Utilities;

import hooks.Base;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DB_InsertInto_Methods extends Base {

    public static Long idGenerator(String givenQuery) throws SQLException {
        resultSet = DBUtils.getStatement().executeQuery(givenQuery);

        List<Long> ids = new ArrayList<>();
        while (resultSet.next()){
            ids.add(resultSet.getLong("id"));
        }

        do {
            id = random.nextLong();
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
        rowCount = preparedStatement.executeUpdate();
        assertEquals(1, rowCount);

        System.out.println("NEW DATA: |" + id + "| |" + name + "| |" + state_id + "|" + status + "| |" + date);
    }

}
