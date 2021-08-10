package by.it_academy.jd2.utils;

import by.it_academy.jd2.utils.annotation.Parse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CopyProperties {

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null || srcValue.equals("")) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static void myCopyProperties(Object src, Object target) {
        if ( src == null) {
            src = target;
        }
        if (target == null) {
            target = src;
        }
        if(src != null) {
            BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
        }
    }

    public static <T> T insertAllProperties(T src, T tar) {
        if (src == null) {
            src = tar;
        }
        if (tar == null) {
            tar = src;
        }
        if (src != null) {
            Field[] srcFields = src.getClass().getDeclaredFields();
            Field[] tartFields = tar.getClass().getDeclaredFields();

            for (Field srcField : srcFields) {
                if (srcField.isAnnotationPresent(Parse.class)) {

                    try {
                        Field tarField = Arrays.stream(tartFields).
                                filter(s -> srcField.getName().equals(s.getName())).
                                findFirst().
                                orElse(srcField);
                        srcField.setAccessible(true);
                        tarField.setAccessible(true);
                        Object srcValue = srcField.get(src);
                        Object tarValue = tarField.get(tar);
                        if (srcValue == null) {
                            srcValue = Class.forName(srcField.getType().getName()).newInstance();
                        }
                        if (tarValue == null) {
                            tarValue = Class.forName(tarField.getType().getName()).newInstance();
                        }
                        CopyProperties.myCopyProperties(srcValue, tarValue);

                        srcField.set(src, tarValue);
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        CopyProperties.myCopyProperties(src, tar);
        return tar;
    }
}
