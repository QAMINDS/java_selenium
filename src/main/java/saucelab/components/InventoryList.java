package saucelab.components;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import saucelab.elements.InventoryListElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class InventoryList extends BasePage implements Iterable<InventoryItem> {
    private List<InventoryItem> items;
    private InventoryListElements elements;
    private List<String> itemNames;
    private List<Float> itemPrices;
    public String[] currentNames;
    public Float[] currentPrices;


    public InventoryList(WebDriver driver, int timeout) {
        super(driver, timeout);
        elements = new InventoryListElements(driver, timeout);
        items = new ArrayList<>();
        itemNames = new ArrayList<>();
        itemPrices = new ArrayList<>();
    }

    @Override
    public Iterator<InventoryItem> iterator() {
        this.refreshResult();
        return this.items.iterator();
    }

    private void refreshResult() {
        this.items.clear();
        for (var element : this.elements.getItems()) {
            this.items.add(new InventoryItem(this.getDriver(), this.getTimeout(), element));
            this.itemNames.add(new InventoryItem(this.getDriver(), this.getTimeout(), element).getName());
            this.itemPrices.add(new InventoryItem(this.getDriver(), this.getTimeout(), element).getPriceNumber());
        }

        currentNames = new String[itemNames.size()];
        currentNames = itemNames.toArray(currentNames);

        currentPrices = new Float[itemPrices.size()];
        currentPrices = itemPrices.toArray(currentPrices);
    }

    public String[] namesAtoZ() {
        String[] namesAtoZ = this.currentNames.clone();
        Arrays.sort(namesAtoZ);

        logger.info("Printing current item names: \n" + itemNames.toString());
        logger.info("Printing item names sorted A to Z: ");
        for (String x : namesAtoZ)
            System.out.print(x + ", ");

        return namesAtoZ;
    }

    public String[] namesZtoA() {
        String[] namesZtoA = this.currentNames.clone();
        Arrays.sort(namesZtoA, Collections.reverseOrder());

        logger.info("Printing current item names: \n" + itemNames.toString());
        logger.info("Printing item names sorted Z to A: ");
        for (String x : namesZtoA)
            System.out.print(x + ", ");

        return namesZtoA;
    }

    public Float[] pricesLotoHi() {
        Float[] pricesLotoHi = currentPrices.clone();
        Arrays.sort(pricesLotoHi);

        logger.info("Printing current item prices: \n" + itemPrices.toString());
        logger.info("Printing item prices sorted Lo to Hi: ");
        for (Float x : pricesLotoHi)
            System.out.print(x + ", ");

        return pricesLotoHi;
    }

    public Float[] pricesHitoLo() {
        Float[] pricesHitoLo = currentPrices.clone();
        Arrays.sort(pricesHitoLo, Collections.reverseOrder());

        logger.info("Printing current item prices: \n" + itemPrices.toString());
        logger.info("Printing item prices sorted Hi to Lo: ");
        for (Float x : pricesHitoLo)
            System.out.print(x + ", ");

        return pricesHitoLo;
    }

}
