// Approach ArrayList
// TC: O(1);
// SC: Depends how many tabs are opened
// LeetCode : 1472. Design Browser History
/*
 You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number
  of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
void visit(string url) Visits url from the current page. It clears up all the forward history.
string back(int steps) Move steps back in history. If you can only return x steps in the history 
and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will
forward only x steps. Return the current url after forwarding in history at most steps.
 
*/
class BrowserHistory {
    ArrayList<String> currPage;
    int curr = -1, last = -1;
   public BrowserHistory(String homepage) {
       currPage = new ArrayList<String>();
       visit(homepage);
   }
   
   public void visit(String url) {
       if (++curr < currPage.size()) {
           currPage.set(curr, url); 
       } else {
           currPage.add(url);
       }
       last = curr;

   }
   
   public String back(int steps) {
       curr = Math.max(0, curr - steps);
       return currPage.get(curr);
   }
   
   public String forward(int steps) {
       curr = Math.min(last, curr+steps);
       return currPage.get(curr);
   }
}

/**
* Your BrowserHistory object will be instantiated and called as such:
* BrowserHistory obj = new BrowserHistory(homepage);
* obj.visit(url);
* String param_2 = obj.back(steps);
* String param_3 = obj.forward(steps);
*/
