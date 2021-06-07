package saucelad.components;

import common.BasePage;
import org.openqa.selenium.WebDriver;
//import saucelab.elements.InventoryListElements;
import saucelad.elements.InventoryListElements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InventoryList extends BasePage implements Iterable<InventoryItem> {
    private List<InventoryItem> items;
    private InventoryListElements elements;

    public InventoryList(WebDriver driver, int timeout) {
        super(driver, timeout);
        elements = new InventoryListElements(driver, timeout);
        items = new ArrayList<>();
    }

    @Override
    public Iterator<InventoryItem> iterator() {
       // this.refreshResult();
        return this.items.iterator();
    }
// no me reconece el "var"
   /* private void refreshResult() {
        this.items.clear();
        for(var element: this.elements.getItems()) {
            this.items.add(new InventoryItem(this.getDriver(), this.getTimeout(), element));
        }*/
    }


