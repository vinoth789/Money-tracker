<div>
<h1 style="color: #000000; text-align:center;">Requirements and User Stories</h1>
<h2 style="color: #000000; text-align:center;">Welcome to our second Blog, you will see information about the requirements, user stories and how we came up with the requirements</h2>
</div>
<div>
<h1 style="color: #2e6c80;">Requirements</h1>
<p>Following are the four modules,</p>
<div>
<ol>
<li><p>Home screen</p></li>
<li><p>Add transaction</p></li>
<li><p>Add category</p></li>
<li><p>Report.</p></li>
</ol>
</div>
<h2 style="color: #2e6c80;">Home screen :<span style="color: #000000;"> -Estimate (1 week/09-05-2017 to 16-05-2017)</span></h2>
<div>
<ol>
<li><p>App should be password protected.</p></li>
<li><p>Total income and expenses should be displayed in the top section of the screen.</p></li>
<li><p>Recent transactions for current, previous and next months will be displayed in descending order.</p></li>
<li><p>There should be an option to change the currency.</p></li>
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
<h1 style="color: #2e6c80;">User stories</h1>
<div>
<ol>
<h2 style="color: #2e6c80; text-align:center;">Home screen module</h2>
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
<h2 style="color: #2e6c80; text-align:center;">Add transaction module</h2>
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
<li><p>Under the Income category, user should be able to see the following sub categories,</p>
<div><ul>
<li><p>Monthly income</p></li>
<li><p>Interest</p></li>
<li><p>Gifts</p></li>
<li><p>Other income, etc.</p></li>
</ul></div>
</li>
<li><p>Under the Expense category, user should be able to see the following sub categories,</p>
<div><ul>
<li><p>Food and Beverages</p>
<div><ul>
<li><p>Cafe</p></li>
<li><p>Bar</p></li>
<li><p>Restaurants</p></li>
</ul></div>
</li>
<li><p>Bills</p>
<div><ul>
<li><p>Rental</p></li>
<li><p>Phone, Electric, Water</p></li>
</ul></div>
</li>
<li><p>Travelling</p></li>
<li><p>Debts</p></li>
<li><p>Shopping</p>
<div><ul>
<li><p>Grocery</p></li>
<li><p>Clothing</p></li>
<li><p>Footwear</p></li>
<li><p>Electronics</p></li>
</ul></div>
</li>
<li><p>Loan</p></li>
<li><p>Education</p></li>
<li><p>Gifts</p></li>
<li><p>Health</p>
<div><ul>
<li><p>Insurance</p></li>
<li><p>Doctor</p></li>
<li><p>Sports</p></li>
</ul></div>
</li>
</ul></div>
</li>
<li><p>On click of ‘New expense category’ user should be able to add a new subcategory if it’s not mentioned by default.</p></li>
<li><p>Onclick of the date icon calendar should be opened for the user to select the date.</p></li>
<h2 style="color: #2e6c80; text-align:center;">View report module</h2>
<li><p>Onclick of the ‘report’ icon in the home screen, the user should be redirected to a new screen where he should be able view the transaction details.</p></li>
<li><p>User should be able to use the date filter to view the transaction details for the selected period (start date – end date).</p></li>
<li><p>User should be able to use the category filter to view the transaction details for the selected category.</p></li>
<li><p>Both filter by date and filter by category should work in tandem.</p></li>
<li><p>User should be able to view his income vs expense in a bar graph based on the filters applied in the top section of the report screen.</p></li>
</ol>
</div>
<p>Based on the above user stories we came up with the use case diagrams</p>
<h2>Use case diagram for Login and Home screen :</h2>
<span align="center">
![usecasediagram image]({{site.baseurl}}/images/HomeScreen.PNG "Login and Home screen")
</span>
<h2>Use case diagram for adding a new transaction :</h2>
<span align="center">
![usecasediagram image]({{site.baseurl}}/images/AddCategory.PNG "Add new transaction")
</span>
<h2>Use case diagram to view reports :</h2>
<span align="center">
![usecaseDiagram3 image]({{site.baseurl}}/images/ViewReport.PNG "View report")
</span>
<h2 style="color: #2e6c80;">Team work on Requirement Analysis </h2>
<div>
<p>The idea behind developing this app is to allow users to track their income and expenses on daily basis. Once we decided to take up Money tracking app, First thing we tried is to understand what the money tracking app is about. So we came up with an idea of exploring an existing app. Each one of us decided to explore and analyse a different app which took about 2 days and we organised the meeting on the 3rd day. Having gained knowledge on money tracking, each one us had our chances to put forth the ideas on the table. The ideas were evaluated carefully and the best ones were picked up. With all the best ideas we framed the requirements. We took the guidance and suggestions of our Professor in the tutorials. That is how the requirements were finalised.</p>
</div>

<div>
<p>With the requirements in hand, we had to think from the user perspective to come up with the user stories. All these requirements were fine tuned to frame the user stories. We split each requirement in to number of smaller user stories as possible. We made sure that each user story is unique and no duplicates exist. </p>
</div>

<div>
<p>Since each of us had different views and a unique style of expressing our ideas at some point for some requirements it created an element of doubt. That is when we started digging in to the requirements a little deeper. For instance, Money tracker app is password protected, we had an idea to validate the user credentials using user name and password. Then, after team discussion we came up with the idea of 4 digit PIN which is way simpler than user credentials. Also, we were not clear about the idea of ‘Currency change’ each one of us had a different view. We initially thought that we need to work on the conversions. Later, we got a clear picture on currency change requirement after discussing with our professor. And while adding a new transaction we weren’t sure as in where the user has to specify whether the transaction is an income or expense. Initially we specified it in the ‘Add transaction’ screen which was little tedious. Our professor made it simpler by changing our requirement in such a way the user selects income/expense before he lands in to the ‘Add transaction’ screen which made a lot of sense.  </p>
</div>
<h2 style="color: #2e6c80;">Future work</h2>
<div>
<p>Having analysed the requirements, the next thing we are going to concentrate is on design and implementation part. As an initiative, we have already installed Android studio. Also, we tried implementing a sample ‘Hello world’ program just to understand the framework and how the request and response is handled.</p>
</div>
<h3 style="color: #000000; text-align:center;">Thanks for visiting our Blog !</h3>

