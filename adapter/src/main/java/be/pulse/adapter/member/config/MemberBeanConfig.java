//package be.pulse.adapter.member.config;
//
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.GenericApplicationContext;
//import org.springframework.core.type.classreading.MetadataReader;
//import org.springframework.core.type.classreading.MetadataReaderFactory;
//import org.springframework.core.type.filter.TypeFilter;
//
//@Configuration
//@NoArgsConstructor
//public class MemberBeanConfig {
//
//
//    @Bean
//    static BeanFactoryPostProcessor MemberBeanFactoryPostProcessor(ApplicationContext beanRegistry) {
//        return beanFactory ->
//                MemberApplicationContext(
//                        (BeanDefinitionRegistry) ((GenericApplicationContext) beanRegistry)
//                                .getBeanFactory());
//    }
//
////    @Bean
////    AmazonSimpleEmailService sesClient() {
////        return AmazonSimpleEmailServiceClientBuilder
////                .standard()
////                .withRegion(Regions.EU_WEST_1)
////                // FIXME Add service account :-)
////                .build();
////    }
//
//    static void MemberApplicationContext(BeanDefinitionRegistry beanRegistry) {
//        ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanRegistry);
//        beanDefinitionScanner.addIncludeFilter(addUseCaseFilter());
//        beanDefinitionScanner.scan(
//                "be.pulse.usecase",
//                "be.pulse.domain"
//        );
//    }
//
//    static TypeFilter addUseCaseFilter() {
//        return (MetadataReader mr, MetadataReaderFactory mrf) -> mr.getClassMetadata()
//                .getClassName()
//                .endsWith("UseCase") ||
//                mr.getClassMetadata()
//                        .getClassName()
//                        .contains("Factory");
//    }
//}
