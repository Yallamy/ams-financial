package br.com.mesttra.financial.util;

import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class Util {

	public static <E, T> E convertModelMapper(T source, Class<E> typeDestination) {

		E model = null;

		if (Objects.nonNull(source) && Objects.nonNull(typeDestination)) {

			ModelMapper modelMapper = new ModelMapper();

			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			model = modelMapper.map(source, typeDestination);
		}

		return model;
	}
}
