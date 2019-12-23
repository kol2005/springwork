package com.biz.pet.domain.petrest;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * java 1.7 이상에서만 작동된다
 * jaxb dependecy(pom.xml)에 추가해주면 된다
 */
//@XmlRootElement(name="rfcOpenApi")
public class RestBody {

	public RestBodyData data;
	
}
