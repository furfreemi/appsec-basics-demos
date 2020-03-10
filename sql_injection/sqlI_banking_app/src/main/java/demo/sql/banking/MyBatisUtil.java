package demo.sql.banking;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    private static SqlSessionFactory factory;

    private MyBatisUtil() {
    }

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }
}
