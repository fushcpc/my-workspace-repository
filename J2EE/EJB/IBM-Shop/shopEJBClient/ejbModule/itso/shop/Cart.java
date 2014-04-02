package itso.shop;

import java.util.List;

public interface Cart {
	void add(Item item);

	void remove(Item item);

	List<Item> getItems();

	List<Item> checkout();
}
