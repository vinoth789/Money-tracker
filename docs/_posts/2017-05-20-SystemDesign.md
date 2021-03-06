<div>
<h2 style="color: #000000; text-align:center;">Welcome to our Third Blog, you will see information about the Interaction and Class diagrams, Design patterns and statergies used in Development process</h2>
</div>

<h1 style="color: #2e6c80; text-align:center;">Sequence diagram </h1>
<h2 style="color: #2e6c80;">Sequence diagram for PIN verification use case</h2>
<span align="center">
![sequencedg1 image]({{site.baseurl}}/images/MTSeqDgLogin.PNG "Sequence Diagram for Login process")
</span>

<p>Above sequence diagram shows login process,Process begins when user enters the 4 digit PIN, the entered PIN will be verified. If PIN doesn't exist (during first login) it will be stored. If it is not first login then it will be verified against existing value and user is either authenticated/rejected from acessing application. </p>

<h2 style="color: #2e6c80;">Sequence diagram for View Report use case</h2>
<span align="center" style="width:60px;">
![usecasediagram image]({{site.baseurl}}/images/MTSeqDgReport.PNG "Add new transaction")
</span>

<p>Above sequence diagram shows View Report process,Process begins when user requests to view his statistics of expense and income. User can either view report by filtering by date or by category. Depending on user request of filters, relevant information is fetched and plotted based on chosen representation type.</p>

<h1 style="color: #2e6c80; text-align:center;">Class Diagram </h1>
<span align="center">
![classdg image]({{site.baseurl}}/images/MTCD.png "Class Diagram")
</span>
<h2 style="color: #2e6c80; ">Detail description of classes and their associations</h2>


<div>
<p>Below is the detailed explaination of Class diagram with its attributes and associated data types, operation and relationship between classes. </p>
<ol>

<div>
  <li>
     <h2 style="color: #2e6c80;">UserDetails</h2>
       <ul>
       <li><p><b>Attributes: </b></p>
               <ul>
                  <li><p>PIN - Integer(Accepts PIN of length 4)</p></li>
              </ul>
         </li>
         <li><p><b>Methods :</b></p>
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
     <h2 style="color: #2e6c80;">CurrencyType</h2>
      <ul>
      <li><p><b>Attributes: </b></p>
               <ul>
                  <li><p>currencyType - String</p></li>
              </ul>
         </li>
         <li><p><b>Methods:</b></p>
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
  <li>
      <h2 style="color: #2e6c80;">Item</h2>
      <ul>
      <li><p><b>Attributes: </b></p>
               <ul>
                 <li><p>amount - integer</p></li>
                  <li><p>Note -  String</p></li>
                  <li><p>Category - enum</p></li>
                  <li><p>subCategory - Arraylist</p></li>
              </ul>
         </li>
         <li><p><b>Methods:</b></p>
              <ul>
                  <li><p>addSubCategory(Item item) - adds custom defined subCategory of type item to Arraylist of subCategories which is predefined </p></li>
              </ul>
          </li>
          <li><p>Every Item is associated with one currencyType and one item per transaction</p> </li> 
       </ul> 
    </li>
</div>


<div>
  <li>
      <h2 style="color: #2e6c80;">Transaction</h2>
      <ul>
      <li><p><b>Attributes: </b></p>
               <ul>
                   <li><p>totalBalance - integer</p></li>
                  <li><p>totalIncome -  integer</p></li>
                  <li><p>totalExpense - integer</p></li>
              </ul>
         </li>
         <li><p><b>Methods:</b></p>
              <ul>
                  <li><p>addTransaction(Item item, String note, Category category, String subCategory) - Adds transaction for selected category and subCategory with note and amount details</p></li>
                  <li><p>Calculate() - calculates total balance, expense and income for every transaction and keeps application with updated values</p></li>
              </ul>
          </li>
          <li><p>Every transaction consits of atleast one Item. Transaction inherits class Item, hence has acess to all attributes and methods defined in class Items and one or many transaction will involve in generating the report.Basically handles all actions involved in adding and maintaining of transactions under Income or Expense category</p> </li> 
       </ul> 
    </li>
</div>


<div>
  <li>
      <h2 style="color: #2e6c80;">TransactionManagement</h2>
      <ul>
      <li><p><b>Attributes: </b></p>
               <ul>
                 <li><p>transactionManagementInstance - TransactionManagement</p></li>
              </ul>
         </li>
         <li><p><b>Methods:</b></p>
              <ul>
                  <li><p>TransactionManagement() - Private constructor with do nothing</p></li>
                   <li><p>getInstance() - Checks if the instance of transaction management class exists, if exists then returns same instance else it will create an instance and returns it</p></li>
              </ul>
          </li>
          <li><p>One or many transaction class can have only one instance of TransactionManagement</p> </li> 
       </ul> 
    </li>
