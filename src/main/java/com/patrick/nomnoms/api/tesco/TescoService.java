package com.patrick.nomnoms.api.tesco;

import com.patrick.nomnoms.api.tesco.response.GroceriesResponseVO;
import com.patrick.nomnoms.entity.Product;

import java.util.List;

/**
 *
 */
public interface TescoService {

    /**
     * Query based search of Tesco's products. Does not contain nutritional information.
     *
     * @param query
     * @param offset
     * @param limit
     * @return
     */
    GroceriesResponseVO searchGroceries(String query, Integer offset, Integer limit);

    /**
     * Query based search of Tesco's products. Returns a friendlier list of results.
     *
     * @param query
     * @return
     */
    List<Product> searchProduct(String query);

    /**
     * TPNP (Tesco's product ID) based search. Nutritional information is available for groceries items.
     *
     * @param tpnb
     * @return
     */
    String searchProducts(String tpnb);

}
