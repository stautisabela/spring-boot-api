package com.stautisabela.completespringbootapi.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {
	
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O, D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}
	
	public static <O, D> List<D> parseObjectsList(List<O> origin, Class<D> destination) {
		List<D> convertedList = new ArrayList<D>();
		for (O obj : origin) {
			convertedList.add(mapper.map(obj, destination));
		}
		return convertedList;
	}
}