</div>



<div>
  <li>
  <h2 style="color: #2e6c80;">Report</h2>
       <ul>
       <li><p><b>Attributes: </b></p>
               <ul>
                  <li><p>startDate - Date</p></li>
                  <li><p>endDate -  Date</p></li>
                  <li><p>Category - enum</p></li>
              </ul>
         </li>
         <li><p><b>Methods :</b></p>
              <ul>
                  <li><p>generateReport(startDate Date, endDate Date) - Generates report based on the given range of date values</p></li>
                  <li><p>generateReport(Category category) - Generates report based on the selected category value</p></li>
                  <li><p>Plot() - Plots the graph for given values</p></li>
              </ul>
          </li>
          <li><p>Each report consits atleast one transaction and can take any number of transactions based on the defined date range or                   category. It will fetch required data and plots in Bar graph/ Pie or Line chart </p></li> 
       </ul> 
    </li>
  </div>


 
 <div>
 <li>
 <h2 style="color: #2e6c80;">Enumerations </h2>
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
    <h1 style="color: #2e6c80; text-align:center;">Design Pattern </h1>
    <p>Design pattern is one of the best practices applied in object oriented programming. It provides standard terminology and are specific to certain scenarios.</p>
    <p>Our Money Tracker application will be built on creational pattern i.e, <b>Singleton Pattern</b> and can also include <b>Model-View-Controller pattern</b></p>
        <h2 style="color: #2e6c80;">Below scenario shows how Signleton pattern and MVC pattern can be applied for Money Tracker app </h2>
        <img style="align:center;" src="/isee2017-codecrunch/images/SingletonPattern.png" alt="Singleton Pattern"/>  
        <p>Fig(a) Singleton pattern </p>
        <img style="align:center;" src="/isee2017-codecrunch/images/MVCPattern.png" alt="MVC Pattern"/>
        <p>Fig(b) MVC pattern </p>
 </div>
    
 <div>
   <h2 style="color: #2e6c80; ">Reasons why we are incorporating this design pattern in our application are: </h2>
        <ul>
            <li><p>Since Money tracker application is specific to one single user, having Singleton pattern to instantiate object for management of complete transaction is much suitable</p></li>
            <li><p>Since the class controls the instantiation process, the class has the flexibility to change the instantiation process</p> </li>
      <li><p>MVC pattern seperates application concerns, keeping input, processing and output in different layers</p></li>
      <li><p>Allows for easier code maintenance and faster development process</p></li>
      <li><p>Provides multiple view as it is necessary in viewing the Report</p></li>
      <li><p>Modifications in one of the layer doesn't require changes in the other layer</p></li>
    </ul>
</div>

<div>
<h1 style="color: #2e6c80; text-align:center;">Development Stratergies </h1>
<ul>
    <li><p>All user stories are broken down into several Epics and logged in Backlog</p></li>
    <li><p>Weekly SPRINT will be followed</p></li>
    <li><p>SPRINT planning is done every Monday and tasks are discussed and assigned to weekly sprint</p></li>
    <li><p>Assigned tasks are analysed and impediments are discussed in stand up meetings</p></li>
    <li><p>SPRRINT review is done every friday. Completed or pending tasks will be discussed</p></li>
    <li><p>Iteravtive Model appproach is followed</p></li>
    <li><p>Agile Methodology in practice</p></li>
    <li>
        <p>Tools used for development:</p>
        <ul>
        <li><p>Andriod Studio</p> </li>
        <li><p>Emulator </p></li>
      </ul>
  </li>
</ul>
</div>

<div>
<h1 style="color: #2e6c80; text-align:center;">Key changes in project requirement </h1>
<ul>
    <li><p>Change in currency type for existing transaction was discarded as it requires currency conversion calculation on fly. Now user will be allowed to select currency only during launch of application for the 1st time</p></li>
    <li><p>Authenticating user by username and password was replaced by 4-digit PIN </p></li>
    <li><p>As per the initial design, an option to select whether the transaction is on income or expense was on the transaction page. As part of the change, onclick of the 'Add transaction' in the home screen the user will now be able to select an option i.e income/expense in a new screen just before he lands on the transaction page.</p></li>
</ul>
</div>

<h3 style="color: #000000; text-align:center;">Thanks for visiting our Blog !</h3>
