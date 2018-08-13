package repositories.boundary;


import repositories.entity.Item;
import repositories.entity.User;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Collection;

import static constants.Constants.PERSISTENT_UNIT;


@Stateless
public class Repository {

    @PersistenceContext(name = PERSISTENT_UNIT)
    private EntityManager em;

    public Collection<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public User getUser(Long id) {
        return em.find(User.class, id);
    }

    public Collection<Item> getAllItems() {
        return em.createQuery("SELECT i FROM Item i", Item.class).getResultList();
    }

    public Item getItem(Long id) {
        return em.find(Item.class, id);
    }

}
