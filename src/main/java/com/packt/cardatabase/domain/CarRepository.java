package com.packt.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository <Car, Long> {
    // Our 'CarRepository' now extends the Spring Boot JPA 'CrudRepository' interface.
    // The <Car, Long> type arguments define that this is the repository for the 'Car'
    // entity class and the type of the ID field is 'Long'.

    // 'CrudRepository' provides multiple CRUD methods that we can now start to use.
    
    // Fetch cars by brand
    List<Car> findByBrand(String brand);

    // Fetch cars by color
    List<Car> findByColor(String color);

    // Fetch cars by year
    List<Car> findByYear(int year);

    // There can be multiple fields after the 'by' keyword
    //  concatenated with the 'And' or 'Or' keywords:

        // Fetch cars by brand or model
        // List<Car> findByBrandAndModel(String brand, String model);

        // Fetch cars by brand or color
        // List<Car> findByBrandAndModel(String brand, String color);

    // Queries can be sorted by using the 'OrderBy' keyword in the query method:

        // Fetch cars by brand and sort by year
        // List<Car> findByBrandOrderByYearAsc(String brand);

    // You can also create queries by using SQL statements via the @Query annotation.
    // The following example shows the usage of s SQL query in CrudRepository:

        // Fetch cars by brand using SQL
        // @Query("select c from Car c where c.brand = ?1")
        // List<Car> findBybrand(String brand);

    // You can also use more advanced expressions with the @Query annotation; 
    // for example 'like'. The following example shows the usage of the 'like'
    // query in 'CrudRepository':

        // Fetch cars by brand using SQL
        // @Query("select c from Car c where c.brand like %?1")
        // List<Car> findByBrandEndsWith(String brand);

    // Spring Data JPA also provides 'PagingAndSortingRepository', which extends
    //  'CrudRepository'. This offers methods to fetch entities using pagination 
    //  sorting. This is a good option if you are dealing with larger amounts of
    //  data. 'PagingAndSortingRepository' can be created in a similar way to how
    // we created 'CrudRepository':

        // package com.packt.cardatabase.domain;
        // import org.springframeword.data.repository.PagingAndSortingRepository;
        // public interface CardRepository extends PagingAndSortingRepository<Car, Long> {

        // }
}