package saucelab.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import saucelab.components.InventoryItem;
import saucelab.components.InventoryList;
import saucelab.elements.ProductElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Producto extends BasePage {
    public ProductElements elements;
    public InventoryList inventoryList;

    public enum SortOption {
        AZ,
        ZA,
        LOHI,
        HILO,
    }

    public Producto(WebDriver driver, int timeout) {
        super(driver, timeout);
        elements = new ProductElements(driver, timeout);
        inventoryList = new InventoryList(driver, timeout);
    }

    @Override
    public void waitUntilLoaded() {
        this.elements.getSelect();
        this.elements.getTitle();
    }

    public void sort(SortOption option) {
        Select select = new Select(this.elements.getSelect());
        select.selectByValue(option.name().toLowerCase());
    }

    public void getInformationProducts(){
        for(InventoryItem item: this.inventoryList) {
            System.out.println("--------------------");
            System.out.println(item.getTitle());
            System.out.println(item.getDescription());
            System.out.println(item.getPrice());
            item.addToCart();
        }
    }

    public boolean isSorted(SortOption option){
        //generamos una lista con los datos a validar
        List<String> listData = this.getListSortProduct(option);

        boolean sorted = false;

        if(option.equals(SortOption.AZ) || option.equals(SortOption.HILO)){
            sorted = isSorted(listData);
        }else if(option.equals(SortOption.LOHI)||option.equals(SortOption.ZA)){
            sorted = isSorted(reverse(listData));
        }

        return sorted;

    }













    public  List<String> getListSortProduct(SortOption option) {
        List<String> items = new ArrayList<String>();
        if(option.equals(SortOption.AZ) ||option.equals(SortOption.ZA) ){
            for(InventoryItem item: this.inventoryList) {
                items.add(item.getTitle());
            }
        }else if (option.equals(SortOption.HILO) ||option.equals(SortOption.LOHI))
        {
            for(InventoryItem item: this.inventoryList) {
                items.add(item.getPrice());
            }
        }
        return items;
    }

    public static <T extends Comparable<? super T>> boolean isSorted(List<T> list) {
        if (list.size() != 0) {
            ListIterator<T> it = list.listIterator();
            System.out.println("Lista ordenada");
            for (T item = it.next(); it.hasNext(); item = it.next()) {
                System.out.println(item);
                if (it.hasPrevious() && it.previous().compareTo(it.next()) > 0) {
                    return false;
                }
            }

        }
        return true;
    }

    static <T> List<T> reverse(final List<T> list) {
        final List<T> result = new ArrayList<>(list);
        Collections.reverse(result);
        return result;
    }

}
