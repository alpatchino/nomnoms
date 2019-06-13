package com.patrick.nomnoms.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

  /*  public static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private ProductService service;

    @Autowired
    public void setProductService(ProductService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Product> getAllProducts() {
        log.info("Retrieving all product...");
        return service.listAllProducts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Product> getProduct(@PathVariable Integer id) {
        log.info("Retrieving single product {}...", id);
        return service.getProductById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        log.info("Creating new product {}...", product);
        return service.saveProduct(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        log.info("Updating product {}...", product.getTpnc());
        product.setTpnc(id);
        return service.saveProduct(product);
    }

    @RequestMapping(value = "/best", method = RequestMethod.GET)
<<<<<<< Updated upstream
    public Iterable<Product> getBestProtein() {
        log.info("Getting best protein {}...");
=======
    public Iterable<Product> getBestProtein(){
        log.info("Getting best protein ...");
>>>>>>> Stashed changes
        return service.listBestProteinProducts();
    }*/


}
