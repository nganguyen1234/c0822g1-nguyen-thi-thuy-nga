package com.example.service.impl;

import com.example.model.Product;
import com.example.service.IProductService;
import com.example.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ProductService implements IProductService {

    public List<Product> getAllProduct() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    public boolean addNewProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                return false;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        Product product = findById(id);
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                return false;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    public Product findById(int id) {
        Session session = null;
      Product product = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("from Product where id = :id")
                    .setParameter("id",id)
                    .getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    public String editProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
            return  "Successfully edited";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                return "Failed to edit";
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return "Failed to edit";

    }

    public List<Product> searchByName(String searchName){
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product where name like CONCAT('%',:searchName,'%') ")
                    .setParameter("searchName",searchName)
                    .getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }
}
