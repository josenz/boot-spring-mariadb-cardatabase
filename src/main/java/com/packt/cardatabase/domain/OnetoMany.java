package com.packt.cardatabase.domain;

import javax.persistence.CascadeType;

public @interface OnetoMany {

	CascadeType cascade();

	String mappedBy();

}
