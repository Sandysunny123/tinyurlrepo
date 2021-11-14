package com.cybrilla.firstRound.repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybrilla.firstRound.entity.UrlMapperEntity;

@Repository
public interface MapperRepository  extends JpaRepository<UrlMapperEntity,Long>{
	
	List<UrlMapperEntity> findByShortUrl(String ShortUrl);
	List<UrlMapperEntity> findByLongUrl(String LongUrl);

			
}
