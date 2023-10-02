package assignment.first.ioC;

import assignment.first.annotation.Dependency;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Injection {
    private Map<Class<?>, Object> beanContainer = new HashMap<>();

    public void registerBean(Object bean) {
        beanContainer.put(bean.getClass(), bean);
    }

    public Object getBean(Class<?> myClass) {
        return beanContainer.get(myClass);
    }

    public void injectDependencies() throws IllegalAccessException {
        //등록된 모든 bean을 순회하면서 의존성을 주입
        for (Object bean : beanContainer.values()) {
            // Reflection API를 사용하여 현재 빈의 클래스에서 선언된 모든 필드 정보를 가져옴
            for (Field field : bean.getClass().getDeclaredFields()) {
                // 의존성 주입 대상에 의존성컨테이너와 같은 bean을 찾은 후 의존성 주입
                if (field.isAnnotationPresent(Dependency.class)) {
                    Object dependency = getBean(field.getType());
                    if (dependency != null) {
                        field.setAccessible(true);
                        field.set(bean, dependency);
                    }
                }
            }
        }
    }
}
