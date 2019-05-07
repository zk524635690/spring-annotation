package com.demo.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.demo.bean.Red;

public class MyImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		String className = importingClassMetadata.getClassName();
		System.out.println("---->"+className);
		return new String[] {"com.demo.bean.Red","com.demo.bean.Blue"};
	}

}
