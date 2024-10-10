package be.pulse.adapter.config;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

@Configuration
@NoArgsConstructor
public class BeanConfig {


    @Bean
    static BeanFactoryPostProcessor MemberBeanFactoryPostProcessor(ApplicationContext beanRegistry) {
        return beanFactory ->
                MemberApplicationContext(
                        (BeanDefinitionRegistry) ((GenericApplicationContext) beanRegistry)
                                .getBeanFactory());
    }

    @Bean
    static BeanFactoryPostProcessor DisciplineBeanFactoryPostProcessor(ApplicationContext beanRegistry) {
        return beanFactory ->
                MemberApplicationContext(
                        (BeanDefinitionRegistry) ((GenericApplicationContext) beanRegistry)
                                .getBeanFactory());
    }



    static void MemberApplicationContext(BeanDefinitionRegistry beanRegistry) {
        ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanRegistry);
        beanDefinitionScanner.addIncludeFilter(addUseCaseFilter());
        beanDefinitionScanner.scan(
                "be.pulse.usecase.member", "be.pulse.domain.member"
        );
    }

    static void DisciplineApplicationContext(BeanDefinitionRegistry beanRegistry) {
        ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanRegistry);
        beanDefinitionScanner.addIncludeFilter(addUseCaseFilter());
        beanDefinitionScanner.scan(
                "be.pulse.usecase.discipline", "be.pulse.domain.discipline"
        );
    }

    static TypeFilter addUseCaseFilter() {
        return (MetadataReader mr, MetadataReaderFactory mrf) -> mr.getClassMetadata()
                .getClassName()
                .endsWith("UseCase") ||
                mr.getClassMetadata()
                        .getClassName()
                        .contains("Factory");
    }
}
