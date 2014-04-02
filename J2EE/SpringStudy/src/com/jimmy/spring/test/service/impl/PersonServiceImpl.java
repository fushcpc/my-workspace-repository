package com.jimmy.spring.test.service.impl;

import com.jimmy.spring.test.service.PersonService;

public class PersonServiceImpl implements PersonService {
	@Override
	public void save() {
		System.out.println("save done!");
	}
}
