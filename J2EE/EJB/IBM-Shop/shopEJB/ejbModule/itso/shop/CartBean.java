package itso.shop;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
public class CartBean implements Cart {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	EntityManager em;

	private List<Item> selectedItems = new ArrayList<Item>();

	@Override
	public void add(Item item) {
		selectedItems.add(item);
		item.setQuantity(item.getQuantity() - 1);
	}

	@Override
	@Remove
	public List<Item> checkout() {
		System.out.println("Checkout:");
		Item[] items = selectedItems.toArray(new Item[selectedItems.size()]);
		for (Item item : items) {
			System.out.println(item.getId() + "    " + item.getName());
		}
		em.flush();
		return selectedItems;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getItems() {
		return em.createNamedQuery("getItem").getResultList();
	}

	@Override
	public void remove(Item item) {
		selectedItems.remove(item);
		item.setQuantity(item.getQuantity() + 1);
	}

}
