package dataaccess;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("abs_albertaBikeSwap_war_1.0-SNAPSHOTPU");//it depends on JPA persistence names

    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
