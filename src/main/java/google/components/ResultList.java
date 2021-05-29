package google.components;

import common.BasePage;
import google.elements.ResultItemElements;
import google.elements.ResultListElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResultList extends BasePage implements Iterable<ResultItemElements>{
    private List<ResultItemElements> items;
    private ResultListElements elements;

    public ResultList(WebDriver driver, int timeout) {
        super(driver, timeout);
        this.items = new ArrayList<>();
        this.elements = new ResultListElements(driver, timeout);
    }

    @Override
    public Iterator<ResultItemElements> iterator() {
        this.refreshResult();
        return this.items.iterator();
    }

    private void refreshResult() {
        this.items.clear();
        for(WebElement element: this.elements.getResultDivs()) {
            ResultItemElements tmp = new ResultItemElements(this.getDriver(), this.getTimeout(), element);
            this.items.add(tmp);
        }
    }
}
