package com.demo.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyFilterType implements TypeFilter {

	@SuppressWarnings("unused")
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		//获取当前类的注解信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//获取当前正在扫描的类的信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//获取当前资源(类的路径)
		Resource resource = metadataReader.getResource();
		String className = classMetadata.getClassName();
		System.out.println("--->"+className);
		
		if (className.contains("Service")) {
			return true;
		}
		return false;
	}

}
