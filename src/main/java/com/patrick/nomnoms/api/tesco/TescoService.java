package com.patrick.nomnoms.api.tesco;

import com.patrick.nomnoms.api.tesco.response.Result;
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
    List<Result> searchGroceries(String query, Integer offset, Integer limit);

    /**
     * Query based search of Tesco's products. Returns a friendlier list of results.
     *
     * @param query
     * @return
     */
    String searchProductByTpnc(String tpnc);

    /**
     * @param query
     * @return
     */
    String searchProductByGtin(String gtin);

    /**
     * <<<<< ignore >>>>>>>></>
     *
     * @param query
     * @return
     */
    List<Product> testFlow(String query);

}
