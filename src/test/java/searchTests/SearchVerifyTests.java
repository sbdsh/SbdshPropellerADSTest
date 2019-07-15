package searchTests;

import org.junit.Test;
import pages.YTSearchPage;
import steps.BaseTest;

public class SearchVerifyTests extends BaseTest {

    private String validSearchRequest = "Selenide";
    private String emptySearchRusultsRequest = "adgweshgrwgrwr";

    @Test
    public void validSearchTest() {
        YTSearchPage.searchYT(validSearchRequest);
        YTSearchPage.resultsExist();
    }

    @Test
    public void emptySearchResultsTest() {
        YTSearchPage.searchYT(emptySearchRusultsRequest);
        YTSearchPage.emptySearchResults();
    }

}
