package demo.sql.banking.service;

import demo.sql.banking.MyBatisUtil;
import demo.sql.banking.model.Item;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    public List<Item> getItemByName(String name) throws SQLException {
       SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ResultSet resultSet = session
                    .getConnection()
                    .prepareStatement("SELECT * FROM item WHERE name = '" + name + "';")
                    .executeQuery();

            List<Item> items = new ArrayList<>();

            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getString(1));
                item.setName(resultSet.getString(2));
                item.setDescription(resultSet.getString(3));
                items.add(item);
            }
            return items;
        } catch (SQLException ex) {
            session.rollback();
            session.clearCache();
            session.close();
            throw ex;
        }
    }
}
