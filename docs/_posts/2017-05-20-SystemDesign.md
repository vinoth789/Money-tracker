<div>
<h2 style="color: #000000; text-align:center;">Welcome to our Third Blog, you will see information about the Interaction and Class diagrams, Design patterns and statergies used in Development process</h2>
</div>

<div>
<h2 style="color: #2e6c80;">Sequence diagram </h2>
<h2 style="color: #2e6c80;">PIN verification use case</h2>
<span align="center">
![sequencedg1 image]({{site.baseurl}}/images/MTSeqDgLogin.PNG "Sequence Diagram for Login process")
</span>
</div>
<div>
<h2 style="color: #2e6c80;">View Report use case</h2>
<span align="center">
![usecasediagram image]({{site.baseurl}}/images/MTSeqDgReport.PNG "Add new transaction")
</span>
</div>

<div>
<h2 style="color: #2e6c80;">Class Diagram </h2>
<span align="center">
![classdg image]({{site.baseurl}}/images/MTClassDg.PNG "View report")
</span>
<h2 style="color: #2e6c80; ">Detail description of classes and there associations</h2>
</div>

<div>
<ol>
<div>
  <li>
      <p><b>UserDetails</b></p>
       <ul>
         <li><p>Attributes: </p>
               <ul>
                  <li><p>PIN - Integer(Accepts PIN of length 4)</p></li>
              </ul>
         </li>
         <li><p>Methods :</p>
              <ul>
                  <li><p>verifyPIN(int PIN) - verifies if entered pin is of lenght 4 and user authentication</p></li>
                  <li><p>setPIN(int PIN) - sets passed pin when user has logged in for the first time</p></li>
                  <li><p>getPIN() - gets PIN on request</p></li>
              </ul>
          </li>
          <li><p>Every user after login will be allowed to select one curreny type. Hence user is associated with minimum of one currency type and maxximum of any number of currency types available </p></li> 
       </ul> 
    </li>
  </div>

<div>
  <li>
      <p><b>CurrencyType</b></p>
      <ul>
           <li><p>Attributes: </p>
               <ul>
                  <li><p>currencyType - String</p></li>
              </ul>
         </li>
         <li><p>Methods:</p>
              <ul>
                  <li><p>getCurrenyType() - returns currency type value set for the application</p></li>
                  <li><p>setCurrencyType(String currencyType) - sets currency type value</p></li>
                  <li><p>Contains getters and setters to get and set value of currency type across the application as it is made private :</p></li>
              </ul>
          </li>
          <li><p>Currency is associated with every item and each user is allowed to set currency type very first time he logs into the application</p> </li> 
       </ul> 
    </li>
</div>

<div>
<li><p><b>Item</b></p>
     <ul>
         <li><p>Contains attributes : amount of type integer,Note of type string, Category of type enum,subCategory of type                          Arraylist</p></li>
         <li><p>Contains one method :</p>
              <ul>
                  <li><p>addSubCategory(Item item) - adds custom defined subCategory of type item to Arraylist of subCategories which is predefined </p></li>
              </ul>
          </li>
          <li>
        <p>Every Item is associated with one currencyType and one item per transaction</p>
          </li> 
       </ul> 
    </li>
</div>

<div>
<li><p><b>Transaction</b></p>
     <ul>
         <li><p>Contains attribute totalBalance, totalIncome and totalExpense of type integer</p></li>
         <li><p>Contains two methods :</p>
              <ul>
                  <li><p>addTransaction(Item item, String note, Category category, String subCategory) - Adds transaction for selected category and subCategory with note and amount details</p></li>
                  <li><p>Calculate() - calculates total balance, expense and income for every transaction and keeps application with updated values</p></li>
              </ul>
          </li>
          <li>
        <p>Every transaction consits of atleast one Item. Transaction inherits class Item, hence has acess to all attributes and methods defined in class Items and one or many transaction will involve in generating the report.Basically handles all actions involved in adding and maintaining of transactions under Income or Expense category</p>
          </li> 
       </ul> 
    </li>
</div>

<div>
<li>
     <p> <b>Report</b></p>
     <ul>
     <li><p>Contains attribute startDate and endDate of type Date and Category of type enum</p></li>
     <li><p>Contains three methods :</p>
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
 </div>
 
 <div>
 <li>
    <p>Enumerations :</p>
    <ul>
        <li><p>Category enum contains value income and expense</p></li> 
        <li><p>Currency enum contains various currency values</p></li>
        <li><p>Currency and Category values are constants and cannot be added or modified during program execution, hence are stored as enums</p></li>
    </ul>
 </li>
 </div>
 
 
</ol>
</div>



<div>
    <h2 style="color: #2e6c80;">Design Pattern </h2>
    <p>Design pattern is one of the best practices applied in object oriented programming. It provides standard terminology and are specific to certain scenarios.</p>
    <p>Our Money Tracker application will be built incorporating <b>Model-View-Controller pattern</b></p>
    <div>
        <h2 style="color: #2e6c80;">Below scenario shows how MVC pattern is applied for Money Tracker app </h2>
        <span align="center">
        ![classdg image]({{site.baseurl}}/images/MVCPattern.PNG "MVC Pattern")
         </span>
    </div>
    <div>
    <h2 style="color: #2e6c80;">Reasons why we are incorporating this design pattern in our application </h2>
    <ul>
    <li><p>MVC pattern seperates application concerns, keeping input, processing and output in different layers</p></li>
    <li><p>Allows for easier code maintenance and faster development process</p></li>
    <li><p>Provides multiple view as it is necessary in viewing the Report</p></li>
    <li><p>Modifications in one of the layer doesn't require changes in the other layer</p></li>
    </ul>
    </div>
</div>

<div>
<h2 style="color: #2e6c80;">Development Stratergies </h2>
<ul>
    <li><p>All user stories are broken down into several Epics and logged in Backlog</p></li>
    <li><p>Weekly SPRINT will be followed</p></li>
    <li><p>SPRINT planning is done every Monday and tasks are discussed and assigned to weekly sprint</p></li>
    <li><p>Assigned tasks are analysed and impediments are discussed in stand up meetings</p></li>
    <li><p>SPRRINT review is done every friday. Completed or pending tasks will be discussed</p></li>
    <li>
        <p>Tools used for development:</p>
        <ul>
        <li><p>Andriod Studio</p> </li>
        <li><p>Emulator </p></li>
      </ul>
  </li>
</ul>
</div>
<h3 style="color: #000000; text-align:center;">Thanks for visiting our Blog !</h3>
