/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Category;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jonas
 */
@Stateless
public class CategoryFacade extends AbstractFacade<Category> {

    @PersistenceContext(unitName = "JSFShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }

    public List<Category> getCollection() {
        List<Category> results = em.createQuery("SELECT m FROM category m").getResultList();
        return results;
    }

}
