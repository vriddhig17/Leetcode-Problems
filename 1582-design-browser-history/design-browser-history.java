class WebAddress {
    String webPageUrl;
    WebAddress prevWebAddress;
    WebAddress nextWebAddress;
    WebAddress(String currWebPage) {
        this.webPageUrl = currWebPage;
    }
}
class BrowserHistory {
    WebAddress homePage;
    WebAddress currPage;
    public BrowserHistory(String homepage) {
        this.homePage = new WebAddress(homepage);
        this.currPage = this.homePage;
    }
 
    public void visit(String url) {
        WebAddress visitingPage = new WebAddress(url);
        this.currPage.nextWebAddress = visitingPage;
        visitingPage.prevWebAddress = this.currPage;
        this.currPage = visitingPage;
    }
 
    public String back(int steps) {
        while(steps > 0 && this.currPage.prevWebAddress != null) {
            steps--;
            this.currPage = this.currPage.prevWebAddress;
        }
        return this.currPage.webPageUrl;
    }
 
    public String forward(int steps) {
        while(steps > 0 && this.currPage.nextWebAddress != null) {
            steps--;
            this.currPage = this.currPage.nextWebAddress;
        }
        return this.currPage.webPageUrl;
    }
}
 
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */