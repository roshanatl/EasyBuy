/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.ProductAdminService;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import model.admin.Item;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


/**
 *
 * @author megha_000
 */
public class ProductManager {
    
    public static void addProduct(Item newProduct)
    {
        Configuration config = new Configuration();
        config.addAnnotatedClass(Item.class);
        config.configure("hibernate.cfg.xml");
        // Creates a table
        //new SchemaExport(config).create(true, true);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(newProduct);
        session.getTransaction().commit();
        session.close();
        
    }
    
    public static Item getProductByID (int productId)
    {
        Configuration config = new Configuration();
        config.addAnnotatedClass(Item.class);
        config.configure("hibernate.cfg.xml");
        // Creates a table
        // new SchemaExport(config).create(true, true);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Item myProduct = null;
        String queryString = "from Item where productId = :productId";
        Query query = session.createQuery(queryString);
        query.setInteger("productId", productId);
        Object queryResult = query.uniqueResult();
        myProduct = (Item) queryResult;
        session.getTransaction().commit();
        session.close();
        return myProduct;
        
    }
    
    public static List<Item> getAllProducts ()
    {
        List<Item> items=new LinkedList<>();
        Configuration config = new Configuration();
        config.addAnnotatedClass(Item.class);
        config.configure("hibernate.cfg.xml");
        // Creates a table
        // new SchemaExport(config).create(true, true);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        
        Item myProduct = null;
        String queryString = "from Item where productQuantity >0 ";
        Query query = session.createQuery(queryString);
        
        List queryResult = query.list();
        for (Iterator it = queryResult.iterator(); it.hasNext();) {
            Object each = it.next();
            myProduct = (Item) each;
            items.add(myProduct);
        }
        
        session.close();
        return items;
        
    }
    
    
    
}
