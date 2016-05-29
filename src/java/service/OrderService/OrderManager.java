package service.OrderService;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import model.Store.Orders;
import org.hibernate.Query;
import org.hibernate.Session;
import util.ORM.HibernateSession;


public class OrderManager {
    @Inject
    static HibernateSession hibFactory;
    
    public static int createOrder(Orders newOrder)
    {
        Session session = hibFactory.getsessionFactory().openSession();
        session.beginTransaction();
        session.save(newOrder);
        session.getTransaction().commit();
        session.close();
        return newOrder.getOrderID();
        
    }
    
    public static List<Orders> getAllMyOrders ( long userID)
    {
        List<Orders> myOrders=new LinkedList<>();
        Session session = hibFactory.getsessionFactory().openSession();
        session.beginTransaction();
        
        Orders myOrder = null;
        String queryString = "from Orders where userID = :userID ";
        Query query = session.createQuery(queryString);
        query.setLong("userID", userID);
        List queryResult = query.list();
        for (Iterator it = queryResult.iterator(); it.hasNext();) {
            Object each = it.next();
            myOrder = (Orders) each;
            myOrders.add(myOrder);
        }
        
        session.close();
        return myOrders;
        
    }

    public static List<Orders> getAllMyRecivedOrders(long sellerID) {
         List<Orders> myOrders=new LinkedList<>();
        Session session = hibFactory.getsessionFactory().openSession();
        session.beginTransaction();
        
        Orders myOrder = null;
        String queryString = "from Orders where sellerID = :sellerID ";
        Query query = session.createQuery(queryString);
        query.setLong("sellerID", sellerID);
        List queryResult = query.list();
        for (Iterator it = queryResult.iterator(); it.hasNext();) {
            Object each = it.next();
            myOrder = (Orders) each;
            myOrders.add(myOrder);
        }
        
        session.close();
        return myOrders;
    }
    
    public static void deliverOrder( int orderID)
    {
        Session session = hibFactory.getsessionFactory().openSession();      
        Orders myOrder=(Orders)session.get(Orders.class, orderID);        
        session.beginTransaction();
        myOrder.setOrderState(1);
        session.update(myOrder);
        session.getTransaction().commit();
        session.close();
        
    }
    
}
