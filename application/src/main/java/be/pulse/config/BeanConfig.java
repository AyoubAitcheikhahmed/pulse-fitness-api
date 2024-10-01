//package be.pulse.config;
//
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
//import org.springframework.beans.factory.support.RootBeanDefinition;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
//import org.springframework.core.type.classreading.MetadataReader;
//import org.springframework.core.type.classreading.MetadataReaderFactory;
//
//import java.io.IOException;
//import java.lang.reflect.Modifier;
//import java.util.stream.Stream;
//
//@Configuration
//public class BeanConfig implements BeanDefinitionRegistryPostProcessor {
////    https://www.baeldung.com/spring-beans-dynamic-registration-properties
//
//    private static final String BASE_PACKAGE = "pulse-fitness-api";
//    private static final String RESOURCE_PATTERN = "classpath*:" + BASE_PACKAGE.replace(".", "/") + "/**/*.class";
//
//    @Override
//    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
//        try {
//            scanAndRegisterBeans(registry);
//        } catch (Exception ignored) {
//
//        }
//    }
//
//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
//    }
//
//    private void scanAndRegisterBeans(BeanDefinitionRegistry registry) throws IOException {
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);
//
//        var resources = resolver.getResources(RESOURCE_PATTERN);
//
//        Stream.of(resources)
//                .filter(Resource::isReadable)
//                .forEach(resource -> {
//                    try {
//                        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
//                        String className = metadataReader.getClassMetadata().getClassName();
//                        Class<?> classMeta = Class.forName(className);
//
//                        if ((hasMatchingSuffix(className) && canBeInstantiated(classMeta))) {
//                            this.registerBean(registry, classMeta);
//                        }
//
//                    } catch (ClassNotFoundException | IOException ignored) {
//
//                    }
//                });
//    }
//
//    private void registerBean(BeanDefinitionRegistry registry, Class<?> classMeta) throws ClassNotFoundException {
//        BeanDefinition beanDefinition = new RootBeanDefinition(classMeta);
//        registry.registerBeanDefinition(classMeta.getSimpleName(), beanDefinition);
//    }
//
//    private boolean hasMatchingSuffix(String className) {
//        return className.endsWith("UseCase") || className.endsWith("Repository");
//    }
//
//    private boolean canBeInstantiated(Class<?> classMeta) throws ClassNotFoundException {
//        return !(classMeta.isInterface() || Modifier.isAbstract(classMeta.getModifiers()));
//    }
//
//}