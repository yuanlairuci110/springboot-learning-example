package org.spring.springboot.repository;

import org.spring.springboot.domain.City;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by lichao on 2018/3/26.
 */
public interface TestRepository extends ElasticsearchRepository<City,Long> {
    /**
     * AND 语句查询
     *
     * @param description
     * @param score
     * @return
     */
    List<City> findByNameAndScore(String description, Integer score);
}
