<div>
<h1 style="color: #000000; text-align:center;">System Design</h1>
<h2 style="color: #000000; text-align:center;">Welcome to our Third Blog, you will see information about the Interaction and Class diagrams, Design patterns and statergies used in Development process</h2>
</div>

<div>
<h2 style="color: #2e6c80;">Sequence diagram </h2>
<h3 style="color: #2e6c80;">PIN verification use case</h3>
<span align="center">
![usecasediagram image]({{site.baseurl}}/images/MTSeqDgLogin.PNG "Sequence Diagram for Login process")
</span>

<h3 style="color: #2e6c80;">View Report use case</h3>
<span align="center">
![usecasediagram image]({{site.baseurl}}/images/MTSeqDgReport.PNG "Add new transaction")
</span>
</div>

<div>
<h2 style="color: #2e6c80;">Class Diagram for Money Tracker Application :</h2>
<span align="center">
![usecaseDiagram3 image]({{site.baseurl}}/images/MTClassDg.PNG "View report")
</span>

<h3 style="color: #2e6c80;">Detail description of classes and there associations</h3>
<ol>
  <li><p><b>User class</b></p>
     <ul>
         <li><p>Contains attribute PIN of type integer. Accepts PIN of length 4<p></li>
         <li>Contains three methods :
              <ul>
                  <li><p>verifyPIN(int PIN) - verifies if entered pin is of lenght 4 and user authentication</p></li>
                  <li><p>setPIN(int PIN) - sets passed pin when user has logged in for the first time</p></li>
                   <li><p>getPIN() - gets PIN on request</p></li>
              </ul>
          </li>
          <li>
        <p>Every user after login will be allowed to select one curreny type. Hence user is associated with minimum of one currency type          and maxximum of any number of currency types available  
        </p>
          </li> 
       </ul> 
    </li>


    <li>
          <p><b>CurrencyType class</b></p>
          <ul>
              <li>Contains attribute currencyType of type String.</li>
              <li>Contains getters and setters to get and set value of currency type across the application as it is made private.</li>
         </ul>
    </li>
    <li>
        <p>Currency is associated with every item and each user is allowed to set currency type very first time he logs into the                  application</p> 
    </li>

    <li>
        <p><b>Item class</b></p>
        <ul>
            <li>Contains attributes : amount of type integer,Note of type string, Category of type enum,subCategory of type                          Arraylist
            </li>
            <li>Contains method :
                <ul>
                    <li>
                         <p>addSubCategory(Item item) - adds custom defined subCategory of type item to Arraylist of subCategories which is predefined 
                         </p>
                    </li>
                </ul>
              </li>
          </ul>
      </li>
       <li>
            <p>Every Item is associated with one currencyType and one item per transaction</p>
       </li>

        <li>
            <p> <b>Transaction class</b></p>
            <ul>
                  <li><p>Contains attribute totalBalance, totalIncome and totalExpense of type integer</p></li>      
                  <li> Contains two methods :
                       <ul>
                            <li><p>addTransaction(Item item, String note, Category category, String subCategory) - Adds transaction for selected category and subCategory with note and amount details</p>
                            </li>
                            <li><p>Calculate() - calculates total balance, expense and income for every transaction and keeps application with updated values</p>
                            </li>
                      </ul>
                  </li>
                  </ul>
                  <li><p>Every transaction consits of atleast one Item. Transaction inherits class Item, hence has acess to all attributes and methods defined in class Items and one or many transaction will involve in generating the report.Basically handles all actions involved in adding and maintaining of transactions under Income or Expense category.</p>
                  </li>

<li>
     <p> <b>Report class</b></p>
     <ul>
     <li><p>Contains attribute startDate and endDate of type Date and Category of type enum</p></li>
     <li>Contains three methods :
          <ul>
               <li><p>generateReport(startDate Date, endDate Date) - Generates report based on the given range of date values</p></li>
                <li><p>generateReport(Category category) - Generates report based on the selected category value</p></li>
                <li><p>Plot() - Plots the graph for given values</p></li>
          </ul>
      </li>
      <li><p>Each report consits atleast one transaction and can take any number of transactions based on the defined date range or                   category. It will fetch required data and plots in Bar graph/ Pie or Line chart</p>
      </li>
  </ul>
 </li>
</ol>

</div>
<h3 style="color: #000000; text-align:center;">Thanks for visiting our Blog !</h3>
