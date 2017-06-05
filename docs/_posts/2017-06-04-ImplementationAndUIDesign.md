<div>
<h1 style="color: #000000; text-align:center;">Implementation and UI Design</h1>
<h2 style="color: #000000; text-align:center;">Welcome to our third Blog, you will see information about the coding conventions followed, whom this application is meant for and prototype of the MoneyTracker application</h2>
</div>
<div>
<h1 style="color: #2e6c80; text-align:center;">Coding Conventions</h1>
<p> A coding standards document tells developers how they must write their code. Instead of each developer coding in their own preferred style, they will write all code to the standards outlined by the organisation or team. This makes sure that a large project is coded in a consistent style and parts are not written differently by different programmers. Not only does this solution make the code easier to understand, but also ensures that any developer who looks at the code will know what to expect throughout the entire application.</p>
<p>Following are the coding conventions that we will be following: </p>
<div>
<ol>
<li><p>The initial package name representing the domain name must be in lower case. For example, de.ovgu.janardhanast.name.login</p></li>
<li><p>Classes are always noun and starts with Uppercase letter followed by lowercase </p></li>
<li><p>Variables always starts with lowercase letter and has mixed case,i.e. it follows camel case convention. Example - Button btnLogin; </p></li>
<li><p>The variables used to store UI components values satrts with the components followed by noun. Example EditText component used to enter UserName will be named as - EditText etUserName, Radio button that holds income value is named as - RadioButton radiobtnIncome such that user understands clearly</p></li>
<li> <p>Functions are always verb and named in accordance to what they do, and are written in lowercase </p></li>
<li><p>Every method and class will hold comments so as to what it does, hence allowing user to quickly understand the functionality</p></li>
<li><p>Constants are always written in Uppercase with underscore seperating the words. Example - int NUMBER_OF_CATEGORY=5;</p></li>
</ol>
</div>
<h2 style="color: #2e6c80;">Home screen :<span style="color: #000000;"> -Estimate (1 week/09-05-2017 to 16-05-2017)</span></h2>
<div>
<ol>
<li><p>App should be password protected.</p></li>
<li><p>Total income and expenses should be displayed in the top section of the screen.</p></li>
<li><p>Recent transactions for current, previous and next months will be displayed in descending order.</p></li>
<li><p>There should be an option to change the currency.</p></li>
<li><p>Two line spacing is maintained between every method and indentation is done</p></li>
</ol>
</div>
<h2 style="color: #2e6c80;">Add transaction :<span style="color: #000000;"> -Estimate (1 week/17-05-2017 to 24-05-2017)</span></h2>
<div>
<ol>
<li><p>How much money was spent</p></li>
<li><p>On what was the money spent  on - Category</p></li>
<li><p>Date of transaction</p></li>
<li><p>A short description </p></li>
<li><p>Spent by cash/ card or bank transfer </p></li>
</ol>
</div>
<h2 style="color: #2e6c80;">Add category :<span style="color: #000000;"> -Estimate (4 days/25-05-2017 to 28-05-2017)</span></h2>
<p>Categories are further divided in to two sub categories,</p>
<div>
<ol>
<li><p>Income – Amount acquired by you by any means will come under income</p></li>
<li><p>Expense – Amount that is spent by any means</p></li>
</ol>
</div>
<h2 style="color: #2e6c80;">Report :<span style="color: #000000;"> -Estimate (1 week/29-05-2017 to 05-06-2017)</span></h2>
<p>All the transaction details has to displayed in the following syntax based on the filters applied,<br/>
dd-mm-yyyy  -  Amount, Category, First 30 characters of the description<br/>
eg (10-05-1995 – 500 euros, Clothing, Birthday shopping)<br/></p>
<p>Transaction details has to be displayed based on the below two filters,</p>
<div>
<ol>
<li><p>Filter by date – select start date and end date</p></li>
<li><p>Filter by category – select the category</p></li>
</ol>
</div>
<p>Note : both filters should work in tandem.</p>
</div>
<h1 style="color: #2e6c80; text-align:center;">User stories</h1>
<div>
<ol>
<h2 style="color: #2e6c80;">Home screen module :</h2>
<li><p>Money tracker application should be password protected. User should be able to set his PIN when he opens the app for the first time.</p></li>
<li><p>User should be able to open the app only if the PIN matches with the PIN that was set by the user (Validation).</p></li>
<li><p>Security PIN should be of 4-digit numeric (Validation).</p></li>
<li><p>Once the user enters the security PIN, the user should be redirected to the home screen of the application.</p></li>
<li><p>User should have an option to change currency in the home screen.</p></li>
<li><p>User should be able to see the last few transactions in the home screen for current month by default.</p></li>
<li><p>User should be able to switch to the previous month to see the last few transactions of previous month in the home screen.</p></li>
<li><p>User should be able to switch to the next month to see the last few transactions of next month in the home screen.</p></li>
<li><p>User should be able to see the income and expenses in the home screen along with last few transactions for the selected period which could be (previous month,current month and next month)</p></li>
<li><p>User should be able to add a new transaction on click of the`+`icon in the home screen.</p></li>
<li><p>User should be able to view the report on click of the `report`icon in the home screen. </p></li>
<h2 style="color: #2e6c80;">Add transaction module :</h2>
<li><p> On click of the`+`icon in the home screen,the user should be redirected to a new screen where he/she should be able to add the transaction details.</p></li>
<li><p>Before landing on the Add transaction details page, the user should be able to select whether the transaction is income or expense</p></li>
<li><p>In the transaction screen user should be able to add the following details, </p>
<div><ul>
<li><p>Amount that he had spent,</p></li>
<li><p>Category</p></li>
<li><p>Date of transaction</p></li>
<li><p>Payment method - cash/card</p></li>
<li><p>Note</p></li>
</ul></div>
</li>
<li><p>Amount field should only accept digits and periods. (Validation).</p></li>
<li><p>Onclick of the category field, user should be able to redirected to a new screen to select the category.</p> </li>
<li><p>User should be able to see two main categories (Income and Expense) in the category screen.</p></li>
<li><p>Under the Income and Expense category, user should be able to see the following sub categories,</p></li>
<img style="align:center;" src="/isee2017-codecrunch/images/IncomeExpense.PNG" alt="Alt text"/>
<li><p>On click of ‘New expense category’ user should be able to add a new subcategory if it’s not mentioned by default.</p></li>
<li><p>Onclick of the date icon calendar should be opened for the user to select the date.</p></li>
<h2 style="color: #2e6c80;">View report module :</h2>
<li><p>Onclick of the ‘report’ icon in the home screen, the user should be redirected to a new screen where he should be able view the transaction details.</p></li>
<li><p>User should be able to use the date filter to view the transaction details for the selected period (start date – end date).</p></li>
<li><p>User should be able to use the category filter to view the transaction details for the selected category.</p></li>
<li><p>Both filter by date and filter by category should work in tandem.</p></li>
<li><p>User should be able to view his income vs expense in a bar graph based on the filters applied in the top section of the report screen.</p></li>
</ol>
</div>
<p>Based on the above user stories we came up with the use case diagrams</p>
<h2 style="color: #2e6c80;">Use case diagram for Login and Home screen :</h2>
<span align="center">
![usecasediagram image]({{site.baseurl}}/images/HomeScreen.PNG "Login and Home screen")
</span>
<h2 style="color: #2e6c80;">Use case diagram for adding a new transaction :</h2>
<span align="center">
![usecasediagram image]({{site.baseurl}}/images/AddCategory.PNG "Add new transaction")
</span>
<h2 style="color: #2e6c80;">Use case diagram to view reports :</h2>
<span align="center">
![usecaseDiagram3 image]({{site.baseurl}}/images/ViewReport.PNG "View report")
</span>
<h1 style="color: #2e6c80; text-align:center;">Team work on Requirement Analysis </h1>
<div>
<p>The idea behind developing this app is to allow users to track their income and expenses on daily basis. Once we decided to take up Money tracking app, First thing we tried is to understand what the money tracking app is about. So we came up with an idea of exploring an existing app. Each one of us decided to explore and analyse a different app which took about 2 days and we organised the meeting on the 3rd day. Having gained knowledge on money tracking, each one us had our chances to put forth the ideas on the table. The ideas were evaluated carefully and the best ones were picked up. With all the best ideas we framed the requirements. We took the guidance and suggestions of our Professor in the tutorials. That is how the requirements were finalised.</p>
</div>

