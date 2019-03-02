package com.patrick.nomnoms.api.tesco;

import com.patrick.nomnoms.api.tesco.response.GroceriesResponseVO;
import com.patrick.nomnoms.api.tesco.response.Result;
import com.patrick.nomnoms.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TescoServiceImpl implements TescoService {

    @Value("${tesco.api.credentials}")
    private String TESCO_CREDENTIALS_LIVE;

    @Value("${tesco.api.groceries.url}")
    private String TESCO_GROCERIES_URL;

    @Value("${tesco.api.products.url}")
    private String TESCO_PRODUCTS_URL;

    private static final Logger log = LoggerFactory.getLogger(TescoServiceImpl.class);

    private RestTemplate restTemplate;

    public TescoServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public GroceriesResponseVO searchGroceries(String query, Integer offset, Integer limit) {

        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TESCO_GROCERIES_URL)
                .queryParam("query", query)
                .queryParam("offset", offset)
                .queryParam("limit", limit);

        log.info("Calling URL: {}", builder.toUriString());

        return restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                getHttpEntity(),
                GroceriesResponseVO.class).getBody();
    }

    @Override
    public List<Product> searchProduct(String query) {

        GroceriesResponseVO vo = searchGroceries(query, 0, 10);

        List<Result> results = vo.getUk().getGhs().getProducts().getResults();

        return formatResults(results);

    }

    private List<Product> formatResults(List<Result> results) {

        List<Product> formattedProducts = new ArrayList<>();

        for(Result result : results){
            Product product = new Product();
            BeanUtils.copyProperties(result, product);
            formattedProducts.add(product);
        }

        return formattedProducts;
    }

    @Override
    public String searchProducts(String tpnb){

        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TESCO_PRODUCTS_URL)
                .queryParam("gtin", tpnb);

        log.info("Calling URL: {}", builder.toUriString());

        return restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                getHttpEntity(),
                String.class).getBody();
    }

    private HttpEntity<String> getHttpEntity() {

        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Ocp-Apim-Subscription-Key", TESCO_CREDENTIALS_LIVE);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        return entity;
    }
}
