package com.cybrilla.firstRound.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybrilla.firstRound.entity.UrlMapperEntity;
import com.cybrilla.firstRound.repository.MapperRepository;

@Service
public class MapperServiceImpl {

	@Autowired
	private MapperRepository mapperRepository;

	private static int counter = 1;

	HashMap<String, String> map = new HashMap<>();

	public String getLongUrl(String shortUrl) {
		if (map.containsKey(shortUrl)) {
			return map.get(shortUrl);
		} else {
			return "Invalid url!";
		}
	}

	public String saveUrl(String longUrl) {

		List<UrlMapperEntity> urlMapperList = new ArrayList<UrlMapperEntity>();

		mapperRepository.findByLongUrl(longUrl).forEach(urlMapperList::add);

		if (!urlMapperList.isEmpty()) {
			if (map.containsValue(longUrl)) {
				for (Entry<String, String> entry : map.entrySet()) {
					if (entry.getValue().equals(longUrl)) {
						return entry.getKey();
					}
				}
			}
		}

		String shortUrl = longUrl.substring(0, 3) + (counter++);
		map.put(shortUrl, longUrl);
		mapperRepository.save((new UrlMapperEntity(shortUrl, longUrl)));
		return shortUrl;

	}

}