<div>
<p>With the requirements in hand, we had to think from the user perspective to come up with the user stories. All these requirements were fine tuned to frame the user stories. We split each requirement in to number of smaller user stories as possible. We made sure that each user story is unique and no duplicates exist. </p>
</div>

<div>
<p>Since each of us had different views and a unique style of expressing our ideas at some point for some requirements it created an element of doubt. That is when we started digging in to the requirements a little deeper. For instance, Money tracker app is password protected, we had an idea to validate the user credentials using user name and password. Then, after team discussion we came up with the idea of 4 digit PIN which is way simpler than user credentials. Also, we were not clear about the idea of ‘Currency change’ each one of us had a different view. We initially thought that we need to work on the conversions. Later, we got a clear picture on currency change requirement after discussing with our professor. And while adding a new transaction we weren’t sure as in where the user has to specify whether the transaction is an income or expense. Initially we specified it in the ‘Add transaction’ screen which was little tedious. Our professor made it simpler by changing our requirement in such a way the user selects income/expense before he lands in to the ‘Add transaction’ screen which made a lot of sense.  </p>
</div>
<h1 style="color: #2e6c80; text-align:center;">Future work</h1>
<div>
<p>Having analysed the requirements, the next thing we are going to concentrate is on design and implementation part. As an initiative, we have already installed Android studio. Also, we tried implementing a sample ‘Hello world’ program just to understand the framework and how the request and response is handled.</p>
</div>
<h3 style="color: #000000; text-align:center;">Thanks for visiting our Blog !</h3>

