package hackerrank;

import java.util.HashMap;

public class FurnitureOrder implements FurnitureOrderInterface {
    
	private final HashMap<Furniture, Integer> furnituresAndCounterMap;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        furnituresAndCounterMap = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        Integer count = 0;
        if(furnituresAndCounterMap.containsKey(type)) {
            count = furnituresAndCounterMap.get(type);
        }
        furnituresAndCounterMap.put(type, count + furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return furnituresAndCounterMap;
    }

    public float getTotalOrderCost() {
        if(!furnituresAndCounterMap.isEmpty()) {
        	float total = 0.0f;
        	for(Furniture furniture:furnituresAndCounterMap.keySet()) {
    			total = total + (furniture.cost() * furnituresAndCounterMap.get(furniture));
    		}
        	return total;
        }
        return 0.0f;
    }

    public int getTypeCount(Furniture type) {
        if(furnituresAndCounterMap.containsKey(type)) {
        	return furnituresAndCounterMap.get(type);
        }
        return 0;
    }

    public float getTypeCost(Furniture type) {
    	if(furnituresAndCounterMap.containsKey(type)) {
        	return furnituresAndCounterMap.get(type) * type.cost();
        }
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
    	if(!furnituresAndCounterMap.isEmpty()) {
    		int total = 0;
    		for(Furniture furniture:furnituresAndCounterMap.keySet()) {
    			total = total + furnituresAndCounterMap.get(furniture);
    		}
        	return total;
        }
        return 0;
    }
}