package org.saucedemo.selenium.utils;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PageUtils {

    //lambda function to verify the presence of an element
    public static <T> boolean verifyElementsPresent(List<T> elements, Predicate<T> predicate) {
        return elements.stream().allMatch(predicate);
    }

    // lambda function to count element that meet a condition
    public static <T> long countElements(List<T> elements, Predicate<T> predicate) {
        return elements.stream().filter(predicate).count();
    }

    // lambda function to find and operate over the first element that meet a condition
    public static <T> void findAndActOnFirstElement(List<T> elements, Predicate<T> predicate, Consumer<T> action) {
        elements.stream()
                .filter(predicate)
                .findFirst()
                .ifPresent(action);
    }
}
